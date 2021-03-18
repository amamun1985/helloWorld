package command_providers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;


public class BrowserAction {
    public WebDriver driver;

    public BrowserAction(WebDriver driver){
        this.driver=driver;
    }

    public BrowserAction openBrowser(String url){
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();
        return this;
    }
    public BrowserAction closeBrowser(){
        driver.quit();
        return this;
    }
   public BrowserAction validateTitle(String expectedTitle){
       String act=driver.getTitle();
       Assert.assertEquals(act,expectedTitle);

       return this;

   }
   public BrowserAction switchWindow(int index){
        String windowId=null;
       Set<String> windowIds=driver.getWindowHandles();
       Iterator<String> iter=windowIds.iterator();
       for (int i=1;i<=index;i++){
           windowId=iter.next();
       }
       driver.switchTo().window(windowId);
        return this;
   }
}
// public String validateTitle(String s){ return driver.getTitle();}
