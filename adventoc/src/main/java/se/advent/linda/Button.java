package se.advent.linda;

public final class Button {
    private Long x = 0L;
    private Long y = 0L;
    private int cost = 0;

    public Button(Long x, Long y, String AorB){
        this.x = x;
        this.y = y;
        this.cost = define_cost(AorB);
    }

    private int define_cost(String AorB){
        int check = 0;
        switch (AorB){
            case "A" -> check = 3;
            case "B" -> check = 1;
        }
        return check;
    }

    public Long getX(){
        return x;
    }

    public Long getY(){
        return y;
    }

    public int getCost(){
        return cost;
    }
}