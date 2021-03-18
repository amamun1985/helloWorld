package automation_test.mortgage_calculate_parameter;

import automation_test.mortgage_calculator.CalculateMonthlyPayment;
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

public class CalculateMonthlyPaymentParameterise{
    private static final Logger LOGGER= LogManager.getLogger(CalculateMonthlyPaymentParameterise.class);
    WebDriver driver;
    @BeforeMethod
    public void browserInitialization() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        LOGGER.info("---------------Test Case: CalculateMonthlyPayment-------");

        ReadConfigFiles readConfigFiles=new ReadConfigFiles();
        Properties prop= readConfigFiles.getPropertyValue();
        String url= prop.getProperty("Url");
        LOGGER.info("Url is:"+url);
        ActOn.browser(driver).openBrowser(url);
    }
    @Test
    public void calculateRate() {
        ResultSet resultSet= SqlConnector.readData("select * from monthly_mortgage");
      try{
          while (resultSet.next()){
             // Home obj= new Home(driver)
             new Home(driver)
                     //obj.typeHomePrice("homevalue")
                      .typeHomePrice(resultSet.getString("homevalue"))
                      .typeDownPayment(resultSet.getString("downpayment"))
                      .clickDownPaymentDollar()
                      .typeLoanAmount(resultSet.getString("loanamount"))
                      .typeInterestRate(resultSet.getString("interestrate"))
                      .typeLoanTerm(resultSet.getString("loanterm"))
                      .selectMonth(resultSet.getString("startdatemonth"))
                      .selectYear(resultSet.getString("startdateyear"))
                      .typePropertyText(resultSet.getString("propertytax"))
                      .typePMI(resultSet.getString("pmi"))
                      .typeHomeInsurance(resultSet.getString("homeownerinsurance"))
                      .selectMonthlyHoa(resultSet.getString("monthlyhoa"))
                      .selectLoanTypeFHA(resultSet.getString("loantype"))
                      .selectBuyOrRefinance(resultSet.getString("buyorrefi"))
                      .clickCalculateButton()
                      .validateTotalMonthlyPayment(resultSet.getString("totalmonthlypayment"));
          }

      }catch(SQLException e){
       LOGGER.error(e.getMessage());
      }


    }
    @AfterMethod
    public void closeBrowser(){
        LOGGER.info("End Test Case And Browser close");
        ActOn.browser(driver).closeBrowser();
    }
}
