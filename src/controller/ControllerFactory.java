package controller;

import model.factory.first.EggPowder;
import model.factory.first.MilkSeprator;
import model.factory.first.Spinnery;
import model.factory.seccond.CookieBakery;
import model.factory.seccond.IceCreamFactory;
import model.factory.seccond.Weaving;

import java.util.ArrayList;

public class ControllerFactory {
    ArrayList<EggPowder> eggPowderFactories;
    ArrayList<MilkSeprator> milkSepratorFactories;
    ArrayList<Spinnery> spinneryFactories;
    ArrayList<CookieBakery> cookieBakeryFactories;
    ArrayList<IceCreamFactory> iceCreamFactories;
    ArrayList<Weaving> WeavingFactories;

    public ControllerFactory() {
        this.eggPowderFactories = new ArrayList<>();
        this.milkSepratorFactories = new ArrayList<>();
        this.spinneryFactories = new ArrayList<>();
        this.cookieBakeryFactories = new ArrayList<>();
        this.iceCreamFactories = new ArrayList<>();
        WeavingFactories = new ArrayList<>();
    }
}
