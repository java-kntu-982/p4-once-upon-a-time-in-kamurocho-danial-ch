package ir.ac.kntu.units.enemis;

import javafx.scene.paint.Color;

public class RedSoldier extends EnemySoldier {

    public RedSoldier() {
        this.health=1000;
        this.damage=500;
        this.attackRange=1;
        this.speed=3;
        this.model.setWidth(10);
        this.model.setHeight(10);
        this.model.setFill(Color.RED);
    }
}
