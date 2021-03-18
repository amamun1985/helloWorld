package exerciseJava;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class JavaScriptExecutionTestingMainMethod {

    WebDriver driver;
    @Test
    public void openBrowser() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.twoplugs.com/");
        driver.manage().window().maximize();
         WebElement joinFree=driver.findElement(By.xpath("/html/body/div/header/div/ul/li[2]/a/span"));

         //Flushing
         JavaScriptExecutorUtil.flash(joinFree,driver);

         //Drow border
        JavaScriptExecutorUtil.drowBorder(joinFree,driver);

        //Take the screen shot
        //File src= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(src,new File("c://screenshot/twoplugs.png"));

        //Get title
        String title=JavaScriptExecutorUtil.getTitleByJS(driver);
        System.out.println(title);


        //Click method by JavaScriptExecutor
       // WebElement loginButton=driver.findElement(By.xpath("/html/body/div/header/div/ul/li[1]/a/span"));
        //loginButton.click();
        //JavaScriptExecutorUtil.clickElementByJS(loginButton,driver);

        //Alert on run time after click
        //JavaScriptExecutorUtil.generateAlert(driver,"You click on loginButton");

        //Refresh the page
        //JavaScriptExecutorUtil.refreshPage(driver);

        //Scroll down the page until I found the element
       // WebElement image=driver.findElement(By.xpath("//*[@id=\"rslides3_s0\"]/div[1]/img"));
        //JavaScriptExecutorUtil.scrollDown(image,driver);

        //Scroll down until the end.
        JavaScriptExecutorUtil.scrollDownTillEnd(driver);

    }

}
