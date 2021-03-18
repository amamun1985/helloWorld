package package001;

public class PolymorphismJava {
    public int multiplication(int a,int b){
        int multiplication=a*b;
        return multiplication;

    }
    public int multiplication(int a,int b,int c){
        int multiplication=a*b*c;
        return multiplication;
    }
    public double multiplication(double a,double b){
        double multiplication=a*b;
        return multiplication;
    }
   public static void main(String[]args){
        PolymorphismJava obj=new PolymorphismJava();
        int x=obj.multiplication(10,5);
       int y= obj.multiplication(10,10,10);
        double z=obj.multiplication(5.25,6.95);
        System.out.println(x);
       System.out.println(y);
       System.out.println(z);
   }
}
