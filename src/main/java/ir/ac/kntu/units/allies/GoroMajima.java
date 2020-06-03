package ir.ac.kntu.units.allies;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

public class GoroMajima extends AllySoldier {

    private static GoroMajima singleInstance = null;

    public static GoroMajima getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new GoroMajima();
        }
        return singleInstance;
    }


    private GoroMajima() {
        this.attackRange = 4;
        this.damage = 4500;
        this.health = 4000;
        this.fieldOfView = 3;
        this.image = new ImagePattern(new Image("file:C:\\Users\\Asus\\Desktop\\projects\\Java\\p4-once-upon-a-time-in-kamurocho-danial-ch\\images\\goro.jpg"));
        lvlUp();
    }

}
