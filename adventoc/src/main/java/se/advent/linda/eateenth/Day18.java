package se.advent.linda.eateenth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Day18 {
    String make_raw_data(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\eateenth\\input" + test + ".txt");
        String line = "";
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
                line += read_file.nextLine() + "\n";
            }
        } catch (FileNotFoundException ex) {
        }
        return line;
    }

    List<Integer[]> make_cordinate(String line){
        List<Integer[]> coridnates = new ArrayList<>();
        for (String cords : line.split("\n")) {
            String[] temp = cords.split(",");
            Integer[] output = {Integer.valueOf(temp[0]), Integer.valueOf(temp[1])}; 
            coridnates.add(output);
        }
        return coridnates;
    }

    String[][] make_matrix(Integer lines, Integer rows){
        String[][] matrix = new String[lines][rows];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = ".";
            }
        }
        return matrix;
    }

    String[][] change_matrix(String[][] matrix, List<Integer[]> cordlist, Integer bytes_fall){
        for (int i = 0; i < bytes_fall; i++) {
            matrix[cordlist.get(i)[1]][cordlist.get(i)[0]] = "#";
        }
        matrix[matrix.length-1][matrix[0].length-1] = "G";
        return matrix;
    }

    int find_distance(String[][] matrix, int startline, int startrow){
        Cords start = new Cords(startline, startrow, 0);
        Queue<Cords> queue = new LinkedList<>();
        queue.add(start);
        boolean[][] seen = new boolean[matrix.length][matrix[0].length];
        seen[start.line][start.row] = true;
    
        while (!queue.isEmpty()) {
            Cords position = queue.remove();

            if ("G".equals(matrix[position.line][position.row])){
                return position.distance;
            }
            if (isValid(position.line - 1, position.row, matrix, seen)) {
                queue.add(new Cords(position.line - 1, position.row, position.distance + 1));
                seen[position.line - 1][position.row] = true;
            }//going up
            if (isValid(position.line + 1, position.row, matrix, seen)) {
                queue.add(new Cords(position.line + 1, position.row, position.distance + 1));
                seen[position.line + 1][position.row] = true;
            } //going down
            if (isValid(position.line, position.row - 1, matrix, seen)) {
                queue.add(new Cords(position.line, position.row - 1, position.distance + 1));
                seen[position.line][position.row - 1] = true;
            }//going left
            if (isValid(position.line, position.row + 1, matrix, seen)) {
                queue.add(new Cords(position.line, position.row + 1, position.distance + 1));
                seen[position.line][position.row + 1] = true;
            }//going right
        }
        return -1;
    }

    boolean isValid(int line, int row, String[][] grid, boolean[][] visited) {
        if (line >= 0 && row >= 0 && line < grid.length && row < grid[0].length && grid[line][row] != "#" && visited[line][row] == false) {
            return true;
        }
    return false;
    }

    public static void main(String[] args) {  
        Day18 day = new Day18();
        List<Integer[]> cordinates = new ArrayList<>(day.make_cordinate(day.make_raw_data("")));
        String[][] matrix = day.make_matrix(71, 71);
        day.change_matrix(matrix, cordinates, 1024);
        System.out.println(day.find_distance(matrix, 0, 0));
        /*for (String[] elem : matrix) {
            System.out.println(Arrays.toString(elem));
        }*/
    }
}
