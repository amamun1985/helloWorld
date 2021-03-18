package package001;

public class ExceptionJava {

    public void myException(){
        try{
        String[] names={"Abdullah","Hasan","Ali","Amina"};
        System.out.println(names[6]);
    }catch(Exception e){
            System.out.println(e);
        }
    }


    public void myException1(){
        String[] names={"Adam","Hasan","Ali","Amina"};
        System.out.println(names[0]);
    }
}
