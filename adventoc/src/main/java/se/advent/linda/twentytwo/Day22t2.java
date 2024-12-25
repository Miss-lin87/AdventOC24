package se.advent.linda.twentytwo;

import java.util.ArrayList;
import java.util.List;

public class Day22t2 {
    
    public static void main(String[] args) {
        Day22 day = new Day22();
        List<Long> inital_numbers = day.make_list(day.make_raw_data("test"));
        List<Long> results = new ArrayList<>();
        Long test = 123L;
        int times = 9;
        //for (int i = 0; i < inital_numbers.size(); i++) {
            //Long temp = inital_numbers.get(i);
            while (times != 0){
                test = day.do_all_steps(test);
                System.out.println(test.toString().charAt(test.toString().length()-1));
                times --;
            }
            //results.add(temp);
            times = 2000;
        //System.out.println(temp);
    //}
    }
}
