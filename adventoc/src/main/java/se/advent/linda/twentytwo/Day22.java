package se.advent.linda.twentytwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day22 {
        String make_raw_data(String test){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\twentytwo\\input" + test + ".txt");
        String line = "";
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
                line += read_file.nextLine() + "\n";
            }
        } catch (FileNotFoundException ex) {
        }
        return line;
    }

    List<Long> make_list(String input){
        List<Long> start_numbers = new ArrayList<>();
        for (String number : input.split("\n")) {
         start_numbers.add(Long.valueOf(number));   
        }
        return start_numbers;
    }

    Long mixing(Long secret, Long number){
        return secret^number;}

    Long prune(Long number){
        return number%16777216;}

    Long steps(Long secret, int step){
        switch (step){
            case 1 -> {
                return step_one(secret);}
            case 2 ->{
                return step_two(secret);}
            case 3 -> {
                return step_three(secret);}
        }
        return secret;
    }

    Long step_one(Long secret){
        Long number = secret*64;
        number = mixing(secret, number);
        number = prune(number);
        return number;
    }

    Long step_two(Long secret){
        Long number = secret/32;
        number = mixing(secret, number);
        number = prune(number);
        return number;
    }

    Long step_three(Long secret){
        Long number = secret*2048;
        number = mixing(secret, number);
        number = prune(number);
        return number;
    }

    Long do_all_steps(Long secret){
        int number = 1;
        while (number < 4){
            secret = steps(secret, number);
            number ++;
        }
        return secret;
    }

public static void main(String[] args) {
    Day22 day = new Day22();
    List<Long> secret_start = day.make_list(day.make_raw_data(""));
    List<Long> results = new ArrayList<>();
    int times = 2000;
    for (int i = 0; i < secret_start.size(); i++) {
        Long temp = secret_start.get(i);
        while (times != 0){
            temp = day.do_all_steps(temp);
            times --;
        }
        results.add(temp);
        times = 2000;
        //System.out.println(temp);
    }
    Long result = 0L;
    for (int i = 0; i < results.size(); i++) {
        result += results.get(i);
    }
    System.out.println(result);
    }
}