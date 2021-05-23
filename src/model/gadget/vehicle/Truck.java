package model.gadget.vehicle;

import model.gadget.Gadget;

public class Truck extends Gadget {
    int truckSpeed;

    public Truck() {
        //x,y where ??
        super("Truck", x, y, 15);
        this.truckSpeed = 5;
    }

    public void transfer(){

    }
}
