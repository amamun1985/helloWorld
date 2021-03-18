package exerciseJava;




public class StringJava {


    public void indexOf(){
        String myString="Hello planet earth,you are a greate planet";
        System.out.println(myString.indexOf("planet"));     //6
        System.out.println(myString.indexOf("e",5));  //
        System.out.println(myString.toUpperCase());
        System.out.println(myString.toLowerCase());

        System.out.println(myString.indexOf("planet"));
        System.out.println(myString.substring(6,12));    //it wiil print particular word.

        System.out.println(myString.replace('e','x'));

        System.out.println(myString.length());

        System.out.println(myString.contains("are"));

        System.out.println(myString.replaceFirst("planet","myplanet"));

        System.out.println(myString.replace('e','x'));

        //If any word I am searching and it is not in the string it will give -1
        System.out.println(myString.concat(" everybody say."));
        System.out.println(myString.concat(""));

    }

    public void learnSubString(String searchTxt){
        String myString="        Hello planet earth,you are a greate planet";
        int index=myString.indexOf(searchTxt);
        String word=myString.substring(index,index+searchTxt.length());
        System.out.println(word);
        System.out.println(word.concat(" Hi planet"));


        System.out.println(myString.trim());

    }

    //Without split how to reverse a string
    public void learnCharAt(){
        String myStr="hello world";
        for(int i=0;i<myStr.length();i++){
            System.out.println(myStr.charAt(i));//individual value print
        }
        int count=0;
        for(int i=0; i < myStr.length(); i++)
        {    if(myStr.charAt(i) == 'o')
            count++;

        }

    }
    public static void main (String[]args){
   StringJava obj=new StringJava();
   obj.learnCharAt();


    }

}
