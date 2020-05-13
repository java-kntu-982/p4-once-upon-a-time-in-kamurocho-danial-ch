package ir.ac.kntu.units.enemis;

import ir.ac.kntu.units.Soldier;
import javafx.scene.shape.Rectangle;

public class EnemySoldier extends Soldier {

    protected Rectangle model;

    public EnemySoldier() {
        this.model = new Rectangle();
    }

    public Rectangle getModel() {
        return model;
    }

    public void setModel(Rectangle model) {
        this.model = model;
    }
}
