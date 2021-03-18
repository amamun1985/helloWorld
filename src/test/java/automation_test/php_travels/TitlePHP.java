package automation_test.php_travels;

import command_providers.ActOn;
import command_providers.ScreenShort;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TitlePHP {
    private static Logger LOGGER= LogManager.getLogger((TitlePHP.class));
    private static final By MyLocator=By.id("PHPTRAVELS");

    WebDriver driver;
    @BeforeMethod
    public void openBrowser() throws IOException, InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.phptravels.com/demo");

        driver.navigate().to("https://www.google.com");

        driver.navigate().forward();
        Thread.sleep(6000);
        driver.navigate().back();
        Thread.sleep(6000);
        driver.navigate().refresh();

        ActOn.browser(driver).openBrowser("https://www.phptravels.com/demo");
        ScreenShort.myShort(driver,MyLocator).myScreenShot("PHP-Title");
         String x  =driver.getPageSource();
         LOGGER.info("This is the page source of PHP");
         System.out.println(x);
         ActOn.browser(driver).switchWindow(1);

    }
    @Test
    public void validateTitle(){
        String expectedTitle = "Demo Script Test drive - PHPTRAVELS";
        String actualtitle = driver.getTitle();
        Assert.assertEquals(actualtitle,expectedTitle);


    }
    @AfterMethod
    public void closeBrowser(){
        ActOn.browser(driver).closeBrowser();

    }
}
