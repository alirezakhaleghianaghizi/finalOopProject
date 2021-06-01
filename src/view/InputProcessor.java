package view;

import controller.MainController;
import menus.Color;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;

public class InputProcessor {
    MainController mainController;
    String input;

    public InputProcessor( MainController mainController) {
        this.mainController = mainController;
        this.input = "";
    }

    public void run(Scanner scanner){
        Matcher matcher;
        System.out.print(Color.BLUE_BOLD);
        System.out.println("Enter your command ");
        System.out.print(Color.RESET);
        while(!(this.input=scanner.nextLine()).equalsIgnoreCase("exit")){
            this.mainController.logger.lastChange=new Date();
            if((matcher=InputAlgorithms.BUY.inputMatcher(input)).find()) this.processBuy(matcher.group(1));
            else if((matcher=InputAlgorithms.PICKUP.inputMatcher(input)).find()) this.pickUp(Double.parseDouble(matcher.group(1)),Double.parseDouble(matcher.group(2)));
            else if(InputAlgorithms.WELL.inputMatcher(input).find()) this.well();
            else if((matcher=InputAlgorithms.PLANT.inputMatcher(input)).find()) this.plant(Double.parseDouble(matcher.group(1)),Double.parseDouble(matcher.group(2)));
            else if((matcher=InputAlgorithms.WORK.inputMatcher(input)).find()) this.work(matcher.group(1));
            else if((matcher=InputAlgorithms.CAGE.inputMatcher(input)).find()) this.cage(Double.parseDouble(matcher.group(1)),Double.parseDouble(matcher.group(2)));
            else if((matcher=InputAlgorithms.TURN.inputMatcher(input)).find()) this.turn(Integer.parseInt(matcher.group(1)));
            else if((matcher=InputAlgorithms.TRUCKLOAD.inputMatcher(input)).find()) this.truckLoad(matcher.group(1));
            else if((matcher=InputAlgorithms.TRUCKUNLOAD.inputMatcher(input)).find())this.truckUnload(matcher.group(1));
            else if(InputAlgorithms.TRUCKGO.inputMatcher(input).find())this.truckGo();
            else if((matcher=InputAlgorithms.INQUIRY.inputMatcher(input)).find())this.inquiry();
            else {
                System.err.println("invalid input");
                this.mainController.logger.commands.add("ERROR,"+this.mainController.logger.lastChange.toString()+",INVALID INPUT COMMAND.");
            }
            System.out.print(Color.BLUE_BOLD);
            System.out.println("Enter your command ");
            System.out.print(Color.RESET);
            this.mainController.logger.jasonWriter(mainController.logger);
        }

        this.mainController.logger.lastChange=new Date();
        this.mainController.logger.commands.add("ERROR,"+this.mainController.logger.lastChange.toString()+",EXIT THE GAME.");
        this.mainController.logger.jasonWriter(mainController.logger);
    }



    public boolean processBuy(String animalName){
        int situation=mainController.animals.buyAnimal(animalName,mainController.personsController.getCurrentUser());
        if( situation==1) {
           System.out.println(animalName+" Have bought");
           this.mainController.logger.commands.add("INFO,"+this.mainController.logger.lastChange.toString()+",BUY "+animalName+" .");
           return true;
       }else if(situation==0) {
           this.mainController.logger.commands.add("ERROR,"+this.mainController.logger.lastChange.toString()+",not have enough coins TO BUY"+animalName+".");
           System.err.println("not have enough coins");
           return false;
       }
       else if(situation==-1){
           this.mainController.logger.commands.add("ERROR,"+this.mainController.logger.lastChange.toString()+",not include animal name : "+animalName+" ");
           System.err.println("there is no animal with "+animalName+" name ");
           return false;
       }
        return false;
    }

    public boolean pickUp(double x,double y){
        if(x>6|x<0|y<0|y>6){
            this.mainController.logger.commands.add("ERROR,"+this.mainController.logger.lastChange.toString()+",OUT OF SURFACE SPOT IN PICKUP+.");
            System.err.println("the spot you choose is not in the surface");
            return false;
        }else {
            if( mainController.goods.pickUp(x,y, mainController.gadgets,this.mainController.logger))
            System.out.println("to the WareHouse ...");
            return true;
        }
    }

    public boolean plant(double x,double y){
        if(x>6|x<0|y<0|y>6){
            this.mainController.logger.commands.add("ERROR,"+this.mainController.logger.lastChange.toString()+",OUT OF SURFACE SPOT IN PLANT+.");
            System.err.println("the spot you choose is not in the surface");
            return false;
        }
        int situation=mainController.goods.plant(x,y, mainController.factories, mainController.gadgets);
        if(situation==2){
            this.mainController.logger.commands.add("INFO,"+this.mainController.logger.lastChange.toString()+",plant in x : "+x+" ,y : "+y+".");
            System.out.println("Plant [x:"+x+",y:"+y+"]");
            return true;
        }else if(situation==1) {
            this.mainController.logger.commands.add("ERROR,"+this.mainController.logger.lastChange.toString()+",planting one factory.");
            System.err.println("cant plant one factory ");
            return false;
        }
        else if(situation==0){
            this.mainController.logger.commands.add("ERROR,"+this.mainController.logger.lastChange.toString()+",planting one gadget.");
            System.err.println("cant plant one gadget ");
            return false;
        }
        else if(situation==-1){
            this.mainController.logger.commands.add("ERROR,"+this.mainController.logger.lastChange.toString()+",well is empty for planting.");
            System.err.println("well is empty ");
            return false;
        }
        return true;
    }

    public boolean well(){
        if(mainController.gadgets.well()){
            this.mainController.logger.commands.add("INFO,"+this.mainController.logger.lastChange.toString()+",well working.");
            System.out.println("well working");
            return true;
        }else {
            this.mainController.logger.commands.add("ERROR,"+this.mainController.logger.lastChange.toString()+",well is full.");
            System.err.println("The well is full ");
            return false;
        }
    }

    public boolean work(String workShopName){
        switch (workShopName){
            case "EggPowder":
               if(mainController.factories.workEggPowder(mainController.factories.eggPowderFactories.get(0), mainController.gadgets)) {
                   System.out.println(workShopName + " working ...");
                   this.mainController.logger.commands.add("INFO,"+this.mainController.logger.lastChange.toString()+","+workShopName+" started working");
                   return true;
               }
            case "CookieFactory":
                if(mainController.factories.workCookieBakery(mainController.factories.cookieBakeryFactories.get(0), mainController.gadgets)){
                    System.out.println(workShopName+" working ...");
                    this.mainController.logger.commands.add("INFO,"+this.mainController.logger.lastChange.toString()+","+workShopName+" started working");
                    return true;
                }
            case "MilkSeprator":
                if(mainController.factories.workMilkSeprator(mainController.factories.milkSepratorFactories.get(0), mainController.gadgets)){
                    System.out.println(workShopName+" working ...");
                    this.mainController.logger.commands.add("INFO,"+this.mainController.logger.lastChange.toString()+","+workShopName+" started working");
                    return true;
                }
            case "IceCreamFactory":
               if(mainController.factories.workIceCreamFactory(mainController.factories.iceCreamFactories.get(0), mainController.gadgets)){
                   System.out.println(workShopName+" working ...");
                   this.mainController.logger.commands.add("INFO,"+this.mainController.logger.lastChange.toString()+","+workShopName+" started working");
                   return true;
               }
            case "Spinnery":
                if(mainController.factories.workSpinnery(mainController.factories.spinneryFactories.get(0), mainController.gadgets)){
                    System.out.println(workShopName+" working ...");
                    this.mainController.logger.commands.add("INFO,"+this.mainController.logger.lastChange.toString()+","+workShopName+" started working");
                    return true;
                }
            case "Weaving":
                if(mainController.factories.workWeaving(mainController.factories.WeavingFactories.get(0), mainController.gadgets)){
                    System.out.println(workShopName+" working ...");
                    this.mainController.logger.commands.add("INFO,"+this.mainController.logger.lastChange.toString()+","+workShopName+" started working");
                    return true;
                }
        }
        this.mainController.logger.commands.add("ERROR,"+this.mainController.logger.lastChange.toString()+",THERE IS NO WORKSHOP WITH NAME "+workShopName);
        System.err.println("THERE IS NO WORKSHOP WITH NAME "+workShopName);
        return false;
    }

    //TODO for tomorrow

    public boolean cage(double x,double y){
        System.out.println("cage x : "+x+"\n y : "+y);
        if(x>6|x<0|y<0|y>6){
            this.mainController.logger.commands.add("ERROR ,"+this.mainController.logger.lastChange.toString()+", out surface spot to cage ");
            System.err.println("the spot you choose is not in the surface");
            return false;
        }
        int situation=mainController.animals.cage(x,y, mainController.goods, mainController.logger);
        if(situation==1){
            System.out.println("wild animal caged and send to warehouse");
            return true;
        }
        else if(situation==0){
            System.out.println("wild animal caged ");
            return true;
        }
        System.err.println("there is no wild animal there");
        return false ;
    }

    public boolean truckLoad(String itemName){
        if(mainController.returnGoodByName(itemName)==null){
            System.err.println("there is no item name"+itemName);
            this.mainController.logger.commands.add("ERROR ,"+this.mainController.logger.lastChange.toString()+",null item name"+itemName);
            return false;
        }
       int situation=mainController.gadgets.truckLoad(mainController.returnGoodByName(itemName));
        if(situation==-1){
            System.err.println("truck has no enough space");
            this.mainController.logger.commands.add("ERROR ,"+this.mainController.logger.lastChange.toString()+",not enough space in truck to load"+itemName);
            return false;
        }
        else if(situation==0){
            System.err.println("truck has go");
            this.mainController.logger.commands.add("ERROR ,"+this.mainController.logger.lastChange.toString()+", truck has gone ");
            return false;
        }
        else if(situation==1){
            System.out.println(itemName+" loaded to truck");
            this.mainController.logger.commands.add("INFO ,"+this.mainController.logger.lastChange.toString()+",truck load "+itemName);
            return true;
        }
        return true;
    }

    public boolean truckUnload(String itemName) {
        if(mainController.returnGoodByName(itemName)==null){
            System.err.println("there is no item name"+itemName);
            this.mainController.logger.commands.add("ERROR ,"+this.mainController.logger.lastChange.toString()+",null item name"+itemName);
            return false;
        }
        int situation=mainController.gadgets.truckUnload(mainController.returnGoodByName(itemName));
        if (situation==1) {
            System.out.println("truck un load" + itemName);
            this.mainController.logger.commands.add("INFO ,"+this.mainController.logger.lastChange.toString()+",truck un load" + itemName);
            return true;
        }
        else if(situation==0){
            System.err.println("truck dose not have "+itemName);
            this.mainController.logger.commands.add("ERROR ,"+this.mainController.logger.lastChange.toString()+",truck DOSE NOT HAVE " + itemName);
            return false;
        }
        else if(situation==-1) {
            System.err.println("truck have gone ");
            this.mainController.logger.commands.add("ERROR,"+this.mainController.logger.lastChange.toString()+",truck have gone" );
            return false;
        }
        return true;
    }

    public boolean truckGo(){

        if(mainController.gadgets.truckGo()){
            System.out.println("truck go");
            this.mainController.logger.commands.add("INFO,"+this.mainController.logger.lastChange.toString()+",truck STARTED THE TRAVEL" );
            return true;
        }
        System.err.println("truck is one the way");
        this.mainController.logger.commands.add("ERROR,"+this.mainController.logger.lastChange.toString()+",CANT SEND THE GONE TRUCK" );
        return true;
    }

    public boolean inquiry(){
        this.mainController.logger.commands.add("INFO ,"+this.mainController.logger.lastChange.toString()+", inquiry command");
        mainController.showAfterTurn();
        return true;
    }

    public boolean turn(int n){
        mainController.turn(n);
        System.out.println("time of turning : "+n);
        //turn time in manager
        return true;
    }

}
