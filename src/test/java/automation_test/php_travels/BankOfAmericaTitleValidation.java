package automation_test.php_travels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class BankOfAmericaTitleValidation {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
         driver.get("https://www.bankofamerica.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void validateTitle(){
        String expectedTitle="Bank of America - Banking, Credit Cards, Loans and Merrill Investing";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @AfterMethod
    public void closeBrowser(){

        driver.quit();
    }

}
