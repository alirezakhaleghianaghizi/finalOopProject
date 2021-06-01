package model.animal.producer;

import model.animal.Animal;
import model.animal.AnimalEnum;

public class Turkey extends producerAnimal implements producerAnimals  {

    public Turkey() {
        super(AnimalEnum.TURKEY.toString(), 3, 3, AnimalEnum.TURKEY.getFootStep(), AnimalEnum.TURKEY.getLivies(), AnimalEnum.TURKEY.getCost());
        this.produceTime = 3;
    }

    @Override
    public boolean produce() {
        return false;
    }

    @Override
    public boolean decreaseLive() {
        return false;
    }
}
