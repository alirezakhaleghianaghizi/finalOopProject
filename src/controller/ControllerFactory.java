package controller;

import model.factory.first.EggPowder;
import model.factory.first.MilkSeprator;
import model.factory.first.Spinnery;
import model.factory.seccond.CookieBakery;
import model.factory.seccond.IceCream;
import model.factory.seccond.Weaving;

import java.util.ArrayList;

public class ControllerFactory {
    ArrayList<EggPowder> eggPowderFactories;
    ArrayList<MilkSeprator> milkSepratorFactories;
    ArrayList<Spinnery> spinneryFactories;
    ArrayList<CookieBakery> cookieBakeryFactories;
    ArrayList<IceCream> iceCreamFactories;
    ArrayList<Weaving> WeavingFactories;

    public ControllerFactory(ArrayList<EggPowder> eggPowderFactories, ArrayList<MilkSeprator> milkSepratorFactories, ArrayList<Spinnery> spinneryFactories, ArrayList<CookieBakery> cookieBakeryFactories, ArrayList<IceCream> iceCreamFactories, ArrayList<Weaving> weavingFactories) {
        this.eggPowderFactories = eggPowderFactories;
        this.milkSepratorFactories = milkSepratorFactories;
        this.spinneryFactories = spinneryFactories;
        this.cookieBakeryFactories = cookieBakeryFactories;
        this.iceCreamFactories = iceCreamFactories;
        WeavingFactories = weavingFactories;
    }
}
