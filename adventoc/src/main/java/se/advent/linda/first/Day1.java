package se.advent.linda.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day1{

    List<Integer> make_raw_data(String name){
        File raw_data = new File("C:\\Users\\loric\\Documents\\Advent of code 2024\\adventoc\\src\\main\\java\\se\\advent\\linda\\first\\" + name + ".txt");
        List<Integer> list = new ArrayList<>();
        try (Scanner read_file = new Scanner(raw_data)) {
            while (read_file.hasNextInt()){
                String number = read_file.nextLine().strip();
                int number2 = Integer.parseInt(number);
                list.add(number2);
            }
        } catch (FileNotFoundException ex) {
        }
        return list;
    }

    public static void main(String[] args) {
        Day1 day = new Day1();
        int final_total = 0;
        List<Integer> list1 = day.make_raw_data("list1");
        List<Integer> list2 = day.make_raw_data("list2");
        Collections.sort(list1);
        Collections.sort(list2);
        for (int i = 0; i < list1.size(); i++ ){
            if (list1.get(i) > list2.get(i)){
                final_total += list1.get(i) - list2.get(i);
            }
            else{ final_total += list2.get(i) - list1.get(i);
            }
        }
        System.out.println(final_total);
    }
}
    