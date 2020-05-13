package ir.ac.kntu.units.allies;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

public class MakotoDate extends AllySoldier {

    private static MakotoDate singleInstance = null;

    public static MakotoDate getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new MakotoDate();
        }
        return singleInstance;
    }

    private MakotoDate() {
        this.attackRange = 3;
        this.damage = 1800;
        this.health = 4500;
        this.fieldOfView = 2;
        this.image = new ImagePattern(new Image("file:C:\\Users\\Asus\\Desktop\\projects\\Java\\p4-once-upon-a-time-in-kamurocho-danial-ch\\images\\makoto.jpg"));

    }
}
