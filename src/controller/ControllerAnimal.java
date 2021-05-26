package controller;

import model.animal.Animal;
import model.animal.asisstant.Cat;
import model.animal.defender.Dog;
import model.animal.producer.Bufallo;
import model.animal.producer.Chicken;
import model.animal.producer.Turkey;
import model.animal.wild.Bear;
import model.animal.wild.Lion;
import model.animal.wild.Tiger;

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

}/*
public boolean eat (Animal animal,ArrayList grass){
    if(animal.name.equalsIgnoreCase("Dog")||animal.name.equalsIgnoreCase("CAT")
            ||animal.name.equalsIgnoreCase("TIGER")||animal.name.equalsIgnoreCase("LION")||
            animal.name.equalsIgnoreCase("BEAR"))
    return false ;
    else if(){

}
}*/
