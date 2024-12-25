package se.advent.linda.ninth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Day9 {
        String raw_data_line(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\ninth\\input" + test + ".txt");
        String rawlist = "";
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
            rawlist += read_file.nextLine();
        }
            } catch (FileNotFoundException ex) {
            }
        return rawlist;
    }

    List<String> make_first_string(String input){
    List<String> finalstring = new ArrayList<>(input.length());
    Long counter = 0L;
    for (Integer i = 0; i < input.length(); i++) {
        if (i%2 == 0){
            finalstring.addAll(converter(counter.toString(), Integer.valueOf(input.substring(i, i+1)))); 
            counter ++;
        }
        else{
            finalstring.addAll(converter(".", Integer.valueOf(input.substring(i, i+1))));
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

    List<String> make_list(String input){
        List<String> input_list = new ArrayList<>(input.length());
        for (String elem : input.split("")) {
            input_list.add(elem);
        }
        return input_list;
    }

    Long find_dots(List<String> list){
        Long counter = 0L;
        for (String elem : list) {
            if(elem.equals(".")){
                counter ++;
            }
        }
        return counter;
    }

    List<String> sorting(List<String> converted_string){
        List<String> temp_list = new ArrayList<>(converted_string);
        Long counter = find_dots(converted_string);
        for (int i = converted_string.size()-1; i > converted_string.size()-counter-1; i--) {
            Collections.swap(temp_list, temp_list.indexOf("."), i);
        }
        return temp_list.subList(0, (int)(temp_list.size()-counter));
    }

    Long find_sum(List<String> sorted_list){
        Long counter = 0L;
        for (int i = 0; i < sorted_list.size(); i++) {
            counter += i * Integer.parseInt(sorted_list.get(i));
        }
        return counter;
    }
    
    //44995 t0 low
    //524795972 to low
    //90719109188 to low
    public static void main(String[] args) {
        Day9 day = new Day9();
        List<String> first_string = day.make_first_string(day.raw_data_line("test"));
        List<String> sorted_final_list = new ArrayList<>(day.sorting(first_string));
        System.out.println(first_string);
        System.out.println(day.find_sum(sorted_final_list));
        //System.out.println((day.find_sum(sorted_final_list)>90719109188L) ? "Yes, Its lager":"No, its smaller");
    }
}