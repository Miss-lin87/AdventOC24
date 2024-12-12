package se.advent.linda.tenthday;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
                output.add(new Cordinates(N, i));
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

    List<List<String>> look_next(List<List<String>> matrix, int line, int row, Integer N){ 
        Integer L = 0; 
        Integer R = 0;
        Integer U = 0;
        Integer D = 0;
        try {
            L = Integer.valueOf(matrix.get(line).get(row-1));}catch(Exception e){}
        try {
            R = Integer.valueOf(matrix.get(line).get(row+1));}catch(Exception e){}
        try{
            U = Integer.valueOf(matrix.get(line-1).get(row));}catch(Exception e){}
        try{
            D = Integer.valueOf(matrix.get(line+1).get(row));}catch(Exception e){}
        System.err.print(N);
        if (N < 10){
            try {
                if (Objects.equals(L, N)){
                    System.err.print(" Left |");
                    look_next(matrix, line, row-1, N+1);
                }
                else if (Objects.equals(R, N)) {
                    System.err.print(" Right |");
                    look_next(matrix, line, row+1, N+1);
                }
                else if (Objects.equals(U, N)) {
                    System.err.print(" Upp |");
                    look_next(matrix, line-1, row, N+1);
                }
                else if (Objects.equals(D, N)){
                    System.out.print(" Down |");
                    look_next(matrix, line+1, row, N+1);
                }        
            } catch (Exception e) {
            }
        }
        else if (N == 10) {
            matrix.get(line).set(row, "X");
        }
    return matrix;
    }

    public static void main(String[] args) {
        Day10N day = new Day10N();
        List<List<Cordinates>> matrix = day.make_matrix(day.raw_data_line("test"));
        System.out.println(matrix.get(0).get(0));
    }
}