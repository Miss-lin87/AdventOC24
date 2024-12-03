package se.advent.linda.thirdday;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {

    String make_raw_data(){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\thirdday\\input.txt");
        String rawlist = null;
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
            rawlist += read_file.nextLine();
        }
            } catch (FileNotFoundException ex) {
            }
        return rawlist;
        }

    String[] mod_string(String input){
        String[] test = input.split("mul");
        return test;
    }

    String find_valid_data(String input){
        String mod1_input = input.substring(1);
        int index = mod1_input.indexOf(")");
        String mod2_input = mod1_input.subSequence(0, index).toString();
        return mod2_input;
    }

    int convertANDmultiply(String input){
        String[] mod_input = input.split(",");
        int result = Integer.parseInt(mod_input[0])*Integer.parseInt(mod_input[1]);
        return result;
        }

public static void main(String[] args) {
    Day3 day = new Day3();
    int total = 0;
    String input = day.make_raw_data();
    String[] test = day.mod_string(input);
    for (int i = 0; i < test.length; i++) {
        try {
            String test2 = day.find_valid_data(test[i]);
            total += day.convertANDmultiply(test2);
        } catch (Exception e) {
        }
    }
    System.err.println(total);
}
}
