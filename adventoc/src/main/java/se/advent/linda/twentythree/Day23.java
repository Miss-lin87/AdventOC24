package se.advent.linda.twentythree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day23 {
     String make_raw_data(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\twentythree\\input" + test + ".txt");
        String line = "";
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
                line += read_file.nextLine() + "\n";
            }
        } catch (FileNotFoundException ex) {
        }
        return line;
    }

    List<String> make_connections(String input){
        List<String> conections = new ArrayList<>();
        for (String line : input.split("\n")) {
            conections.add(line);
        }
        return conections;
    }

    public static void main(String[] args) {
        Day23 day = new Day23();
        List<String> conections = day.make_connections(day.make_raw_data("test"));
        for (String conect : conections) {
            System.out.println(conect);
        }
    }
}
