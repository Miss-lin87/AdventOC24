package se.advent.linda.fortenthday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14t2 {

    String[][] make_map(Integer tall, Integer wide){
        String[][] output = new String[tall+1][wide+1];
        for (int i = 0; i < tall+1; i++) {
            for (int j = 0; j < wide+1; j++) {
                output[i][j] = ".";
            }
        }
        return output;
    }

    void printmap(String[][] matrix){
        for (String[] line : matrix) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println("");
    }
    
    boolean place_cordinates(List<Integer[]> positions, String[][] map){
        for (int i = 0; i < positions.size(); i++) {
            map[positions.get(i)[0]][positions.get(i)[1]] = "x";
        }
        //printmap(map);
        return false;
    }

    void test_tree(String[][] map, Integer row, Integer counter){
        Integer tempcounter = counter;
        if (row >= map.length){
            return;
        }
        for (int j = 0; j < map[row].length-1; j++) {
            if (map[row][j+1].equals(map[row][j])){
                counter ++;
            }
            System.out.println(counter);
            }
    }

    Map<String, Integer> test_row(String[][] map){
        Integer counter = 0;
        Map<String, Integer> map_tree = new HashMap<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == "x"){
                    counter ++; 
                }
            map_tree.put(String.valueOf(i), counter);
            counter = 0;
            }
        }
        return map_tree;
    }

    public static void main(String[] args) {
        Day14 day = new Day14();
        Day14t2 day2 = new Day14t2();
        Map<String, Integer> tree_test = new HashMap<>();
        boolean test = false;
        List<Integer[]> positions = day.make_positions(day.make_raw_data(""));
        List<Integer[]> speeds = day.make_speeds(day.make_raw_data(""));
        Integer wide = 100;
        Integer tall = 102;
        int number = 10;
        String[][] map = day2.make_map(wide, tall);
        Integer awnser = 215476074;
        Integer secounds = 0;
        //day2.printmap(map);
        /*for (int i = 0; i < positions.size(); i++) {
            while(number != 0){
                day.find_position(positions.get(i), speeds.get(i), wide, tall);
                number --;
            }
            day.place_robots(positions.get(i), wide, tall, robots2);
        }*/
        //day2.printmap(map);
        while (test == false) {
            while (number != 0){
            for (int i = 0; i < positions.size(); i++) {
                day.find_position(positions.get(i), speeds.get(i), wide, tall);
                //day.place_robots(positions.get(i), wide, tall, robots2);
                day2.place_cordinates(positions, map);
                //day2.test_tree(map, 0, 0);
                tree_test = day2.test_row(map);
            }
            System.out.println(tree_test);
            //System.out.println(robots2);
            /*if ((robots2.getOrDefault("Q1", 1)*robots2.getOrDefault("Q2", 1))*robots2.getOrDefault("Q3", 1)*robots2.getOrDefault("Q4", 1) < awnser){
                awnser = (robots2.getOrDefault("Q1", 1)*robots2.getOrDefault("Q2", 1))*robots2.getOrDefault("Q3", 1)*robots2.getOrDefault("Q4", 1);
                secounds = number;
            }*/
            //robots2.clear();
            number --;
        }
            //System.out.println(awnser);
            //System.out.println(secounds);
            test = true;
        }
    }
}

//3716 to low
//13716 to high
//7431