package automation_test.mortgage_calculator;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_object.Home;
import utilities.ReadConfigFiles;

import java.io.IOException;
import java.util.Properties;

public class CalculateRates {
    private static final Logger LOGGER= LogManager.getLogger(CalculateRates.class);
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        LOGGER.info("---------------Test Case: CalculateRates-------");

        ReadConfigFiles readConfigFiles=new ReadConfigFiles();
        Properties prop= readConfigFiles.getPropertyValue();
        String url= prop.getProperty("Url");
        LOGGER.info("Url is:"+url);
        ActOn.browser(driver).openBrowser(url);

        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
    }
      @Test
    public void calculateRealAPR() {
          new Home(driver)
                  .mouseHoverRates()
                  .clickONRealApr()
                  .typeHomeValuePrice("200000")
                  .typeDownPayment("15000")
                  .selectDownPaymentInDollar()
                  .typeInterestRate("3")
                  .clickOnCalculateButton()
                  .validateAprRate("3.130%");

      }
    @AfterMethod
    public void closeBrowser(){

        ActOn.browser(driver).closeBrowser();
    }
}
