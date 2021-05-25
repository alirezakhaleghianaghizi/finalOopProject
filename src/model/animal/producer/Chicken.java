package model.animal.producer;
import model.animal.Animal;
import model.animal.AnimalEnum;
import model.goods.Egg;
public class Chicken extends producerAnimal implements producerAnimals  {

    public Chicken() {
        super(AnimalEnum.CHICKEN.toString(), 3, 3, AnimalEnum.CHICKEN.getFootStep(), AnimalEnum.CHICKEN.getLivies(), AnimalEnum.CHICKEN.getCost());
        this.produceTime = 2;
        this.isFull=false;
    }


}
