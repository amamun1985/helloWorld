package new_command_provider;

import org.openqa.selenium.WebDriver;

public class Browser_Actions {
   public WebDriver driver;
   public Browser_Actions(WebDriver driver){
       this.driver=driver;
   }
   public Browser_Actions openBrowser(String url){
       driver.manage().deleteAllCookies();
       driver.get(url);
       driver.manage().window().maximize();
       return this;
   }
   public Browser_Actions closeBrowser(){
       driver.quit();
       return this;
   }
   public String getTitle(){
       return driver.getTitle();
   }
}
