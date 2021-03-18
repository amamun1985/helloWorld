package exerciseJava;

import org.apache.logging.log4j.core.appender.ConsoleAppender;

public class MethodParameterAndArgument {

    public static int methodParameter(int a,int b) {
            int sum=a+b;
             return sum;
        }
    public static void main (String[]args){

        //MethodParameterAndArgument obj=new MethodParameterAndArgument();
          int x=methodParameter(10,20);
          System.out.println(x);

    }


}
