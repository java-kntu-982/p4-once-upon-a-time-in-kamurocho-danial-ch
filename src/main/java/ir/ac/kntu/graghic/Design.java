package ir.ac.kntu.graghic;

import ir.ac.kntu.gamePlay.Initializer;
import ir.ac.kntu.gamePlay.OrganizeSoldier;
import ir.ac.kntu.gamePlay.Player;
import ir.ac.kntu.gamePlay.UnitUpgrade;
import ir.ac.kntu.units.Unit;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Design {

    public static void designButtons() {

        Main.missionButton.setStyle("-fx-background-color: #404040");
        Main.missionButton.setTextFill(Color.WHITE);
        Main.missionButton.setPrefWidth(350);
        Main.missionButton.setPrefHeight(30);
        Main.missionButton.setTranslateX(40);
        Main.missionButton.setTranslateY(40);
        Main.missionButton.setOpacity(0.8);

        Main.organizationButton.setStyle("-fx-background-color: #404040");
        Main.organizationButton.setTextFill(Color.WHITE);
        Main.organizationButton.setPrefWidth(350);
        Main.organizationButton.setPrefHeight(30);
        Main.organizationButton.setTranslateX(40);
        Main.organizationButton.setTranslateY(90);
        Main.organizationButton.setOpacity(0.8);

        Main.trainButton.setStyle("-fx-background-color: #404040");
        Main.trainButton.setTextFill(Color.WHITE);
        Main.trainButton.setPrefWidth(350);
        Main.trainButton.setPrefHeight(30);
        Main.trainButton.setTranslateX(40);
        Main.trainButton.setTranslateY(140);
        Main.trainButton.setOpacity(0.8);

        Main.fortifyHQButton.setStyle("-fx-background-color: #404040");
        Main.fortifyHQButton.setTextFill(Color.WHITE);
        Main.fortifyHQButton.setPrefWidth(350);
        Main.fortifyHQButton.setPrefHeight(30);
        Main.fortifyHQButton.setTranslateX(40);
        Main.fortifyHQButton.setTranslateY(190);
        Main.fortifyHQButton.setOpacity(0.8);

        Main.unlockButton.setStyle("-fx-background-color: #404040");
        Main.unlockButton.setTextFill(Color.WHITE);
        Main.unlockButton.setPrefWidth(350);
        Main.unlockButton.setPrefHeight(30);
        Main.unlockButton.setTranslateX(40);
        Main.unlockButton.setTranslateY(240);
        Main.unlockButton.setOpacity(0.8);

        Main.exitButton.setStyle("-fx-background-color: #404040");
        Main.exitButton.setTextFill(Color.WHITE);
        Main.exitButton.setPrefWidth(350);
        Main.exitButton.setPrefHeight(30);
        Main.exitButton.setTranslateX(40);
        Main.exitButton.setTranslateY(290);
        Main.exitButton.setOpacity(0.8);

        Main.mission1Button.setStyle("-fx-background-color: #404040");
        Main.mission1Button.setTextFill(Color.WHITE);
        Main.mission1Button.setPrefWidth(350);
        Main.mission1Button.setPrefHeight(30);
        Main.mission1Button.setTranslateX(40);
        Main.mission1Button.setTranslateY(90);
        Main.mission1Button.setOpacity(0.8);
        Main.mission1Button.setVisible(false);

        Main.mission2Button.setStyle("-fx-background-color: #404040");
        Main.mission2Button.setTextFill(Color.WHITE);
        Main.mission2Button.setPrefWidth(350);
        Main.mission2Button.setPrefHeight(30);
        Main.mission2Button.setTranslateX(40);
        Main.mission2Button.setTranslateY(140);
        Main.mission2Button.setOpacity(0.8);
        Main.mission2Button.setVisible(false);

        Main.backButton.setStyle("-fx-background-color: #404040");
        Main.backButton.setTextFill(Color.WHITE);
        Main.backButton.setPrefWidth(350);
        Main.backButton.setPrefHeight(30);
        Main.backButton.setTranslateX(40);
        Main.backButton.setTranslateY(40);
        Main.backButton.setOpacity(0.8);

        Main.upgradeButton.setTextFill(Color.WHITE);
        Main.upgradeButton.setPrefWidth(150);
        Main.upgradeButton.setPrefHeight(50);
        Main.upgradeButton.setTranslateX(600);
        Main.upgradeButton.setTranslateY(250);
        Main.upgradeButton.setFont(Font.font(20));
        Main.upgradeButton.setStyle("-fx-background-color: DarkRed");

    }

    public static void moneyDisplay() {

        Rectangle bgRectangle = new Rectangle();
        bgRectangle.setFill(Color.DIMGRAY);
        bgRectangle.setOpacity(0.9);
        bgRectangle.setX(790);
        bgRectangle.setY(10);
        bgRectangle.setHeight(30);
        bgRectangle.setWidth(180);
        Main.root.getChildren().add(bgRectangle);

        Circle coin = new Circle();
        coin.setCenterX(810);
        coin.setCenterY(25);
        coin.setRadius(11);
        coin.setFill(new ImagePattern(new Image("file:images/coin image.jpg")));
        Main.root.getChildren().add(coin);

        Text moneyAmount = new Text();
        moneyAmount.setFill(Color.GOLD);
        moneyAmount.setX(835);
        moneyAmount.setY(33);
        moneyAmount.setFont(Font.font(18));
        moneyAmount.setStroke(Color.WHITE);
        moneyAmount.setStrokeWidth(0.3);
        Main.root.getChildren().add(moneyAmount);

        AnimationTimer moneyChecker = new AnimationTimer() {
            @Override
            public void handle(long l) {
                moneyAmount.setText(String.valueOf(Player.getSingleInstance().getMoney()));
            }
        };
        moneyChecker.start();

    }

    public static void rectangleDesign() {
        OrganizeSoldier.heroPoolRectangle.setWidth(910);
        OrganizeSoldier.heroPoolRectangle.setHeight(220);
        OrganizeSoldier.heroPoolRectangle.setX(45);
        OrganizeSoldier.heroPoolRectangle.setY(360);
        OrganizeSoldier.heroPoolRectangle.setFill(Color.BLACK);
        OrganizeSoldier.heroPoolRectangle.setStroke(Color.rgb(130, 86, 30));
        OrganizeSoldier.heroPoolRectangle.setStrokeWidth(5);
        OrganizeSoldier.heroPoolRectangle.setArcHeight(15);
        OrganizeSoldier.heroPoolRectangle.setArcWidth(15);

        OrganizeSoldier.heroStackRectangle.setWidth(560);
        OrganizeSoldier.heroStackRectangle.setHeight(110);
        OrganizeSoldier.heroStackRectangle.setX(220);
        OrganizeSoldier.heroStackRectangle.setY(200);
        OrganizeSoldier.heroStackRectangle.setFill(Color.BLACK);
        OrganizeSoldier.heroStackRectangle.setStroke(Color.rgb(130, 86, 30));
        OrganizeSoldier.heroStackRectangle.setStrokeWidth(5);
        OrganizeSoldier.heroStackRectangle.setArcHeight(15);
        OrganizeSoldier.heroStackRectangle.setArcWidth(15);

        for (int i = 0; i < OrganizeSoldier.heroPoolRec.size(); i++) {
            OrganizeSoldier.heroPoolRec.get(i).setHeight(110);
            OrganizeSoldier.heroPoolRec.get(i).setWidth(70);
            OrganizeSoldier.heroPoolRec.get(i).setX(45 + (i * 70));
            OrganizeSoldier.heroPoolRec.get(i).setY(360);
        }

        for (int i = 0; i < OrganizeSoldier.stackHeroes.size(); i++) {
            OrganizeSoldier.stackHeroes.get(i).setHeight(110);
            OrganizeSoldier.stackHeroes.get(i).setWidth(70);
            OrganizeSoldier.stackHeroes.get(i).setX(220 + (i * 70));
            OrganizeSoldier.stackHeroes.get(i).setY(200);
        }
    }

    public static void upgradeHeroDesign() {
        UnitUpgrade.heroPoolRectangle.setWidth(910);
        UnitUpgrade.heroPoolRectangle.setHeight(220);
        UnitUpgrade.heroPoolRectangle.setX(45);
        UnitUpgrade.heroPoolRectangle.setY(360);
        UnitUpgrade.heroPoolRectangle.setFill(Color.BLACK);
        UnitUpgrade.heroPoolRectangle.setStroke(Color.rgb(130, 86, 30));
        UnitUpgrade.heroPoolRectangle.setStrokeWidth(5);
        UnitUpgrade.heroPoolRectangle.setArcHeight(15);
        UnitUpgrade.heroPoolRectangle.setArcWidth(15);

        for (int i = 0; i < UnitUpgrade.heroPoolRec.size(); i++) {
            UnitUpgrade.heroPoolRec.get(i).setHeight(110);
            UnitUpgrade.heroPoolRec.get(i).setWidth(70);
            UnitUpgrade.heroPoolRec.get(i).setX(45 + (i * 70));
            UnitUpgrade.heroPoolRec.get(i).setY(360);
        }

        UnitUpgrade.chosenHero.setWidth(105);
        UnitUpgrade.chosenHero.setHeight(165);
        UnitUpgrade.chosenHero.setX(400);
        UnitUpgrade.chosenHero.setY(150);
        UnitUpgrade.chosenHero.setFill(Color.BLACK);
        UnitUpgrade.chosenHero.setStroke(Color.rgb(130, 86, 30));
        UnitUpgrade.chosenHero.setStrokeWidth(5);
        UnitUpgrade.chosenHero.setArcHeight(15);
        UnitUpgrade.chosenHero.setArcWidth(15);
        infoDesign();
    }

    public static void upgradeItemDesign() {
        UnitUpgrade.itemPoolRectangle.setWidth(720);
        UnitUpgrade.itemPoolRectangle.setHeight(280);
        UnitUpgrade.itemPoolRectangle.setX(140);
        UnitUpgrade.itemPoolRectangle.setY(320);
        UnitUpgrade.itemPoolRectangle.setFill(Color.BLACK);
        UnitUpgrade.itemPoolRectangle.setStroke(Color.rgb(130, 86, 30));
        UnitUpgrade.itemPoolRectangle.setStrokeWidth(5);
        UnitUpgrade.itemPoolRectangle.setArcHeight(15);
        UnitUpgrade.itemPoolRectangle.setArcWidth(15);

        for (int i = 0; i < UnitUpgrade.itemPoolRec.size(); i++) {
            UnitUpgrade.itemPoolRec.get(i).setHeight(140);
            UnitUpgrade.itemPoolRec.get(i).setWidth(240);
            UnitUpgrade.itemPoolRec.get(i).setX(140 + (i * 240));
            UnitUpgrade.itemPoolRec.get(i).setY(320);
            UnitUpgrade.itemPoolRec.get(i).setStrokeWidth(1);
            UnitUpgrade.itemPoolRec.get(i).setStroke(Color.BLACK);
        }

        UnitUpgrade.chosenItem.setWidth(312);
        UnitUpgrade.chosenItem.setHeight(182);
        UnitUpgrade.chosenItem.setX(140);
        UnitUpgrade.chosenItem.setY(100);
        UnitUpgrade.chosenItem.setFill(Color.BLACK);
        UnitUpgrade.chosenItem.setStroke(Color.rgb(130, 86, 30));
        UnitUpgrade.chosenItem.setStrokeWidth(5);
        UnitUpgrade.chosenItem.setArcHeight(15);
        UnitUpgrade.chosenItem.setArcWidth(15);
        infoDesign();

    }

    public static void infoDesign() {
        UnitUpgrade.info.setX(570);
        UnitUpgrade.info.setY(190);
        UnitUpgrade.info.setFont(Font.font("none", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 23));
        UnitUpgrade.info.setStroke(Color.WHITE);
        UnitUpgrade.info.setStrokeWidth(0.5);
        UnitUpgrade.info.setFill(Color.RED);
    }

    public static void inGameRecDesign() {

        OrganizeSoldier.heroStackRectangle.setY(480);
        for (int i = 0; i < OrganizeSoldier.stackHeroes.size(); i++) {
            OrganizeSoldier.stackHeroes.get(i).setY(480);
        }
    }

    public static void unlockHeroDesign(Rectangle icon,Rectangle blackRec,Text info){

        icon.setFill(Initializer.heroes.getLast().getImage());
        icon.setX((Main.scene.getWidth()/2) - 70);
        icon.setY(150);
        icon.setHeight(220);
        icon.setWidth(140);

        blackRec.setWidth(Main.scene.getWidth());
        blackRec.setHeight(Main.scene.getHeight());
        blackRec.setFill(Color.BLACK);
        blackRec.setOpacity(0.8);

        info.setX(240);
        info.setY(430);
        info.setFill(Color.RED);
        info.setFont(Font.font("none", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,35));
    }

}
