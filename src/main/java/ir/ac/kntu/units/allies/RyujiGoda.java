package ir.ac.kntu.units.allies;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

public class RyujiGoda extends AllySoldier {

    private static RyujiGoda singleInstance = null;

    public static RyujiGoda getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new RyujiGoda();
        }
        return singleInstance;
    }

    private RyujiGoda() {
        this.attackRange = 2;
        this.damage = 5000;
        this.health = 5000;
        this.fieldOfView = 1;
        this.image = new ImagePattern(new Image("file:C:\\Users\\Asus\\Desktop\\projects\\Java\\p4-once-upon-a-time-in-kamurocho-danial-ch\\images\\ryuji.jpg"));

    }
}
