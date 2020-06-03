package ir.ac.kntu.gamePlay;

import ir.ac.kntu.graghic.Design;
import ir.ac.kntu.graghic.EventHandling;
import ir.ac.kntu.graghic.Main;
import ir.ac.kntu.units.allies.AllySoldier;
import ir.ac.kntu.units.items.Item;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.LinkedList;

public class UnitUpgrade {

    public static Rectangle heroPoolRectangle = new Rectangle();
    public static Rectangle itemPoolRectangle = new Rectangle();
    public static LinkedList<Rectangle> heroPoolRec = new LinkedList<>();
    public static LinkedList<Rectangle> itemPoolRec = new LinkedList<>();
    public static Rectangle chosenHero = new Rectangle();
    public static Rectangle chosenItem = new Rectangle();
    public static int heroNumber=0;
    public static int itemNumber=0;
    public static Text info = new Text();
    public static int upgradeType=1;

    public static void soldierUpgrade(){

        Main.backButton.setVisible(true);
        Main.upgradeButton.setVisible(true);

        for (int i = 0; i < Initializer.heroes.size(); i++) {
            Rectangle rectangle = new Rectangle();
            rectangle.setFill(Initializer.heroes.get(i).getImage());
            heroPoolRec.add(rectangle);
        }

        Main.root.getChildren().add(heroPoolRectangle);
        for (int i = 0; i < Initializer.heroes.size(); i++) {
            Main.root.getChildren().add(heroPoolRec.get(i));
        }

        Design.upgradeHeroDesign();
        chosenHero.setFill(Initializer.heroes.get(heroNumber).getImage());
        Main.root.getChildren().add(chosenHero);

        setInfo();
        Main.root.getChildren().add(info);

        EventHandling.upgradeHeroEventHandling();
    }

    public static void setInfo(){

        if(upgradeType == 1){
            AllySoldier hero = Initializer.heroes.get(heroNumber);
            int cost = (int)(150*Math.pow(1.2,hero.getLevel()-1));
            info.setText("Level " + hero.getLevel() + " " + hero.getClass().getSimpleName()+"\n\t" +"cost: " +cost);
        } else if( upgradeType == 2){
            Item item = Initializer.items.get(itemNumber);
            int cost = (int)(150*Math.pow(1.2,item.getLevel()-1));
            info.setText("Level " + item.getLevel() + " " + item.getClass().getSimpleName()+"\n" +"cost: " +cost);
        }
    }


    public static void itemUpgrade(){

        Main.backButton.setVisible(true);
        Main.upgradeButton.setVisible(true);

        for (int i = 0; i < Initializer.items.size(); i++) {
            Rectangle rectangle = new Rectangle();
            rectangle.setFill(Initializer.items.get(i).getImage());
            itemPoolRec.add(rectangle);
        }

        Main.root.getChildren().add(itemPoolRectangle);
        for (int i = 0; i < Initializer.items.size(); i++) {
            Main.root.getChildren().add(itemPoolRec.get(i));
        }

        Design.upgradeItemDesign();
        chosenItem.setFill(Initializer.items.get(itemNumber).getImage());
        Main.root.getChildren().add(chosenItem);

        setInfo();
        Main.root.getChildren().add(info);

        EventHandling.upgradeItemEventHandling();
    }

}
