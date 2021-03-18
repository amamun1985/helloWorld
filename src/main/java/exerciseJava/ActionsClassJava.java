package exerciseJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class ActionsClassJava {
    /*
    What we can do with actions class
        1.doubleClick()
        2.clickAndHold
        3.contextClick()
        4.dragAndDrop(source ,target)
        5.drahAndDropBt(source,x-offSet,y-offSet)
        6.moveToElement(toElement)
        7.release()
     */
    WebDriver driver;

    @Test
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://wayfair.com");
        driver.manage().window().maximize();

        Actions actions=new Actions(driver);
        WebElement x= (WebElement) driver.findElement(By.id("DepartmentItem-Furniture"));
        actions.moveToElement(x).perform();
        driver.findElement(By.xpath("//*[@id=\"store_nav\"]/nav[1]/ul/li[1]/div/div/ul/li[1]/ul/li[1]/a")).click();
        /*
        When I have to mouseHover more than once in an element
        store as y for second mouseHover.Then again
         actions.moveToElement(x).moveToElement(y).moveToElement(driver.findElement(By.id("abc"))).click();
         */




    }
}