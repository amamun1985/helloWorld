package exerciseJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WileyTestCase1 {
    private static final Logger LOGGER= LogManager.getLogger(WileyTestCase1.class);
    private final By WhoWeServe=By.xpath("//*[@id='main-header-navbar']/ul[1]/li[1]/a");
    private final By AllLocators=By.xpath("//div[@id='Level1NavNode1']//ul/descendant::li[@class='dropdown-item ']");

    WebDriver driver;
    @Test
    public void wileyOpenPagewhoWeServe() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get(" https://www.wiley.com/en-us");
        driver.manage().window().maximize();

        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(WhoWeServe)).perform();

        List<WebElement> list= driver.findElements(AllLocators);
        LOGGER.info("total number of elements :"+list.size());
        for (int i=0;i<list.size();i++){
            boolean element=driver.findElements(AllLocators).size()>0;
            Assert.assertEquals(list.size(),12);

        }
    }
}
