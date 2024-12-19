package se.advent.linda;


public class Testing_stuff {
    void find_peramit(String[][] matrix, Integer line, Integer row, String plant){
        }

    Integer test_increase(Integer time, Integer fun){
        if(fun != 0){
            time = test_increase(time +1, fun-1);
        }
        return time;
    }

    public static void main(String[] args) {
        Testing_stuff test = new Testing_stuff();
        /*String plant = "R";
        String[][] matrix = {{"R","R","R","R","I","I","C","C","F","F"},
                            {"R","R","R","R","I","I","C","C","C","F"},
                            {"V","V","R","R","R","C","C","F","F","F"},
                            {"V","V","R","C","C","C","J","F","F","F"}};
        for (int line = 0; line < matrix.length; line++) {
            for (int row = 0; row < matrix[0].length; row++) {
                if(matrix[line][row].equals(plant)){
                    test.find_peramit(matrix, line, row, plant);
                }
            }
        }*/
        System.out.println(4>4);
        Integer number = test.test_increase(0, 5);
        System.out.println(number);
    }

}
