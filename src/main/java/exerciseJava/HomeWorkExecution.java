package exerciseJava;

import java.util.Arrays;

public class HomeWorkExecution {

    public static void main (String[]args){
        HomeWork myObj=new HomeWork();


/*        System.out.println(Arrays.toString(myObj.arrayFirstElement(new int[] {1,2,3},new int[] {7,9,8})));
        System.out.println(Arrays.toString(myObj.arrayMiddle(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(myObj.arrayMiddle(new int[] {7,1,2,3,4,9})));
        System.out.println(Arrays.toString(myObj.arrayMiddle(new int[] {1,2})));
        System.out.println(myObj.arraySummation(new int[] {1,2,3,4}));*/




        System.out.println(Arrays.toString(myObj.fizzArray(4)));
        System.out.println(Arrays.toString(myObj.fizzArray(1)));
        System.out.println(Arrays.toString(myObj.fizzArray(10)));

         System.out.println(myObj.countHi("abc, bbb"));
        System.out.println(myObj.countHi("ABChi hi"));
       System.out.println( myObj.countHi("hihi"));

        System.out.println(myObj.loneSum(1,2,3));
        System.out.println(myObj.loneSum(3,2,3));
        System.out.println(myObj.loneSum(3,3,3));







    }
}
