package controller;

import model.factory.first.EggPowder;
import model.factory.first.MilkSeprator;
import model.factory.first.Spinnery;
import model.factory.seccond.CookieBakery;
import model.factory.seccond.Weaving;
import model.goods.*;

import java.util.ArrayList;

public class ControllerGoods {

        ArrayList<Cloth> Clothes;
        ArrayList<Cookie> cookies;
        ArrayList<Egg> eggs;
        ArrayList<Feather> feathers;
        ArrayList<Flour> flours;
        ArrayList<Grass> grasses;
        ArrayList<IceCream> iceCreams;
        ArrayList<Milk> milks;
        ArrayList<SepratedMilk> sepratedMilks;
        ArrayList<Silk> silks;
        ArrayList<Water> Waters;

        public ControllerGoods() {
            this.Clothes = new ArrayList<>();
            this.cookies = new ArrayList<>();
            this.eggs = new ArrayList<>();
            this.feathers = new ArrayList<>();
            this.flours = new ArrayList<>();
            this.grasses = new ArrayList<>();
            this.iceCreams = new ArrayList<>();
            this.milks = new ArrayList<>();
            this.sepratedMilks = new ArrayList<>();
            this.silks = new ArrayList<>();
            this.Waters = new ArrayList<>();
        }

}
