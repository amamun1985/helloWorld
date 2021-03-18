package command_providers;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screen {
    private static final Logger LOGGER= LogManager.getLogger(Screen.class);
    private WebDriver driver;
    private By locator;

    public Screen(WebDriver driver,By locator){
        this.driver=driver;
        this.locator=locator;
    }
    public Screen myScreenShot(String fileName) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("C:/project 001 java/target"+fileName+".png"));
        return this;
    }
}
