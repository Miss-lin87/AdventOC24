package se.advent.linda.second;

import java.util.ArrayList;
import java.util.List;

public class Day2t2{
    boolean test_safe_damp(List<Integer> list){
        Day2 day = new Day2();
        List<Integer> temp = new ArrayList<>(list);
            for (int i = 0; i < temp.size(); i++) {
                list.remove(i);
                if (day.list_accen(list) | day.list_desc(list) == true){
                    return true;
                }
                else{list.add(i, temp.get(i));}     
            }
        return false;
    }

public static void main(String[] args) {
    Day2t2 day2 = new Day2t2();
    Day2 day = new Day2();
    int result = 0;
    List<List<Integer>> x = day.make_raw_data();
    for (int i = 0; i < x.size(); i++) {
        if (day.list_desc(x.get(i)) | day.list_accen(x.get(i)) == true){
            result ++;
        }
        else{
            if (day2.test_safe_damp(x.get(i))==true){
                result ++;
            }
        }
        }
    System.err.println(result);    
    }
}