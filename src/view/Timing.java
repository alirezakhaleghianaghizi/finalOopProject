package view;

public class Timing {
    public static int currentTime;
    private int date;
    public Timing(int date) {
        this.date =Timing.currentTime;
    }
    public static void goForward(){
        Timing.currentTime++;
    }

}
