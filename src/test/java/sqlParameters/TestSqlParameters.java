package sqlParameters;

import org.testng.annotations.Test;
import utilities.SqlConnector;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSqlParameters {
    @Test
    public  void testDataBaseValues(){
        ResultSet resultSet= SqlConnector.readData("select * from monthly_mortgage");
        try{
            while(resultSet.next()){
                System.out.println("The home price is: "+resultSet.getString("homevalue"));
                System.out.println("The home price is: "+resultSet.getString("downpayment"));
                System.out.println("The home price is: "+resultSet.getString("loanamount"));
                System.out.println("The home price is: "+resultSet.getString("loanterm"));
                System.out.println("The home price is: "+resultSet.getString("startdatemonth"));
                System.out.println("The home price is: "+resultSet.getString("startdateyear"));
            }
        }catch(SQLException e){
              System.out.println(e.getMessage());
        }

    }
}
