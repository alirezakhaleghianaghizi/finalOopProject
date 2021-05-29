package controller;

import model.animal.wild.Tiger;
import model.factory.Factory;
import model.factory.first.EggPowder;
import model.factory.first.MilkSeprator;
import model.factory.first.Spinnery;
import model.factory.seccond.CookieBakery;
import model.factory.seccond.IceCreamFactory;
import model.factory.seccond.Weaving;
import model.goods.*;

import java.util.ArrayList;

public class ControllerGoods {

        ArrayList<Cloth> Clothes;
        ArrayList<Cookie> cookies;
        ArrayList<Egg> eggs;
        ArrayList<Feather> feathers;
        ArrayList<Flour> flours;
        ArrayList<Grass> grasses;
        ArrayList<IceCream> iceCreams;
        ArrayList<Milk> milks;
        ArrayList<SepratedMilk> sepratedMilks;
        ArrayList<Silk> silks;
        ArrayList<Water> Waters;
        ArrayList<LionDoll> lionDolls ;
        ArrayList<TigerDoll> tigerDolls;
        ArrayList<BearDoll> bearDolls;

        public ControllerGoods() {
            this.Clothes = new ArrayList<>();
            this.cookies = new ArrayList<>();
            this.eggs = new ArrayList<>();
            this.feathers = new ArrayList<>();
            this.flours = new ArrayList<>();
            this.grasses = new ArrayList<>();
            this.iceCreams = new ArrayList<>();
            this.milks = new ArrayList<>();
            this.sepratedMilks = new ArrayList<>();
            this.silks = new ArrayList<>();
            this.Waters = new ArrayList<>();
            this.lionDolls = new ArrayList<>();
            this.tigerDolls= new ArrayList<>();
            this.bearDolls= new ArrayList<>();
        }
    public boolean plant(double x , double y,ControllerFactory factory,ControllerGadget gadget){
        for (CookieBakery cookieBakeryFactory : factory.cookieBakeryFactories) {
            if(cookieBakeryFactory.x==x&&cookieBakeryFactory.y==y){return false;}
        }
        for (EggPowder eggPowderFactory : factory.eggPowderFactories) {
            if(eggPowderFactory.x==x&&eggPowderFactory.y==y){return false;}
        }
        for (IceCreamFactory iceCreamFactory : factory.iceCreamFactories) {
            if(iceCreamFactory.x==x&&iceCreamFactory.y==y){return false;}
        }
        for (MilkSeprator milkSepratorFactory : factory.milkSepratorFactories) {
            if(milkSepratorFactory.x==x&&milkSepratorFactory.y==y){return false;}
        }

        for (Spinnery spinneryFactory : factory.spinneryFactories) {
            if(spinneryFactory.x==x&&spinneryFactory.y==y){return false;}
        }
        for (Weaving weavingFactory : factory.WeavingFactories) {
            if(weavingFactory.x==x&&weavingFactory.y==y){return false;}
        }
        if(gadget.well.x==x&&gadget.well.y==y){return false;}
        if(gadget.truck.x==x&&gadget.truck.y==y){return false;}
        if(gadget.warehouse.x==x&&gadget.warehouse.y==y){return false;}
        if(gadget.well.capacity<GoodsEnum.GRASS.getCapacity()){return false;}
        grasses.add(new Grass(x,y));
        return true;
    }





}
