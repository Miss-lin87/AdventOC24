package se.advent.linda.sixday;

import java.util.ArrayList;
import java.util.List;


class Day6t2 {
    static Day6 day = new Day6();
    static Day6t2 day2 = new Day6t2();
    
void printmap(List<List<String>> temp){
    for (List<String> row : temp) {
        System.out.println(row);
    }
    System.out.println("");
    System.out.println("");
}

    int test_loop(List<List<String>> matrix, List<Integer> cord, List<Integer> face){
        boolean testL = true;
        int counter = 0;
        // make new all
        List<Integer> tempcord = new ArrayList<>();
        for (Integer elem : cord) {
            tempcord.add(elem);
        }

        List<Integer> tempface = new ArrayList<>();
        for (Integer elem : face){
            tempface.add(elem);
        }

        List<List<String>> temp = new ArrayList<>();
        for (List<String> row : matrix){
            temp.add(new ArrayList<>(row));
        }
        temp.get((tempcord.get(0)+tempface.get(0))).set((tempcord.get(1)+tempface.get(1)), "#");

        int loop = 0;
        while (testL == true){
            loop ++;
            try {
                if(!day.try_valid_move(temp, tempface, tempcord) == true) {
                    tempface = day.change_face_forward(tempface);
                    boolean sameface = tempface.equals(face);
                    if (day.look_at_cord(temp, tempcord.get(0)+tempface.get(0), tempcord.get(1)+tempface.get(1)) == "X" && sameface){
                        counter ++;
                        return counter;
                    }
                }
                else {
                    temp.get(tempcord.get(0)).set((tempcord.get(1)), "X");
                    tempcord = day.change_cords(tempface, tempcord);
                }
                //day2.printmap(temp);
        } catch (Exception e) {
            return counter;
        }
        if (loop == 50000){testL = false;}
    }
    return counter;
    }

    //2752 test ?
    //2554 test ?

    //2751 wrong
    //2800 wrong
    public static void main(String[] args) {
        Day6t2 day2 = new Day6t2();
        List<List<String>> matrix = new ArrayList<>(day.make_matrix(day.raw_data_line("")));
        List<Integer> cordinates = new ArrayList<>(day.get_inital_cord(matrix));
        List<Integer> facing = new ArrayList<>(day.set_facing(day.get_starting_face(matrix)));
        boolean test = true;
        int counter = 0;
        while (test == true){
        try {
            if (!day.try_valid_move(matrix, facing, cordinates)==true){
                facing = day.change_face_forward(facing);
            }
            else {
                counter += day2.test_loop(matrix, cordinates, facing);
                cordinates = day.change_cords(facing, cordinates);
            }
        } catch (Exception e) {
            System.out.println("Out of bounds");
            break;
        }
    }
    System.out.println(counter);
    }
}