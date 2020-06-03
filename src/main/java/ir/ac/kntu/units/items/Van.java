package ir.ac.kntu.units.items;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Van extends Item {

    private static Van singleInstance = null;

    public static Van getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new Van();
        }
        return singleInstance;
    }

    private Van() {
        this.health=6000;
        this.image = new ImagePattern(new Image("file:C:\\Users\\Asus\\Desktop\\projects\\Java\\p4-once-upon-a-time-in-kamurocho-danial-ch\\images\\Van.jpg"));
        this.getModel().setFill(new ImagePattern(new Image("file:C:\\Users\\Asus\\Desktop\\projects\\Java\\p4-once-upon-a-time-in-kamurocho-danial-ch\\images\\van-model.png")));
        lvlUp();
    }
}
