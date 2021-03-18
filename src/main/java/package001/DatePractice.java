package package001;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatePractice {

    WebDriver driver;
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("www.expedia.com");

    }

        public static String returnNextMonth(){
            //create date object
            Date dNow=new Date();
            //create calender object for gregorian calender
            Calendar calendar=new GregorianCalendar();
            //set calender date to current date
            calendar.setTime(dNow);

            //create object of simpleDateFormat
            SimpleDateFormat sdf=new SimpleDateFormat("mm-yyyy");
            //incrementing the current month
            calendar.add(Calendar.MONTH,1);
            //generating the time date based on the specified format
            String date=sdf.format(calendar.getTime());
            return date;

        }
    public static  void main(String[]args) {

        DatePractice obj=new DatePractice();
       String x= obj.returnNextMonth();
       System.out.println(x);

    }
    }

