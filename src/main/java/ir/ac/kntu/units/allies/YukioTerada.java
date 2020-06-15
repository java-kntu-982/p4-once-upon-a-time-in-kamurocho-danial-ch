package ir.ac.kntu.units.allies;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class YukioTerada extends AllySoldier {

    private static YukioTerada singleInstance = null;

    public static YukioTerada getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new YukioTerada();
        }
        return singleInstance;
    }

    private YukioTerada() {
        this.attackRange = 1;
        this.damage = 3000;
        this.health = 4000;
        this.fieldOfView = 1;
        this.image = new ImagePattern(new Image("file:images/yukio.jpg"));
        lvlUp();
    }
}
