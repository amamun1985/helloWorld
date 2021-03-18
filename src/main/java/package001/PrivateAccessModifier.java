package package001;

//Private access modifier only ca access in this class.if I try to use in another class it will not work.
//even If I want to execute in another I can not do that.
//that why I have to write main method in this class to execute .
//even If I use "Inheritances" I can not access any other class or any other package.
 class PrivateAccessModifier {

     private int salary=1500;

     private int mySalary(){
         return salary;
     }
     public static void main(String[]args){
         PrivateAccessModifier obj = new PrivateAccessModifier();
         obj.mySalary();
         System.out.println(obj.mySalary());
     }
}
