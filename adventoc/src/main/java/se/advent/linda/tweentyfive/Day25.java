package se.advent.linda.tweentyfive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day25 {
        String raw_data_line(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\tweentyfourth\\input" + test + ".txt");
        String rawlist = "";
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
                rawlist += read_file.nextLine() +"\n";
            }
            } catch (FileNotFoundException ex) {
            }
        return rawlist;
    }

    Integer find_empty(String input){
        for (String line : input.split("\n")) {
            if (line.isEmpty()){
                System.out.println("test");
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        Day25 day = new Day25();
        day.find_empty(day.raw_data_line("test"));
    }
}
