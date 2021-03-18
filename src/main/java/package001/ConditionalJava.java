package package001;

public class ConditionalJava {
    public void myIfCondition(){
        int a=50;
        if(a<60){
            System.out.println("this is true");
        }
    }
    public void myCondition1(){
        int b=5;
        if (b<1){
            System.out.println("This is true");
        }else{
            System.out.println("This is false");
        }
    }
    public void myCondition2(){
        int c=10;
        int d=15;
        if(c<20){
            if(d>30){
                System.out.println("This is exact true");
            }else {
                System.out.println("This is 100% false");
            }
        }
    }
}
