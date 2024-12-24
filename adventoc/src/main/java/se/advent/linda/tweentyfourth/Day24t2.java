package se.advent.linda.tweentyfourth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day24t2 {

    void test (List<String> operations){
        for (int i = 0; i < operations.size(); i++) {
            String Valuez = operations.get(i).substring(operations.get(i).indexOf("->")+3, operations.get(i).length()).strip();
            if(Valuez.startsWith("z")){
                System.out.println("found z, index: " + i);
            }
        }
    }

    void test_line (List<String> operations, String line, int firstORsecund) {
        
    }
    
    public static void main(String[] args) {
        Day24 day = new Day24();
        Day24t2 day2 = new Day24t2();
        Map<String, Wiers> wiremap = new HashMap<>(day.make_map(day.make_wiers(day.raw_data_line("test"))));
        List<String> org_operations = new ArrayList<>(day.make_operations(day.raw_data_line("test")));
        List<String> operations = new ArrayList<>(day.make_operations(day.raw_data_line("test")));
        //day.calculations(wiremap, operations);
        day2.test(org_operations);
    }
}
