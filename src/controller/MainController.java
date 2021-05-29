package controller;

import java.util.ArrayList;

public class MainController {
    ControllerGoods goods;
    ControllerFactory factories;
    ControllerAnimal animals;
    public AllLevels allLevels;
    ControllerGadget gadgets;
   public PersonsController personsController;

    public MainController() {
        this.goods = new ControllerGoods();
        this.factories = new ControllerFactory();
        this.animals = new ControllerAnimal();
        this.allLevels = new AllLevels();
        this.gadgets = new ControllerGadget();
        this.personsController = new PersonsController();
    }
}
