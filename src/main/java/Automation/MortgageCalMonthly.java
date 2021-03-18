package Automation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
////
////I JUST MAKE AS COMMENT TO DO LATER.
/*import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;*/

import java.util.concurrent.TimeUnit;

public class MortgageCalMonthly {
    private final By homeValue=By.id("homeval");
    private final By downPayment=By.id("downpayment");
    private final By downPaymentDollar=By.xpath("//*[@id='calc']//input[@name='param[downpayment_type]'][@value='money']");
    private final By LoanAmount=By.id("loanamt");
    private final By InterestRate=By.id("intrstsrate");
    private final By LoanTerm=By.id("loanterm");
    private final By MonthDropDown=By.name("param[start_month]");
    private final By YearSelect=By.id("start_year");
    private final By PropertyTax=By.id("pptytax");
    private final By PMI=By.id("pmi");
    private final By HomeIns=By.id("hoi");
    private final By MonthlyHOA=By.id("hoa");
    private final By LoanType=By.name("param[milserve]");
    private final By BuyOrRefi=By.name("param[refiorbuy]");
    private final By Calculate=By.name("cal");


    WebDriver driver;
    Select select;

    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
    }

    public void enterData(){
        //Enter Home Value 300000
        driver.findElement(homeValue).clear();
        driver.findElement(homeValue).sendKeys("300000");
        //enter Down Payment 60000
        driver.findElement(downPayment).clear();
        driver.findElement(downPayment).sendKeys("60000");
        //select radio button
        driver.findElement(downPaymentDollar).click();
        //Enter loan Amount
        driver.findElement(LoanAmount).clear();
        driver.findElement(LoanAmount).sendKeys("240000");
        //enter Interest Rate
        driver.findElement(InterestRate).clear();
        driver.findElement(InterestRate).sendKeys("3");
        //enter Loan term
        driver.findElement(LoanTerm).clear();
        driver.findElement(LoanTerm).sendKeys("30");
        //Select Start Date by drop down and select nov
        select=new Select(driver.findElement(MonthDropDown));
        select.selectByVisibleText("Nov");
        //enter year 2020
        driver.findElement(YearSelect).clear();
        driver.findElement(YearSelect).sendKeys("2020");
        // enter property Tax
        driver.findElement(PropertyTax).clear();
        driver.findElement(PropertyTax).sendKeys("2400");
        //enter PMI
        driver.findElement(PMI).clear();
        driver.findElement(PMI).sendKeys("0.5");
        //enter Home ins
        driver.findElement(HomeIns).clear();
        driver.findElement(HomeIns).sendKeys("1000");
        //Enter monthly HOA 100
        driver.findElement(MonthlyHOA).clear();
        driver.findElement(MonthlyHOA).sendKeys("100");
        //Select Loan Type FHA
        select =new Select(driver.findElement(LoanType));
        select.selectByVisibleText("FHA");
        //select buy 0r refinance option
        select=new Select(driver.findElement(BuyOrRefi));
        select.selectByVisibleText("Buy");


    }

    public void calculateRate() throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        enterData();
        //click Calculate button
        driver.findElement(Calculate).click();

        //validate calculated rate 1,395.18
        String total_monthly_payment="$1,395.18";
        boolean present=driver.findElements(By.xpath("//*[@id='calc']//h3[text()='"+total_monthly_payment+"']")).size()>0;
////
        ////I JUST MAKE THIS LINE COMMENT TO DO LATE.

        //Assert.assertTrue(present,"total monthly calculated is wrong");

        Thread.sleep(6000);
    }

    public void closeBrowser(){
        driver.quit();
    }


}
