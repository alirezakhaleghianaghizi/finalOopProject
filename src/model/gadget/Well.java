package model.gadget;

public class Well extends Gadget{
    int   timePeride;
    public int capacity;

    public Well(double x , double y) {

        super(GadgetEnum.WELL.toString(), x, y, GadgetEnum.WELL.capacity);
        this.timePeride=3;
        this.capacity=GadgetEnum.WELL.capacity;
    }


}
