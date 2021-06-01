package controller;

import menus.Logger;
import model.animal.AnimalEnum;
import model.animal.defender.Dog;
import model.animal.producer.Chicken;
import model.goods.Egg;
import model.goods.Goods;
import model.goods.GoodsEnum;
import model.level.Level;
import view.Timing;

import java.util.ArrayList;

public class MainController {

    public ControllerGoods goods;
    public ControllerFactory factories;
    public ControllerAnimal animals;
    public AllLevels allLevels;
    public ControllerGadget gadgets;
    public PersonsController personsController;
    Timing timing;
    public Logger logger ;

    public MainController() {
        this.goods = new ControllerGoods();
        this.factories = new ControllerFactory();
        this.animals = new ControllerAnimal();
        this.allLevels = new AllLevels();
        this.gadgets = new ControllerGadget();
        this.personsController = new PersonsController();
        timing = new Timing();
        this.logger=new Logger();
    }


    public void turn(int n) {
        for (int i = 1; i <= n; i++) {
            timing.goForward();
            
        }
        wellFulling();
        producing();
        showAfterTurn();
    }

    public void showAfterTurn() {
        System.out.println("The time passed :" + timing.getCurrentTime());
        goods.showGrass();
        animals.showAnimal();
        showTask(personsController.getCurrentUser().currentLevel);
    }

    public void showTask(Level level){
        for (GoodsEnum value : GoodsEnum.values()) {
            String good = value.toString();
            if(good.equalsIgnoreCase(level.task1)){
                System.out.println("1 : "+level.task1+" : "+returnArrByGoodName(good).size()+"/"+level.task1Number);
            }
        }
        for (AnimalEnum value : AnimalEnum.values()) {
            String animal = value.toString();
            if(animal.equalsIgnoreCase(level.task1)){
                System.out.println("1 : "+level.task1+" : "+returnArrByAnimalName(animal).size()+"/"+level.task1Number);
            }
        }
        if(level.task1.equalsIgnoreCase("coin")){
            System.out.println("coins : "+personsController.getCurrentUser().totalCoins+"/"+level.task1Number);
        }

        for (GoodsEnum value : GoodsEnum.values()) {
            String good = value.toString();
            if(good.equalsIgnoreCase(level.task2)){
                System.out.println("2 : "+level.task2+" : "+returnArrByGoodName(good).size()+"/"+level.task2Number);
            }
        }
        for (AnimalEnum value : AnimalEnum.values()) {
            String animal = value.toString();
            if(animal.equalsIgnoreCase(level.task2)){
                System.out.println("2 : "+level.task2+" : "+returnArrByAnimalName(animal).size()+"/"+level.task2Number);
            }
        }
        if(level.task2.equalsIgnoreCase("coin")){
            System.out.println("coins : "+personsController.getCurrentUser().totalCoins+"/"+level.task2Number);
        }

        for (GoodsEnum value : GoodsEnum.values()) {
            String good = value.toString();
            if(good.equalsIgnoreCase(level.task3)){
                System.out.println("3 : "+level.task3+" : "+returnArrByGoodName(good).size()+"/"+level.task3Number);
            }
        }
        for (AnimalEnum value : AnimalEnum.values()) {
            String animal = value.toString();
            if(animal.equalsIgnoreCase(level.task3)){
                System.out.println("3 : "+level.task3+" : "+returnArrByAnimalName(animal).size()+"/"+level.task3Number);
            }
        }
        if(level.task3.equalsIgnoreCase("coin")){
            System.out.println("coins : "+personsController.getCurrentUser().totalCoins+"/"+level.task3Number);
        }
    }

    //Search methods :
    public ArrayList returnArrByGoodName(String GoodName){
        switch (GoodName){
            case "EGG":return gadgets.warehouse.eggInWareHouse;
            case "COOKIE":return gadgets.warehouse.cookieInWareHouse;
            case "SILK":return gadgets.warehouse.silkInWareHouse;
            case "MILK":return gadgets.warehouse.milkInWareHouse;
            case "SEPRATEDMILK":return gadgets.warehouse.sepratedMilkInWareHouse;
            case"FEATHER":return gadgets.warehouse.featherInWareHouse;
            case "CLOTH" :return gadgets.warehouse.clothInWareHouse;
            case "FLOUR" :return gadgets.warehouse.flourInWareHouse;
            case "ICECREAM" :return gadgets.warehouse.iceCreamInWareHouse;
            case "BEARDOLL" :return gadgets.warehouse.bearDollInWareHouse;
            case "LIONDOLL" :return gadgets.warehouse.lionDollInWareHouse;
            case "TIGERDOLL" :return gadgets.warehouse.tigerDollInWareHouse;
        }
        return null;
    }

    public ArrayList returnArrByAnimalName(String animalName){
        switch (animalName){
            case "BUFALLO" :return animals.bufallos;
            case "CHICKEN" :return animals.chickens;
            case "TURKEY" :return animals.turkeys;
            case "BEAR" :return animals.bears;
            case "LION" :return animals.lions;
            case "TIGER" :return animals.tigers;
            case "CAT" :return animals.cats;
            case "DOG" :return animals.dogs;
        }
        return null;
    }

    public Goods returnGoodByName(String name){
        for (Goods productGood : goods.productGoods) {
            if(productGood.name.equalsIgnoreCase(name)){
                return productGood;
            }
        }
        return null;
    }

    public Goods returnProductByLocation(double x , double y){
        for (Goods productGood : goods.productGoods) {
            if(productGood.x==x&&productGood.y==y){
                return productGood;
            }
        }
        return null;
    }

    //check time passing after turn :
    public boolean wellFulling(){
        if(gadgets.well.fulling==null)return false;
        if(gadgets.well.fulling.getDate()+gadgets.well.timePeride<=Timing.getCurrentTime()){
            gadgets.well.capacity=5;
            return true;
        }
            return false;
    }

    public boolean movingAnimal(){
        for (Chicken chicken : animals.chickens) {
            chicken.moving(chicken);
            return true;
        }
        return false;
    }

    public boolean producing(){
        for (Chicken chicken : animals.chickens) {
            chicken.produce();
            //TODO >= to be fixed
            if(chicken.produce.getDate()+chicken.produceTime>=Timing.getCurrentTime()){
                if(chicken.produce()){
                    goods.productGoods.add(new Egg(chicken.x, chicken.y));
                }
                return true;
            }
        }
        return false;
    }

}
