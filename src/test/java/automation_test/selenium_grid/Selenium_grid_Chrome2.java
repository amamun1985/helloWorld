package automation_test.selenium_grid;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import utilities.TestEnvironment;

import java.net.URL;

public class Selenium_grid_Chrome2 {
    WebDriver driver;
    @Test
    public void RunInChrome1() {
        WebDriverManager.chromedriver().setup();

      /*  TestEnvironment obj=new TestEnvironment();   //When test environment is non static
        obj.selectTestEnvironment();
        driver=obj.selectTestEnvironment();*/

        driver = TestEnvironment.selectTestEnvironment();   //When test environment is  static
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }

}
