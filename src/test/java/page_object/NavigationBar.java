package page_object;

import command_providers.ActOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    private final By Rates_Link=By.linkText("Rates");
    private final By RealAPR_link=By.linkText("Real APR");
    private final By MortGageCalculateLogo=By.xpath("//img[@alt='Logo']");

     WebDriver driver;

    public NavigationBar(WebDriver driver){
        this.driver=driver;
    }
    public NavigationBar mouseHoverRates(){
        ActOn.element(driver,Rates_Link).mouseHover();
        return this;
    }
    public RealAPR clickONRealApr(){
    ActOn.element(driver,RealAPR_link).click();

        return new RealAPR(driver);
    }
public Home navigateToHome(){
        ActOn.element(driver,MortGageCalculateLogo).click();
return new Home(driver);
}
}
