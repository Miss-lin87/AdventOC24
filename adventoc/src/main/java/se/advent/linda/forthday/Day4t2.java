package se.advent.linda.forthday;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4t2 {
    
    String raw_data_line(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\forthday\\input" + test + ".txt");
        String rawlist = "";
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
            rawlist += "\n" + read_file.nextLine();
            }
        } catch (FileNotFoundException ex) {
            }
        return rawlist.substring(1);
        }

    List<String> make_arraylist(String[] input){
        List<String> output = new ArrayList<>();
        for (String letter : input) {
            if("X".equals(letter)){
                output.add(".");
            }
            else{output.add(letter);}
        }
        return output;
        }
    
    List<List<String>> make_matrix(String input){
        List<String> list_row = make_arraylist(input.split("\n"));
        List<List<String>> matrix = new ArrayList<>();
        for (String elem : list_row) {
            List<String> temp = make_arraylist(elem.split(""));
            matrix.add(temp);
        }
        return matrix;
        }

    boolean check_valid_xLtR(List<List<String>> matrix, int row, int colum){
        boolean test = false;
        try {
            switch (matrix.get(row-1).get(colum-1)){
                case "M" ->  test = ("S".equals(matrix.get(row+1).get(colum+1)));
                case "S" ->  test = ("M".equals(matrix.get(row+1).get(colum+1)));
            }
        } catch (Exception e) {
        }
        return test;
    }

    boolean check_valid_xRtL(List<List<String>> matrix, int row, int colum){
        boolean test = false;
        try {
            switch (matrix.get(row-1).get(colum+1)){
                case "M" -> test = ("S".equals(matrix.get(row+1).get(colum-1)));
                case "S" -> test = ("M".equals(matrix.get(row+1).get(colum-1)));
            }    
        } catch (Exception e) {
        }
        return test;
    }

    List<Integer> get_index(List<String> input){
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i <input.size(); i++) {
            if ("A".equals(input.get(i))){
                indexes.add(i);
            }
        }
        return indexes;
    }


    public static void main(String[] args) {
        Day4t2 day2 = new Day4t2();
        int counter = 0;
        List<List<String>> matrix = day2.make_matrix(day2.raw_data_line(""));
        /*for (List<String> line : matrix) {
            System.out.print(line);
            System.out.println(day2.get_index(line));
            }*/
        for (List<String> line : matrix) {
            List<Integer> indexes = day2.get_index(line);
            for (Integer index : indexes) {
                if (day2.check_valid_xLtR(matrix, matrix.indexOf(line), index) && day2.check_valid_xRtL(matrix, matrix.indexOf(line), index)){
                    counter ++;
                }
                
            }
        }
        System.out.println(counter);
    }
}