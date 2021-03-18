package new_command_provider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class New_Element_Action {
    public WebDriver driver;
    public By locator;
    public New_Element_Action(WebDriver driver,By locator){
        this.driver=driver;
        this.locator=locator;
    }
    public WebElement getElement(){
        WebElement element=null;
        try{
            element= driver.findElement(locator);
        }catch (Exception e){
            System.out.println("This is the element locator: "+locator+"This is the exception: "+e);
        }
        return element;
    }
    public New_Element_Action click(){
       getElement().click();
        return this;
    }
    public New_Element_Action setValue(String value){
        getElement().clear();
        getElement().sendKeys(value);
        return this;
    }
    public New_Element_Action selectValue(String value){
        Select select=new Select(getElement());
        select.selectByVisibleText(value);
        return this;
    }
    public New_Element_Action mouseHover(){
        Actions actions=new Actions(driver);
        actions.moveToElement(getElement()).perform();
        return this;
    }
    public String getTextValue(){
        return getElement().getText();
    }

}
