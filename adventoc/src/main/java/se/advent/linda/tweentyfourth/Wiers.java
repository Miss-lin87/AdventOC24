package se.advent.linda.tweentyfourth;

public class Wiers {
    private final String name;
    private final int value;
    private Wiers parentx;
    private Wiers parenty;

    public Wiers(String name, int value){
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return name; 
    }

    public int getValue(){
        return value;
    }
}
