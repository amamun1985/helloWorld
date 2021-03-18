package package001;

public class EnumJava {
    enum levels{
        HIGH,
        MEDIUM,
        LOW
    }
    public void myEnum(){

    }
    public static  void main(String[]args) {
        levels obj=levels.HIGH;
    /*switch(obj){
        case HIGH:
            System.out.println("This is level high.");
            break;
        case MEDIUM:
            System.out.println("This is level medium.");
            break;
        case LOW:
            System.out.println("This level Low");
            break;

    }*/
        if(obj== levels.HIGH){
            System.out.println("This is High");
        }else if(obj==levels.MEDIUM){
            System.out.println("this is medium");
        }else if(obj==levels.LOW){
            System.out.println("this is low");
        }else{
            System.out.println("You enter wrong level");
        }
    }

}
