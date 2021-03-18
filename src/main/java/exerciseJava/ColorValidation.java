package exerciseJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import java.io.IOException;

public class ColorValidation {


    WebDriver driver;

    @Test
    public void openBrowser() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.twoplugs.com/");
        driver.manage().window().maximize();
        WebElement joinFree = driver.findElement(By.xpath("/html/body/div/header/div/ul/li[2]/a/span"));
        String color=joinFree.getCssValue("color");
        System.out.println(color);   //it will give rgba like this (225,225,225,2)
        String col =Color.fromString(color).asHex();
        System.out.println(col);
        //now validate the color
        if(col.equals("#ffffff")){
            System.out.println("This is the right color and test pass");
        }else{
            System.out.println("wrong color and test fail");
        }
        driver.quit();
    }

}