package ir.ac.kntu.units.enemis;

import javafx.scene.paint.Color;

public class YellowSoldier extends EnemySoldier {

    public YellowSoldier() {
        this.health=800;
        this.damage=1800;
        this.attackRange=2;
        this.speed=1;
        this.model.setWidth(8);
        this.model.setHeight(8);
        this.model.setFill(Color.YELLOW);
    }
}
