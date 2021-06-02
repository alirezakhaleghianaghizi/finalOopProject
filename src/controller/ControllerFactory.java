package controller;

import model.factory.Factory;
import model.factory.FactoryMoney;
import model.factory.first.EggPowder;
import model.factory.first.MilkSeprator;
import model.factory.first.Spinnery;
import model.factory.seccond.CookieBakery;
import model.factory.seccond.IceCreamFactory;
import model.factory.seccond.Weaving;
import model.goods.*;
import view.Timing;

import java.util.ArrayList;

public class ControllerFactory {
    public EggPowder eggPowderFactories;
    public MilkSeprator milkSepratorFactories;
    public Spinnery spinneryFactories;
    public  CookieBakery cookieBakeryFactories;
    public IceCreamFactory iceCreamFactories;
    public  Weaving weavingFactories;

    public ControllerFactory() { }

    //Working fac methods
        // first fac :
    public int workFactory(Factory factory, ControllerGadget gadget){
        if (factory.name.equalsIgnoreCase(FactoryMoney.EGGPOWDER.toString())) return workEggPowder((EggPowder) factory,gadget);
        if (factory.name.equalsIgnoreCase(FactoryMoney.SPINNERY.toString())) return workSpinnery((Spinnery) factory,gadget);
        if (factory.name.equalsIgnoreCase(FactoryMoney.COOKIEBAKERY.toString())) return workCookieBakery((CookieBakery) factory,gadget);
        if (factory.name.equalsIgnoreCase(FactoryMoney.MILKSEPERATOR.toString())) return workMilkSeprator( (MilkSeprator) factory,gadget);
        if (factory.name.equalsIgnoreCase(FactoryMoney.ICECREAMFACTORY.toString())) return workIceCreamFactory((IceCreamFactory) factory,gadget);
        if (factory.name.equalsIgnoreCase(FactoryMoney.WEAVING.toString())) return workWeaving( (Weaving) factory,gadget);
        return 0;
    }
    public int  workEggPowder(EggPowder eggPowder, ControllerGadget gadget) {
        if (eggPowder.level == 1) {
            for (Goods goods1 : gadget.warehouse.existence) {
                if (goods1.name.equals(GoodsEnum.EGG.name())) {
                    gadget.warehouse.existence.remove(goods1);
                    if(eggPowder.work(1)) return 1;
                    return -1;
                }
            }
            return 0;
        }else {
            int a = 0;
            ArrayList index;
            while (a <= 2) {
                for (Goods g : gadget.warehouse.existence) {
                    if (g.name.equals(GoodsEnum.EGG.name())) {
                        a++;
                        gadget.warehouse.existence.remove(g);
                    }
                }
            }
            if(a==0) return 0;
            if(eggPowder.work(a))return 1;
            return -1;
        }
    }

    public int workSpinnery(Spinnery spinnery, ControllerGadget gadget) {
        if (spinnery.level == 1) {
            for (Goods goods1 : gadget.warehouse.existence) {
                if (goods1.name.equals(GoodsEnum.FEATHER.name())) {
                    gadget.warehouse.existence.remove(goods1);
                    if(spinnery.work(1)) return 1;
                    return -1;
                }
            }
            return 0;
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
            if(a==0) return 0;
            if(spinnery.work(a)) return 1;
            return -1;
        }
    }

    public int workMilkSeprator(MilkSeprator milkSeprator,ControllerGadget gadget) {
        if (milkSeprator.level == 1) {
            for (Goods goods1 : gadget.warehouse.existence) {
                if (goods1.name.equals(GoodsEnum.MILK.name())) {
                    gadget.warehouse.existence.remove(goods1);
                    if(milkSeprator.work(1)) return 1;
                    return -1;
                }
            }
            return 0;
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
            if(a==0) return 0;
            if(milkSeprator.work(a)) return 1;
            return -1;
        }
    }

        //seccond fac :
    public int workCookieBakery(CookieBakery cookieBakery, ControllerGadget gadget) {
        if (cookieBakery.level == 1) {
            for (Goods goods1 : gadget.warehouse.existence) {
                if (goods1.name.equals(GoodsEnum.FLOUR.name())) {
                    gadget.warehouse.existence.remove(goods1);
                    if(cookieBakery.work(1)) return 1;
                    return -1;
                }
            }
            return 0;
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
            if(a==0) return 0;
            if(cookieBakery.work(a)) return 1;
            return -1;
        }
    }

    public int workWeaving(Weaving weaving, ControllerGadget gadget) {
        if (weaving.level == 1) {
            for (Goods goods1 : gadget.warehouse.existence) {
                if (goods1.name.equals(GoodsEnum.SILK.name())) {
                    gadget.warehouse.existence.remove(goods1);
                    if(weaving.work(1)) return 1;
                    return -1;
                }
            }
            return 0;
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
            if(a==0) return 0;
            if(weaving.work(a)) return 1;
            return -1;
        }
    }

    public int  workIceCreamFactory(IceCreamFactory iceCreamFactory, ControllerGadget gadget) {
        if (iceCreamFactory.level == 1) {
            for (Goods goods1 : gadget.warehouse.existence) {
                if (goods1.name.equals(GoodsEnum.SEPARATEDMILK.name())) {
                    gadget.warehouse.existence.remove(goods1);
                    if(iceCreamFactory.work(1)) return 1;
                    return -1;
                }
            }
            return 0;
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
            if(a==0) return 0;
            if(iceCreamFactory.work(a)) return 1;
            return -1;
        }
    }


}
