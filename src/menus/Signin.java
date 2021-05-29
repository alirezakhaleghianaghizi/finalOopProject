package menus;

import model.Person;

import java.util.HashMap;

public class Signin extends Menu{
    public Signin(SignLogMenu signLogMenu) {
        super("SIGN IN",signLogMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, new StartMenu(this));
        this.setSubmenus(submenus);
    }

    @Override
    public void show() {
        System.out.println("");
    }

    @Override
    public void execute() {
        if(logInFromFile()){
            this.submenus.get(1).show();
            this.submenus.get(1).execute();
        }
        else {
            this.parentMenu.show();
            this.parentMenu.execute();
        }
    }

    public boolean logInFromFile(){
        String userName;
        String password;
        this.manager.personsController=this.manager.personsController.reloadUsers.readFile(this.manager.personsController);
        if(this.manager.personsController.isAnyOneInTheGame){
            System.out.println("You have Already logged in");
            System.out.println("your userName is \" "+this.manager.personsController.CurrentUser.userName+"\" \n your password is \" "+this.manager.personsController.CurrentUser.password+"\"");
            return true;

        }
        System.out.println("Enter Your User Name To signin");
        userName=scanner.next();
        if(this.manager.personsController.userNamePersonMap.containsKey(userName)){
            System.err.println("this User name + (  "+userName+" ) is token" );
            return false;
        }
        password=scanner.next();
        this.manager.personsController.userNamePersonMap.put(userName,new Person(userName,password,new HashMap<>(),new HashMap<>(),0));
        this.manager.personsController.CurrentUser= this.manager.personsController.userNamePersonMap.get(userName);
        System.out.println("your userName is \" "+userName+"\" \n your password is \" "+password+"\"");
        this.manager.personsController.isAnyOneInTheGame=true;
        this.manager.personsController.reloadUsers.jasonWriter(this.manager.personsController);
        return true;
    }
}
