package ir.ac.kntu.gamePlay;

import ir.ac.kntu.graghic.Design;
import ir.ac.kntu.graghic.EventHandling;
import ir.ac.kntu.graghic.Main;
import ir.ac.kntu.units.allies.AllySoldier;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.LinkedList;

public class OrganizeSoldier {

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
            Rectangle rectangle = new Rectangle();
            if(Player.getSingleInstance().getPlayerStack()[i] != null){
                rectangle.setFill(Player.getSingleInstance().getPlayerStack()[i].getImage());
            }
            stackHeroes.add(rectangle);
        }

    }

    public static void showOrganization(){
        Design.rectangleDesign();
        EventHandling.organizationEventHandling();
        Main.backButton.setVisible(true);
        Main.root.getChildren().add(heroPoolRectangle);
        Main.root.getChildren().add(heroStackRectangle);


        for (int i = 0; i < Initializer.heroes.size(); i++) {
            Main.root.getChildren().add(heroPoolRec.get(i));
        }

        for (Rectangle stackHero : stackHeroes) {
            Main.root.getChildren().add(stackHero);
        }
    }

    public static boolean checkHeroExistInStack(int soldierNumber){
        AllySoldier soldier = Initializer.heroes.get(soldierNumber);
        boolean found = false;
        for(int i=0;i<8;i++){
            if(Player.getSingleInstance().getPlayerStack()[i] != null){
                if(soldier.equals(Player.getSingleInstance().getPlayerStack()[i])){
                    found = true;
                }
            }
        }
        return found;
    }

    public static void shiftHeroesInStack(int startFrom){
        for(int i=startFrom;i<7;i++){
            if(Player.getSingleInstance().getPlayerStack()[i+1] != null){
                if(i==6){
                    Player.getSingleInstance().getPlayerStack()[i] = Player.getSingleInstance().getPlayerStack()[i+1];
                    stackHeroes.get(i).setFill(Player.getSingleInstance().getPlayerStack()[i+1].getImage());
                    Player.getSingleInstance().getPlayerStack()[7] = null;
                    stackHeroes.get(7).setFill(Color.BLACK);
                    break;
                }
                Player.getSingleInstance().getPlayerStack()[i] = Player.getSingleInstance().getPlayerStack()[i+1];
                stackHeroes.get(i).setFill(Player.getSingleInstance().getPlayerStack()[i+1].getImage());
            } else {
                Player.getSingleInstance().getPlayerStack()[i] = null;
                stackHeroes.get(i).setFill(Color.BLACK);
                break;
            }
        }
    }
}
