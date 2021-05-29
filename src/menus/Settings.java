package menus;

public class Settings extends Menu{
    public Settings(Menu parentMenu) {
        super("SETTINGS",parentMenu);
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
