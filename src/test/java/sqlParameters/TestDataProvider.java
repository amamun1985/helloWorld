package sqlParameters;

import org.testng.annotations.Test;
import utilities.DataProviderClasses;

public class TestDataProvider {
    @Test(dataProvider = "MultipleValue",dataProviderClass = DataProviderClasses.class)
    public void readMultipleValue(String name,String State,int zipCode){
        System.out.println("name is :"+name);
        System.out.println("State is :"+State);
        System.out.println("zipCode is: "+zipCode);


    }

}
