package controller;

import menus.Color;
import menus.Logger;
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
import java.util.Date;

public class ControllerGoods {

        ArrayList<Cloth> clothes;
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
            this.clothes = new ArrayList<>();
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

    public int plant(double x , double y,ControllerFactory factory,ControllerGadget gadget){
        for (CookieBakery cookieBakeryFactory : factory.cookieBakeryFactories) {
            if(cookieBakeryFactory.x==x&&cookieBakeryFactory.y==y){return 1;}
        }
        for (EggPowder eggPowderFactory : factory.eggPowderFactories) {
            if(eggPowderFactory.x==x&&eggPowderFactory.y==y){return 1;}
        }
        for (IceCreamFactory iceCreamFactory : factory.iceCreamFactories) {
            if(iceCreamFactory.x==x&&iceCreamFactory.y==y){return 1;}
        }
        for (MilkSeprator milkSepratorFactory : factory.milkSepratorFactories) {
            if(milkSepratorFactory.x==x&&milkSepratorFactory.y==y){return 1;}
        }

        for (Spinnery spinneryFactory : factory.spinneryFactories) {
            if(spinneryFactory.x==x&&spinneryFactory.y==y){return 1;}
        }
        for (Weaving weavingFactory : factory.WeavingFactories) {
            if(weavingFactory.x==x&&weavingFactory.y==y){return 1;}
        }
        if(gadget.well.x==x&&gadget.well.y==y){return 0;}
        if(gadget.truck.x==x&&gadget.truck.y==y){return 0;}
        if(gadget.warehouse.x==x&&gadget.warehouse.y==y){return 0;}
        if(gadget.well.capacity<GoodsEnum.GRASS.getCapacity()){return -1;}
        grasses.add(new Grass(x,y));
        gadget.well.capacity--;
        return 2;
    }

    public boolean pickUp(double x , double y, ControllerGadget gadget, Logger logger){
        for (Goods e : productGoods) {
            if(e.x==x&&e.y==y){
                if(gadget.warehouse.haveSpace(e)){
                    gadget.warehouse.existence.add(e);
                    gadget.warehouse.seprateGoods(e);
                    logger.commands.add("INFO,"+logger.lastChange.toString()+",PICKUP "+e.name+" TO WAREHOUSE.");
                    return true;
                }else {
                    logger.commands.add("ERROR,"+logger.lastChange.toString()+",NOT ENOUGH SPACE IN WAREHOUSE TO PICKUP "+e.name+" .");
                    System.err.println("WareHouse does not have enough space ");
                    return false;
                }
            }
        }
        logger.commands.add("ERROR ,"+logger.lastChange.toString()+",NO GOODS TO PICKUP.");
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
                System.out.print(grassNum[i][j]+" ");
            }
            System.out.println();
        }
    }

}
