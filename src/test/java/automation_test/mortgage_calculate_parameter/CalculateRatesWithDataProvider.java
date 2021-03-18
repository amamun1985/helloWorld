package automation_test.mortgage_calculate_parameter;

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
import utilities.DataProviderClasses;
import utilities.ReadConfigFiles;

import java.io.IOException;
import java.util.Properties;

public class CalculateRatesWithDataProvider {
    private static final Logger LOGGER= LogManager.getLogger(CalculateRatesWithDataProvider.class);
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
    }
      @Test(dataProvider="RealAprRates",dataProviderClass = DataProviderClasses.class)
    public void calculateRealAPR(String homePrice,String downPayment,String interestRate,String aprRate) {
          new Home(driver)
                  .mouseHoverRates()
                  .clickONRealApr()
                  .typeHomeValuePrice(homePrice)
                  .typeDownPayment(downPayment)
                  .selectDownPaymentInDollar()
                  .typeInterestRate(interestRate)
                  .clickOnCalculateButton()
                  .validateAprRate(aprRate);

      }
    @AfterMethod
    public void closeBrowser(){

        ActOn.browser(driver).closeBrowser();
    }
}
