package exerciseJava;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapCollectonJava {
    public void hashMap(){
        Map<Integer, String> mapHttpErrors = new HashMap<>();

        mapHttpErrors.put(200, "OK");
        mapHttpErrors.put(303, "See Other");
        mapHttpErrors.put(404, "Not Found");
        mapHttpErrors.put(500, "Internal Server Error");

        System.out.println(mapHttpErrors);
    }
    //LinkedHashMap always follow the orders when execute
    public void linkHashMap(){
        Map<String, String> mapContacts = new LinkedHashMap<>();

        mapContacts.put("01", "Tom");
        mapContacts.put("03", "Peter");
        mapContacts.put("08", "Mary");
        mapContacts.put("05", "John");

        System.out.println(mapContacts);
    }

    //this tree map autometically order its map
    public void myTree(){
        Map<String, String> mapLang = new TreeMap<>();

        mapLang.put(".c", "C");
        mapLang.put(".java", "Java");
        mapLang.put(".pl", "Perl");
        mapLang.put(".cs", "C#");
        mapLang.put(".php", "PHP");
        mapLang.put(".cpp", "C++");
        mapLang.put(".xml", "XML");
        mapLang.put(".abc", "Abdullah");

        System.out.println(mapLang);
    }
    public static void main(String[]args){
        MapCollectonJava obj=new MapCollectonJava();
        obj.hashMap();//it does not follow the orders
        obj.linkHashMap();//this is as it is
        obj.myTree();//this always order as alphabetecally/numberly
    }

}
