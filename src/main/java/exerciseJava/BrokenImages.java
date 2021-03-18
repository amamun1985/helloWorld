package exerciseJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenImages {
    @Test
    public void brokenImages() throws InterruptedException, IOException {

        //go to this github account for proxy set up also "https://bit.ly/3nttoPh"

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.theworldsworstwebsiteever.com/");
        Thread.sleep(5000);
        List<WebElement> images =driver.findElements(By.tagName("img"));
        System.out.println(images.size());

        for(WebElement image :images){
            String imageSrc=image.getAttribute("src");


            try {
                URL url=new URL(imageSrc);
                URLConnection urlConnection= url.openConnection();
                HttpURLConnection httpURLConnection=(HttpURLConnection) urlConnection;
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();
                if(httpURLConnection.getResponseCode()==200)
                    System.out.println(imageSrc+">>>>"+httpURLConnection.getResponseCode()+">>>>"+httpURLConnection.getResponseMessage());
                else System.err.println(imageSrc+">>>>"+httpURLConnection.getResponseCode()+">>>>"+httpURLConnection.getResponseMessage());

                httpURLConnection.disconnect();
            }catch (Exception e){
                System.err.println(imageSrc);
            }
        }
           driver.quit();
    }
}
