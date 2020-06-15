package ir.ac.kntu.units.allies;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class TetsuTachibanaN extends AllySoldier {

    private static TetsuTachibanaN singleInstance = null;

    public static TetsuTachibanaN getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new TetsuTachibanaN();
        }
        return singleInstance;
    }

    private TetsuTachibanaN() {
        this.attackRange = 1;
        this.damage = 4000;
        this.health = 5600;
        this.fieldOfView = 2;
        this.image = new ImagePattern(new Image("file:images/tetsu.jpg"));
        lvlUp();
    }
}
