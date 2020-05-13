package ir.ac.kntu.units.allies;

import ir.ac.kntu.units.Soldier;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class AllySoldier extends Soldier {
    protected int fieldOfView;
    protected ImagePattern image;
    protected Circle model;
    protected boolean alive;

    public AllySoldier() {
        this.speed = 5;
        this.model = new Circle();
        this.model.setRadius(10);
        this.model.setFill(Color.YELLOW);
        this.alive = true;
    }

    public int getFieldOfView() {
        return fieldOfView;
    }

    public void setFieldOfView(int fieldOfView) {
        this.fieldOfView = fieldOfView;
    }

    public ImagePattern getImage() {
        return image;
    }

    public void setImage(ImagePattern image) {
        this.image = image;
    }

    public Circle getModel() {
        return model;
    }

    public void setModel(Circle model) {
        this.model = model;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
