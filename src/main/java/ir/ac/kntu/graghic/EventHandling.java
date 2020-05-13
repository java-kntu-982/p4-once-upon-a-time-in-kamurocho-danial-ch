package ir.ac.kntu.graghic;

import ir.ac.kntu.gamePlay.Initializer;
import ir.ac.kntu.gamePlay.Mission;
import ir.ac.kntu.gamePlay.OrganizeSoldier;
import ir.ac.kntu.gamePlay.Player;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class EventHandling {

    public static void buttonEventHandling(){

        Main.missionButton.setOnMouseEntered(mouseEvent -> Main.missionButton.setStyle("-fx-background-color: #357092"));
        Main.missionButton.setOnMouseExited(mouseEvent -> Main.missionButton.setStyle("-fx-background-color: #404040"));
        Main.missionButton.setOnMouseClicked(mouseEvent -> {
            menuButtonClick();
            Main.mission1Button.setVisible(true);
            if(Player.getSingleInstance().isLvl1Passed()){
                Main.mission2Button.setVisible(true);
            }
        });

        Main.organizationButton.setOnMouseEntered(mouseEvent -> Main.organizationButton.setStyle("-fx-background-color: #357092"));
        Main.organizationButton.setOnMouseExited(mouseEvent -> Main.organizationButton.setStyle("-fx-background-color: #404040"));
        Main.organizationButton.setOnMouseClicked(mouseEvent -> {
            menuButtonClick();
            OrganizeSoldier.organize();
            OrganizeSoldier.showOrganization();
        });

        Main.trainButton.setOnMouseEntered(mouseEvent -> Main.trainButton.setStyle("-fx-background-color: #357092"));
        Main.trainButton.setOnMouseExited(mouseEvent -> Main.trainButton.setStyle("-fx-background-color: #404040"));

        Main.fortifyHQButton.setOnMouseEntered(mouseEvent -> Main.fortifyHQButton.setStyle("-fx-background-color: #357092"));
        Main.fortifyHQButton.setOnMouseExited(mouseEvent -> Main.fortifyHQButton.setStyle("-fx-background-color: #404040"));

        Main.exitButton.setOnMouseEntered(mouseEvent -> Main.exitButton.setStyle("-fx-background-color: #357092"));
        Main.exitButton.setOnMouseExited(mouseEvent -> Main.exitButton.setStyle("-fx-background-color: #404040"));
        Main.exitButton.setOnMouseClicked(mouseEvent -> Platform.exit());

        Main.mission1Button.setOnMouseEntered(mouseEvent -> Main.mission1Button.setStyle("-fx-background-color: #357092"));
        Main.mission1Button.setOnMouseExited(mouseEvent -> Main.mission1Button.setStyle("-fx-background-color: #404040"));
        Main.mission1Button.setOnMouseClicked(mouseEvent -> {
            menuButtonClick();
            Mission.preparation(1,1);
        });

        Main.mission2Button.setOnMouseEntered(mouseEvent -> Main.mission2Button.setStyle("-fx-background-color: #357092"));
        Main.mission2Button.setOnMouseExited(mouseEvent -> Main.mission2Button.setStyle("-fx-background-color: #404040"));
        Main.mission2Button.setOnMouseClicked(mouseEvent -> {
            menuButtonClick();
            Mission.preparation(2,1);
        });

        OrganizeSoldier.backButton.setOnMouseEntered(mouseEvent -> OrganizeSoldier.backButton.setStyle("-fx-background-color: #357092"));
        OrganizeSoldier.backButton.setOnMouseExited(mouseEvent -> OrganizeSoldier.backButton.setStyle("-fx-background-color: #404040"));
        OrganizeSoldier.backButton.setOnMouseClicked(mouseEvent -> {
            Main.root.getChildren().remove(OrganizeSoldier.backButton);
            Main.root.getChildren().remove(OrganizeSoldier.heroPoolRectangle);
            Main.root.getChildren().remove(OrganizeSoldier.heroStackRectangle);
            for (Rectangle rectangle:
                 OrganizeSoldier.heroPoolRec) {
                Main.root.getChildren().remove(rectangle);
            }
            for (Rectangle rectangle:
                    OrganizeSoldier.stackHeroes) {
                Main.root.getChildren().remove(rectangle);
            }
            Initializer.mainMenu();
        });
    }

    public static void sceneEventHandler(){

        Main.scene.addEventFilter(KeyEvent.KEY_PRESSED ,key -> {
            if(key.getCode()== KeyCode.Q){
                if(Mission.chosenTarget>0 && Player.getSingleInstance().getPlayerStack()[Mission.chosenTarget-1] != null){
                    Mission.chosenTarget--;
                }
            }
            else if(key.getCode()== KeyCode.E){
                if(Mission.chosenTarget<7 && Player.getSingleInstance().getPlayerStack()[Mission.chosenTarget+1] != null){
                    Mission.chosenTarget++;
                }
            }
        });

        Main.scene.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            Player.getSingleInstance().getPlayerStack()[Mission.chosenTarget].getModel().setCenterX(mouseEvent.getX());
            Player.getSingleInstance().getPlayerStack()[Mission.chosenTarget].getModel().setCenterY(mouseEvent.getY());
        });
    }

    public static void menuButtonClick(){
        Main.missionButton.setVisible(false);
        Main.organizationButton.setVisible(false);
        Main.trainButton.setVisible(false);
        Main.fortifyHQButton.setVisible(false);
        Main.exitButton.setVisible(false);
    }
}
