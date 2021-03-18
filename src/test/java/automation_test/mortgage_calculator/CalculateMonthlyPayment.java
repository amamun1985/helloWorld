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

public class CalculateMonthlyPayment {
    private static final Logger LOGGER= LogManager.getLogger(CalculateMonthlyPayment.class);
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

        new Home(driver)
                .typeHomePrice("300000")
                .typeDownPayment("60000")
                .clickDownPaymentDollar()
                .typeLoanAmount("240000")
                .typeInterestRate("3")
                .typeLoanTerm("30")
                .selectMonth("Nov")
                .selectYear("2020")
                .typePropertyText("2400")
                .typePMI("0.5")
                .typeHomeInsurance("1000")
                .selectMonthlyHoa("100")
                .selectLoanTypeFHA("FHA")
                .selectBuyOrRefinance("Buy")
                .clickCalculateButton()
                .validateTotalMonthlyPayment("$1,395.18");


    }
    @AfterMethod
    public void closeBrowser(){
        LOGGER.info("End Test Case And Browser close");
       ActOn.browser(driver).closeBrowser();
    }
}
