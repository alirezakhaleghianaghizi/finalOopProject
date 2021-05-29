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
       this.logInFromFile();
    }

    @Override
    public void execute() {
        super.execute();
    }
    public boolean logInFromFile(){
        String userName;
        String password;
        System.out.println("Enter Your User Name");
        userName=scanner.next();
        this.manager.personsController=this.manager.personsController.reloadUsers.readFile(this.manager.personsController);
        if(this.manager.personsController.userNamePersonMap.containsKey(userName)){
            password=scanner.next();
            while(this.manager.personsController.userNamePersonMap.get(userName).())
        }
         System.err.println("the User Name ( "+userName+" ) dose not exist ." );
        return false;
    }
}
