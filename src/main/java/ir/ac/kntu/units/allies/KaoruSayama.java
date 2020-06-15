package ir.ac.kntu.units.allies;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

public class KaoruSayama extends AllySoldier {

    private static KaoruSayama singleInstance = null;

    public static KaoruSayama getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new KaoruSayama();
        }
        return singleInstance;
    }

    private KaoruSayama() {
        this.attackRange = 4;
        this.damage = 4500;
        this.health = 4500;
        this.fieldOfView = 2;
        this.image = new ImagePattern(new Image("file:images/kaoru.jpg"));
        lvlUp();
    }
}
