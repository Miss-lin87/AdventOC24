package se.advent.linda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class File_for_testing{

    boolean test_valid(List<String> stripes, String towel, String start) {
        for (int i = 0; i < stripes.size(); i++) {
            String teststring = start + stripes.get(i);
            if (teststring.equals(towel)) {
                return true;
            }
            if (towel.startsWith(teststring)) {
                boolean tempresult = test_valid(stripes, towel, teststring);
                if (tempresult == true) {
                    return true;
                }
            }
            //teststring = start;
        }
        return false;
    }
    

    public static void main(String[] args) {
        File_for_testing testi = new File_for_testing();
        List<String> colors = new ArrayList<>(Arrays.asList("r", "wr", "b", "g", "bwu", "rb", "gb", "br"));
        List<String> towels = new ArrayList<>(Arrays.asList("brwrr"));
        String stringtest = "ubwu";
        String stringtest2 = "brwrr";
        String stringtest3 = "rrbgbr";
        String stringtest4 = "rydhri";
        List<Integer> indexes = new ArrayList<>();
        boolean test = colors.stream().anyMatch(towels::contains);
        System.out.println(testi.test_valid(colors, stringtest2, ""));
      }
}



/*brwrr
bggr
gbbr
rrbgbr
ubwu
bwurrg
brgr
bbrgwb*/