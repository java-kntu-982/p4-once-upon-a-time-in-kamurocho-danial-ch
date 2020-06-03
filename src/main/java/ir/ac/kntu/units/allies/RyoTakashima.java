package ir.ac.kntu.units.allies;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

public class RyoTakashima extends AllySoldier {

    private static RyoTakashima singleInstance = null;

    public static RyoTakashima getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new RyoTakashima();
        }
        return singleInstance;
    }

    private RyoTakashima() {
        this.attackRange = 1;
        this.damage = 3800;
        this.health = 3600;
        this.fieldOfView = 1;
        this.image = new ImagePattern(new Image("file:C:\\Users\\Asus\\Desktop\\projects\\Java\\p4-once-upon-a-time-in-kamurocho-danial-ch\\images\\ryo.jpg"));
        lvlUp();
    }
}
