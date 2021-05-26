package menus;

import java.util.HashMap;

public class Signin extends Menu{
    public Signin(SignLogMenu signLogMenu) {
        super("SIGN IN",signLogMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, new StartMenu(this));
        this.setSubmenus(submenus);
    }
}
