package se.advent.linda.eathday;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day8 {
     String raw_data_line(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\eathday\\input" + test + ".txt");
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

    void print_matrix(List<List<String>> matrix){
        for (List<String> line : matrix) {
            System.out.println(line);            
        }
    }

    List<String> find_uniq_towers(List<List<String>> matrix){
        List<String> unik_towers = new ArrayList<>();
        for (List<String> line : matrix) {
            for (int i = 0; i < line.size(); i++) {
                if (!unik_towers.contains(line.get(i)) && !line.get(i).equals(".")){
                    unik_towers.add(line.get(i));
                }
            }
        }
        return unik_towers;
    }

    Map<String, Collection<List<Integer>>> find_tower_location(List<List<String>> matrix, List<String> towers){
        Map<String, Collection<List<Integer>>> tower_locations = new HashMap<>();
        for (String tower : towers) {
            for (List<String> line : matrix) {
                for (int i = 0; i < line.size(); i++) {
                    if (line.get(i).equals(tower)){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(matrix.indexOf(line));
                        temp.add(line.indexOf(line.get(i)));
                        tower_locations.computeIfAbsent(tower, k-> new HashSet<List<Integer>>()).add(temp);
                    }
                }
            }
        }
    return tower_locations;
    }

    Map<String, List<Integer>> find_all_tower(List<List<String>> matrix, String tower){
        Map<String, List<Integer>> tower_locations = new HashMap<>();
        Integer counter = 0;
            for (List<String> line : matrix) {
                for (int i = 0; i < line.size(); i++) {
                    if (line.get(i).equals(tower)){
                        List<Integer> temp = new ArrayList<>();                      
                        temp.add(matrix.indexOf(line));
                        temp.add(line.indexOf(line.get(i)));
                        tower_locations.putIfAbsent((tower + counter.toString()), temp);
                        counter ++;
                    }
                }
            }
    return tower_locations;
    }

    List<String> place_antinode(Map<String, Collection<List<Integer>>> tower_locations, List<String> towers){
        List<String> antinodes = new ArrayList<>();
        for (String tower : towers) {
            for (List<Integer> list : tower_locations.get(tower)) {
                System.out.println(list);
            }
        }
        return antinodes;
    }

    String look_at_cord(List<List<String>> matrix, int x, int y){
        return matrix.get(x).get(y);
    }

    Integer record_antinode(List<Integer> tower1, List<Integer> tower2){
            Integer[] node1 = {tower1.get(0)-(tower2.get(0)-tower1.get(0)), tower1.get(1)-(tower2.get(1)-tower1.get(1))};

            int x = 8;
            int y = 8;
            int z = 9;
            int p = 9;
            System.out.println(x-(z-x) + "," + (y-(p-y)));
        return 0;
    }

    public static void main(String[] args) {
        Day8 day = new Day8();
        List<List<String>> matrix = day.make_matrix(day.raw_data_line("test"));
        //day.print_matrix(matrix);
        List<String> towers = day.find_uniq_towers(matrix);
        for (String tower : towers) {
            Map<String, List<Integer>> temp_list = day.find_all_tower(matrix, tower);
            for (int i = 0; i < temp_list.size() ; i++) {
                
            }
            System.out.println();
        }
        Map<String, Collection<List<Integer>>> tower_locations = day.find_tower_location(matrix, towers);
       //day.place_antinode(tower_locations, towers);
            
        }
    }

