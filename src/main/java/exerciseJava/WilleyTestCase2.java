package exerciseJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class WilleyTestCase2 {

    WebDriver driver;
    @Test
    public void validateItemsInTheSearchBox() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get(" https://www.wiley.com/en-us");
        driver.manage().window().maximize();

        driver.findElement(By.id("js-site-search-input")).sendKeys("Java");
        Thread.sleep(10000);
        List<WebElement> list= driver.findElements(By.xpath("//div[@class='search-list']//div/descendant::a[@tabindex='-1']"));
        System.out.println("total number of elements :"+list.size());
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).getText());
            Thread.sleep(10000);
            if(list.get(3).getText().contains("javad")){
              System.out.println("When enter java in search box relared items shown");

            }

        }
    }
}
