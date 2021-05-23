package model.animal.producer;
import model.animal.Animal;
import model.goods.Egg;
public class Chicken extends Animal {
    int produceTime;
    public Chicken(String name, double x, double y, double footStep, int livies) {
        super("Chicken", 3, 3, 1, 100, 100);
        this.produceTime = 2;
    }

    public void layEgg(){
        Egg egg = new Egg();

    }
    public void eat(){

    }

}
