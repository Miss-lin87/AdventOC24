package se.advent.linda.sixth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day6{
        String raw_data_line(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\sixth\\input" + test + ".txt");
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

    String get_starting_face(List<List<String>> matrix){
        String facing = null;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if("<, ^, ˅, >".contains(matrix.get(i).get(j))){
                    String face = matrix.get(i).get(j);
                    switch (face) {
                        case "^" -> facing = "N";
                        case "˅" -> facing = "S";
                        case "<" -> facing = "E";
                        case ">" -> facing = "W";
                    }
                }
            }
        }
        return facing;
    }

    List<Integer> get_inital_cord(List<List<String>> matrix){
        List<Integer> cords = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if("<, ^, ˅, >".contains(matrix.get(i).get(j))){
                    cords.add(i);
                    cords.add(j);
                }
            }
        }
        return cords;
    }

    String look_at_cord(List<List<String>> matrix, int x, int y){
        return matrix.get(x).get(y);
    }

    boolean try_valid_move(List<List<String>> matrix, List<Integer> face, List<Integer> cord){
        return !"#".equals(look_at_cord(matrix, (cord.get(0)+face.get(0)), (cord.get(1)+face.get(1)))); // !"X".equals(look_at_cord(matrix, (cord.get(0)+face.get(0)), (cord.get(1)+face.get(1)))));
      }

    List<Integer> change_face_forward(List<Integer> facing){
        switch (facing.get(0).toString()+facing.get(1).toString()){
            case "-10" -> {facing.set(0, 0); facing.set(1, 1); return facing;}
            case "01" -> {facing.set(0, 1); facing.set(1, 0); return facing;}
            case "10" -> {facing.set(0, 0); facing.set(1, -1); return facing;}
            case "0-1" -> {facing.set(0, -1); facing.set(1, 0); return facing;}
        }
    return null;
    }

    List<Integer> change_cords(List<Integer> facing, List<Integer> cords){
        cords.set(0, cords.get(0)+facing.get(0));
        cords.set(1, cords.get(1)+facing.get(1));
        return cords;
    }

    List<Integer> set_facing(String faceing){
        List<Integer> output = new ArrayList<>();
        output.add(0);
        output.add(0);
        switch (faceing) {
            case "N" -> {
                output.set(0,-1);
                output.set(1,0);
                }
            case "E" -> {
                output.set(0,0);
                output.set(1,1);
                }
            case "S" -> {
                output.set(0,1);
                output.set(1,0);
                }
            case "W" -> {
                output.set(0,0);
                output.set(1,-1);
                }
        }
        return output;
    }

    public static void main(String[] args) {
        Day6 day = new Day6();
        List<String> seen_cords = new ArrayList<>();
        List<List<String>> matrix = day.make_matrix(day.raw_data_line("test"));
        List<Integer> cordinates = day.get_inital_cord(matrix);
        List<Integer> facing = day.set_facing(day.get_starting_face(matrix));
        boolean test = true;
        //for (Object elem : matrix) {
        //    System.out.println(elem);
        //}
        while (test == true){
        try {
            if (day.try_valid_move(matrix, facing, cordinates)==true){
                if(!seen_cords.contains(cordinates.toString())){
                    seen_cords.add(cordinates.toString());
                }
                cordinates = day.change_cords(facing, cordinates);
            }
            else {
                facing = day.change_face_forward(facing);
            }
        } catch (Exception e) {
            seen_cords.add(cordinates.toString());
            System.out.println("Out of bounds");
            test = false;
        }
    }
    // System.out.println(seen_cords);
    System.out.println(seen_cords.size());
    }
}