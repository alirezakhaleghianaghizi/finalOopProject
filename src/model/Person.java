package model;

import model.level.Level;

import java.util.HashMap;

public class Person {
    String userName;
    String password;
    HashMap<Integer, Level> completedLevel;
    HashMap<Integer,Integer> personCoinEachLevel;
}
