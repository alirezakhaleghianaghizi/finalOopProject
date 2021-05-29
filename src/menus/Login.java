package menus;

import java.util.HashMap;

public class Login extends Menu {
    public Login(SignLogMenu signLogMenu) {
        super("LOGIN",signLogMenu);
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
        System.out.println("Enter Your User Name To login");
        userName=scanner.next();
        if(this.manager.personsController.userNamePersonMap.containsKey(userName)){
            password=scanner.next();
            while(!this.manager.personsController.userNamePersonMap.get(userName).password.equalsIgnoreCase(password)&&password.equalsIgnoreCase("main")){
                password=scanner.next();
            }
            if(password.equalsIgnoreCase("main")){
                return false;
            }
            this.manager.personsController.CurrentUser=this.manager.personsController.userNamePersonMap.get(userName);
            this.manager.personsController.isAnyOneInTheGame=true;
            System.out.println("your userName is \" "+userName+"\" \n your password is \" "+password+"\"");
            this.manager.personsController.reloadUsers.jasonWriter(this.manager.personsController);
            return true;

        }
         System.err.println("the User Name ( "+userName+" ) dose not exist ." );
        return false;
    }
}
