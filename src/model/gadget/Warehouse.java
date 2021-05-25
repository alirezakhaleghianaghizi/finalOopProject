package model.gadget;

public class Warehouse extends Gadget {
    public Warehouse(double x , double y ) {
        super(GadgetEnum.WAREHOUSE.toString(), x, y, GadgetEnum.WAREHOUSE.capacity);
    }
}
