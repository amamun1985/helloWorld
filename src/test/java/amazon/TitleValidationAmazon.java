package amazon;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TitleValidationAmazon {

    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        ActOn.browser(driver).openBrowser("http://www.amazon.com/");
    }
    @Test
    public void titleValidate(){
       ActOn.browser(driver).validateTitle("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");

    }
    @AfterMethod
    public void closeBrowser(){

        ActOn.browser(driver).closeBrowser();
    }
}
