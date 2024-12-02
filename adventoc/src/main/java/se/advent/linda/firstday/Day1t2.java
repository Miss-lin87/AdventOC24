package se.advent.linda.firstday;

import java.util.List;
import java.util.Objects;

public class Day1t2 {
    public static void main(String[] args) {
        Day1 day = new Day1();
        int total_similarity = 0;
        int temp = 0;
        List<Integer> list1 = day.make_raw_data("list1");
        List<Integer> list2 = day.make_raw_data("list2");
        for (int i = 0; i < list1.size(); i++){
            if (list2.contains(list1.get(i))){
                for (int j = 0; j < list2.size(); j++){
                    if (Objects.equals(list1.get(i), list2.get(j))){
                        temp ++;
                    }
                total_similarity += list1.get(i)*temp;
                temp = 0;
                }
            }

        }
    System.out.println(total_similarity);
    System.out.println(temp);
    }
}
