package exerciseJava;

import org.junit.Test;

import java.util.Random;

public class RandomNumberAndString {
@Test
    public void rendomNumber(){
        //random
        Random rand=new Random();
        int rand_int=rand.nextInt(20);//for integer
        System.out.println(rand_int);

        double rand_double=rand.nextDouble();
        System.out.println(rand_double);


        //another way
    System.out.println(Math.random());
    }
}
