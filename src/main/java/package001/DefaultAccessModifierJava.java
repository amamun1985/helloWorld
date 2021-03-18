package package001;

              // Default Access Modifier....

//this is default access modifier.no need to mention public.we can access within the classes og package001only.
//we can not use this class in another package.
//see we do not have access modifier(public) on class
// but still we can execute in another class.(ExecutionHello.java)
//for default modifier we do not declare any access modifier on variables.(

class DefaultAccessModifierJava {      //just delete public.
    int salary=1000;             //no need to declare any access modifier.
     void displayText(){         //just delete public.
        System.out.println("We love selenium");
    }
}
