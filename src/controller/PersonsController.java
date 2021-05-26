package controller;

import model.Person;

import java.util.ArrayList;

public class PersonsController {
    public ArrayList<Person> users;
    public Person CurrentUser;
    public boolean isAnyOneInTheGame;

    public PersonsController() {
        this.users = new ArrayList<>();
        CurrentUser = null;
        this.isAnyOneInTheGame = false;
    }
}
