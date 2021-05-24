package model.factory;

import model.Model;
import view.Timing;

public abstract class Factory extends Model {
    public int timeOfProducingGood;
    public int moneyCreatingCreating;
    public Timing dateOf
    public Factory(String name, double x, double y,int timeOfProducingGood,int moneyCreatingCreating) {
        super(name, x, y);
        this.moneyCreatingCreating=moneyCreatingCreating;
        this.timeOfProducingGood=timeOfProducingGood;

    }
}
