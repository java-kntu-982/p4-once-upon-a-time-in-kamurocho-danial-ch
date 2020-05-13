package ir.ac.kntu.units.enemis;

import javafx.scene.paint.Color;

public class BossLvl2 extends EnemySoldier {

    public BossLvl2() {
        this.health=20000;
        this.damage=12000;
        this.attackRange=1;
        this.speed=2;
        this.model.setWidth(25);
        this.model.setHeight(25);
        this.model.setFill(Color.BLACK);
    }
}
