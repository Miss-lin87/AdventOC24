package se.advent.linda.eighteenth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day18t2 {
    public static void main(String[] args) {
        Day18 day = new Day18();
        List<Integer[]> cordinates = new ArrayList<>(day.make_cordinate(day.make_raw_data("")));
        String[][] matrix = day.make_matrix(71, 71);
        Integer test = 0;
        Integer counter = 0;
        while (test != -1){
            day.change_matrix(matrix, cordinates, counter+1);
            test = day.find_distance(matrix, 0, 0);
            counter ++;
        }
        System.out.println(Arrays.toString(cordinates.get(counter-1)));
    }
}
