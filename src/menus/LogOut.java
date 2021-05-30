package menus;

import model.Person;

import java.util.HashMap;

public class LogOut extends Menu{
    public LogOut(Menu parentMenu) {
        super("LOG OUT",parentMenu);

    }
    @Override
    public void show() {
        System.out.println("LOG OUT");
    }

    @Override
    public void execute() {
        this.manager.personsController=this.manager.personsController.reloadUsers.readFile(this.manager.personsController);
        System.err.println("ARE YOU SURE YOU WANT TO LOG OUT THE ACCOUNT . (Y/N)");
        String answer=scanner.nextLine();
        if(answer.equalsIgnoreCase("Y")){
            this.manager.personsController.isAnyOneInTheGame=false;
            HashMap<String,Person> personHashMap=this.manager.personsController.getUserNamePersonMap();
            this.manager.personsController.setCurrentUser(null);
            this.manager.personsController.setUserNamePersonMap(personHashMap);
            HashMap<Integer, Menu> submenus = new HashMap<>();
            submenus.put(1, new SignLogMenu());
            this.setSubmenus(submenus);
            this.manager.personsController.reloadUsers.jasonWriter(this.manager.personsController);
            this.submenus.get(1).show();
            this.submenus.get(1).execute();
        }
        else{
            this.parentMenu.show();
            this.parentMenu.execute();
        }
    }

}
