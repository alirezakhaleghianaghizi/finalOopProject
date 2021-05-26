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
        userName=scanner.next();
        password=scanner.next();
return false;
    }
}
