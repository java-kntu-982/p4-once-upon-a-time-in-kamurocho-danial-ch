package ir.ac.kntu.units.enemis;

import javafx.scene.paint.Color;

public class GraySoldier extends EnemySoldier {

    public GraySoldier() {
        this.health=1000;
        this.damage=800;
        this.attackRange=1;
        this.speed=2;
        this.model.setWidth(15);
        this.model.setHeight(15);
        this.model.setFill(Color.GRAY);
    }
}
