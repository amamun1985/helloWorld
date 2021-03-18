package interview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class InterviewSolutionsQ1Q2Q3 {
    private final By WhoWeServe = By.xpath("//*[@id='main-header-navbar']//a[contains(text(),'WHO WE SERVE')]");
    private final By StudentSubMenu = By.xpath("//*[@id='Level1NavNode1']/ul/li/a[contains(text(),'Students')]");
    private final By ItemsOfDropDownSebMenu = By.xpath("//*[@id='Level1NavNode1']/ul/li[contains(@class,'dropdown-item')]");
    private final By SearchBox = By.id("js-site-search-input");
    private final By SearchContent = By.xpath("//a[text()='beans']/span[text()='java']");
    private final By SearchButton = By.xpath("//*[@id='main-header-container']//span/button[text()='Search']");
    private final By SortByRelevance = By.xpath("//*[@id='sortOptions-button']/span[contains(text(),'Relevance')]");
    private final By AddToCartButtons = By.xpath("//div[@class='product-content']//a/div/form/button[text()='Add to cart']/../span[@data-medium-type='E-Book']");
    private final By ViewOnWileyButtons = By.xpath("//a[contains(text(),'View on Wiley Online Library')]");

    WebDriver driver;

    @BeforeMethod
    // The main page to start with: https://www.wiley.com/en-us
    public void browserInitialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.wiley.com/en-us");
        driver.manage().window().maximize();
    }
    /*Q1:
    Test needs to open the page and check items under Who We Serve sub-head
    there should be 11 items under resources sub-header
    titles are “Students”, “Instructors”, “Book Authors”, “Professionals”,
    “Researchers”, “Institutions”, “Librarians”, “Corporations”, “Societies”, “Journal Editors”, “Government”
     */
    @Test
    public void validateResourcesUnderWhoWeServeSubHeader() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(WhoWeServe)).perform();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(StudentSubMenu));

        List<WebElement> items = driver.findElements(ItemsOfDropDownSebMenu);

        // Total number of sub header is 12 but as per the requirement it should be 11 - might be a possible bug
        // As per the requirement, the sub-header "Bookstores" is not mentioned that is the additional sub-header
        Assert.assertEquals(items.size(), 11, "Total number of sub header is mismatched");

        for (WebElement item : items) {
            boolean titleMatched;
            String subHeader = item.getText();
            switch (subHeader) {
                case "Students":
                case "Instructors":
                case "Book Authors":
                case "Professionals":
                case "Researchers":
                case "Institutions":
                case "Librarians":
                case "Corporations":
                case "Societies":
                case "Journal Editors":
                case "Government":
                    titleMatched = true;
                    break;
                default:
                    titleMatched = false;
            }

            Assert.assertTrue(titleMatched, subHeader + " sub-header does not exist");
        }
    }
    /*
    Q2:
    Search functionality. Test should enter “Java” in the search input box and do not press the search button (with magnifying glass icon)
    check area with related content is displayed right under the search header
     */
    @Test
    public void validateSearchFunctionality() {
        driver.findElement(SearchBox).sendKeys("Java");

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchContent));

        Assert.assertTrue(driver.findElement(SearchContent).isDisplayed(), "Search content is not visible");
    }
    /*
    Q3:
    Enter “Java” in the search input, press the search button and
    apply checks to verify that only titles containing “Java” are displayed
    there are 10 titles on the page
    each title has at least one “Add to Cart” button for E-Book/Print version
    and “VIEW ON WILEY ONLINE LIBRARY” for O-BOOK version
     */
    @Test
    public void validateSearchResults() {
        String searchWord = "Java";
        driver.findElement(SearchBox).sendKeys(searchWord);
        driver.findElement(SearchButton).click();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SortByRelevance));

        List<WebElement> titles = driver.findElements(By.xpath("//*[@id='search-result-page-row']//a/span[text()='"+ searchWord +"']"));
        Assert.assertEquals(titles.size(), 10, "Total number of tiles is mismatched");

        List<WebElement> addToCarts = driver.findElements(AddToCartButtons);

        // There are total 7 "Add to Cart" button for E-Book/Print version, 3 of the title do not have "Add to cart button"
        // As per the requirement, for each title there should be at least 1 "Add cart button" so the total should be 10
        // Might be a possible bug
        Assert.assertEquals(addToCarts.size(), 10, "Total number of Add To cart button is mismatched");

        List<WebElement> viewOnWileyButtons = driver.findElements(ViewOnWileyButtons);

        // There are total 2 "VIEW ON WILEY ONLINE LIBRARY" button for O-BOOK version, 8 of the title do not have this option
        // As per the requirement, for each title there should be at least 1 "VIEW ON WILEY ONLINE LIBRARY" so the total should be 10
        // Might be a possible bug
        Assert.assertEquals(viewOnWileyButtons.size(), 10, "Total number of VIEW ON WILEY ONLINE LIBRARY button is mismatched");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

}
