package se.advent.linda.eleventday;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Day11 {
    String raw_data_line(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\eleventday\\input" + test + ".txt");
        String rawlist = "";
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
            rawlist +=  read_file.nextLine();
        }
            } catch (FileNotFoundException ex) {
            }
        return rawlist;
        }
        
    List<Long> make_list(String input){
        List<Long> output = new ArrayList<>();
        for (String number : input.split(" ")) {
            output.add(Long.valueOf(number));
        }
    return output;
    }

    Long devide_stone(Long tempinput, String oneOrtwo){
        String temp = tempinput.toString();
        switch (oneOrtwo){
            case "one" -> temp = temp.substring(0, (temp.length()/2));
            case "two" -> temp = temp.substring(temp.length()/2, temp.length());
        }
        return Long.valueOf(temp);
    }

    List<Long> check_rules(List<Long> input){
        List<Long> templist = new ArrayList<>();    
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == 0){
                templist.add(1L);
            }
            else if (input.get(i).toString().split("").length%2 == 0){
                // System.out.println(input.get(i));
                templist.add(devide_stone(input.get(i), "one"));
                templist.add(devide_stone(input.get(i), "two"));
            }
            else{
                // System.out.println(input.get(i));
                templist.add((input.get(i))*2024);
            } 
        }
        return templist;
    }

    public static void main(String[] args) {
        Day11 day = new Day11();
        //List<Long> test = new ArrayList<>(day.make_list(day.raw_data_line("")));
        List<Long> test = List.of(125L, 17L);
        int counter = 10;
        while (counter > 0){
            test = day.check_rules(test);
            System.out.println(test);
            counter --;
        }
        System.out.println(test.size());
    }
}
