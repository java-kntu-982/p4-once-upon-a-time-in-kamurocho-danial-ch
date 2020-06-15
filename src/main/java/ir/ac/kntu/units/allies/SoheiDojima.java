package ir.ac.kntu.units.allies;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

public class SoheiDojima extends AllySoldier {

    private static SoheiDojima singleInstance = null;

    public static SoheiDojima getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new SoheiDojima();
        }
        return singleInstance;
    }

    private SoheiDojima() {
        this.attackRange = 1;
        this.damage = 3000;
        this.health = 3000;
        this.fieldOfView = 1;
        this.image = new ImagePattern(new Image("file:images/sohei.jpg"));
        lvlUp();
    }
}
