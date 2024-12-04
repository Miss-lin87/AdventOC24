package se.advent.linda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class File_for_testing{
    int match(){
        int counter = 0;
            Pattern find = Pattern.compile("XMAS");
            Pattern find2 = Pattern.compile("SAMX");
            Matcher match = find.matcher("XMASMAXMMSAMXX");
            Matcher match2 = find2.matcher("XMASMAXMMSAMXX");
            while (match.find()||match2.find()){
                counter ++;
            }
        return counter;
    }
    public static void main(String[] args) {
        File_for_testing test = new File_for_testing();
        System.out.println(test.match());
    }
}