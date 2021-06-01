package model.animal.producer;

import model.animal.Animal;
import view.Timing;

public  abstract class producerAnimal extends Animal {
    public Timing produce;
    public int produceTime;
    boolean isFull;
    public producerAnimal(String name, double x, double y, double footStep, int livies, int cost) {
        super(name, x, y, footStep, livies, cost);
    }
    public void die(){
        this.livies=0;
    }

    public boolean haveEaten() {
        if(this.livies>=80){
            isFull = true;
            return true;
        }else {
            isFull=false;
            return false;
        }
    }
}
