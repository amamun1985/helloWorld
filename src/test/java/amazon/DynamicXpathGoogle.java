package amazon;

import automation_test.mortgage_calculate_parameter.CalculateMonthlyPaymentParameterise;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DynamicXpathGoogle {
    private static final Logger LOGGER= LogManager.getLogger(CalculateMonthlyPaymentParameterise.class);
    WebDriver driver;

    @Test
    public void xpathDynamic(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https:www.google.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("testing");
       List<WebElement> list= driver.findElements(By.xpath("//ul[@class='erkvQe']/li"));
       //"//ul[@role='listbox']//li/descendant::div[@class='sbl1']"
       //System.out.println("total number of elements :"+list.size());
      /* for (int i=0;i<list.size();i++){
           System.out.println(list.get(i).getText());
           if(list.get(i).getText().contains("testing near me")){
               list.get(i).click();
               break;
           }*/
       //}
        for(WebElement el:list){
            System.out.println(el.getText()+"***");
            if (el.getText().trim().equals("testing near me")){
                el.click();
            }
        }
    }
}
