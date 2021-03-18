package package001;

public class SplitArrayMethod {
    //we do splitArray when we have a string and we need to store that string into an array.
    //first we need to declare a string
    //then we need to split that string into an array
    //lets do it
    public void mySplitArray(){
        String names="Hasan,Nazmul,Ali,Abdullah,Raihan,Hudaifa";
        String[] name=names.split(",");
        for (int i=0;i<name.length;i++){
            System.out.println(name[i]);
        }
    }
}
