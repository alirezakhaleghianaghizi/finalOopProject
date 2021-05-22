package model.animal.producer;
import model.animal.Animal;
import model.goods.Egg;
public class Chicken extends Animal {

    public Chicken(String name, double x, double y, double footStep, int livies) {
        super(name, x, y, footStep, livies);
    }

    public void layEgg(){
        Egg egg = new Egg();

    }
    public void eat(){

    }

}
