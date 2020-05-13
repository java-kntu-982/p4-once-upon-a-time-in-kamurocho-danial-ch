package ir.ac.kntu.units.allies;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

public class OsamuKashiwagi extends AllySoldier {

    private static OsamuKashiwagi singleInstance = null;

    public static OsamuKashiwagi getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new OsamuKashiwagi();
        }
        return singleInstance;
    }

    private OsamuKashiwagi() {
        this.attackRange = 1;
        this.damage = 3000;
        this.health = 4000;
        this.fieldOfView = 2;
        this.image = new ImagePattern(new Image("file:C:\\Users\\Asus\\Desktop\\projects\\Java\\p4-once-upon-a-time-in-kamurocho-danial-ch\\images\\osamu.jpg"));

    }
}
