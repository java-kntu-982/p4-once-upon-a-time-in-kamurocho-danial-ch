package ir.ac.kntu.units.items;

public class Van extends Item {

    private static Van singleInstance = null;

    public static Van getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new Van();
        }
        return singleInstance;
    }

    private Van() {
        this.durability=6000;
    }
}
