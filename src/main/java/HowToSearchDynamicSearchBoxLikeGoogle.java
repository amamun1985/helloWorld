import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HowToSearchDynamicSearchBoxLikeGoogle {
    private static Logger LOGGER= LogManager.getLogger(HowToSearchDynamicSearchBoxLikeGoogle.class);
    WebDriver driver;
    @Test
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("apple green");
        driver.findElement(By.id("nav-search-submit-button")).click();
        List<WebElement>list =driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
        System.out.println(list.size());
        LOGGER.info("all elements");
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i).getText());

            if (list.get(i).getText().contains("apple")) {
                list.get(i).click();
                break;
            }

        }

    }

}
