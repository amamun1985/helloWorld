package package001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ConvertArrayToList {
    //Create an array
    public void myConvertArrayToList(){
        int[] numbers={10,20,30,40,50,60,70};
        System.out.println(Arrays.toString(numbers));
        List<Integer> nums=new ArrayList<Integer>();
        for (int i=0;i<nums.size();i++){
            System.out.println( ","+ nums.get(i));
        }
    }


}
