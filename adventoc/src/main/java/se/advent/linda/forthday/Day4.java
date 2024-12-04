package se.advent.linda.forthday;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {
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
                output.add(letter);
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

        String get_one_line(List<List<String>> input, int line){
            String temp = "";
            for (String elem : input.get(line)) {
                temp += elem;
                }
            return temp;
        }

        String get_one_row(List<List<String>> input, int row){
            String temp = "";
            try {
                for (int i = 0; i < input.size(); i++) {
                        temp += input.get(i).get(row);
                    }
                
            } catch (Exception e) {
            }
            return temp;
        }
        
        String find_diagonal_LtR(List<List<String>> matrix, int start_row, int start_line){
            int max_line = matrix.size();
            String diagnoal = "";
            try {
                for (int i = 0; i < max_line; i++) {
                    diagnoal += matrix.get(start_row+i).get(start_line+i);
                }
            } catch (Exception e) {
            }
            return diagnoal;
        }

        String find_diagonal_RtL(List<List<String>> matrix, int start_row, int start_line){
            int max_line = matrix.size();
            String diagnoal = "";
            try {
                for (int i = 0; i < max_line; i++) {
                    diagnoal += matrix.get(start_row+i).get(start_line-i);
                }
            } catch (Exception e) {
            }
            return diagnoal;
        }

        int check_valids(String input, String check, String checkR){
            int counter = 0;
            Pattern find = Pattern.compile(check);
            Pattern findR = Pattern.compile(checkR);
            Matcher match = find.matcher(input);
            Matcher matchR = findR.matcher(input);
            while (match.find() || matchR.find()){
                counter ++;
            }
            return counter;
        }

        public static void main(String[] args) {
            Day4 day = new Day4();
            List<List<String>> matrix = day.make_matrix(day.raw_data_line(""));
            int counter_total = 0;
            for (List<String> row : matrix) {
                System.out.println(row);
            }
            // get from all lines
            for (int i = 0; i < matrix.size() ; i++) {
                String line = day.get_one_line(matrix, i);
                counter_total += day.check_valids(line, "XMAS","SAMX");
            }
            // get all rows
            for (int i = 0; i < matrix.get(0).size(); i++) {
                String row = day.get_one_row(matrix, i);
                counter_total += day.check_valids(row, "XMAS", "SAMX");
            }
            // check diagnoal LtR + RtL rows
            for (int i = 0; i < matrix.size(); i++) {
                String row = day.find_diagonal_LtR(matrix, i, 0);
                counter_total += day.check_valids(row, "XMAS", "SAMX");
                String rowback = day.find_diagonal_RtL(matrix, i, matrix.get(0).size()-1);
                counter_total += day.check_valids(rowback, "XMAS", "SAMX");
            }
            // check diagnoal LtR + RtL lines
            for (int i = 0; i < matrix.get(0).size(); i++) {
                String row = day.find_diagonal_LtR(matrix, 0, i+1);
                counter_total += day.check_valids(row, "XMAS", "SAMX");
                String rowback = day.find_diagonal_RtL(matrix, 0, (matrix.get(0).size()-2)-i);
                counter_total += day.check_valids(rowback, "XMAS", "SAMX");
            }
            System.out.println(counter_total);
            }
        }