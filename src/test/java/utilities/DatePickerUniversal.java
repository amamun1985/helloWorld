package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DatePickerUniversal {
    @Test

    public void testDAtePicker(){

        //DAte and Time to be set in textbox

        String dateTime ="12/10/2020";

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.hotels.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //button to open calendar

        WebElement selectDate = driver.findElement(By.id("widget-query-label-1"));

        selectDate.click();

        //button to move next in calendar

        WebElement nextLink = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div[2]/div[1]/button[2]"));

        //button to click in center of calendar header

       // WebElement midLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-fast')]"));

        //button to move previous month in calendar

        WebElement previousLink = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div[1]/div[1]/button[1]"));

        //Split the date time to get only the date part

        String date_MM_dd_yyyy[] = (dateTime.split(" ")[1]).split("/");

        //get the year difference between current year and year to set in calander

        int yearDiff = Integer.parseInt(date_MM_dd_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);

        //midLink.click();

        if(yearDiff!=0){

            //if you have to move next year

            if(yearDiff>0){

                for(int i=0;i< yearDiff;i++){

                    System.out.println("Year Diff->"+i);

                    nextLink.click();

                }

            }

            //if you have to move previous year

            else if(yearDiff<0){

                for(int i=0;i< (yearDiff*(-1));i++){

                    System.out.println("Year Diff->"+i);

                    previousLink.click();

                }

            }

        }

        //Thread.sleep(1000);

        //Get all months from calendar to select correct one

        List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath("//div[@class='widget-datepicker-label']"));

        list_AllMonthToBook.get(Integer.parseInt(date_MM_dd_yyyy[0])-1).click();

        //Thread.sleep(1000);

        //get all dates from calendar to select correct one

        List<WebElement> list_AllDateToBook = driver.findElements(By.xpath("//div[@class='widget-datepicker-bd']"));

        list_AllDateToBook.get(Integer.parseInt(date_MM_dd_yyyy[1])-1).click();

        ///FOR TIME

       // WebElement selectTime = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_timeview']"));

        //click time picker button

       // selectTime.click();

        //get list of times

       /* List<WebElement> allTime = driver.findElements(By.xpath("//div[@data-role='popup'][contains(@style,'display: block')]//ul//li[@role='option']"));

        dateTime = dateTime.split(" ")[1]+" "+dateTime.split(" ")[2];

        //select correct time*/

      /*  for (WebElement webElement : allTime) {

            if(webElement.getText().equalsIgnoreCase(dateTime))

            {

                webElement.click();

            }

        }*/

    }

}
