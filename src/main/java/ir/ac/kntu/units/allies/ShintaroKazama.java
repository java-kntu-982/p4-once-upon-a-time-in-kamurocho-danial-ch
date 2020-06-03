package ir.ac.kntu.units.allies;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

public class ShintaroKazama extends AllySoldier {

    private static ShintaroKazama singleInstance = null;

    public static ShintaroKazama getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new ShintaroKazama();
        }
        return singleInstance;
    }

    private ShintaroKazama() {
        this.attackRange = 1;
        this.damage = 4500;
        this.health = 4500;
        this.fieldOfView = 2;
        this.image = new ImagePattern(new Image("file:C:\\Users\\Asus\\Desktop\\projects\\Java\\p4-once-upon-a-time-in-kamurocho-danial-ch\\images\\shintaro.jpg"));
        lvlUp();
    }
}
