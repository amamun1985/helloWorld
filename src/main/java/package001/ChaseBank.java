package package001;

public class ChaseBank extends BankOfAmerica{

    public void withDroMoney() {

        super.withDroMoney();
    }

    public int depositMoney(int cash, int check,int other) {
        int total=cash+check+other;
        return super.depositMoney(cash, check);
    }
    public void textCustomer(){
        System.out.println("Thanks for our valued customer");
    }
    public static void main(String[]args){
        ChaseBank obj=new ChaseBank();
        int x=obj.depositMoney(200,300,400);
        System.out.println(x);
        int y=obj.depositMoney(100,150);
        System.out.println(y);
        obj.textCustomer();


    }
}
