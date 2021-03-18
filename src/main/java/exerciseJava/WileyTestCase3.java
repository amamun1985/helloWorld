package exerciseJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WileyTestCase3 {
    WebDriver driver;
    @Test
    public void validateJavaOnSearchBoxWithTitle() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get(" https://www.wiley.com/en-us");
        driver.manage().window().maximize();

        driver.findElement(By.id("js-site-search-input")).sendKeys("Java");
        driver.findElement(By.xpath("//span[@class='input-group-btn']")).click();

        String containingWord="Java";
        boolean present=driver.findElements(By.xpath("//span[text()='"+containingWord+"']")).size()<=10;
        System.out.println("Total Java word displays:10"+ present);

        List<WebElement> ActualWordEbooks=driver.findElements(By.xpath("//button[text()='Add to cart']"));
        System.out.println("total number of elements :"+ActualWordEbooks.size());

        driver.quit();
    }
}
