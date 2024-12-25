package se.advent.linda.sixteenth;

public class Cord {
    int line;
    int row;
    int distance;

    public Cord(int line, int row, int distance){
        this.line = line;
        this.row = row;
        this.distance = distance;
    }

    public int getLine(){
        return line;
    }

    public int getRow(){
        return row;
    }

    public int getDistance(){
        return distance;
    }
}
