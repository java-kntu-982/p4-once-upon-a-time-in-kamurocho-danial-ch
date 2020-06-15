package ir.ac.kntu.units.allies;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

public class FutoshiShimano extends AllySoldier {

    private static FutoshiShimano singleInstance = null;

    public static FutoshiShimano getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new FutoshiShimano();
        }
        return singleInstance;
    }

    private FutoshiShimano() {
        this.attackRange = 1;
        this.damage = 4000;
        this.health = 4200;
        this.fieldOfView = 2;
        this.image = new ImagePattern(new Image("file:images/futoshi.jpg"));
        lvlUp();
    }
}
