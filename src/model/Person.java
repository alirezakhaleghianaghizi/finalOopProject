package model;

import model.level.Level;

import java.util.HashMap;

public class Person {
    String userName;
    String password;
    int level ;
    HashMap<Integer, Level> completedLevel;
    public HashMap<Integer,Integer> personCoinEachLevel;
    public int coins ;
    public int totalCoins ;

    public Person(String userName, String password, HashMap<Integer, Level> completedLevel, HashMap<Integer, Integer> personCoinEachLevel, int coins, int totalCoins,int level) {
        this.userName = userName;
        this.password = password;
        this.completedLevel = completedLevel;
        this.personCoinEachLevel = personCoinEachLevel;
        this.coins = coins;
        this.level=level;
        this.totalCoins=this.coins+this.personCoinEachLevel.get(level);
    }
}
