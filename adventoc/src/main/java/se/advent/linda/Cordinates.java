package se.advent.linda;

import java.util.LinkedList;
import java.util.List;

public class Cordinates {
    private long value;
    private List<Cordinates> child;

    public Cordinates(long value){
        this.value = value;
        this.child = new LinkedList<>();
    }

    public void addChild(Cordinates childnode){
        this.child.add(childnode);
    }

    public long getValue(){
        return value;
    }

    public List<Cordinates> getChilds(){
        return child;
    }

    public void setValue(long value){
        this.value = value;
    }

    public Cordinates getAdd(){
        return getChilds().getFirst();
    }

    public Cordinates getMulti(){
        return getChilds().getLast();
    }

}


