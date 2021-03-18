package exerciseJava;

import org.junit.Test;

import java.util.Arrays;

public class ArrayLearn {

    //#################Sum Of ARRAY###########
    public void sumArray(){
        int[] a={5,2,3,20};
        int sum=0;
        /*for(int i=0;i<=a.length-1;i++){
            sum=sum+a[i];
        }
        System.out.println(sum);*/
        //Also I can do with enhanced for loop
    for (int b:a){
        sum=sum+b;//0+
    }
    System.out.println(sum);
    }

//##############How to print even or odd from Array############################

    public void evenOrOddArray() {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
    System.out.println("This is all even number:   ");
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                System.out.println(a[i]);
            }
        }
    System.out.println("This is all Odd number:   ");
            for (int i=0;i<a.length;i++){
                if (a[i]%2 !=0){
                    System.out.println(a[i]);
                }
            }

    //Special for loop we can do so
    System.out.println("This is all even number:   ");
    for(int value:a){
       if (value%2==0){
           System.out.println(value);
       }
    }
    System.out.println("This is all odd number:   ");
    for(int value:a){
        if (value%2!=0){
            System.out.println(value);
        }
    }

        }
@Test
       //####################How to shorting the array###################
    public  void shortArray(){
    int[] numbers = {4, 9, 1, 3, 2, 8, 7, 0, 6, 5};

    System.out.println(Arrays.toString(numbers));

     Arrays.sort(numbers);

    System.out.println(Arrays.toString(numbers));
    }
    }


