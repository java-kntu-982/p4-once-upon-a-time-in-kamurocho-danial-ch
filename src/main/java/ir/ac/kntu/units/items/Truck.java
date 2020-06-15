package ir.ac.kntu.units.items;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Truck extends Item {

    private static Truck singleInstance = null;

    public static Truck getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new Truck();
        }
        return singleInstance;
    }

    private Truck() {
        this.health=5000;
        this.image = new ImagePattern(new Image("file:images/truck.jpg"));
        this.getModel().setFill(new ImagePattern(new Image("file:images/truck-model.jpg")));
        this.getModel().setHeight(125);
        lvlUp();
    }
}
