package ir.ac.kntu.units.items;

import ir.ac.kntu.units.Unit;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public abstract class Item extends Unit {
    protected ImagePattern image;
    protected Rectangle model;

    public Item() {
        model = new Rectangle();
        model.setHeight(45);
        model.setWidth(25);
        model.setFill(Color.GREEN);
    }

    public void lvlUp(){
        this.setHealth((int)(this.getHealth()*Math.pow(1.05,this.getLevel()-1)));
    }

    public Rectangle getModel() {
        return model;
    }

    public void setModel(Rectangle model) {
        this.model = model;
    }

    public ImagePattern getImage() {
        return image;
    }

    public void setImage(ImagePattern image) {
        this.image = image;
    }
}
