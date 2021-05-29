package controller;

import model.factory.Factory;
import model.factory.first.EggPowder;
import model.factory.first.MilkSeprator;
import model.factory.first.Spinnery;
import model.factory.seccond.CookieBakery;
import model.factory.seccond.IceCreamFactory;
import model.factory.seccond.Weaving;
import model.goods.*;

import java.util.ArrayList;

public class ControllerFactory {
    ArrayList<EggPowder> eggPowderFactories;
    ArrayList<MilkSeprator> milkSepratorFactories;
    ArrayList<Spinnery> spinneryFactories;
    ArrayList<CookieBakery> cookieBakeryFactories;
    ArrayList<IceCreamFactory> iceCreamFactories;
    ArrayList<Weaving> WeavingFactories;

    public ControllerFactory() {
        this.eggPowderFactories = new ArrayList<>();
        this.milkSepratorFactories = new ArrayList<>();
        this.spinneryFactories = new ArrayList<>();
        this.cookieBakeryFactories = new ArrayList<>();
        this.iceCreamFactories = new ArrayList<>();
        WeavingFactories = new ArrayList<>();
    }

    public boolean workEggPowder(EggPowder eggPowder, ControllerGoods goods , ControllerGadget gadget) {
        if (eggPowder.level == 1) {
            for (Goods goods1 : gadget.warehouse.existence) {
                if (goods1.name.equals("Egg")) {
                    gadget.warehouse.existence.remove(goods1);
                    return true;
                }
            }
            return false;
        }else {
            int a = 0;
            while (a <= 2) {
                for (Goods g : gadget.warehouse.existence) {
                    if (g.name.equals("Egg")) {
                        a++;
                        gadget.warehouse.existence.remove(g);
                    }
                }
            }
            if(a!=0) return true;return false;
        }
    }



}
