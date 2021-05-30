package menus;

import view.InputProcessor;

public class Start extends Menu{
    InputProcessor inputProcessor;
    public Start(Menu parentMenu) {
        super("START",parentMenu);
        this.inputProcessor=new InputProcessor(this.manager);
    }
    @Override
    public void show() {
        System.out.println("");
        System.out.print(Color.CYAN_BOLD_BRIGHT);
        System.out.println("Enter The Level You Want To Play");
        int level;
        while ((level=Integer.parseInt(scanner.nextLine()))>=this.manager.personsController.getCurrentUser().level+2){
            System.err.println("PLEAS ENTER THE LEVEL WITCH IS OPENED FOR YOU");
        }
        System.out.print(Color.RESET);
        System.out.println("");
        this.inputProcessor.run(scanner);
    }

    @Override
    public void execute() {
        this.parentMenu.show();
        this.parentMenu.execute();
    }
}
