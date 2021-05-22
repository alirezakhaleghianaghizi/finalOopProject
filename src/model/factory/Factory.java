package model.factory;

import model.Model;

public abstract class Factory extends Model {
    public int timeOfProducingGood;
    public int moneyCreatingCreating;

    public Factory(String name, double x, double y,int timeOfProducingGood,int moneyCreatingCreating) {
        super(name, x, y);
        this.moneyCreatingCreating=moneyCreatingCreating;
        this.timeOfProducingGood=timeOfProducingGood;

    }
}
