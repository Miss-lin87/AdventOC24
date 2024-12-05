package se.advent.linda.fifthday;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5 {
        List<String> get_rulings_list(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\fifthday\\inputrule" + test +".txt");
        List<String> rawlist = new ArrayList<>();
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
                String[] temp = read_file.nextLine().split("\n");
                for (String elem : temp) {
                    rawlist.add(elem);
                }
        }
            } catch (FileNotFoundException ex) {
            }
        return rawlist;
    }

    List<String> get_raw_data(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\fifthday\\input" + test +".txt");
        List<String> raw_string = new ArrayList<>();
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
                String[] temp = read_file.nextLine().split("\n");
                for (String elem : temp) {
                    raw_string.add(elem.replace(",", "|"));
                }
        }
            } catch (FileNotFoundException ex) {
            }
        return raw_string;
    }

    boolean test_valid_one(List<String> rules, String input){
        boolean test_one;
        test_one = rules.contains(input);
        return test_one;
    }

    boolean test_valid_all(List<String> rules , String[] input){
        int counter = 0;
        String number_pair = "";
        boolean test = true;
        for (String elem : input) {
            for (int i = 1; i < input.length-counter; i++) {
                number_pair = (elem + "|" + input[i+counter]);
                //System.out.println(number_pair);
                if(test_valid_one(rules, number_pair)==false){
                    test = false;
                    break;
                }
            }
            counter ++;
            //System.out.println("");
        }
        //System.out.println(test);
        return test;
    }

    int find_midle_number(String[] input){
        int midle = input.length/2;
        int output = Integer.parseInt(input[midle]);
        return output;
    }
    public static void main(String[] args) {
        Day5 day = new Day5();
        int total = 0;
        List<String> rules = day.get_rulings_list("");
        //System.out.println(rules);
        List<String> input = day.get_raw_data("");
        for (int i = 0; i < input.size(); i++) {
            String[] temp = input.get(i).split("\\|");
            //System.out.println(Arrays.toString(input.get(i).split("\\|")));
            if (day.test_valid_all(rules, temp) == true){
                total += day.find_midle_number(temp);
            }
            
        }
        System.out.println(total);
    }
}