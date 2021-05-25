package model.animal.producer;
import model.animal.Animal;
import model.animal.AnimalEnum;

public class Bufallo extends Animal {
    int produceTime;

    public Bufallo() {
        super(AnimalEnum.BUFALLO.toString(), 3, 3, AnimalEnum.BUFALLO.getFootStep(), AnimalEnum.BUFALLO.getLivies(), AnimalEnum.BUFALLO.getCost());
        this.produceTime = 5;
    }
}
