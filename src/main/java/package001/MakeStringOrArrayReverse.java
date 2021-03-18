package package001;

public class MakeStringOrArrayReverse {
    //first we are going to reverse a String.
    public void myReverse(){
        String sentence="Whoever love to eat halal burger ,please come in New York";
        //first split this string to array.
        String[] words=sentence.split(" ");
        for (int i=words.length-1;i>=0;i--){
            System.out.print( " "+words[i]);
        }
    }
    //now we are going to reverse an array directly
    public void myReverse1(){
        String[] names={"Abdullah","Mohammad","Hasan","Alex"};
        for(int i=names.length-1;i>=0;i--){
            System.out.print(" "+  names[i]);
        }
    }

}
