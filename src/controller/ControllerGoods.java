package controller;

import menus.Color;
import model.animal.wild.Tiger;
import model.factory.Factory;
import model.factory.first.EggPowder;
import model.factory.first.MilkSeprator;
import model.factory.first.Spinnery;
import model.factory.seccond.CookieBakery;
import model.factory.seccond.IceCreamFactory;
import model.factory.seccond.Weaving;
import model.gadget.Warehouse;
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
        public  ArrayList<Goods> productGoods ;

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
            this.productGoods = new ArrayList<>();
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
        gadget.well.capacity--;
        return true;
    }

    public boolean pickUp( double x , double y,ControllerGadget gadget){
        for (Goods e : productGoods) {
            if(e.x==x&&e.y==y){
                if(gadget.warehouse.haveSpace(e)){
                    gadget.warehouse.existence.add(e);
                    return true;
                }else {
                    System.err.println("WareHouse does not have enough space ");
                    return false;
                }
            }
        }
        System.err.println("there is no Goods ");
        return false;
    }

    public void showGrass(){
        int [] [] grassNum = new int[6][6];
        for (int i=0;i<6;i++){
            for (int j=0;j<6;j++){
                for (Grass grass : grasses) {
                    if(grass.x==i+1&&grass.y==j+1){
                        grassNum[i][j]++;
                    }
                }
            }
        }
        for (int i=0;i<6;i++){
            for (int j=0;j<6;j++){
                System.out.println(grassNum[i][j]+" ");
            }
            System.out.println();
        }
    }

}
