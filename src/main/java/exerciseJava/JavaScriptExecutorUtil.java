package exerciseJava;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class JavaScriptExecutorUtil {


    public static void flash(WebElement element, WebDriver driver) {

        //Flushing on element
        String bgcolor = element.getCssValue("backgroungColor");
        for (int i = 0; i < 100; i++) {
            changeColor("#000000", element, driver);
            changeColor(bgcolor, element, driver);
        }
    }

    public static void changeColor(String color, WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
        }
    }

    //Drow Border on element
    public static void drowBorder(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border = ' 10px solid red'", element);

    }

    //Get title by JavaScriptExecutor
    public static String getTitleByJS(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    //Click method By JavaScriptExecutor
    public static void clickElementByJS(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", element);
    }

    //Alert massage by JavaScriptExecutor
    public static void generateAlert(WebDriver driver,String message) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("alert('" +message+"')");
    }

    //refresh the page by JS
    public static void refreshPage(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("history.go(0)");
    }

    //Scroll the page  down
    public static void scrollDown(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    //Scroll the page  down all the way end
    public static void scrollDownTillEnd(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

}