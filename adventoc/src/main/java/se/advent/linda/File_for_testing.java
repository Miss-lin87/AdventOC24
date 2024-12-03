package se.advent.linda;

public class File_for_testing{
    int convert_fix(String[] input){
        int total = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i].startsWith("(")){
                int index = input[i].indexOf(")");
                String modded = input[i].substring(1,index);
                try {
                    String[] modded2 = modded.split(",");
                    total += Integer.parseInt(modded2[0])*Integer.parseInt(modded2[1]);
                } catch (Exception e) {
                }
            }
            
        }
        return total;
    }

public static void main(String[] args) {
    File_for_testing file = new File_for_testing();
    String[] test = {"(2,4)&","()?", "(8,5))"};
    System.err.println(file.convert_fix(test));
}
}