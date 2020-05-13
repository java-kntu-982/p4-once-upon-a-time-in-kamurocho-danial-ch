package ir.ac.kntu.units.items;

public class Truck extends Item {

    private static Truck singleInstance = null;

    public static Truck getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new Truck();
        }
        return singleInstance;
    }

    private Truck() {
        this.durability=5000;
    }
}
