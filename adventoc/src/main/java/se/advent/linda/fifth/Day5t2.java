package se.advent.linda.fifth;

import java.util.List;

public class Day5t2{
    String[] sort_list(String[] input_to_sort){
        for (int i = 0; i < input_to_sort.length-1; i++) {
            if (Integer.parseInt(input_to_sort[i]) < Integer.parseInt(input_to_sort[i+1])){
                String temp;
                temp = input_to_sort[i];
                input_to_sort[i] = input_to_sort[i+1];
                input_to_sort[i+1] = temp;
            }
        }
        return input_to_sort;
    }

    String[] sort_to_valid(List<String> rules, String[] sorted_list){
        Day5 day = new Day5();
        for (int i = sorted_list.length-1; i > 0; i--) {
            if (day.test_valid_one(rules, (sorted_list[i-1] + "|" +  sorted_list[i])) == false){
                String placeholder;
                placeholder = sorted_list[i];
                sorted_list[i] = sorted_list[i-1];
                sorted_list[i-1] = placeholder;
                sort_to_valid(rules, sorted_list);
            }
        }
        return sorted_list;
    }
    public static void main(String[] args) {
        Day5 day = new Day5();
        Day5t2 day2 = new Day5t2();
        int counter = 0;
        List<String> rules = day.get_rulings_list("");
        List<String> input = day.get_raw_data("");
        for (int i = 0; i < input.size(); i++) {
            String[] temp = input.get(i).split("\\|");
            if (day.test_valid_all(rules, temp) == false){
                temp = day2.sort_to_valid(rules, day2.sort_list(temp));
                counter += day.find_midle_number(temp);
            }
        }
    System.out.println(counter);
    }
}
