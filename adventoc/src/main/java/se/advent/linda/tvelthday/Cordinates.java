package se.advent.linda.tvelthday;

public class Cordinates {
    private int line;
    private int row;
    private String plant;

    public Cordinates(int line, int row, String plant){
        this.line = line;
        this.row = row;
        this.plant = plant;
    }

    public int getLine(){
        return line;
    }

    public int getRow(){
        return row;
    }

    public String getPlant(){
        return plant;
    }

    public boolean check_next(Cordinates input){
        
     return false; 
    }

}
