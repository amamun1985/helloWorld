package Automation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//make this comment to do later
/*
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
*/

public class CalcuRates {
    private final By Rates=By.linkText("Rates");
    private final By RealAPR=By.linkText("Real APR");
    WebDriver driver;


    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
    }
    public void navigateToRatePage(){
        //Mouse hover to rates Link
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(Rates)).perform();
        driver.findElement(RealAPR).click();

    }

    public void calculateRealAPR() {
        navigateToRatePage();


        driver.findElement(By.name("HomeValue")).clear();
        driver.findElement(By.name("HomeValue")).sendKeys("200000");

        driver.findElement(By.name("DownPayment")).clear();
        driver.findElement(By.name("DownPayment")).sendKeys("15000");

        driver.findElement(By.name("DownPaymentSel")).click();

        driver.findElement(By.name("Interest")).clear();
        driver.findElement(By.name("Interest")).sendKeys("3");

        driver.findElement(By.name("calculate")).click();


        String aprRate=driver.findElement(By.xpath("//*[@id='analysisDiv']/table[1]/tbody//strong[contains(text(),'Actual APR')]/../../td[2]/strong")).getText();

        ////make this comment to do later
        // Assert.assertEquals(aprRate,"3.130%");
    }



    public void closeBrowser(){
        driver.quit();
    }

}
