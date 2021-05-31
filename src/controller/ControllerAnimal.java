package controller;

import model.Person;
import model.animal.Animal;
import model.animal.AnimalEnum;
import model.animal.asisstant.Cat;
import model.animal.defender.Dog;
import model.animal.producer.Bufallo;
import model.animal.producer.Chicken;
import model.animal.producer.Turkey;
import model.animal.wild.Bear;
import model.animal.wild.Lion;
import model.animal.wild.Tiger;
import model.goods.BearDoll;
import model.goods.LionDoll;
import model.goods.TigerDoll;

import java.util.ArrayList;

public class ControllerAnimal {
    ArrayList<Tiger> tigers = new ArrayList<>();
    ArrayList<Bear> bears = new ArrayList<>();
    ArrayList<Lion> lions = new ArrayList<>();
    ArrayList<Dog> dogs = new ArrayList<>();
    ArrayList<Cat> cats = new ArrayList<>();
    ArrayList<Chicken> chickens = new ArrayList<>();
    ArrayList<Bufallo> bufallos= new ArrayList<>();
    ArrayList<Turkey> turkeys  = new ArrayList<>();

/*
public boolean eat (Animal animal,ArrayList grass){
    if(animal.name.equalsIgnoreCase("Dog")||animal.name.equalsIgnoreCase("CAT")
            ||animal.name.equalsIgnoreCase("TIGER")||animal.name.equalsIgnoreCase("LION")||
            animal.name.equalsIgnoreCase("BEAR"))
    return false ;
    else if(){

}*/
    public boolean buyAnimal(String name, Person person){
        switch (name){
            case "chicken" :
                if(person.totalCoins>= AnimalEnum.CHICKEN.getCost()){
                    person.totalCoins-=AnimalEnum.CHICKEN.getCost();
                    return true;
                }
                return false;
            case "bufallo":
                if(person.totalCoins>= AnimalEnum.BUFALLO.getCost()){
                    person.totalCoins-=AnimalEnum.BUFALLO.getCost();
                    return true;
                }
                return false;
            case "turkey":
                if(person.totalCoins>= AnimalEnum.TURKEY.getCost()){
                    person.totalCoins-=AnimalEnum.TURKEY.getCost();
                    return true;
                }
                return false;
        }
        return false;
    }

    public boolean cage(double x, double y,ControllerGoods goods){

        for (Tiger tiger : tigers) {
            if(tiger.x==x&&tiger.y==y){
             tiger.cage+=1;
             if(tiger.cage==4){
                 goods.tigerDolls.add(new TigerDoll(x,y));
                 tigers.remove(tiger);
             }
                return true;
            }
        }
        for (Lion lion : lions) {
            if(lion.x==x&&lion.y==y){
                lion.cage+=1;
                if(lion.cage==3){
                    goods.lionDolls.add(new LionDoll(x,y));
                    tigers.remove(lion);
                }
                return true;
            }
        }
        for (Bear bear : bears) {
            if(bear.x==x&&bear.y==y){
                bear.cage+=1;
                if(bear.cage==3){
                    goods.bearDolls.add(new BearDoll(x,y));
                    tigers.remove(bear);
                }
                return true;
            }
        }
        return false;
    }

    public void showAnimal() {
        // name life cage loc
        if (turkeys.size() > 0) {
            for (Turkey turkey : turkeys) {
                System.out.println(turkey.name + " " + turkey.livies + " [" + turkey.x + "," + turkey.y + "]");
            }
        }
        if (chickens.size() > 0) {
            for (Chicken chicken : chickens) {
                System.out.println(chicken.name + " " + chicken.livies + " [" + chicken.x + "," + chicken.y + "]");
            }
        }
        if (bufallos.size() > 0) {
            for (Bufallo bufallo : bufallos) {
                System.out.println(bufallo.name + " " + bufallo.livies + " [" + bufallo.x + "," + bufallo.y + "]");
            }
        }
        if(tigers.size()>0){
            for (Tiger tiger : tigers) {
                System.out.println(tiger.name + " "+"cage needed :"+tiger.cage + " [" + tiger.x + "," + tiger.y + "]");
            }
        }
        if(lions.size()>0){
            for (Lion lion : lions) {
                System.out.println(lion.name + " "+"cage needed :"+lion.cage + " [" + lion.x + "," + lion.y + "]");
            }
        }
        if(bears.size()>0){
            for (Bear bear : bears) {
                System.out.println(bear.name + " "+"cage needed :"+bear.cage + " [" + bear.x + "," + bear.y + "]");
            }
        }
        if(dogs.size()>0){
            for (Dog dog : dogs) {
                System.out.println(dog.name + " [" + dog.x + "," + dog.y + "]");
            }
        }
        if(cats.size()>0){
            for (Cat cat : cats) {
                System.out.println(cat.name + " [" + cat.x + "," + cat.y + "]");
            }
        }


    }
}

