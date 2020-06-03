package ir.ac.kntu.units;

import javafx.scene.shape.Rectangle;

public abstract class Unit {

    protected int level;
    protected int health;

    public Unit() {
        this.level=1;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
