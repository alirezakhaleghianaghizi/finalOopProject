package controller;
import model.gadget.vehicle.Truck;
import model.goods.Goods;
import view.Timing;
import java.util.ArrayList;

public class ControllerGadget {
    Truck truck = new Truck(0,0);
    ArrayList<Goods> truckgoods = new ArrayList<>();
    public boolean truckLoad(Goods good){
        if(this.truck.isFull())
        {return false;}
        else {
            this.truckgoods.add(good);
            this.truck.avaiableCap-=good.capacity;
            return true;
        }
    }
    public void truckUnload(Goods good){
        this.truckgoods.remove(good);
        this.truck.avaiableCap+= good.capacity;

    }
    public boolean truckGo(){
    if(this.truck.go) return false;
    this.truck.goTime = new Timing();
    this.truck.go=true;
    return true;
    }
    public boolean truckCome(){
        if(this.truck.goTime.getDate()+10<=Timing.getCurrentTime()){
        truck.go=false;
        this.truck.goTime=null;
         return true;
        }
        return false;
    }
    
}
