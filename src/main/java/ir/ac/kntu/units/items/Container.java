package ir.ac.kntu.units.items;

import ir.ac.kntu.graghic.Main;
import ir.ac.kntu.units.allies.OsamuKashiwagi;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.awt.font.ImageGraphicAttribute;

public class Container extends Item {

    private static Container singleInstance = null;

    public static Container getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new Container();
        }
        return singleInstance;
    }

    private Container() {
        this.health=3000;
        this.image = new ImagePattern(new Image("file:C:\\Users\\Asus\\Desktop\\projects\\Java\\p4-once-upon-a-time-in-kamurocho-danial-ch\\images\\container.jpg"));
        this.model.setFill(new ImagePattern(new Image("file:C:\\Users\\Asus\\Desktop\\projects\\Java\\p4-once-upon-a-time-in-kamurocho-danial-ch\\images\\container-model.jpg")));
        lvlUp();
    }
}
