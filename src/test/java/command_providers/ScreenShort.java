package command_providers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScreenShort {
    public static Screen myShort(WebDriver driver, By locator){
        return new Screen(driver,locator);
    }
}
