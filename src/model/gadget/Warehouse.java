package model.gadget;

import model.goods.Goods;

import java.util.ArrayList;

public class Warehouse extends Gadget {
    public ArrayList<Goods> existence;
    int currentCapacity;

    public Warehouse(double x, double y) {
        super(GadgetEnum.WAREHOUSE.toString(), x, y, GadgetEnum.WAREHOUSE.capacity);
        this.existence = new ArrayList<>();
    }

    public boolean haveSpace(Goods goods) {
        if (currentCapacity > goods.capacity)
            return true;
            return false;
    }
}
