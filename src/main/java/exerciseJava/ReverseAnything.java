package exerciseJava;

import org.junit.Test;

public class ReverseAnything {


    public void intReverse(){
        int number=123456;
        int rev=0;
        while (number!=0){
            rev=rev*10+number%10;
            number=number/10;
        }
        System.out.println("Reverse number is :"+rev);
    }

    //another way is StringBuffer
    public void numReverse(){
        int number=96587458;
        StringBuffer sb=new StringBuffer(String.valueOf(number));
        StringBuffer rev=sb.reverse();
        System.out.println(rev);
    }

    //another way is StringBuilder class
    public void intRev(){
        StringBuilder sb1=new StringBuilder();
        sb1.append(4567);
        StringBuilder rev=sb1.reverse();
        System.out.println(rev);
    }
//#############################String Reverse####################################################################
    public void stringRev(){
        String str="Abdullah al mamun";
        String rev="";
        for(int i=str.length()-1;i>=0;i--){
            rev=rev+str.charAt(i);
        }
        System.out.println(rev);
    }

    public void myString(){
        String str="Abdullah Al mamun";
        String[]str1=str.split(" ");
        for(int i=str1.length-1;i>=0;i--){
            System.out.print(" "+str1[i]);
        }
    }
    @Test
    public void stringreverse(){
        String str="Abdullah Al Mamun";
        StringBuffer sb=new StringBuffer(str);
        System.out.println(sb.reverse());
    }
}
