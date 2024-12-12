package se.advent.linda;

import java.util.HashMap;
import java.util.Map;

public class File_for_testing{

    Map<String, Long> change_once(Map<String, Long> input, String number, Long times){
        input.put(number, (input.get(number)-times));
        if ("0".equals(number)){
            input.put("1", input.getOrDefault("1", 0L)+times);
        }
        else if (number.length()%2 == 0) {
            String one = number.substring(0, (number.length()/2));
            String two = Long.valueOf(number.substring((number.length()/2), number.length())).toString();
            input.put(one, input.getOrDefault(one, 0L)+times);
            input.put(two, input.getOrDefault(two, 0L)+times);
        }
        else{
            Long test = Long.parseLong(number)*2024;
            input.put(test.toString(), input.getOrDefault(test.toString(), 0L)+times);
        }
        return input;
    }

    Map<String, Long> one_iteration(Map<String, Long> input){
        Map<String,Long> test2 = new HashMap<>(input);
        for (String elem : input.keySet()) {
            if(input.get(elem) != 0){
                    test2 = change_once(test2, elem, input.get(elem));
                    //System.out.println(test2);
            }
        }
        return test2;
    }

    public static void main(String[] args) {
        File_for_testing testing = new File_for_testing();
        
        Map<String, Long> test = new HashMap<>();
        test.put("125", 1L);
        test.put("17", 1L);

        Long total = 0L;
        Integer counter = 50;
        for (int i = counter; i > 0; i--) {
            test = testing.one_iteration(test);
            //System.out.println(test);
        }
        System.out.println(test);
        for (String elem : test.keySet()) {
            total += test.get(elem);            
        }
        System.out.println(total);
    }
}