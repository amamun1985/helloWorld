package utilities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClasses {
    @DataProvider(name="SingleValue")
    public Object[][] storeSingleValue(){
        return new Object[][]{{"Abdullah"},{"Mohammad"},{"Hasan"},{"Abbus"}};
    }
    @DataProvider(name="MultipleValue")
    public Object[][]storeMultipleValue(){
        return new Object[][]{{"Momin","New York",33162},{"Raihan","Atlanta",11433},{"Akash","Miami",55426}};
    }
  @Test(dataProvider = "SingleValue")
    public void readSingleValue(String name){
        System.out.println("Single value is: "+name);
        //in this case I do not need to use loop.It automatically use loop for me
    }
    @Test(dataProvider ="MultipleValue")

    public void readMultipleValue(String name,String State){
        System.out.println("Multiple value name :"+name);
        System.out.println("Multiple State: ");
    }
    @DataProvider(name="RealAprRates")
    public Object[][] storeRealApr(){
        return new Object[][]{{"200000","15000","3","3.130%"}};
    }
}
