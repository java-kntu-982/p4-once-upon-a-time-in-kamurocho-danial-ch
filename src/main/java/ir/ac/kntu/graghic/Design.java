package ir.ac.kntu.graghic;

import ir.ac.kntu.gamePlay.Mission;
import ir.ac.kntu.gamePlay.OrganizeSoldier;
import javafx.scene.paint.Color;

public class Design {

    public static void designButtons(){

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

        Main.exitButton.setStyle("-fx-background-color: #404040");
        Main.exitButton.setTextFill(Color.WHITE);
        Main.exitButton.setPrefWidth(350);
        Main.exitButton.setPrefHeight(30);
        Main.exitButton.setTranslateX(40);
        Main.exitButton.setTranslateY(240);
        Main.exitButton.setOpacity(0.8);

        Main.mission1Button.setStyle("-fx-background-color: #404040");
        Main.mission1Button.setTextFill(Color.WHITE);
        Main.mission1Button.setPrefWidth(350);
        Main.mission1Button.setPrefHeight(30);
        Main.mission1Button.setTranslateX(40);
        Main.mission1Button.setTranslateY(40);
        Main.mission1Button.setOpacity(0.8);
        Main.mission1Button.setVisible(false);

        Main.mission2Button.setStyle("-fx-background-color: #404040");
        Main.mission2Button.setTextFill(Color.WHITE);
        Main.mission2Button.setPrefWidth(350);
        Main.mission2Button.setPrefHeight(30);
        Main.mission2Button.setTranslateX(40);
        Main.mission2Button.setTranslateY(90);
        Main.mission2Button.setOpacity(0.8);
        Main.mission2Button.setVisible(false);

        OrganizeSoldier.backButton.setStyle("-fx-background-color: #404040");
        OrganizeSoldier.backButton.setTextFill(Color.WHITE);
        OrganizeSoldier.backButton.setPrefWidth(350);
        OrganizeSoldier.backButton.setPrefHeight(30);
        OrganizeSoldier.backButton.setTranslateX(40);
        OrganizeSoldier.backButton.setTranslateY(40);
        OrganizeSoldier.backButton.setOpacity(0.8);
    }

    public static void rectangleDesign(){
        OrganizeSoldier.heroPoolRectangle.setWidth(910);
        OrganizeSoldier.heroPoolRectangle.setHeight(220);
        OrganizeSoldier.heroPoolRectangle.setX(45);
        OrganizeSoldier.heroPoolRectangle.setY(360);
        OrganizeSoldier.heroPoolRectangle.setFill(Color.BLACK);
        OrganizeSoldier.heroPoolRectangle.setStroke(Color.rgb(130,86,30));
        OrganizeSoldier.heroPoolRectangle.setStrokeWidth(5);
        OrganizeSoldier.heroPoolRectangle.setArcHeight(15);
        OrganizeSoldier.heroPoolRectangle.setArcWidth(15);

        OrganizeSoldier.heroStackRectangle.setWidth(560);
        OrganizeSoldier.heroStackRectangle.setHeight(110);
        OrganizeSoldier.heroStackRectangle.setX(220);
        OrganizeSoldier.heroStackRectangle.setY(200);
        OrganizeSoldier.heroStackRectangle.setFill(Color.BLACK);
        OrganizeSoldier.heroStackRectangle.setStroke(Color.rgb(130,86,30));
        OrganizeSoldier.heroStackRectangle.setStrokeWidth(5);
        OrganizeSoldier.heroStackRectangle.setArcHeight(15);
        OrganizeSoldier.heroStackRectangle.setArcWidth(15);

        for (int i=0;i<OrganizeSoldier.heroPoolRec.size();i++){
            OrganizeSoldier.heroPoolRec.get(i).setHeight(110);
            OrganizeSoldier.heroPoolRec.get(i).setWidth(70);
            OrganizeSoldier.heroPoolRec.get(i).setX(45+(i*70));
            OrganizeSoldier.heroPoolRec.get(i).setY(360);
        }

        for (int i=0;i<OrganizeSoldier.stackHeroes.size();i++){
            OrganizeSoldier.stackHeroes.get(i).setHeight(110);
            OrganizeSoldier.stackHeroes.get(i).setWidth(70);
            OrganizeSoldier.stackHeroes.get(i).setX(220+(i*70));
            OrganizeSoldier.stackHeroes.get(i).setY(200);
        }
    }

    public static void inGameRecDesign(){

        OrganizeSoldier.heroStackRectangle.setY(480);
        for (int i=0;i<OrganizeSoldier.stackHeroes.size();i++){
            OrganizeSoldier.stackHeroes.get(i).setY(480);
        }
    }
}
