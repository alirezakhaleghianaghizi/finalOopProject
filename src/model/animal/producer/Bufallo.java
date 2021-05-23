package model.animal.producer;
import model.animal.Animal;
public class Bufallo extends Animal {
    int produceTime;

    public Bufallo() {
        super("Bufallo", 3, 3, 1, 100, 400);
        this.produceTime = 5;
    }
}
