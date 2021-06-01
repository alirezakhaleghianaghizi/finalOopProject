package model.animal.producer;
import model.animal.Animal;
import model.animal.AnimalEnum;
import model.goods.Egg;
import view.Timing;

public class Chicken extends producerAnimal implements producerAnimals  {



    public Chicken() {
        super(AnimalEnum.CHICKEN.toString(), 3, 3, AnimalEnum.CHICKEN.getFootStep(), AnimalEnum.CHICKEN.getLivies(), AnimalEnum.CHICKEN.getCost());
        this.produceTime = 2;
        this.isFull=true;
    }

    @Override
    public boolean produce() {
        this.haveEaten();
        if(this.isFull){
           produce = new Timing();
            return true;
        }
        return false;
    }

    @Override
    public boolean decreaseLive() {
        return false;
    }
}
