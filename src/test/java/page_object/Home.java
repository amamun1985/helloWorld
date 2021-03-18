package page_object;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends NavigationBar{
    private final By HomeValue=By.id("homeval");
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

    private static final Logger LOGGER= LogManager.getLogger(NavigationBar.class);

    public Home(WebDriver driver) {
        super(driver);
    }
    public Home typeHomePrice(String value){
       LOGGER.debug("Home price is: "+value);
        //Enter Home Value 300000
        ActOn.element(driver,HomeValue).setValue(value);
        return this;
    }
    public Home typeDownPayment(String value){
        LOGGER.debug("DownPayment is: "+value);
        //enter Down Payment 60000
        ActOn.element(driver,downPayment).setValue(value);
        return this;
    }
    public Home clickDownPaymentDollar(){
        LOGGER.debug("Click downPaymentIn dollar ");
        //select radio button
        ActOn.element(driver,downPaymentDollar).click();
        return this;
    }
    public Home typeLoanAmount(String value){
        LOGGER.debug("Loan amount is: "+value);
        //Enter loan Amount
        ActOn.element(driver,LoanAmount).setValue(value);
        return this;
    }
    public Home typeInterestRate(String value){
        LOGGER.debug("Home interest rate is: "+value);
//enter Interest Rate
        ActOn.element(driver,InterestRate).setValue(value);
        return this;
    }
    public Home typeLoanTerm(String value){
        LOGGER.debug("Loan term years is: "+value);
        //enter Loan term
        ActOn.element(driver,LoanTerm).setValue(value);
        return this;
    }
    public Home selectMonth(String month){
        LOGGER.debug("Enter month: "+month);
        //Select Start Date by drop down and select nov
        ActOn.element(driver,MonthDropDown).selectValue(month);
        return this;
    }
    public Home selectYear(String year){
        LOGGER.debug("Enter year: "+year);
        //enter year 2020
        ActOn.element(driver,YearSelect).setValue(year);
        return this;
    }
    public Home typePropertyText(String value){
        LOGGER.debug("Enter propertyTax: "+value);
        // enter property Tax
        ActOn.element(driver,PropertyTax).setValue(value);
        return this;
    }
    public Home typePMI(String value){
        LOGGER.debug("Enter PMI: "+value);
        //enter PMI
        ActOn.element(driver,PMI).setValue(value);
        return this;
    }
    public Home typeHomeInsurance(String value){
        LOGGER.debug("Enter Home Insurance: "+value);
        //enter Home ins
        ActOn.element(driver,HomeIns).setValue(value);
        return this;
    }
    public Home selectMonthlyHoa(String value){
        //Enter monthly HOA 100
        ActOn.element(driver,MonthlyHOA).setValue(value);
        return this;
    }
    public Home selectLoanTypeFHA(String value){
        LOGGER.debug("Enter loan type : "+value);
        //Select Loan Type FHA
        ActOn.element(driver,LoanType).selectValue(value);
        return this;
    }
    public Home selectBuyOrRefinance(String value){
        LOGGER.debug("Select buy 0r refinance option: "+value);
        //select buy 0r refinance option
        ActOn.element(driver,BuyOrRefi).selectValue(value);
        return this;
    }
    public Home clickCalculateButton(){
        LOGGER.debug("Click on calculate button");
        //click Calculate button
        ActOn.element(driver,Calculate).click();
        return this;
    }
    public Home validateTotalMonthlyPayment(String totalMonthlyPayment){
LOGGER.info("expected total monthly payment"+totalMonthlyPayment);
        By monthlyPaymentLocator=By.xpath("//*[@id='calc']//h3[text()='"+totalMonthlyPayment+"']");
        AssertThat.elementAssertions(driver,monthlyPaymentLocator).elementExist();
        return this;
    }
}
