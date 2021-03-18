package package001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertListToArray {
    public void myConvertListToArray(){
        List<Integer> employeeId=new ArrayList<>();
        employeeId.add(101);
        employeeId.add(102);
        employeeId.add(103);
        employeeId.add(104);
        employeeId.add(105);
        employeeId.add(106);
        //lets convert this list to Array
        Integer[] idNum=employeeId.toArray(new Integer[employeeId.size()]);  //do not forget to write Integer.Because it is non premitive data type.
        System.out.println(Arrays.toString(idNum));                           //If i write int it will not work.
        for (int i=0;i<idNum.length;i++){
            System.out.println(idNum[i]);
        }
    }
}
