package se.advent.linda;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class File_for_testing{


    public static void main(String[] args) {
        File_for_testing testing = new File_for_testing();
        
        List<String> line = new LinkedList<>();

        Map<String, Integer> storage = new Hashtable<>();
        storage.put("key", 1);
        storage.put("key", 2);
        System.out.println(storage);
    }
}