package se.advent.linda.thirdday;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3t2 {
        String make_raw_data(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\thirdday\\input" + test + ".txt");
        String rawlist = null;
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
            rawlist += read_file.nextLine();
        }
            } catch (FileNotFoundException ex) {
            }
        return rawlist;
        }

        String[] mod_string(String input){
            String[] test = input.split("do()");
            return test;
        }

        boolean test_if_not(String input){
            boolean test = input.startsWith("n't");
            return test;
        }

        int convert_fix(String[] input){
            int total = 0;
            for (int i = 0; i < input.length; i++) {
                if (input[i].stripLeading().startsWith("(")){
                    try {
                        int index = input[i].indexOf(")");
                        String modded = input[i].substring(1,index);
                        String[] modded2 = modded.split(",");
                        total += Integer.parseInt(modded2[0])*Integer.parseInt(modded2[1]);
                    } catch (Exception e) {
                    }
                }
                
            }
            return total;
        }

    public static void main(String[] args) {
        Day3t2 day2 = new Day3t2();
        int total = 0;
        String input = day2.make_raw_data("");
        String[] result = day2.mod_string(input);
        for (int i = 0; i < result.length; i++) {
            if (day2.test_if_not(result[i])==false){
                total += day2.convert_fix(result[i].split("mul"));
            }
            }
        System.err.println(total);
        }
    }
