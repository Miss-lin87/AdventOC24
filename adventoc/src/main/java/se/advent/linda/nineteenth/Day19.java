package se.advent.linda.nineteenth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day19 {
        String raw_data_line(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\nineteenth\\input" + test + ".txt");
        String rawlist = "";
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
            rawlist += "\n" + read_file.nextLine();
        }
            } catch (FileNotFoundException ex) {
            }
        return rawlist.substring(1);
        }

    List<String> make_stripes(String input){
        String temp = input.substring(0, input.indexOf("\n"));
        List<String> stripes = new ArrayList<>();
        for (String stripe : temp.split(",")) {
            stripes.add(stripe.stripLeading());
        }
        return stripes;
    }

    List<String> make_towels(String input){
        String temp = input.substring(input.indexOf("\n")+2, input.length());
        List<String> towels = new ArrayList<>();
        for (String line : temp.split("\n")) {
            towels.add(line);
        }
        return towels;
    }

    boolean test_valid(List<String> stripes, String towel, String start) {
        for (int i = 0; i < stripes.size(); i++) {
            String teststring = start + stripes.get(i);
            if (teststring.equals(towel)) {
                return true;
            }
            if (towel.startsWith(teststring)) {
                boolean tempresult = test_valid(stripes, towel, teststring);
                if (tempresult == true) {
                    return true;
                }
            }
            teststring = start;
        }
        return false;
    }

    Long different_ways(){
        Long way = 0L;
        return way;
    }

    public static void main(String[] args) {
        Day19 day = new Day19();
        List<String> stripes = day.make_stripes(day.raw_data_line(""));
        List<String> towels = day.make_towels(day.raw_data_line(""));
        Long counter = 0L;
        //String stringtest2 = "brwrr";
        //List<String> colors = new ArrayList<>(Arrays.asList("r", "wr", "b", "g", "bwu", "rb", "gb", "br"));
        //System.out.println(stripes);
        //System.out.println(towels);
        System.out.println(day.test_valid(stripes, towels.get(0), ""));
        for (String towel : towels) {
            if (day.test_valid(stripes, towel, "") == true){
                counter ++;
            }
        }
        System.out.println(counter);
    }
}
