package se.advent.linda.sixteenth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import se.advent.linda.eighteenth.Cords;

public class Day16 {
    String raw_data_line(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\sixteenth\\input" + test + ".txt");
        String rawlist = "";
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
            rawlist += "\n" + read_file.nextLine();
        }
            } catch (FileNotFoundException ex) {
            }
        return rawlist.substring(1);
    }

    String[][] make_matrix(String raw_data){
        String[][] matrix = new String[raw_data.split("\n").length][raw_data.split("\n")[0].length()];
        for (int i = 0; i < raw_data.split("\n").length; i++) {
            for (int j = 0; j < raw_data.split("\n")[0].length(); j++) {
                matrix[i][j] = raw_data.split("\n")[i].split("")[j];
            }
        }
        return matrix;
    }

    Integer Start_race(String[][] matrix){
        Integer counter = 0;
        Integer count[] = {0};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if("S".equals(matrix[i][j])){
                    //counter = find_distance(matrix, i, j);
                    sertch_path(matrix, i, j, count);
                    //System.err.println(counter[0]);
                }
            }
        }
        return count[0];
    }

    String look_at_cord(String[][] matrix, int line, int row){
        return matrix[line][row];
    }

    boolean try_valid_move(String[][] matrix, Integer[] facing, int line, int row){
        return !"#".equals(look_at_cord(matrix, line+facing[0], row+facing[1]));
    }

    Integer[] change_face_forward(Integer[] facing){
        switch (facing[0].toString()+facing[1].toString()){
            case "-10" -> {facing[0] = 0; facing[1] = 1; return facing;}
            case "01" -> {facing[0] = 1; facing[1] = 0; return facing;}
            case "10" -> {facing[0] = 0; facing[1] = -1; return facing;}
            case "0-1" -> {facing[0] = -1; facing[1] = 0; return facing;}
        }
    return null;
    }

    void sertch_path(String[][] matrix, int line, int row, Integer[] points){
        int hight = matrix.length;
        int length = matrix[0].length;

        if (row < 0 || line < 0 || line >= hight|| row >= length || "E".equals(matrix[line][row])){
            return;
        }
        
        sertch_path(matrix, line+1, row, points); //move down
        sertch_path(matrix, line-1, row, points); //move up
        sertch_path(matrix, line, row+1, points); //move right 
        sertch_path(matrix, line, row-1, points); //move left
    }

    public static void main(String[] args) {
        Day16 day = new Day16();
        String[][] matrix = day.make_matrix(day.raw_data_line("test"));
        for (String[] line : matrix) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println(day.Start_race(matrix));
        for (String[] line : matrix) {
            System.out.println(Arrays.toString(line));
        }
    }
}

// 12012 to low