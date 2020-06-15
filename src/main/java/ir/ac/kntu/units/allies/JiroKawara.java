package ir.ac.kntu.units.allies;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

public class JiroKawara extends AllySoldier {

    private static JiroKawara singleInstance = null;

    public static JiroKawara getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new JiroKawara();
        }
        return singleInstance;
    }


    private JiroKawara() {
        this.attackRange = 3;
        this.damage = 3200;
        this.health = 5500;
        this.fieldOfView = 3;
        this.image = new ImagePattern(new Image("file:images/jiro.jpg"));
        lvlUp();
    }
}
