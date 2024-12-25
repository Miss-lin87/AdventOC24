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

    String[][] make_matrix(String input){
        String[][] matrix = new String[input.split("\n").length][input.split("\n")[0].length()];
        for (int i = 0; i < input.split("\n").length; i++) {
            for (int j = 0; j < input.split("\n")[0].length(); j++) {
                matrix[i][j] = input.split("\n")[i].split("")[j];
            }
        }
        return matrix;
    }

    int try_zero(String[][] matrix){
        Integer[] counter = {0};
        List<String> used_zero = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if("0".equals(matrix[i][j]) && !used_zero.contains(String.valueOf(i) + String.valueOf(j))){
                    List<String> visited = new ArrayList<>();
                    used_zero.add(String.valueOf(i)+String.valueOf(j));
                    deepth_first(matrix, i, j, 0, counter, visited);
                    //System.err.println(counter[0]);
                }
            }
        }
        return counter[0];
    }

    void deepth_first(String[][] matrix, Integer line, Integer row, int number, Integer nines[], List<String> visited){
        int hight = matrix.length;
        int length = matrix[0].length;

        if (row < 0 || line < 0 || line >= hight|| row >= length || (matrix[line][row] == null ? String.valueOf(number) != null : !matrix[line][row].equals(String.valueOf(number)))){
            return;
        }
        else if ("9".equals(matrix[line][row]) && !visited.contains(String.valueOf(line)+String.valueOf(row))){
            visited.add(String.valueOf(line)+String.valueOf(row));
            nines[0] ++;
            return;
        }
            deepth_first(matrix, line+1, row, number+1, nines, visited);
            deepth_first(matrix, line-1, row, number+1, nines, visited);
            deepth_first(matrix, line, row+1, number+1, nines, visited);
            deepth_first(matrix, line, row-1, number+1, nines, visited);
    }

    public static void main(String[] args) {
        Day10N day = new Day10N();
        String[][] matrix = day.make_matrix(day.raw_data_line(""));
        System.out.println(day.try_zero(matrix));

        /*for (String[] line : matrix) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println("");
        Integer[] counter = {0};
        List<String> visited = new ArrayList<>();
        day.deepth_first(matrix, 0, 2, 0, counter, visited);
        for (String[] line : matrix) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println(counter[0]);*/
    }
}