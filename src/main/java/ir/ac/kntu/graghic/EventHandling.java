package ir.ac.kntu.graghic;

import ir.ac.kntu.gamePlay.*;
import ir.ac.kntu.units.allies.AllySoldier;
import ir.ac.kntu.units.items.Item;
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
            Main.backButton.setVisible(true);
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
        Main.trainButton.setOnMouseClicked(mouseEvent -> {
            UnitUpgrade.upgradeType=1;
            menuButtonClick();
            UnitUpgrade.soldierUpgrade();
        });

        Main.fortifyHQButton.setOnMouseEntered(mouseEvent -> Main.fortifyHQButton.setStyle("-fx-background-color: #357092"));
        Main.fortifyHQButton.setOnMouseExited(mouseEvent -> Main.fortifyHQButton.setStyle("-fx-background-color: #404040"));
        Main.fortifyHQButton.setOnMouseClicked(mouseEvent -> {
            UnitUpgrade.upgradeType=2;
            menuButtonClick();
            UnitUpgrade.itemUpgrade();
        });

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

        Main.backButton.setOnMouseEntered(mouseEvent -> Main.backButton.setStyle("-fx-background-color: #357092"));
        Main.backButton.setOnMouseExited(mouseEvent -> Main.backButton.setStyle("-fx-background-color: #404040"));
        Main.backButton.setOnMouseClicked(mouseEvent -> {
            Main.backButton.setVisible(false);
            Main.mission1Button.setVisible(false);
            Main.mission2Button.setVisible(false);
            Main.upgradeButton.setVisible(false);
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

            Main.root.getChildren().remove(UnitUpgrade.heroPoolRectangle);
            for (Rectangle rectangle:
                    UnitUpgrade.heroPoolRec) {
                Main.root.getChildren().remove(rectangle);
            }
            Main.root.getChildren().remove(UnitUpgrade.chosenHero);
            Main.root.getChildren().remove(UnitUpgrade.info);

            Main.root.getChildren().remove(UnitUpgrade.itemPoolRectangle);
            for (Rectangle rectangle:
                    UnitUpgrade.itemPoolRec) {
                Main.root.getChildren().remove(rectangle);
            }
            Main.root.getChildren().remove(UnitUpgrade.chosenItem);

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
            if(Player.getSingleInstance().getPlayerStack()[Mission.chosenTarget] != null){
                Player.getSingleInstance().getPlayerStack()[Mission.chosenTarget].getModel().setCenterX(mouseEvent.getX());
                Player.getSingleInstance().getPlayerStack()[Mission.chosenTarget].getModel().setCenterY(mouseEvent.getY());
            }
        });
    }

    public static void organizationEventHandling(){

        for(int i=0;i<OrganizeSoldier.heroPoolRec.size();i++){
            int finalI = i;
            OrganizeSoldier.heroPoolRec.get(i).setOnMouseClicked(mouseEvent -> {
                if (!OrganizeSoldier.checkHeroExistInStack(finalI)) {
                    for (int j = 0; j < 8; j++) {
                        if (Player.getSingleInstance().getPlayerStack()[j] == null) {
                            Player.getSingleInstance().getPlayerStack()[j] = Initializer.heroes.get(finalI);
                            OrganizeSoldier.stackHeroes.get(j).setFill(Initializer.heroes.get(finalI).getImage());
                            break;
                        }
                    }
                }
            });
        }

        for(int i=0;i<OrganizeSoldier.stackHeroes.size();i++){
            int finalI = i;
            OrganizeSoldier.stackHeroes.get(i).setOnMouseClicked(mouseEvent -> {
                if(Player.getSingleInstance().getPlayerStack()[finalI] != null){
                    OrganizeSoldier.shiftHeroesInStack(finalI);
                }
            });
        }
    }

    public static void upgradeHeroEventHandling(){
        for(int i=0;i<UnitUpgrade.heroPoolRec.size();i++){
            int finalI = i;
            UnitUpgrade.heroPoolRec.get(i).setOnMouseClicked(mouseEvent -> {
                UnitUpgrade.heroNumber = finalI;
                UnitUpgrade.chosenHero.setFill(UnitUpgrade.heroPoolRec.get(finalI).getFill());
                UnitUpgrade.setInfo();
            });
        }
        upgradeButtonClick();
    }

    public static void upgradeItemEventHandling(){
        for(int i=0;i<UnitUpgrade.itemPoolRec.size();i++){
            int finalI = i;
            UnitUpgrade.itemPoolRec.get(i).setOnMouseClicked(mouseEvent -> {
                UnitUpgrade.itemNumber = finalI;
                UnitUpgrade.chosenItem.setFill(UnitUpgrade.itemPoolRec.get(finalI).getFill());
                UnitUpgrade.setInfo();
            });
        }
        upgradeButtonClick();
    }
    public static void upgradeButtonClick(){

        Main.upgradeButton.setOnMouseClicked(mouseEvent -> {
            if(UnitUpgrade.upgradeType==1){
                AllySoldier hero = Initializer.heroes.get(UnitUpgrade.heroNumber);
                int cost = (int)(150*Math.pow(1.2,hero.getLevel()-1));
                if(Player.getSingleInstance().getMoney() >= cost){
                    Player.getSingleInstance().setMoney(Player.getSingleInstance().getMoney()-cost);
                    hero.setLevel(hero.getLevel()+1);
                    hero.lvlUp();
                    UnitUpgrade.setInfo();
                }
            } else if(UnitUpgrade.upgradeType==2){
                Item item = Initializer.items.get(UnitUpgrade.itemNumber);
                int cost = (int)(150*Math.pow(1.2,item.getLevel()-1));
                if(Player.getSingleInstance().getMoney() >= cost){
                    Player.getSingleInstance().setMoney(Player.getSingleInstance().getMoney()-cost);
                    item.setLevel(item.getLevel()+1);
                    item.lvlUp();
                    UnitUpgrade.setInfo();
                }
            }
        });
    }

    public static void menuButtonClick(){
        Main.backButton.setVisible(false);
        Main.missionButton.setVisible(false);
        Main.organizationButton.setVisible(false);
        Main.trainButton.setVisible(false);
        Main.fortifyHQButton.setVisible(false);
        Main.exitButton.setVisible(false);
    }

}
