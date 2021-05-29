package menus;

public class LogOut extends Menu{
    public LogOut(Menu parentMenu) {
        super("LOG OUT",parentMenu);

    }
    @Override
    public void show() {
        System.out.println("I'm sub-menu 1-1");
    }

    @Override
    public void execute() {
        System.out.println("execute in sub-menu 1-1");
        this.parentMenu.show();
        this.parentMenu.execute();
    }

}
