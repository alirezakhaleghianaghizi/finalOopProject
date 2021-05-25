package model.animal.wild;

import model.animal.Animal;
import model.animal.AnimalEnum;

public class Lion extends WildAnimal implements WildAnimals  {
    int cautch;
    public Lion() {
        super(AnimalEnum.LION.toString(), 3, 3, AnimalEnum.LION.getFootStep(), AnimalEnum.LION.getLivies(), AnimalEnum.LION.getCost());
        this.cautch=3;
    }

    @Override
    public void die() {

    }
}
