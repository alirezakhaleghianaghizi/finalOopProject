package model.animal.producer;

import model.animal.Animal;

public  abstract class producerAnimal extends Animal {
    int produceTime;
    boolean isFull;
    public producerAnimal(String name, double x, double y, double footStep, int livies, int cost) {
        super(name, x, y, footStep, livies, cost);
    }
    public void die(){
        this.livies=0;
    }

    public boolean isFull() {
        if(isFull)
        return false;
        return true;
    }
    public void decLives(){

    }
}
