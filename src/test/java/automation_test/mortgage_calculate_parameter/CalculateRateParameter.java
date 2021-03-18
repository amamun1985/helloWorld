package automation_test.mortgage_calculate_parameter;

import automation_test.mortgage_calculator.CalculateRates;
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
import utilities.SqlConnector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class CalculateRateParameter {
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
        ResultSet resultSet= SqlConnector.readData("select * from apr_rate");
        try{
            while(resultSet.next()){
                new Home(driver)
                        .mouseHoverRates()
                        .clickONRealApr()
                        .typeHomeValuePrice(resultSet.getString("homevalue"))
                        .typeDownPayment(resultSet.getString("downpayment"))
                        .selectDownPaymentInDollar()
                        .typeInterestRate(resultSet.getString("intetestrate"))
                        .clickOnCalculateButton()
                        .validateAprRate(resultSet.getString("totalinterestrate"));
            }

        }catch(SQLException e){
           LOGGER.error(e.getMessage());
        }


    }
    @AfterMethod
    public void closeBrowser(){

        ActOn.browser(driver).closeBrowser();
    }

}
