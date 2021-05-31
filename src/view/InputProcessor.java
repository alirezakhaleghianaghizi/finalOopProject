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
            if((matcher=InputAlgorithms.BUY.inputMatcher(input)).find()) this.buy(matcher.group(1));
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

    //TODO

    public boolean buy(String animalName){
        System.out.println("buy "+animalName);
        //buy in manager
        return true;
    }

    public boolean pickUp(double x,double y){
        System.out.println("pick up x : "+x+"\n y : "+y);
        if(x>6|x<0|y<0|y>6){
            System.out.println("the spot you choose is not in the surface");
            return false;
        }
        // pick in manager
        return true;
    }

    public boolean plant(double x,double y){
        System.out.println("plant x : "+x+"\n y : "+y);
        if(x>6|x<0|y<0|y>6){
            System.out.println("the spot you choose is not in the surface");
            return false;
        }
        // plant in manager
        return true;
    }

    public boolean well(){
        System.out.println("well working");
        // well in manager
        return true;
    }

    public boolean work(String workShopName){
        System.out.println("workshop working"+workShopName);
        //work in manager
        return true;
    }

    public boolean cage(double x,double y){
        System.out.println("cage x : "+x+"\n y : "+y);
        if(x>6|x<0|y<0|y>6){
            System.out.println("the spot you choose is not in the surface");
            return false;
        }
        // cage in manager
        return true;
    }

    public boolean truckLoad(String itemName){
        System.out.println("truck load"+itemName);
        //truck load in manager
        return true;
    }

    public boolean truckUnload(String itemName){
        System.out.println("truck un load"+itemName);
        //truck un load in manager
        return true;
    }

    public boolean truckGo(){
        System.out.println("truck go");
        //truck go in manager
        return true;
    }

    public boolean inquiry(){
        System.out.println("inquiry");
        //inquiry in manager
        return true;
    }

    public boolean turn(int n){
        System.out.println("time of turning : "+n);
        //turn time in manager
        return true;
    }

}
