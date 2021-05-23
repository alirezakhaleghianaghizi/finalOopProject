package model.goods;

import model.Model;

public abstract class Goods extends Model {

    public int cost;
    public Goods(String name, double x, double y,int cost) {
        super(name, x, y);
        this.cost=cost;
    }
}
