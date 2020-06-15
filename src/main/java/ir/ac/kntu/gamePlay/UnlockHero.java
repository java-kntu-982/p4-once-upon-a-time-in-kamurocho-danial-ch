package ir.ac.kntu.gamePlay;

import ir.ac.kntu.graghic.Design;
import ir.ac.kntu.graghic.Main;
import ir.ac.kntu.units.allies.AllySoldier;
import ir.ac.kntu.units.allies.SotaroKomakiN;
import ir.ac.kntu.units.allies.TetsuTachibanaN;
import ir.ac.kntu.units.allies.YukioTerada;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Random;

public class UnlockHero {

    public static void unlock(){

        if(Player.getSingleInstance().getMoney() >= 500){

            Player.getSingleInstance().setMoney(Player.getSingleInstance().getMoney()-500);

            while (true){

                boolean flag=true;
                AllySoldier newSoldier;
                int random = new Random().nextInt(3);
                switch (random){
                    case 1:
                        newSoldier = SotaroKomakiN.getSingleInstance();
                        break;
                    case 2:
                        newSoldier = TetsuTachibanaN.getSingleInstance();
                        break;
                    default:
                        newSoldier = YukioTerada.getSingleInstance();;
                }
                for(AllySoldier soldier:Initializer.heroes){
                    if(soldier.equals(newSoldier)){
                        flag=false;
                        break;
                    }
                }

                if (flag){
                    Initializer.heroes.add(newSoldier);
                    break;
                }
            }

            Rectangle blackRec = new Rectangle();
            Rectangle heroIcon = new Rectangle();
            heroIcon.setFill(Initializer.heroes.getLast().getImage());
            Text info = new Text("You Unlocked "+ Initializer.heroes.getLast().getClass().getSimpleName());
            Design.unlockHeroDesign(heroIcon,blackRec,info);

            Main.root.getChildren().add(blackRec);
            Main.root.getChildren().add(heroIcon);
            Main.root.getChildren().add(info);

            Timeline timedShow = new Timeline(new KeyFrame(Duration.ZERO), new KeyFrame(Duration.millis(3500)
            ));
            timedShow.setCycleCount(1);
            timedShow.play();
            timedShow.setOnFinished(actionEvent ->{
                Main.root.getChildren().remove(blackRec);
                Main.root.getChildren().remove(heroIcon);
                Main.root.getChildren().remove(info);
            });

        } else {

            Text notEnoughMoney = new Text("Not Enough Money");
            notEnoughMoney.setX(300);
            notEnoughMoney.setY(500);
            notEnoughMoney.setFill(Color.RED);
            notEnoughMoney.setStrokeWidth(1);
            notEnoughMoney.setStroke(Color.WHITE);
            notEnoughMoney.setFont(Font.font("none", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,35));
            Main.root.getChildren().add(notEnoughMoney);
            Timeline timedShow = new Timeline(new KeyFrame(Duration.ZERO), new KeyFrame(Duration.millis(500)
            ));
            timedShow.setCycleCount(1);
            timedShow.play();
            timedShow.setOnFinished(actionEvent ->{
                Main.root.getChildren().remove(notEnoughMoney);
            });
        }
    }
}
