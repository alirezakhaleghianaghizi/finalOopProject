package model.animal.producer;
import model.animal.Animal;
import model.animal.AnimalEnum;
import model.goods.Egg;
public class Chicken extends Animal {
    int produceTime;
    public Chicken(String name, double x, double y, double footStep, int livies) {
        super(AnimalEnum.CHICKEN.toString(), 3, 3, AnimalEnum.CHICKEN.getFootStep(), AnimalEnum.CHICKEN.getLivies(), AnimalEnum.CHICKEN.getCost());
        this.produceTime = 2;
    }

    public void layEgg(){
        Egg egg = new Egg(this.x,this.y);

    }
    public void eat(){

    }

}
