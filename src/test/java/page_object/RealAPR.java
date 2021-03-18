package page_object;

import command_providers.ActOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RealAPR extends NavigationBar{


    private final By HomeValue=By.name("HomeValue");
    private final By DownPayment=By.name("DownPayment");
    private final By DownPaymentInDollar=By.name("DownPaymentSel");
    private final By InterestRate=By.name("Interest");
    private final By CalculateButton=By.name("calculate");
    private final By ActualAPR=By.xpath("//*[@id='analysisDiv']/table/tbody/tr/td/strong[text()='Actual APR:']/../../td[2]/strong");
    //*[@id='analysisDiv']//strong[text()='3.130%']------another xpath for ActualAPR

    public RealAPR(WebDriver driver) {
        super(driver);
    }
public RealAPR typeHomeValuePrice(String value){
    ActOn.element(driver,HomeValue).setValue(value);
        return this;
}
public  RealAPR typeDownPayment(String value){
    ActOn.element(driver,DownPayment).setValue(value);
        return  this;
}
public RealAPR selectDownPaymentInDollar(){
    ActOn.element(driver,DownPaymentInDollar).click();
        return this;
}
public RealAPR typeInterestRate(String value){
    ActOn.element(driver,InterestRate).setValue(value);
        return this;
}
public RealAPR clickOnCalculateButton(){
    ActOn.element(driver,CalculateButton).click();
        return this;
}
public RealAPR validateAprRate(String expectedValue){
    String aprRate=ActOn.element(driver,ActualAPR).getTextValue();

    Assert.assertEquals(aprRate,expectedValue);
        return this;
}

}
