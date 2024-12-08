package se.advent.linda.sevethday;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

    List<Long> make_awnsers(String input){
        List<Long> output = new ArrayList<>();
        String[] temp = input.split("\n");
        for (String line : temp) {
            output.add(Long.valueOf(line.substring(0, line.indexOf(":"))));
        }
        return output;
    }

    List<String> make_equations(String input){
        List<String> output = new ArrayList<>();
        String[] temp = input.split("\n");
        for (String elem : temp) {
            output.add(elem.substring(elem.indexOf(":")+1, elem.length()).strip());
        }
        return output;
    }

    List<Long> convert_int(String input){
        List<Long> output = new ArrayList<>();
        for (String elem: input.split(" ")) {
            output.add(Long.valueOf(elem));
        }
        return output;
    }

    float test_valid(List<Long> input, Long awnser){
        float temp = awnser;
        //System.out.println(temp);
        for (int i = input.size()-1; i > -1; i--) {
            //System.out.println(input.get(i));
            if (temp%input.get(i) == 0){
                temp /= input.get(i);
                //System.out.println(temp);
                //System.out.println("");
            }
            else{
                temp -= input.get(i);
                //System.out.println(temp);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Day7 day = new Day7();
        List<Long> awnsers = day.make_awnsers(day.raw_data_line(""));
        List<String> equations = day.make_equations(day.raw_data_line(""));
        Long total = 0L;
        for (int i = 0; i < equations.size(); i++) {
            System.out.println(equations.get(i));
            System.out.println(awnsers.get(i).toString());
            float temp = day.test_valid(day.convert_int(equations.get(i)), awnsers.get(i));
            System.out.println(temp);
            System.out.print("\n");
            if (temp == 1 | temp == 0){
                total += awnsers.get(i);
            }
        }
        System.out.println(total);
        }
    }
