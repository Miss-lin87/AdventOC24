package se.advent.linda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class File_for_testing{
    Integer multiply(List<Integer> input, Integer N){
        Integer multiply = input.get(N)*input.get(N+1);
        List<Integer> temp = new ArrayList<>(input);
        System.out.println(temp);
        temp.removeAll(Arrays.asList(input.get(N), input.get(N+1)));
        System.out.println(temp);
        for (Integer elem : temp) {
            multiply += elem;
        }
        return multiply;
    }

    Integer add(List<Integer> input, Integer N, Integer I){
        Integer temp = 0;
        for (Integer elem : input.subList(0, N)) {
            // System.out.print(input.subList(0, N));
            temp += elem;
            System.err.println(temp);
        }
        for (Integer elem : input.subList(N, N+1)) {
            // System.out.print(input.subList(N, N+I+1));
            temp *= elem;
            System.err.println(temp);
        }
        for (Integer elem : input.subList(N+1, input.size())) {
            // System.out.print(input.subList(N+I+1, input.size()));
            temp += elem;
            System.out.println(temp);
        }
        System.err.println("\n");
    return temp;
    }

    Integer testshit(List<Integer> input, int multi){
        Integer temp = input.get(0);
        for (Integer elem : input.subList(1, input.size())) {
            if (input.indexOf(elem) == multi){
                temp *= elem;
            }
            else{
                temp += elem;
            }
        }
        return temp;
    }

    Integer testshit2(List<Integer> input, List<Integer> multi){
        Integer temp = input.get(0);
        for (Integer elem : input.subList(1, input.size())) {
            if (multi.contains(input.indexOf(elem))){
                temp *= elem;
            }
            else{
                temp += elem;
            }
        }
        return temp;
    }

    Integer add(int x, int y){
        return x+y;
    }
    Integer multi(int x, int y){
        return x*y;
    }

    float test_valid(List<Integer> input, int awnser){
        float temp = awnser;
        for (int i = input.size()-1; i > 0; i--) {
            if (temp/input.get(i) != (int)temp/input.get(i)){
                temp -= input.get(i);
            }
            else{
                temp %= input.get(i);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        File_for_testing test = new File_for_testing();
        Integer awnser = 16183610;
        List<Integer> test1 = new ArrayList<>();
        test1.add(62);
        test1.add(7);
        test1.add(96);
        test1.add(8);
        test1.add(6);
        test1.add(8);
        test1.add(52);
        test1.add(3);
        test1.add(3);
        test1.add(47);
        List<Integer> multi = new ArrayList<>();
        List<Integer> seen = new ArrayList<>();
        int N = 0;
        System.out.println(test.test_valid(test1, awnser));


    List<String[]> fuck = new ArrayList<>();
    fuck.add(("+,*").split(","));

    HashMap <Integer,String> testhash = new HashMap<>();
    testhash.putIfAbsent(2, "+, *");
    testhash.putIfAbsent(3, "++, **, +*, *+");
    testhash.putIfAbsent(test1.size(), "");

    }
}