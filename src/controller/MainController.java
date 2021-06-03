package controller;

import menus.Logger;
import model.animal.Animal;
import model.animal.AnimalEnum;
import model.animal.asisstant.Cat;
import model.animal.defender.Dog;
import model.animal.producer.Bufallo;
import model.animal.producer.Chicken;
import model.animal.producer.Turkey;
import model.animal.producer.producerAnimal;
import model.goods.*;
import model.level.Level;
import view.Timing;

import java.util.ArrayList;
import java.util.Locale;

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
            movingAllAnimal();
            eatAllanimal();
            timing.goForward();
            wellFulling();
            producing();
            decreaseLive();
        }
        showAfterTurn();
    }

    public void showAfterTurn() {
        this.showGood();
        System.out.println("The time passed :" + timing.getCurrentTime());
        goods.showGrass();
        animals.showAnimal();
        showTask(personsController.getCurrentUser().currentLevel);
    }

    public void showSingleTask(String task,int taskNum,int taskNumber){
        for (GoodsEnum value : GoodsEnum.values()) {
            String good = value.toString();
            if(good.equalsIgnoreCase(task)){
                System.out.println(taskNum+" : "+task+" : "+returnArrByGoodName(good).size()+"/"+taskNumber);
            }
        }
        for (AnimalEnum value : AnimalEnum.values()) {
            String animal = value.toString();
            if(animal.equalsIgnoreCase(task)){
                System.out.println(taskNum+" : "+task+" : "+returnArrByAnimalName(animal).size()+"/"+taskNumber);
            }
        }
        if(task.equalsIgnoreCase("coin")){
            System.out.println(taskNum+" : coins : "+personsController.getCurrentUser().totalCoins+"/"+taskNumber);
        }
    }

    public void showTask(Level level){
        this.showSingleTask(level.task1,1, level.task1Number);
        this.showSingleTask(level.task2,2, level.task2Number);
        this.showSingleTask(level.task3,3, level.task3Number);

    }

    public void showGood(){
        if(this.goods.productGoods!=null)
        for (Goods productGood : this.goods.productGoods) {
            System.out.println(productGood.name+"\t x :"+productGood.x+"\t y: "+ productGood.y);
        }
    }

    //Search methods :
    public ArrayList returnArrByGoodName(String GoodName){
        switch (GoodName.toUpperCase(Locale.ROOT)){
            case "EGG" : return gadgets.warehouse.eggInWareHouse;
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

    public Goods returnGoodInWarehouseByName(String name){
        for (Goods goods1 : gadgets.warehouse.existence) {
            if(goods1.name.equalsIgnoreCase(name)){
                return goods1;
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

    public Goods returnInTruckGoodsByName(String name){
        for (Goods truckgood : gadgets.truckgoods) {
            if(truckgood.name.equalsIgnoreCase(name))
                return truckgood;
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

    public void producing(){
        for (Chicken chicken : animals.chickens) {
            if(chicken.produce!=null){
                if(chicken.produce.getDate()+chicken.produceTime<=Timing.getCurrentTime()){
                    goods.productGoods.add(new Egg(chicken.x, chicken.y));
                    chicken.isFull=false;
                    chicken.produce=null;
                }
            }
        }
        for (Turkey turkey : animals.turkeys) {
            if (turkey.produce!=null) {
                if (turkey.produce.getDate() + turkey.produceTime <= Timing.getCurrentTime()) {
                    goods.productGoods.add(new Feather(turkey.x, turkey.y));
                    turkey.isFull=false;
                    turkey.produce=null;
                }
            }
        }
        for (Bufallo bufallo : animals.bufallos) {
            if (bufallo.produce != null) {
                if (bufallo.produce.getDate() + bufallo.produceTime <= Timing.getCurrentTime()) {
                    goods.productGoods.add(new Milk(bufallo.x, bufallo.y));
                    bufallo.isFull=false;
                    bufallo.produce = null;
                }
            }
        }
    }

        //Moving methods :
    public boolean movingProducerAnimal(producerAnimal animal) {
        double path;
        double xDest = animal.x, yDest = animal.y;
        double minPath = 36;
        for (Grass grass : goods.grasses) {
            path = Math.abs(animal.x - grass.x) + Math.abs(animal.y - grass.y);
            if (path < minPath) {
                minPath = path;
                xDest = grass.x;
                yDest = grass.y;
            }
        }
        return goToDest(xDest,yDest,animal);
    }

    public boolean goToDest(double xDest , double yDest , Animal animal){
        if (animal.x == xDest && animal.y == yDest) {
            return false;
        } else if (animal.x == xDest) {
            if (animal.y > yDest) {
                animal.y--;
            } else {
                animal.y++;
                return true;
            }
        } else if (animal.y == yDest) {
            if (animal.x > xDest) {
                animal.x--;
            } else {
                animal.x++;
                return true;
            }
        } else {
            if (Math.abs(animal.x - xDest) > Math.abs(animal.y - yDest)) {
                if (animal.x > xDest) {
                    animal.x--;
                } else {
                    animal.x++;
                    return true;
                }
            } else {
                if (animal.y > yDest) {
                    animal.y--;
                    return true;
                } else {
                    animal.y++;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean movingCatAnimal(Animal animal){
        double path;
        double xDest = 0, yDest = 0;
        double minPath = 20;
        for (Goods productGood : goods.productGoods) {
            path = Math.abs(animal.x - productGood.x) + Math.abs(animal.y - productGood.y);
            if (path < minPath) {
                minPath = path;
                xDest = productGood.x;
                yDest = productGood.y;
            }
        }
        return goToDest(xDest,yDest,animal);
    }

    public void movingAllAnimal(){
        for (Chicken chicken : animals.chickens) {
            movingProducerAnimal(chicken);
        }
        for (Turkey turkey : animals.turkeys) {
            movingProducerAnimal(turkey);
        }
        for (Bufallo bufallo : animals.bufallos) {
            movingProducerAnimal(bufallo);
        }
        for (Cat cat : animals.cats) {
            movingCatAnimal(cat);
        }

        //TODO Dogs , Wilds
    }
        //Eating methods :
    public boolean eat(producerAnimal animal){
        for (Grass grass : goods.grasses) {
            if(grass.x==animal.x&&grass.y==animal.y&&!animal.isFull&&animal.produce==null){
                goods.grasses.remove(grass);
                animal.livies=110;
                animal.isFull=true;
                animal.produce=new Timing();
                return true;
            }
        }
        return false;
    }

    public void eatAllanimal(){
        for (Chicken chicken : animals.chickens) {
            eat(chicken);
            if(chicken.isFull){
                if(chicken.produce==null) chicken.produce = new Timing();
            }
        }
        for (Bufallo bufallo : animals.bufallos) {
            eat(bufallo);
            if(bufallo.isFull){
                if(bufallo.produce==null) bufallo.produce = new Timing();
            }
        }
        for (Turkey turkey : animals.turkeys) {
            eat(turkey);
            if(turkey.isFull){
                if(turkey.produce==null) turkey.produce = new Timing();
            }
        }
    }

    
    public void decreaseLive(){
        boolean bool;
        ArrayList<Bufallo> index1  = new ArrayList<>();
        for (Bufallo bufallo : animals.bufallos) {
                   bufallo.livies-=10;
                   bufallo.isFull=false;
                   if(bufallo.isDie()) index1.add(bufallo);
        }
        for (Bufallo bufallo : index1) {
            bool=false;
            for (Bufallo bufallo1 : animals.bufallos) {
                if(bufallo.equals(bufallo1)) bool=true;
            }
            if(bool)
            animals.bufallos.remove(bufallo);
        }
        index1.clear();
        ArrayList<Chicken> index  = new ArrayList<>();
        for (Chicken chicken : animals.chickens) {
                    chicken.livies-=10;
                    chicken.isFull=false;
                    if(chicken.isDie())
                        index.add(chicken);
        }
        for (Chicken chicken : index) {
            bool =false;
            for (Chicken chicken1 : animals.chickens) {
                if(chicken.equals(chicken1)) bool = true;
            }
            if(bool)
            animals.chickens.remove(chicken);
        }
        index.clear();
        ArrayList<Turkey> index2 = new ArrayList<>();
        for (Turkey turkey : animals.turkeys) {
                    turkey.livies-=10;
                    turkey.isFull=false;
                    if(turkey.isDie()) index2.add(turkey);
        }
        for (Turkey turkey : index2) {
            bool=false;
            for (Turkey turkey1 : animals.turkeys) {
                if(turkey.equals(turkey1)) bool = true;
            }
            if(bool) animals.turkeys.remove(turkey);
        }
        index2.clear();
    }
}
