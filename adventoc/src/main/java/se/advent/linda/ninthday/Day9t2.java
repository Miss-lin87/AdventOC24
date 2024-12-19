package se.advent.linda.ninthday;

import java.util.ArrayList;
import java.util.List;

public class Day9t2 {
    Day9 day = new Day9();

    List<List<String>> make_first_list(String input){
        List<List<String>> finalstring = new ArrayList<>(input.length());
        Long counter = 0L;
        for (Integer i = 0; i < input.length(); i++) {
            if (i%2 == 0){
                finalstring.add(converter(counter.toString(), Integer.valueOf(input.substring(i, i+1)))); 
                counter ++;
            }
            else{
                finalstring.add(converter(".", Integer.valueOf(input.substring(i, i+1))));
            }
        }
        return finalstring;
        }
    
        List<String> converter(String character, Integer times){
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < times; i++) {
                temp.add(character);
            }
            return temp;
        }

        List<List<String>> remove_empty(List<List<String>> input){
            for (List<String> list : input) {
                if(list.isEmpty()){
                    input.remove(input.indexOf(list));
                }
            }
            return input;
        }

    List<String> sorting_first(List<String> total_list){
        for (int i = total_list.size()-1; i > 0; i--){
            if(!".".equals(total_list.get(i))){
                try {
                    
                } catch (Exception e) {
                }
                System.out.print(total_list.lastIndexOf(total_list.get(i)) - total_list.indexOf(total_list.get(i))+1 + "|");
                //System.out.print(total_list.indexOf(total_list.get(i)) + "|");
                //System.out.println(total_list.lastIndexOf(total_list.get(i)));
             }
        return total_list;
    }

    List<List<String>> sorting_final(List<List<String>> complete_list, List<String> list_to_move){
        List<List<String>> changed_list = new ArrayList<>(complete_list);
        for (int i = 0; i < complete_list.size(); i++) {
            if(complete_list.get(i).size() > list_to_move.size() && complete_list.get(i).contains(".")){
                changed_list.set(complete_list.indexOf(complete_list.get(i)), (complete_list.get(i).subList(list_to_move.size(), complete_list.get(i).size())));
                changed_list.set(complete_list.indexOf(list_to_move), make_only_dots(new ArrayList<>(list_to_move)));
                changed_list.add(complete_list.indexOf(complete_list.get(i)), list_to_move);
                //System.out.println(changed_list);
                //System.out.print(complete_list.get(i).toString());
                //System.out.println(list_to_move.toString());
                break;
            }
        }
        return changed_list;
    }

    List<String> make_only_dots (List<String> input){
        for (int i = 0; i < input.size(); i++) {
            input.set(i, ".");
        }
        return input;
    }

    public static void main(String[] args) {
        Day9t2 day2 = new Day9t2();
        //List<List<String>> firstlist = new ArrayList<>(day2.make_first_list(day2.day.raw_data_line("test")));
        //System.err.println(firstlist);
        //System.out.println(day2.remove_empty(firstlist));
        List<String> numbers = new ArrayList<>(day2.day.make_first_string(day2.day.raw_data_line("test")));
        System.out.println(numbers);
        day2.sorting_first(numbers);
        //firstlist = day2.remove_empty(firstlist);
        //firstlist = day2.sorting_first(firstlist);
    }

}
