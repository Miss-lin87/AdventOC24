package se.advent.linda.secoundday;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {
    List<List<Integer>> make_raw_data(){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\secoundday\\input.txt");
        List<List<Integer>> list = new ArrayList<>();
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextLine()){
                String[] line = read_file.nextLine().replace(" ", ",").split(",");
                List<Integer> temp = new ArrayList<>();
                for (String elem : line) {
                    temp.add(Integer.valueOf(elem));
                }
                list.add(temp);
            }
            } catch (FileNotFoundException ex) {
            }
            return list;
        }


    boolean list_desc(List<Integer> list){
        boolean test = true;
        for (int i = 0; i < list.size()-1; i++){
            test = (list.get(i+1) > list.get(i) && Math.abs(list.get(i+1) - list.get(i))<=3);
            if (test == false){
                return test;
            }
            }
        return test;
    }

    boolean list_accen(List<Integer> list){
        boolean test = true;
        for (int i = 0; i < list.size()-1; i++){
            test = (list.get(i+1) < list.get(i) && Math.abs(list.get(i+1) - list.get(i))<=3);
            if (test == false){
                return test;
            }
            }
        return test;
    }

public static void main(String[] args) {
    Day2 day = new Day2();
    int result = 0;
    List<List<Integer>> x = day.make_raw_data();
    for (int i = 0; i < x.size(); i++) {
        if (day.list_desc(x.get(i)) | day.list_accen(x.get(i)) == true){
            result ++;
        }
        }
    System.err.println(result);    
    }
}
    

