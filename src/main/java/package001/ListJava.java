package package001;

import java.util.ArrayList;
import java.util.List;

public class ListJava {
    List<String> names=new ArrayList<>();
    //List is also one kind ofArray.
    //difference between Array and ListArray is:  we can add,remove and modify any value without replacing existing value.

    //First we create a ListArray.
    public void myListArray(){
        names.add("Sultan");
        names.add("Ali");
        names.add("Rifat");
        names.add("Aladdin");
        names.add("Nasir");
    }
    //now if I want to add any new name.I can do it.Lets do it now
     public void mylistArray1(){
        names.add("Mahmudul-Hasan");
        names.add("Mamun");
     }

     public void removeFormList(){
        names.remove("Sultan");

     }
    public void printList(){
        myListArray();
        mylistArray1();
        removeFormList();

        for(int i=0;i<names.size();i++){
            System.out.print("  " + names.get(i));
        }
    }
}
