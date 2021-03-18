package automation_test.selenium_grid;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import utilities.TestEnvironment;

import java.net.URL;

public class Selenium_grid_Chrome1 {

    WebDriver driver;
    @Test
    public void RunInChrome() {
        WebDriverManager.chromedriver().setup();

        /*TestEnvironment obj=new TestEnvironment();  //When test environment is non static
        obj.selectTestEnvironment();
        driver=obj.selectTestEnvironment();*/

        driver = TestEnvironment.selectTestEnvironment();  //When test environment is static
        driver.get("https://www.mortgagecalculator.org/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test
    public void RunInFirefox() {
        WebDriverManager.firefoxdriver().setup();

        /*TestEnvironment obj=new TestEnvironment();  //When test environment is non static
        obj.selectTestEnvironment();
        driver=obj.selectTestEnvironment();*/

        driver = TestEnvironment.selectTestEnvironment();  //When test environment is static
        driver.get("https://www.mortgagecalculator.org/");
        System.out.println(driver.getTitle());
        driver.quit();
    }

}
