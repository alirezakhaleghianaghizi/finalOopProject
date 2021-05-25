package model.gadget;

public class Well extends Gadget{
    int   timePeride;

    public Well(double x , double y) {

        super(GadgetEnum.WELL.toString(), x, y, GadgetEnum.WELL.capacity);
        this.timePeride=3;
    }
    public void foodmaking(){

    }

}
