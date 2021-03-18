package amazon;

import command_providers.ActOn;
import command_providers.AssertThat;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HPLaptop {
    private final By ClickAllDropDowm= By.id("searchDropdownBox");
    private final By ClickSearchVar =By.id("twotabsearchtextbox");
    private final By ClickSearchButton=By.id("nav-search-submit-text");
    private final By FreeShipping=By.xpath("//*[@id='p_76/1249137011']//i[@class='a-icon a-icon-checkbox']");
    private final By PriceAbove200=By.id("p_36/1253507011");
    private final By ClickHPLink=By.xpath("//*[@id='search']//a/span[text()='HP 15-dy1036nr 10th Gen Intel Core i5-1035G1, 15.6-Inch FHD Laptop, Natural Silver']");
    private final By ClickOnCart=By.id("add-to-cart-button");
    private final By ClickOnCartButton=By.id("nav-cart-count");
    private final By ValidateSubTotalPrice=By.xpath("//*[@id='sc-subtotal-amount-activecart']/span[text()='$511.04']");


    WebDriver driver;
    Select select;
    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        ActOn.browser(driver).openBrowser("http://www.amazon.com/");
    }
    @Test
    public void laptopPriceValidation(){
        ActOn.element(driver,ClickAllDropDowm).click();
        ActOn.element(driver,ClickAllDropDowm).selectValue("Electronics");
        ActOn.element(driver,ClickSearchVar).setValue("HP Laptop");
        ActOn.element(driver,ClickSearchButton).click();
        ActOn.element(driver,FreeShipping).click();
        ActOn.element(driver,PriceAbove200).click();
        ActOn.element(driver,ClickHPLink).click();
        ActOn.element(driver,ClickOnCart).click();
        ActOn.element(driver,ClickOnCartButton).click();

        AssertThat.elementAssertions(driver,ValidateSubTotalPrice).elementExist();
     /*  String expectedPrice="$511.34";
       String actualPrice=ActOn.element(driver,ValidateSubTotalPrice).getTextValue();
        Assert.assertEquals(actualPrice,expectedPrice);*/

       // String tot_monthly_payment = "$701.18";
//        By monthlyPaymentLocator = By.xpath("//*[@id='calc']//h3[text()='" + tot_monthly_payment + "']");
//        AssertThat.elementAssertions(driver, monthlyPaymentLocator).elementExist();

    }

  @AfterMethod
  public void closeBrowser(){

        ActOn.browser(driver).closeBrowser();
  }
}
