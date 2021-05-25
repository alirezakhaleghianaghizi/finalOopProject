package model.gadget.vehicle;

import model.gadget.Gadget;
import model.gadget.GadgetEnum;

public class Truck extends Gadget {
    int truckSpeed;

    public Truck(double x , double y) {

        super(GadgetEnum.TRUCK.toString(), x, y, GadgetEnum.TRUCK.getCapacity());
        this.truckSpeed = 5;
    }

    public void transfer(){

    }
}
