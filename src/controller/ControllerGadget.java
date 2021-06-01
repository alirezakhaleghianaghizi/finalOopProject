package controller;
import model.gadget.GadgetEnum;
import model.gadget.Well;
import model.gadget.Warehouse;
import model.gadget.vehicle.Truck;
import model.goods.Goods;
import view.Timing;
import java.util.ArrayList;

public class ControllerGadget {

    public Truck truck;
    public Well well;
    public Warehouse warehouse;
    ArrayList<Goods> truckgoods;

    public ControllerGadget() {
        this.truck = new Truck(0, 0);
        this.well = new Well(0, 0);
        this.warehouse = new Warehouse(0, 0);
        this.truckgoods = new ArrayList<>();
    }


    public boolean truckLoad(Goods good) {
        if (this.truck.isFull(good) || truckGo()) {
            return false;
        } else {
            this.truckgoods.add(good);
            this.truck.avaiableCap -= good.capacity;
            return true;
        }
    }

    public boolean truckUnload(Goods good) {
        if (!truckGo()) {
            this.truckgoods.remove(good);
            this.truck.avaiableCap += good.capacity;
            return true;
        }
        return false;
    }

    public boolean truckGo() {
        if (this.truck.go) return false;
        this.truck.goTime = new Timing();
        this.truck.go = true;
        return true;
    }

    public boolean truckCome() {
        if (this.truck.goTime.getDate() + 10 <= Timing.getCurrentTime()) {
            truck.go = false;
            this.truck.goTime = null;
            return true;
        }
        return false;
    }

    public boolean well() {
        if (!this.well.isfull) {
            this.well.fulling = new Timing();
            well.setTimePeride();
            return true;
        }
        return false;
    }
}


