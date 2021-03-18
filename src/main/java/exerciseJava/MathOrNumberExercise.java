package exerciseJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class MathOrNumberExercise {
  /*  public static int readfromScanner() {
        Scanner scan=new Scanner(System.in);
        System.out.println("My input is x:");
        int num1=scan.nextInt();
        for (int i=0; i< 10; i++){
            System.out.println(num1+"x"+(i+1) +"="+ num1 * (i+1));
        }
        return num1;
    }*/


    public static void main(String[] args) {
        List<String> listStrings = new ArrayList<String>();
        listStrings.add("D");
        listStrings.add("C");
        listStrings.add("E");
        listStrings.add("A");
        listStrings.add("B");
        System.out.println("listStrings before sorting: " + listStrings);
        Collections.sort(listStrings);
        System.out.println("listStrings after sorting: " + listStrings);

    }
}




