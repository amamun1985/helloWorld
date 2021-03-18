package exerciseJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class UtilityTestEnvironment {
    static WebDriver driver;
    static URL gridUrl ;


//This method will select the execution environment base on the user input and return WebDriver
    public static WebDriver selectTestEnvironment() {
        String environment = System.getProperty("environment")==null? "local":System.getProperty("environment");
        String browser = System.getProperty("browser")==null? "chrome":System.getProperty("browser");
        try {
            gridUrl = new URL("http://localhost:4444/wd/hub");
        } catch (Exception e) {

        }
        if (environment.equals("remote") && browser.equals("chrome")){

            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new RemoteWebDriver(gridUrl, chromeOptions);
        }else if (environment.equals("remote") && browser.equals("firefox")){

            FirefoxOptions firefoxOptions= new FirefoxOptions();
            driver = new RemoteWebDriver(gridUrl, firefoxOptions);
        }else if (environment.equals("local") && browser.equals("chrome")){

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        return driver;
    }

}
