package controller;

import fileOperator.FileUsersNamePassword;
import model.Person;

import java.util.ArrayList;
import java.util.HashMap;
public class PersonsController {
    public Person CurrentUser;
    public boolean isAnyOneInTheGame;
    public HashMap<String,Person> userNamePersonMap;
    public FileUsersNamePassword reloadUsers;
    public PersonsController() {
        this.userNamePersonMap=new HashMap<>();
        CurrentUser = null;
        this.isAnyOneInTheGame = false;
    }
}
