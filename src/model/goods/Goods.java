package model.goods;

import model.Model;

public abstract class Goods extends Model {
    public int capacity;
    public int cost;
    public int timeOfRemaining;
    public Goods(String name, double x, double y,int cost,int capacity,int timeOfRemaining) {
        super(name, x, y);
        this.cost=cost;
        this.capacity=capacity;
        this.timeOfRemaining=timeOfRemaining;
    }
}
