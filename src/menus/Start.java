package menus;

import view.InputProcessor;

import java.util.Date;

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
        int level=-1;
        this.logger.userName=this.manager.personsController.CurrentUser.userName;
        boolean isInputCorrect=false;
        this.manager.allLevels=this.manager.allLevels.FILE.reloadLevels(this.manager.allLevels);
        while(!isInputCorrect){
            try{
                while ((level=Integer.parseInt(scanner.nextLine()))>=this.manager.personsController.getCurrentUser().level+2||level>manager.allLevels.numberOfLevels){
                if(manager.allLevels.numberOfLevels<level) {
                    System.err.println("PLEASE ENTER AN AVAILABLE LEVEL IN THE GAME. ");
                    logger.lastChange=new Date();
                    this.logger.commands.add("ERROR,"+logger.lastChange.toString()+",NOT AVAILABLE LEVEL. ");
                }
                if(this.manager.personsController.getCurrentUser().level+2<=level) {
                    System.err.println("PLEAS ENTER THE LEVEL WITCH IS OPENED FOR YOU");
                    logger.lastChange=new Date();
                    this.logger.commands.add("ERROR,"+logger.lastChange.toString()+",LEVEL NOT OPENED. ");
                }
                }
                isInputCorrect=true;
            }
            catch (NumberFormatException e){
                    logger.lastChange=new Date();
                    this.logger.commands.add("ERROR,"+logger.lastChange.toString()+",NOT CORRECT format INPUT . ");
                System.err.println("numberFormatException");
            }

            }
        logger.lastChange=new Date();
        this.logger.commands.add("INFO,"+logger.lastChange.toString()+",STARTED THE GAME. ");
        this.logger.jasonWriter(this.logger);
        System.out.print(Color.RESET);
        System.out.println("");
        this.manager.personsController.getCurrentUser().currentLevel=this.manager.allLevels.levels.get(level-1);
        System.out.println(this.manager.allLevels.numberOfLevels);
        this.manager.personsController.getCurrentUser().totalCoins=this.manager.personsController.CurrentUser.coins+this.manager.personsController.getCurrentUser().currentLevel.startCoins;
        this.manager.logger=this.logger;
        this.inputProcessor.run(scanner);
    }

    @Override
    public void execute() {
        this.parentMenu.show();
        this.parentMenu.execute();
    }
}
