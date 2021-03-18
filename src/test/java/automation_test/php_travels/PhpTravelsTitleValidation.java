package automation_test.php_travels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PhpTravelsTitleValidation {
    WebDriver driver;
    @BeforeMethod
    public void openChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.phptravels.com/demo/");
        driver.manage().window().maximize();
    }
    @Test
    public void titleValidationPhpTravels(){
        String expectedTitle="Demo Script Test drive - PHPTRAVELS";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
