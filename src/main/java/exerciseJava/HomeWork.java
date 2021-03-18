package exerciseJava;

import java.util.HashMap;
import java.util.Map;

public class HomeWork {
    /*
    Ques:Create a method that will accept 2 int array,a and b,any length of parameter.
    return a new array with the first element of each array.
    Sample output:
    arrayFirstElement([1,2,3],[7,9,8])-----[1,7]
    arrayFirstElement([1],[2])-----[1,2]
     */
    public int[] arrayFirstElement(int[] a, int[] b) {
       /* int[] newArray={a[0],b[0]};    //one way
        int[] array=new int[] {a[0],b[0]};    //2nd way

        int[] array1=new int[2];    //3rd way
        array1[0]=a[0];
        array1[1]=b[0];*/

        return new int[]{a[0], b[0]}; // profesional way

        // return newArray; //this is for one 2nd and 3rd way return.All are same
    }

    /*
    Ques:Create a method to return a new array contaning the middle two elements from the orignal array.
    The original array will be length 2 or more  and will be always even length.
    output:
    arrayMiddle([1,2,3,4])-----[2,3]
    arrayMiddle([7,1,2,3,4,9])-----[2,3]
    arrayMiddle([1,2])-----[1,2]
     */
    public int[] arrayMiddle(int[] a) {
        return new int[]{a[a.length / 2 - 1], a[a.length / 2]};
    }

    /*
    Ques:Create a method that will return the summation of the array elements
    OutPut:
    arraySummation([1,2,3,4])-------10

     */
    public int arraySummation(int[] a) {
        int sum = 0;
        for (int number : a) {
            sum = sum + number;
        }
        return sum;
    }
    /*
    Problem 1:
Create a method that will accept an array of strings as a method parameter, return a HashMap<String, Integer> containing a key for every different string in the array, always with the value 0.
Sample Output Example:
word0(["a", "b", "a", "b"]) → {"a": 0, "b": 0}
word0(["a", "b", "a", "c", "b"]) → {"a": 0, "b": 0, "c": 0}
word0(["c", "b", "a"]) → {"a": 0, "b": 0, "c": 0}
word0(["c", "c", "c", "c"]) → {"c": 0}

Hints: To validate a key exist in a Hash Map you can use containsKey.

Method Structure -


     */

    /*public HashMap<String, Integer> word0(String[] strings) {


    }*/

/*
Problem 2:
Create a method that will accept an array of strings as a method parameter, return a Map<String, Integer> containing a key for every different string in the array, and the value is that string's length.
Sample Output Example:
wordLen(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 1}
wordLen(["this", "and", "that", "and"]) → {"that": 4, "and": 3, "this": 4}
wordLen(["code", "code", "code", "bug"]) → {"code": 4, "bug": 3}

Method Structure -

 */



  /* Problem 3:
        Create a method that will accept a number n as a method parameter, create and return a new int array of length n, containing the numbers 0, 1, 2, ... n-1. The given n maybe 0, in which case just return a length 0 array.
        Sample Output Example:
        fizzArray(4) → [0, 1, 2, 3]
        fizzArray(1) → [0]
        fizzArray(10) → [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]*/

    public int[] fizzArray(int n) {
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = i;

        return arr;
    }


    /*Problem 4:
        Create a method that will return the number of times that the string "hi" appears anywhere in the given string. The method will accept a String as a parameter.
        Sample Output Example:
        countHi("abc hi ho") → 1
        countHi("ABChi hi") → 2
        countHi("hihi") → 2*/
    public  int countHi(String string) {
        int count =0;
        return countHi(string,count);
    }

    public int countHi(String string, int count) {
        if(string.length()==0)
            return count;
        else {
            if(string.endsWith("hi"))
                count++;

            return countHi(string.substring(0, string.length()-1) , count);
        }
    }




    /*
       Problem 5:
       Create a method that will accept 3 int values, a b c, as a parameter and return their sum. However, if one of the values is the same as another of the values, it does not count towards the sum.
       Sample Output Example:
       loneSum(1, 2, 3) → 6
       loneSum(3, 2, 3) → 2
       loneSum(3, 3, 3) → 0
        */
    public int loneSum(int a, int b, int c) {
        int sum = 0;
        if (a != b && a != c){
            sum += a;
        } if((b != a && b != c)){
            sum += b;
        }{
            if (c != a && c != b)
                sum += c;
        }
        return sum;
    }






    }





