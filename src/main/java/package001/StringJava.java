package package001;

public class StringJava {
    public  String myString () {
        String sentence="Today is very   cold";
       //System.out.println(sentence.toLowerCase());
        /*System.out.println(sentence.toUpperCase());
        System.out.println(sentence.length());
        System.out.println(sentence.indexOf("job"));
        System.out.println(sentence.indexOf('i'));
        System.out.println(sentence.contains("january2020"));
        System.out.println(sentence.substring(64,71));
        System.out.println(sentence.substring(1));
        System.out.println(sentence.replace('o','i'));
        System.out.println(sentence.trim());*/
        return sentence;
    }
    public static void main(String[]args){
StringJava obj=new StringJava();
     System.out.println(obj.myString().substring(10));
     /*   System.out.println(myString().replace('i','S'));
        System.out.println(myString().indexOf("very"));
        System.out.println(myString().substring(9));*/


    }
}
