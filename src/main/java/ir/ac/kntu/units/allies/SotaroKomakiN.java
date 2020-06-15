package ir.ac.kntu.units.allies;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class SotaroKomakiN extends AllySoldier {

    private static SotaroKomakiN singleInstance = null;

    public static SotaroKomakiN getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new SotaroKomakiN();
        }
        return singleInstance;
    }

    private SotaroKomakiN() {
        this.attackRange = 1;
        this.damage = 4500;
        this.health = 4500;
        this.fieldOfView = 2;
        this.image = new ImagePattern(new Image("file:images/sotaro.jpg"));
        lvlUp();
    }
}
