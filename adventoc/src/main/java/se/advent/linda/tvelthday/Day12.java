package se.advent.linda.tvelthday;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day12 {
    String raw_data_line(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\tvelthday\\input" + test + ".txt");
        String rawlist = "";
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
            rawlist += "\n" + read_file.nextLine();
        }
            } catch (FileNotFoundException ex) {
            }
        return rawlist.substring(1);
        }
    
        List<> make_arraylist(String[] input){
            List<String> output = new ArrayList<>();
            output.addAll(Arrays.asList(input));
            return output;
        }

    List<List<Cordinates>> make_matrix(String input){
        List<String> list_row = make_arraylist(input.split("\n"));
        List<List<Cordinates>> matrix = new ArrayList<>();
        for (String elem : list_row) {
            List<Cordinates> temp = make_arraylist(elem.split(""));
            matrix.add(temp);
        }
        return matrix;
    }

}
