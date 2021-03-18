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

public class InterviewSolutionsQ1And2 {
    private final By WhoWeServe = By.xpath("//*[@id='main-header-navbar']//a[contains(text(),'WHO WE SERVE')]");
    private final By UnorderedListElement = By.xpath("//*[@id='Level1NavNode1']/ul");
    private final By StudentSubMenu = By.xpath("//*[@id='Level1NavNode1']/ul/li/a[contains(text(),'Students')]");
    private final By ItemsOfDropDownSebMenu = By.xpath("//*[@id='Level1NavNode1']/ul/li[contains(@class,'dropdown-item')]");
    private final By SearchBox = By.id("js-site-search-input");
    private final By SearchContent = By.xpath("//a[text()='beans']/span[text()='java']");

    WebDriver driver;

    @BeforeMethod
    public void browserInitialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.wiley.com/en-us");
        driver.manage().window().maximize();
    }

    @Test
    public void validateResourcesUnderWhoWeServeSubHeader() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(WhoWeServe)).perform();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(StudentSubMenu));

        WebElement elements = driver.findElement(UnorderedListElement);
        List<WebElement> items = elements.findElements(ItemsOfDropDownSebMenu);

        Assert.assertEquals(items.size(), 11, "Total number of sub header is mismatched");

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < items.size(); i++) {
            map.put(items.get(i).getText(), i);
        }

        for (WebElement item : items) {
            String subHeader = item.getText();
            Assert.assertTrue(map.containsKey(subHeader), subHeader + " title failed to match");
        }
    }

    @Test
    public void validateSearchFunctionality() {
        driver.findElement(SearchBox).sendKeys("Java");

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchContent));

        Assert.assertTrue(driver.findElement(SearchContent).isDisplayed(), "Search content is not visible");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
