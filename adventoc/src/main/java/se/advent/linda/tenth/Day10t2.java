package se.advent.linda.tenth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day10t2 {
        void deepth_first_new(String[][] matrix, Integer line, Integer row, int number, Integer nines[], List<String> visited){
        int hight = matrix.length;
        int length = matrix[0].length;

        if (row < 0 || line < 0 || line >= hight|| row >= length || (matrix[line][row] == null ? String.valueOf(number) != null : !matrix[line][row].equals(String.valueOf(number)))){
            return;
        }
        else if ("9".equals(matrix[line][row])){
            nines[0] ++;
            return;
        }
            deepth_first_new(matrix, line+1, row, number+1, nines, visited);
            deepth_first_new(matrix, line-1, row, number+1, nines, visited);
            deepth_first_new(matrix, line, row+1, number+1, nines, visited);
            deepth_first_new(matrix, line, row-1, number+1, nines, visited);
    }

    int try_zero_new(String[][] matrix){
        Integer[] counter = {0};
        List<String> used_zero = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if("0".equals(matrix[i][j]) && !used_zero.contains(String.valueOf(i) + String.valueOf(j))){
                    List<String> visited = new ArrayList<>();
                    used_zero.add(String.valueOf(i)+String.valueOf(j));
                    deepth_first_new(matrix, i, j, 0, counter, visited);
                    //System.err.println(counter[0]);
                }
            }
        }
        return counter[0];
    }
    
    public static void main(String[] args) {
        Day10N day = new Day10N();
        Day10t2 day2 = new Day10t2();
        String[][] matrix = day.make_matrix(day.raw_data_line(""));
        for (String[] line : matrix) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println(day2.try_zero_new(matrix));
    }
}
