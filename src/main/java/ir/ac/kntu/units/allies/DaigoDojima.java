package ir.ac.kntu.units.allies;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

public class DaigoDojima extends AllySoldier {

    private static DaigoDojima singleInstance = null;

    public static DaigoDojima getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new DaigoDojima();
        }
        return singleInstance;
    }

    private DaigoDojima() {
        this.attackRange = 2;
        this.damage = 4000;
        this.health = 4000;
        this.fieldOfView = 1;
        this.image = new ImagePattern(new Image("file:C:\\Users\\Asus\\Desktop\\projects\\Java\\p4-once-upon-a-time-in-kamurocho-danial-ch\\images\\daigo.jpg"));

    }

}
