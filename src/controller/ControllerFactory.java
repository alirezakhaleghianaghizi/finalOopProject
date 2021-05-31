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
    public ArrayList<EggPowder> eggPowderFactories;
    public ArrayList<MilkSeprator> milkSepratorFactories;
    public ArrayList<Spinnery> spinneryFactories;
    public  ArrayList<CookieBakery> cookieBakeryFactories;
    public ArrayList<IceCreamFactory> iceCreamFactories;
    public  ArrayList<Weaving> WeavingFactories;

    public ControllerFactory() {
        this.eggPowderFactories = new ArrayList<>();
        this.milkSepratorFactories = new ArrayList<>();
        this.spinneryFactories = new ArrayList<>();
        this.cookieBakeryFactories = new ArrayList<>();
        this.iceCreamFactories = new ArrayList<>();
        WeavingFactories = new ArrayList<>();
    }

    //Working fac methods
        // first fac :
    public boolean workEggPowder(EggPowder eggPowder, ControllerGadget gadget) {
        if (eggPowder.level == 1) {
            for (Goods goods1 : gadget.warehouse.existence) {
                if (goods1.name.equals(GoodsEnum.EGG.name())) {
                    gadget.warehouse.existence.remove(goods1);
                    return true;
                }
            }
            return false;
        }else {
            int a = 0;
            while (a <= 2) {
                for (Goods g : gadget.warehouse.existence) {
                    if (g.name.equals(GoodsEnum.EGG.name())) {
                        a++;
                        gadget.warehouse.existence.remove(g);
                    }
                }
            }
            if(a!=0) return true;
            return false;
        }
    }

    public boolean workSpinnery(Spinnery spinnery,ControllerGadget gadget) {
        if (spinnery.level == 1) {
            for (Goods goods1 : gadget.warehouse.existence) {
                if (goods1.name.equals(GoodsEnum.FEATHER.name())) {
                    gadget.warehouse.existence.remove(goods1);
                    return true;
                }
            }
            return false;
        }else {
            int a = 0;
            while (a <= 2) {
                for (Goods g : gadget.warehouse.existence) {
                    if (g.name.equals(GoodsEnum.FEATHER.name())) {
                        a++;
                        gadget.warehouse.existence.remove(g);
                    }
                }
            }
            if(a!=0) return true;
            return false;
        }
    }

    public boolean workMilkSeprator(MilkSeprator milkSeprator,ControllerGadget gadget) {
        if (milkSeprator.level == 1) {
            for (Goods goods1 : gadget.warehouse.existence) {
                if (goods1.name.equals(GoodsEnum.MILK.name())) {
                    gadget.warehouse.existence.remove(goods1);
                    return true;
                }
            }
            return false;
        }else {
            int a = 0;
            while (a <= 2) {
                for (Goods g : gadget.warehouse.existence) {
                    if (g.name.equals(GoodsEnum.MILK.name())) {
                        a++;
                        gadget.warehouse.existence.remove(g);
                    }
                }
            }
            if(a!=0) return true;
            return false;
        }
    }

        //seccond fac :
    public boolean workCookieBakery(CookieBakery cookieBakery, ControllerGadget gadget) {
        if (cookieBakery.level == 1) {
            for (Goods goods1 : gadget.warehouse.existence) {
                if (goods1.name.equals(GoodsEnum.FLOUR.name())) {
                    gadget.warehouse.existence.remove(goods1);
                    return true;
                }
            }
            return false;
        }else {
            int a = 0;
            while (a <= 2) {
                for (Goods g : gadget.warehouse.existence) {
                    if (g.name.equals(GoodsEnum.FLOUR.name())) {
                        a++;
                        gadget.warehouse.existence.remove(g);
                    }
                }
            }
            if(a!=0) return true;
            return false;
        }
    }

    public boolean workWeaving(Weaving weaving, ControllerGadget gadget) {
        if (weaving.level == 1) {
            for (Goods goods1 : gadget.warehouse.existence) {
                if (goods1.name.equals(GoodsEnum.SILK.name())) {
                    gadget.warehouse.existence.remove(goods1);
                    return true;
                }
            }
            return false;
        }else {
            int a = 0;
            while (a <= 2) {
                for (Goods g : gadget.warehouse.existence) {
                    if (g.name.equals(GoodsEnum.SILK.name())) {
                        a++;
                        gadget.warehouse.existence.remove(g);
                    }
                }
            }
            if(a!=0) return true;
            return false;
        }
    }

    public boolean workIceCreamFactory(IceCreamFactory iceCreamFactory, ControllerGadget gadget) {
        if (iceCreamFactory.level == 1) {
            for (Goods goods1 : gadget.warehouse.existence) {
                if (goods1.name.equals(GoodsEnum.SEPARATEDMILK.name())) {
                    gadget.warehouse.existence.remove(goods1);
                    return true;
                }
            }
            return false;
        }else {
            int a = 0;
            while (a <= 2) {
                for (Goods g : gadget.warehouse.existence) {
                    if (g.name.equals(GoodsEnum.SEPARATEDMILK.name())) {
                        a++;
                        gadget.warehouse.existence.remove(g);
                    }
                }
            }
            if(a!=0) return true;
            return false;
        }
    }


}
