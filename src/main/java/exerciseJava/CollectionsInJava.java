package exerciseJava;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class CollectionsInJava {


    //printout an array list
    public void myLists(){
        List<String> numbers=new ArrayList<>();
        numbers.add("two");
        numbers.add("three");
       // numbers.set(1,"four");
        numbers.add("one");
        //Updateing to the list

        System.out.println(numbers);
        Collections.sort(numbers);
        System.out.println(numbers);

        List<String> listStrings = new ArrayList<String>();
        listStrings.add("D");
        listStrings.add("C");
        listStrings.add("E");
        listStrings.add("A");
        listStrings.add("B");
        System.out.println("listStrings before sorting: " + listStrings);
        Collections.sort(listStrings);
        System.out.println("listStrings after sorting: " + listStrings);


      //  copy and paste  from one list to another list

        List<String> sourceList = new ArrayList<String>();
        sourceList.add("A");
        sourceList.add("B");
        sourceList.add("C");
        sourceList.add("D");
        sourceList.add("e");
        List<String> destList = new ArrayList<String>();
        destList.add("V");
        destList.add("W");
        destList.add("X");
        destList.add("Y");
        destList.add("Z");
        System.out.println("destList before copy: " + destList);
        //Collections.copy(destList, sourceList);
        Collections.copy(destList,sourceList);
        System.out.println("destList after copy: " + destList);


      /*  if (numbers.remove("one")) {
            System.out.println("number is removed from the list");
        } else {
            System.out.println("There is no such element");
        }
        System.out.println(numbers);
        numbers.clear();*/
    }
    public void myList2(){
        List<Number> linkedNumbers = new LinkedList<>();
        linkedNumbers.add(123);
        linkedNumbers.add(3.1415);
        linkedNumbers.add(299.988);
        linkedNumbers.add(67000);
        linkedNumbers.add(20.05);

        if(linkedNumbers.contains(123)){
            System.out.println("element exist");
        }else {
            System.out.println("there is no such element");
        }

        /*System.out.println(linkedNumbers.remove(0));
        System.out.println(linkedNumbers);*/
    }
    public void getList(){
        LinkedList<Integer> numbers = new LinkedList<>();
// add elements to the list...
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        for (int elements : numbers) {
            System.out.println(elements);
        }
// get the first and the last elements:
        Number first = numbers.getFirst();
        Number last = numbers.getLast();
        System.out.println(first);
        System.out.println(last);
    }


    public void reverseElementInAList(){
        List<Integer> numbers = new ArrayList<Integer>();
      /*  numbers.add(10);
          numbers.add(20);
          numbers.add(30);
          numbers.add(40);
          numbers.add(50);
          numbers.add(60);*/
        for (int i = 0; i <= 30; i++) numbers.add(i);
        System.out.println("List before reversing: " + numbers);
        Collections.reverse(numbers);
        System.out.println("List after reversing: " + numbers);

    }
    public void returnMidleOfAnyList(){
        List<String> listNames = Arrays.asList("Tom", "John", "Mary", "Peter", "David", "Alice");
        System.out.println("Original list: " + listNames);
        List<String> subList = listNames.subList(2,3);
        System.out.println("Sub list: " + subList);
    }
    public void convertListToArray(){
        List<String> listNames = Arrays.asList("John", "Peter", "Tom", "Mary", "David", "Sam");
        List<Integer> listNumbers = Arrays.asList(1, 3, 5, 7, 9, 2, 4, 6, 8);
        System.out.println(listNames);
        System.out.println(listNumbers);
        int x=listNames.size();
        System.out.println(x);
    }

    public void array001() throws FileNotFoundException {
try {
    int a = 30, b = 0;
    int c = a/b;  // cannot divide by zero
    System.out.println ("Result = " + c);
}catch (ArithmeticException e){
    System.out.println("can not devided a number by 0");
}
        // Following file does not exist
    File file=new File("C:\\jav\\refinanceJava.iml");
    FileReader fl=new FileReader(file);


    }
   /* public static void main(String[]args){
        //CollectionsInJava obj=new CollectionsInJava();
        //obj.myLists();
        //obj.myList2();
       //obj.getList();
        //obj.reverseElementInAList();
       //obj.returnMidleOfAnyList();
        //obj.convertListToArray();
    }*/
}
