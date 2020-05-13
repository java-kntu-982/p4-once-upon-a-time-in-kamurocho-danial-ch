package ir.ac.kntu.units.items;

import ir.ac.kntu.units.allies.OsamuKashiwagi;

public class Container extends Item {

    private static Container singleInstance = null;

    public static Container getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new Container();
        }
        return singleInstance;
    }

    private Container() {
        this.durability=3000;
    }
}
