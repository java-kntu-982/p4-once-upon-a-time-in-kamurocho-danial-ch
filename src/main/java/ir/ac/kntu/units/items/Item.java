package ir.ac.kntu.units.items;

import ir.ac.kntu.units.Unit;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Item extends Unit {

    protected int durability;
    protected Rectangle model;

    public Item() {
        model = new Rectangle();
        model.setHeight(45);
        model.setWidth(25);
        model.setFill(Color.GREEN);
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public Rectangle getModel() {
        return model;
    }

    public void setModel(Rectangle model) {
        this.model = model;
    }
}
