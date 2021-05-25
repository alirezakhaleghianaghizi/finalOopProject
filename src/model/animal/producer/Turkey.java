package model.animal.producer;

import model.animal.Animal;
import model.animal.AnimalEnum;

public class Turkey extends Animal {
    int produceTime;
    public Turkey() {
        super(AnimalEnum.TURKEY.toString(), 3, 3, AnimalEnum.TURKEY.getFootStep(), AnimalEnum.TURKEY.getLivies(), AnimalEnum.TURKEY.getCost());
        this.produceTime = 3;
    }

}
