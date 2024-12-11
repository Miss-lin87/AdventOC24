package se.advent.linda.tenthday;

public class Cordinates {
    private int line;
    private int row;
    private Integer value;

    public Cordinates(int line, int row, Integer value){
        this.line = line;
        this.row = row;
        this.value = value;
    }

    public void setValue(Integer newvalue){
        this.value = newvalue;
    }

    
    public Integer getValue(){
        return value;
    }

    public int getLine(){
        return line;
    }

    public int getRow(){
        return row;
    }
}
