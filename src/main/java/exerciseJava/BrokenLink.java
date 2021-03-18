package exerciseJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLink {

    @Test
    public void brokenLinks() throws InterruptedException {

        //go to this github account for proxy set up also "https://bit.ly/3nttoPh"

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        Thread.sleep(5000);
        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        //linkList.addAll(driver.findElements(By.tagName("img")));//if I want to add images at the same time//this is optional//or We can searcg link and images together.
        System.out.println(linkList.size());

        for (WebElement image : linkList) {
            String links = image.getAttribute("href");

            try {
                URL url=new URL(links);
                URLConnection urlConnection= url.openConnection();
                HttpURLConnection httpURLConnection=(HttpURLConnection) urlConnection;
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();
                if(httpURLConnection.getResponseCode()==200)
                    System.out.println(links+">>>>"+httpURLConnection.getResponseCode()+">>>>"+httpURLConnection.getResponseMessage());
                else System.err.println(links+">>>>"+httpURLConnection.getResponseCode()+">>>>"+httpURLConnection.getResponseMessage());

                httpURLConnection.disconnect();
            }catch (Exception e){
                System.err.println(links);
            }
        }
        driver.quit();
        }
    }
