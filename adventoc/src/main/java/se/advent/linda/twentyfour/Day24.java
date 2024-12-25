package se.advent.linda.twentyfour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day24 {
    String raw_data_line(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\twentyfour\\input" + test + ".txt");
        String rawlist = "";
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
                rawlist += read_file.nextLine() +"\n";
            }
            } catch (FileNotFoundException ex) {
            }
        return rawlist;
    }

    List<String> make_wiers(String input){
        List<String> wiers = new ArrayList<>();
        for (String line : input.split("\n")) {
            if(line.contains(":")){
                wiers.add(line);
            }
        }
        return wiers;
    }

    Map<String, Wiers> make_map(List<String> wiers){
        Map<String, Wiers> wiermap = new HashMap<>();
        for (int i = 0; i < wiers.size(); i++) {
            String tempname = wiers.get(i).substring(0, wiers.get(i).indexOf(":"));
            wiermap.put(tempname, new Wiers(tempname, Integer.parseInt(wiers.get(i).substring(wiers.get(i).indexOf(":")+1, wiers.get(i).length()).strip())));
        }
        return wiermap;
    }

    List<String> make_operations(String input){
        List<String> operations = new ArrayList<>();
        for (String line : input.split("\n")) {
            if (line.contains("->")){
                operations.add(line);
            }
        }
        return operations;
    }

    int gateAND(int x, int y){
        if (x == 0 || y == 0){
            return 0;
        }
        return 1;
    }

    int gateOR(int x, int y){
        if (x == 0 && y == 0){
            return 0;
        }
        return 1;
    }

    int gateXOR(int x, int y){
        if (x != y){
            return 1;
        }
        return 0;
    }

    int calcValue(Wiers wire1, Wiers wire2, String gate){
        int result = 0;
        switch (gate){
            case "AND" -> result = gateAND(wire1.getValue(), wire2.getValue());
            case "OR" -> result = gateOR(wire1.getValue(), wire2.getValue());
            case "XOR" -> result = gateXOR(wire1.getValue(), wire2.getValue());
        }
    return result;
    }

    void calculations(Map<String, Wiers> wiremap, List<String> operations){

        if (operations.isEmpty()){
            return;
        }

        int times = 0;
        while(times < operations.size()){
            String wire1 = operations.get(times).substring(0, operations.get(times).indexOf(" ")).strip();
            String wire2 = operations.get(times).substring(operations.get(times).indexOf(" ", 4), operations.get(times).indexOf("->")).strip();

            if (wiremap.keySet().contains(wire1) && wiremap.keySet().contains(wire2)){
                String tempwire = operations.get(times).substring(operations.get(times).indexOf("->")+3, operations.get(times).length());
                wiremap.put(tempwire, new Wiers(tempwire, calcValue(wiremap.get(wire1), wiremap.get(wire2), operations.get(times).substring(4, operations.get(times).indexOf(" ", 4)))));
                operations.remove(times);
            }
            else{
                times ++;
            }
        }
        calculations(wiremap, operations);
    }

    int find_z_amount(Map<String, Wiers> wiremap){
        int amount = 0;
        for (String set : wiremap.keySet()) {
            if (wiremap.get(set).getName().startsWith("z")){
                amount ++;
            }
        }
        return amount;
    }

    String make_awnser(Map<String, Wiers> wiremap, int Z_amount){
        String awnser = "";
        List<Wiers> seen = new ArrayList<>();
        for (int i = Z_amount; i > -1; i--) {
            for (String key : wiremap.keySet()) {
                if (wiremap.get(key).getName().startsWith("z") && wiremap.get(key).getName().endsWith(String.valueOf(i)) && !seen.contains(wiremap.get(key))){
                    awnser += String.valueOf(wiremap.get(key).getValue());
                    seen.add(wiremap.get(key));
                }
            }
        }
        return awnser;
    }

    public static void main(String[] args) {
        Day24 day = new Day24();
        Map<String, Wiers> wiermap = new HashMap<>(day.make_map(day.make_wiers(day.raw_data_line(""))));
        List<String> operations = new ArrayList<>(day.make_operations(day.raw_data_line("")));
        day.calculations(wiermap, operations);
        String awnser = day.make_awnser(wiermap, day.find_z_amount(wiermap));
        Long test = Long.parseLong(awnser,2);
        System.out.println(test);
    }
}
