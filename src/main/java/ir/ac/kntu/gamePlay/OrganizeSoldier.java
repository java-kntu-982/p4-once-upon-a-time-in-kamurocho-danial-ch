package ir.ac.kntu.gamePlay;

import ir.ac.kntu.graghic.Design;
import ir.ac.kntu.graghic.Main;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;

import java.util.LinkedList;

public class OrganizeSoldier {

    public static Button backButton = new Button("Back");
    public static Rectangle heroPoolRectangle = new Rectangle();
    public static Rectangle heroStackRectangle = new Rectangle();
    public static LinkedList<Rectangle> heroPoolRec = new LinkedList<>();
    public static LinkedList<Rectangle> stackHeroes = new LinkedList<>();

    public static void organize() {

        stackHeroes.clear();

        for (int i = 0; i < Initializer.heroes.size(); i++) {
            Rectangle rectangle = new Rectangle();
            rectangle.setFill(Initializer.heroes.get(i).getImage());
            heroPoolRec.add(rectangle);
        }

        for(int i=0;i<8;i++){
            if(Player.getSingleInstance().getPlayerStack()[i] != null){
                Rectangle rectangle = new Rectangle();
                rectangle.setFill(Player.getSingleInstance().getPlayerStack()[i].getImage());
                stackHeroes.add(rectangle);
            }
        }

    }

    public static void showOrganization(){
        Design.rectangleDesign();
        Main.root.getChildren().add(backButton);
        Main.root.getChildren().add(heroPoolRectangle);
        Main.root.getChildren().add(heroStackRectangle);


        for (int i = 0; i < Initializer.heroes.size(); i++) {
            Main.root.getChildren().add(heroPoolRec.get(i));
        }

        for (Rectangle stackHero : stackHeroes) {
            Main.root.getChildren().add(stackHero);
        }
    }

}
