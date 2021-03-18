package automation_test.php_travels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Walmart {
    WebDriver driver;
    @BeforeTest
    public void OpenBrows(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.walmart.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void TitleValidate(){
        String expectedTitle = "Walmart.com | Save Money. Live Better.";
        String actualtitle = driver.getTitle();
        Assert.assertEquals(actualtitle,expectedTitle);

    }
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();


    }

}
