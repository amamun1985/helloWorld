package automation_test.selenium_grid;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.TestEnvironment;

public class Selenium_grid_Firefox {

   WebDriver driver;
    @Test
    public void RunInFirefox() {
        WebDriverManager.chromedriver().setup();
       /* TestEnvironment obj=new TestEnvironment();   //When test environment is non static
        obj.selectTestEnvironment();
        driver=obj.selectTestEnvironment();*/

       driver = TestEnvironment.selectTestEnvironment();   //When test environment is static
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }

}
