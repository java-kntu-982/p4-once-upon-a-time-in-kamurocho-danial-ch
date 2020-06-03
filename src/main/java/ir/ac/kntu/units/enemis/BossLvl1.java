package ir.ac.kntu.units.enemis;

import javafx.scene.paint.Color;

public class BossLvl1 extends EnemySoldier {

    public BossLvl1() {
        this.health=8000;
        this.damage=5000;
        this.attackRange=1;
        this.speed=2;
        this.model.setWidth(25);
        this.model.setHeight(25);
        this.model.setFill(Color.PERU);
    }
}
