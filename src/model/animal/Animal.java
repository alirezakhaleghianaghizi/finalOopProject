package model.animal;
import model.Model;
import model.animal.asisstant.Cat;
import model.animal.defender.Dog;
import model.animal.producer.Bufallo;
import model.animal.producer.Chicken;
import model.animal.producer.Turkey;
import model.animal.wild.Bear;
import model.animal.wild.Lion;
import model.animal.wild.Tiger;
import view.Timing;

import java.util.ArrayList;
import java.util.Random;
public class Animal extends Model {
    Timing startMoving ;
    public double footStep;
    public int livies ;
    public int cost;
    public int timeMovingPeriode;


    public Animal(String name, double x, double y, double footStep, int livies,int cost) {
        super(name, x, y);
        this.footStep = footStep;
        this.livies = livies;
        this.cost=cost;
    }

    public void randomMoving (){
        startMoving = new Timing();
        Random random = new Random();
        int randSituation = random.nextInt(4);
        switch (randSituation){
            case 0:
                if(this.x+footStep>=0&&this.x+footStep<=6) {
                    //this.timeMovingPeriode=footStep/animal.footStep;
                    this.x += footStep;
                }
                break;
            case 1:
                if(this.x-footStep>=0&&this.x-footStep<=6)
                    this.x-=footStep;
                break;
            case 2:
                if(this.y+footStep>=0&&this.y+footStep<=6)
                    this.y+=footStep;
                break;
            case 3:
                if(this.y-footStep>=0&&this.y-footStep<=6)
                    this.y-=footStep;
                break;
        }
    }


}
