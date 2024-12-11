package se.advent.linda.tenthday;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Day10N {
    String raw_data_line(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\tenthday\\input" + test + ".txt");
        String rawlist = "";
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
            rawlist += "\n" + read_file.nextLine();
        }
            } catch (FileNotFoundException ex) {
            }
        return rawlist.substring(1);
        }
    
        List<Cordinates> make_arraylist(String[] input, int N){
            List<Cordinates> output = new ArrayList<>();
            for (int i = 0; i < input.length; i++) {
                output.add(new Cordinates(N, i, Integer.valueOf(input[i])));
            }
            return output;
        }

    List<List<Cordinates>> make_matrix(String input){
        List<List<Cordinates>> matrix = new ArrayList<>();
        String[] temp = input.split("\n");
        for (int i = 0; i < temp.length; i++) {
            matrix.add(make_arraylist(temp[i].split(""), i));
        }
            return matrix;
        }

    public static void main(String[] args) {
        Day10N day = new Day10N();
        List<List<Cordinates>> matrix = day.make_matrix(day.raw_data_line("test"));
        System.out.println(matrix.get(0).get(0).getValue());
    }
}