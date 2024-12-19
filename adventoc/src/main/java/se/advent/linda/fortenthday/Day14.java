package se.advent.linda.fortenthday;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day14 {

    String make_raw_data(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\fortenthday\\input" + test + ".txt");
        String line = "";
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
                line += read_file.nextLine() + "\n";
            }
        } catch (FileNotFoundException ex) {
        }
        return line;
    }

    List<Integer[]> make_positions(String input){
        List<Integer[]> position = new ArrayList<>();
        for (String line : input.split("\n")) {
            Integer[] temp = {Integer.valueOf(line.substring(line.indexOf("p=")+2, line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1, line.indexOf(" ")))};
            position.add(temp);
        }
        return position;
    }

    List<Integer[]> make_speeds(String input){
        List<Integer[]> speeds = new ArrayList<>();
        for (String line : input.split("\n")) {
            Integer[] temp = {Integer.valueOf(line.substring(line.indexOf("v=")+2, line.lastIndexOf(","))), Integer.valueOf(line.substring(line.lastIndexOf(",")+1, line.length()))};
            speeds.add(temp);
        }
        return speeds;
    }

    void find_position2(Integer[] position, Integer[] speed, Integer wide, Integer tall, Integer times){
        if (times > 0){
            
        }
    }


    void find_position(Integer[] position, Integer[] speed, Integer wide, Integer tall, Integer times){
        if (times == 0){
            //System.out.println("Returning");
            return;
        }
        position[0] += speed[0];
        position[1] += speed[1];
        // System.out.println(position[0] + "|" + position[1]);
        if (position[0] > wide){
            position[0] -= wide+1;
            //System.out.println(position[0] + "<-" + position[1]);
            //find_position(position, speed, wide, tall, times-1);
        }
        if (position[0] < 0){
            position[0] += wide+1;
            //System.out.println(position[0] + "->" + position[1]);
            //find_position(position, speed, wide, tall, times-1);
        }
        if (position[1] < 0){
            position[1] += tall+1;
            //System.out.println(position[0] + "^" + position[1]);
            //find_position(position, speed, wide, tall, times-1);
        }
        if (position[1] > tall){
            position[1] -= tall+1;
            //System.out.println(position[0] + "|" + position[1]);
            //find_position(position, speed, wide, tall, times-1);
        }
        //System.out.println("wide: " + position[0] + "|" + "Tall: "  + position[1]);
        find_position(position, speed, wide, tall, times-1);
    }

    Map<String, Integer> place_robots(Integer[] position, Integer wide, Integer tall, Map<String, Integer> robots){
        if(position[0] < (wide/2) && position[1] < (tall/2)){
            System.out.println(Arrays.toString(position) + " | Q1");
            robots.put("Q1", robots.getOrDefault("Q1", 0)+1);
        }
        if(position[0] > (wide/2) && position[1] < (tall/2)){
            System.out.println(Arrays.toString(position) + " | Q2");
            robots.put("Q2", robots.getOrDefault("Q2", 0)+1);
        }
        if(position[0] < (wide/2) && position[1] > (tall/2)){
            System.err.println(Arrays.toString(position) + " | Q3");
            robots.put("Q3", robots.getOrDefault("Q3", 0)+1);
        }
        if(position[0] > (wide/2) && position[1] > (tall/2)){
            System.err.println(Arrays.toString(position) + " | Q4");
            robots.put("Q4", robots.getOrDefault("Q4", 0)+1);
        }
        //System.out.println(robots.keySet());
        return robots;
    }

    public static void main(String[] args) {
        Day14 day = new Day14();
        Map<String, Integer> robots = new HashMap<>();
        List<Integer[]> positions = day.make_positions(day.make_raw_data("test"));
        List<Integer[]> speeds = day.make_speeds(day.make_raw_data("test"));
        
        Integer wide = 11;
        //System.out.println((wide/2)-1);
        //System.out.println((wide/2)+1);
        Integer tall = 7;
        //System.out.println(tall/2);
        Integer number = 100;
        for (int i = 0; i < positions.size(); i++) {
            //System.out.println(Arrays.toString(positions.get(i)));
            day.find_position(positions.get(i), speeds.get(i), wide, tall, number);
            day.place_robots(positions.get(i), wide, tall, robots);
            //System.out.println(Arrays.toString(positions.get(i))+ "\n");
            //System.out.println(Arrays.toString(speeds.get(i)));
        }
        System.out.println(robots);
        //System.out.println(position[0] + ":" + position[1]);
        System.out.println(day.place_robots(positions.get(1), wide, tall, robots));
    }    
}
