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

import java.util.List;
@Test
public class InterviewSolutionQ4 {
    private final By Subjects = By.xpath("//*[@id='main-header-navbar']//a[contains(text(),'SUBJECTS')]");
    private final By ItemsOfDropDownSebMenu = By.xpath("//*[@id='Level1NavNode2']/ul/li/a/../../li[@class]");

    WebDriver driver;

    @BeforeMethod
    // The main page to start with: https://www.wiley.com/en-us
    public void browserInitialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.wiley.com/en-us");
        driver.manage().window().maximize();
    }
    /*Q4:
    Go to Subjects top menu, select Education
    Check “Education” header is displayed
    13 items are displayed under “Subjects” on the left side of the screen and the texts are:
    "Information & Library Science","Education & Public Policy", "K-12 General","Higher Education General",
    "Vocational Technology","Conflict Resolution & Mediation (School settings)","Curriculum Tools- General",
    "Special Educational Needs","Theory of Education", "Education Special Topics","Educational Research & Statistics",
     "Literacy & Reading", "Classroom Management"

     */
    @Test
    public void validateResourcesUnderWhoWeServeSubHeader() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Subjects)).perform();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ItemsOfDropDownSebMenu));

        List<WebElement> items = driver.findElements(ItemsOfDropDownSebMenu);

        Assert.assertEquals(items.size(), 23, "Total number of sub header is mismatched");

        for (WebElement item : items) {
            boolean titleMatched;
            String subHeader = item.getText();
            switch (subHeader) {
                case "Accounting":
                case "Agriculture":
                case "Arts & Architecture":
                case "Business & Management":
                case "Chemistry":
                case "Computing":
                case "Culinary & Hospitality":
                case "Earth & Space Sciences":
                case "Education":
                case "Engineering & Materials Science":
                case "Humanities":
                case "Law & Criminology":
                case "Life Sciences":
                case "Lifestyle":
                case "Mathematics":
                case "Medicine, Nuesing & Dentistry":
                case "Physics & Astronomy":
                case "Phylogy":
                case "Reference":
                case "Social & Behavioral Sciences":
                case "Technology":
                case "Veterinary Medicine":
                case "World Languages":
                    titleMatched = true;
                    break;
                default:
                    titleMatched = false;
            }

            Assert.assertTrue(titleMatched, subHeader + " sub-header does not exist");
        }
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
