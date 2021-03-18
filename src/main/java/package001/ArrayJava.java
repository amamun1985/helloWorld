package package001;

public class ArrayJava {

    public void myArray(){
       /* String name="Abdullah";
        String name1="Hasan";
        String name2="Mohammad";
        System.out.println(name);
        System.out.println(name1);
        System.out.println(name2);*/
        //String[]names={"Abdullah","Hasan","Mohammad"};


        String a="abdullah";
        String[] name=a.split("");
       for(int i=name.length-1;i>=0;i--){
           System.out.print(""+name[i]);
       }
    }


}
