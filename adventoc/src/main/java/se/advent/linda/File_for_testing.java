package se.advent.linda;

public class File_for_testing{
    Cordinates set_children(Cordinates parent, Long target, Long[] numbers){
        if(parent.getValue() > target){
            System.out.println("toHigh");
        }
        else if(parent.getValue() == target){
            System.out.println("target found");
        }
        return null;
    }
    

    public static void main(String[] args) {
        Long target = 3267L; 
        Long[] numbers = {81L, 40L, 27L};
        Cordinates first = new Cordinates(81L);
        first.addChild(new Cordinates(first.getValue()+40L));
        first.addChild(new Cordinates(first.getValue()*40L));
        first.getAdd().addChild(new Cordinates(first.getChilds().getFirst().getValue()+27L));
        first.getMulti().addChild(new Cordinates(first.getChilds().getLast().getValue()*27L));

        System.out.println(first.getMulti().getValue());
    }
}