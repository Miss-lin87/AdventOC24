package se.advent.linda.twelfth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day12 {
    String raw_data_line(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\twelfth\\input" + test + ".txt");
        String rawlist = "";
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
            rawlist += "\n" + read_file.nextLine();
        }
            } catch (FileNotFoundException ex) {
            }
        return rawlist.substring(1);
        }
    
        String[][] make_matrix(String[] input){
            String[][] output = new String[input.length][input[0].split("").length];
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[i].split("").length; j++) {
                    output[i][j] = input[i].split("")[j];
                }
            }
            return output;
        }

        List<String> find_plants(String[][] matrix){
            List<String> different_plants = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if(!different_plants.contains(matrix[i][j])){
                        different_plants.add(matrix[i][j]);
                    }
                }
            }
            return different_plants;
        }

        int find_island(String[][] matrix, String plant){
            int result = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if(plant.equals(matrix[i][j])){
                        deepth_first(matrix, i, j, plant);
                        result ++;
                    }
                }
            }
            return result;
        }

        Integer find_island2(String[][] matrix, String plant){
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if(plant.equals(matrix[i][j])) {
                        //locations.add(String.valueOf(i)+String.valueOf(j));
                        Integer[] area = {0};
                        Integer[] perimiter = {0}; //test what a call <--- ther will do!!!
                        deepth_first2(matrix, i, j, plant, area, perimiter);
                        printmap(matrix);
                        find_peramiter(matrix, i, j, plant, perimiter);
                        printmap(matrix);
                        System.out.println(Arrays.toString(area));
                        System.out.println(perimiter[0]);
                    }
                }
            }
            return 0;
        }

        void deepth_first2(String[][] matrix, Integer line, Integer row, String plant, Integer[] area, Integer[] perimiter){
            int hight = matrix.length;
            int length = matrix[0].length;
    
            if (row < 0 || line < 0 || line >= hight|| row >= length || !plant.equals(matrix[line][row])){
                //printmap(matrix);
                return;
            }
                area[0] ++;
                matrix[line][row] = "0";
                deepth_first2(matrix, line+1, row, plant, area, perimiter); //move up
                deepth_first2(matrix, line-1, row, plant, area, perimiter); //move down
                deepth_first2(matrix, line, row+1, plant, area, perimiter); //move right
                deepth_first2(matrix, line, row-1, plant, area, perimiter); //move left
        }

        void deepth_first(String[][] matrix, int line, int row, String plant){
            int hight = matrix.length;
            int length = matrix[0].length;
    
            if (row < 0 || line < 0 || line >= hight|| row >= length || !plant.equals(matrix[line][row])){
                return;
            }
                matrix[line][row] = "0";
                deepth_first(matrix, line+1, row, plant); //look up
                deepth_first(matrix, line-1, row, plant); //look down
                deepth_first(matrix, line, row+1, plant); //look right
                deepth_first(matrix, line, row-1, plant); //look left
        }

        void printmap(String[][] matrix){
            for (String[] line : matrix) {
                System.out.println(Arrays.toString(line));
            }
            System.out.println("");
        }

        void find_peramiter(String[][] matrix, Integer line, Integer row, String plant, Integer[] peramiter){
            int hight = matrix.length;
            int length = matrix[0].length;
    
            if (row < 0 || line < 0 || line >= hight|| row >= length || !plant.equals(matrix[line][row])){
                peramiter[0] += 4;
                return;
            }
                matrix[line][row] = "1";
                if (line+1 >= matrix.length && matrix[line+1][row] == "1"){
                    peramiter[0] -= 1;
                    find_peramiter(matrix, line+1, row, plant, peramiter);
                }
                if(line-1 >= 0 && matrix[line-1][row] == "1"){
                    peramiter[0] -= 1;
                    find_peramiter(matrix, line-1, row, plant, peramiter);
                }
                if(row-1 >= 0 && matrix[line][row-1] == "1"){
                    peramiter[0] -= 1;
                    find_peramiter(matrix, line, row-1, plant, peramiter);
                }
                if(row+1 <= matrix[0].length && matrix[line][row+1] == "1"){
                    peramiter[0] -= 1;
                    find_peramiter(matrix, line, row+1, plant, peramiter);
                }
            }

    public static void main(String[] args) {
        Day12 day = new Day12();
        String[][] matrix = day.make_matrix(day.raw_data_line("test").split("\n"));
        //List<String> different_plants = day.find_plats(matrix);
        //System.out.println(different_plants);
        //day.printmap(matrix);
        //System.out.println(day.find_island(matrix, "I"));
        System.out.println(day.find_island2(matrix, "I"));
    }
}