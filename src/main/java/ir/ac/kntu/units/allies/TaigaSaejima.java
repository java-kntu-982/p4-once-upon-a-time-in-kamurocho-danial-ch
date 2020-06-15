package ir.ac.kntu.units.allies;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

import java.awt.*;

public class TaigaSaejima extends AllySoldier {

    private static TaigaSaejima singleInstance = null;

    public static TaigaSaejima getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new TaigaSaejima();
        }
        return singleInstance;
    }

    private TaigaSaejima() {
        this.attackRange = 1;
        this.damage = 5000;
        this.health = 7000;
        this.fieldOfView = 1;
        this.image = new ImagePattern(new Image("file:images/taiga.jpg"));
        lvlUp();
    }
}
