package se.advent.linda.thirteenth;

public final class Button {
    private int x = 0;
    private int y = 0;
    private int cost = 0;

    public Button(int x, int y, String AorB){
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

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getCost(){
        return cost;
    }
}
