package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    @Test

    public static String returnNextMonth(){
        //String dNow="11/20/2020";
        //create date object
        Date dNow=new Date();
        //create calender object for gregorian calender
        Calendar calendar=new GregorianCalendar();
        //set calender date to current date
        calendar.setTime(dNow);

        //create object of simpleDateFormat
        SimpleDateFormat sdf=new SimpleDateFormat("mm/yyyy");
        //incrementing the current month
        calendar.add(Calendar.MONTH,1);
        //generating the time date based on the specified format
        String date=sdf.format(calendar.getTime());
        return date;

    }
}
