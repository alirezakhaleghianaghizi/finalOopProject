package model.animal.wild;

import model.animal.Animal;
import model.animal.AnimalEnum;

public class Bear extends Animal {
    int cautch;
    public Bear() {
        super(AnimalEnum.BEAR.toString(), 3, 3, AnimalEnum.BEAR.getFootStep(), AnimalEnum.BEAR.getLivies(), AnimalEnum.BEAR.getCost());
        this.cautch=4;
    }
}
