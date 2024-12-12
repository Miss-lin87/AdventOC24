package se.advent.linda.tenthday;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Day10 {
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
    
        List<String> make_arraylist(String[] input){
            List<String> output = new ArrayList<>();
            output.addAll(Arrays.asList(input));
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


    List<List<String>> find_zero(List<List<String>> matrix){
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if("0".equals(matrix.get(i).get(j))){
                    while(matrix.contains("9")){

                    }
                    }
                }
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

    String look_at_cord(List<List<String>> matrix, int x, int y){
        return matrix.get(x).get(y);
    }

    void printmap(List<List<String>> temp){
        for (List<String> line : temp) {
            System.out.println(line);
        }
        System.out.println("");
    }

    Integer find_nines(List<List<String>> matrix, int x, int y){
        int counter = 0;
        for (List<String> line : matrix.subList(Math.max(0, x-10), Math.min(matrix.get(0).size(), x+10))) {
            for (String number : line.subList(Math.max(0, y-10), Math.min(matrix.get(0).size(),y+10))) {
                if ("9".equals(number)){
                    counter ++;
                }
            }
        }
    return counter;
    }

    public static void main(String[] args) {
        Day10 day = new Day10();
        List<List<String>> matrix = day.make_matrix(day.raw_data_line("test"));
        day.printmap(matrix);
        //System.out.println(day.find_nines(matrix, 0, 4));
        //System.err.println(day.look_at_cord(matrix, 2, 4));
        System.err.println("");
        day.printmap(matrix);
        //System.err.println(day.find_nines(matrix, 0, 2));
    }
}
