package exerciseJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class WileyTestCase4 {
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
    @Test
    public void validateItemsInTheSearchBox()  {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get(" https://www.wiley.com/en-us");
        driver.manage().window().maximize();


        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(Subjects)).perform();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ItemsOfDropDownSebMenu));
        List<WebElement> list= driver.findElements(ItemsOfDropDownSebMenu);

        for (int i=0;i<list.size();i++){

            System.out.println(list.get(i).getText());

            if(list.get(i).getText().contains("Education")){
                list.get(i).click();
             break;
            }
        }
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
