package se.advent.linda;

import java.util.LinkedList;
import java.util.List;


public class Conection {
    private String name;
    private List<Conection> conections;

    public Conection(String name){
        this.name = name;
        this.conections = new LinkedList<>();
    }

    public void addChild(Conection childname){
        this.conections.add(childname);
    }

    public String getName(){
        return name;
    }

    public List<Conection> getChilds(){
        return conections;
    }

    public Integer getConect_amount(){
        return this.getChilds().size();
    }

    public Conection getChild(int index){
        return this.getChilds().get(index);
    }

    public boolean getLAN(){
        return false;
    }
}
