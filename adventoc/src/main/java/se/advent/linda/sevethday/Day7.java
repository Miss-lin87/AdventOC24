package se.advent.linda.sevethday;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day7 {
    String raw_data_line(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\sevethday\\input" + test + ".txt");
        String rawlist = "";
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
            rawlist += "\n" + read_file.nextLine();
        }
            } catch (FileNotFoundException ex) {
            }
        return rawlist.substring(1);
    }

    List<String> make_list(String input){
        List<String> output = new ArrayList<>();
        String[] temp = input.split("\n");
        for (String elem : temp) {
            output.add(elem);
        }
        return output;
    }

    long solve_it(long awnser, long total, long[] equations, int times, int operat) {
        if (awnser == total && equations.length == times) {
            return total;
        } else if (equations.length == times) {
            return 0;
        } else if (total > awnser) {
            return 0;
        } else {
            long result = solve_it(awnser, total + equations[times], equations, times+1, operat);
            if (result == awnser) {
                return awnser;
            }
            result = solve_it(awnser, total * equations[times], equations, times+1, operat);
            if (result == awnser) {
                return awnser;
            }
            if (operat == 3) {
                return solve_it(awnser, Long.parseLong(total + "" + equations[times]), equations, times + 1, operat);
            } else {
                return 0;
            }
        }
    }
    
    public static void main(String[] args){
        Day7 day = new Day7();
        List<String> input = day.make_list(day.raw_data_line(""));
        
        Long total_one = 0L;
        Long total_two = 0L;
        for (String line : input) {
            String[] awnserS = line.split(": ");
            Long awnser = Long.valueOf(awnserS[0]);
            //System.out.println(awnser);
            long[] equations = Arrays.stream(awnserS[1].split(" ")).mapToLong(Long::valueOf).toArray();
            //System.out.println(Arrays.toString(equations));
            total_one += day.solve_it(awnser, equations[0], equations, 1, 2);
            total_two += day.solve_it(awnser, equations[0], equations, 1, 3);
        }
        System.out.println(total_one);
        System.out.println(total_two);
    }
}

