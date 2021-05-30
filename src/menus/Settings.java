package menus;

public class Settings extends Menu{
    public Settings(Menu parentMenu) {
        super("SETTINGS",parentMenu);
    }
    @Override
    public void show() {
        System.err.println("SETTING MENU IS AVAILABLE IN NEXT VERSION");
    }

    @Override
    public void execute() {
        this.parentMenu.show();
        this.parentMenu.execute();
    }
}
