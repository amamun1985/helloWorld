package exerciseJava;

import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.junit.Test;

public class FactorialFinding {
@Test
    public void myFactorial(){
        int num=20;
       // int factorial=1;//if factorial is too big use data type long instead od int
        long factorial=1;  //if i want to 1*2*3*4 like this. Also we can not declare as 0.because 0 multify anything is 0.
        for (int i=1;i<=num;i++){
            factorial=factorial*i;
        }
        System.out.println(factorial);

    }
}
