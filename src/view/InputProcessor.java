package view;

import controller.MainController;
import menus.Color;

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
            else System.err.println("invalid input");
            System.out.print(Color.BLUE_BOLD);
            System.out.println("Enter your command ");
            System.out.print(Color.RESET);
        }
    }



    public boolean processBuy(String animalName){
       if( mainController.animals.buyAnimal(animalName,mainController.personsController.getCurrentUser())) {
           System.out.println(animalName+" Have bought");
           return true;
       }else {
           System.err.println("not have enough coins");
       }
        return false;
    }

    public boolean pickUp(double x,double y){
        if(x>6|x<0|y<0|y>6){
            System.out.println("the spot you choose is not in the surface");
            return false;
        }else {
            mainController.goods.pickUp(x,y, mainController.gadgets);
            System.out.println("to the WareHouse ...");
            return true;
        }
    }

    public boolean plant(double x,double y){
        if(x>6|x<0|y<0|y>6){
            System.out.println("the spot you choose is not in the surface");
            return false;
        }
        if(mainController.goods.plant(x,y, mainController.factories, mainController.gadgets)){
            System.out.println("plant x : "+x+"\n y : "+y);
            return true;
        }else {
            System.err.println("the loc is on somethig ");
            return false;
        }
    }

    public boolean well(){
        if(mainController.gadgets.Well(mainController.gadgets.well)){
            System.out.println("well working");
            return true;
        }else {
            System.err.println("The well is full ");
            return false;
        }
    }

    public boolean work(String workShopName){
        switch (workShopName){
            case "EggPowder":
               if(mainController.factories.workEggPowder(mainController.factories.eggPowderFactories.get(0), mainController.gadgets)) {
                   System.out.println(workShopName + " working ...");
                   return true;
               }
                break;
            case "CookieFactory":
                if(mainController.factories.workCookieBakery(mainController.factories.cookieBakeryFactories.get(0), mainController.gadgets)){
                    System.out.println(workShopName+" working ...");
                    return true;
                }
                break;
            case "MilkSeprator":
                if(mainController.factories.workMilkSeprator(mainController.factories.milkSepratorFactories.get(0), mainController.gadgets)){
                    System.out.println(workShopName+" working ...");
                    return true;
                }
                break;
            case "IceCreamFactory":
               if(mainController.factories.workIceCreamFactory(mainController.factories.iceCreamFactories.get(0), mainController.gadgets)){
                   System.out.println(workShopName+" working ...");
                   return true;
               }
                break;
            case "Spinnery":
                if(mainController.factories.workSpinnery(mainController.factories.spinneryFactories.get(0), mainController.gadgets)){
                    System.out.println(workShopName+" working ...");
                    return true;
                }
                break;
            case "Weaving":
                if(mainController.factories.workWeaving(mainController.factories.WeavingFactories.get(0), mainController.gadgets)){
                    System.out.println(workShopName+" working ...");
                    return true;
                }
                break;
        }
        return false;
    }

    //TODO for tomorrow

    public boolean cage(double x,double y){
        System.out.println("cage x : "+x+"\n y : "+y);
        if(x>6|x<0|y<0|y>6){
            System.out.println("the spot you choose is not in the surface");
            return false;
        }
        if(mainController.animals.cage(x,y, mainController.goods)){
            return true;
        }
        System.err.println("there is no wild animal there");
        return false ;
    }

    public boolean truckLoad(String itemName){
        System.out.println("truck load"+itemName);
       mainController.gadgets.truckLoad(mainController.returnGoodByName(itemName));
        return true;
    }

    public boolean truckUnload(String itemName) {
        if (mainController.gadgets.truckUnload(mainController.returnGoodByName(itemName))) {
            System.out.println("truck un load" + itemName);
            return true;
        } else {
            System.err.println("truck have gone ");
            return false;
        }
    }

    public boolean truckGo(){

        if(mainController.gadgets.truckGo()){
            System.out.println("truck go");
            return true;
        }
        System.err.println("truck is one the way");
        return true;
    }

    public boolean inquiry(){
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
