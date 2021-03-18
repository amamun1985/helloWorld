package exerciseJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadingSelenium {
    WebDriver driver;
    @Test
    public void uploadFile() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://mail.google.com/mail/u/0/?tab=rm&ogbl#inbox");
        driver.manage().window().maximize();
        driver.findElement(By.id("identifierId")).sendKeys("rumamun01@gmail.com");
        driver.findElement(By.id("identifierNext")).click();

        driver.findElement(By.id(":ta")).sendKeys("C:\\Users\\rumam\\OneDrive\\Desktop\\Resume2021\\Abdullah Mamun-Resume.doc");
       // Thread.sleep(5000);


    }

}
