package model.gadget;

import model.goods.Goods;

import java.util.ArrayList;

public class Warehouse extends Gadget {
    public ArrayList<Goods> existence ;
    public Warehouse(double x , double y ) {
        super(GadgetEnum.WAREHOUSE.toString(), x, y, GadgetEnum.WAREHOUSE.capacity);
        this.existence = new ArrayList<>();
    }

}
