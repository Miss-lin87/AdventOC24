package se.advent.linda.thirteenth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day13 {
    String raw_data_line(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\thirteenth\\input" + test + ".txt");
        String rawlist = "";
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
                rawlist += "\n" + read_file.nextLine();
            }
            } catch (FileNotFoundException ex) {
            }
        return rawlist.substring(1);
        }

    List<String> make_list(String[] input){
        List<String> output = new ArrayList<>();
        String temp = "";
        for (String row : input) {
            if(!row.equals("")){
                temp += row;
            }
            else{
                output.add(row);
                temp = "";
            }
        }
        return output;
    }
    
    Button make_button(String input){
        return null;
    }

    public static void main(String[] args) {
        Day13 day = new Day13();
        String[] test = day.raw_data_line("test").split("\n");
        List<String> 
        //System.out.println(day.make_list(day.raw_data_line("test").split("\n")));
        //System.out.println(Arrays.toString(test));
        /*for (String elem : test) {
            if(elem.equals("")){

            }
            System.out.println(elem);
        }*/
    }
}
