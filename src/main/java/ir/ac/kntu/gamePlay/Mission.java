package ir.ac.kntu.gamePlay;

import ir.ac.kntu.graghic.Design;
import ir.ac.kntu.graghic.EventHandling;
import ir.ac.kntu.graghic.Main;
import ir.ac.kntu.units.Soldier;
import ir.ac.kntu.units.allies.AllySoldier;
import ir.ac.kntu.units.enemis.EnemySoldier;
import ir.ac.kntu.units.items.Container;
import ir.ac.kntu.units.items.Item;
import ir.ac.kntu.units.items.Truck;
import ir.ac.kntu.units.items.Van;
import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javax.sound.midi.Soundbank;
import java.util.Random;

public class Mission {

    public static int chosenTarget = 0;
    public static AnimationTimer toolBarLighten;
    public static final double V=0.1;
    public static final double K=7;
    public static final double M=40;

    public static void preparation(int lvlNumber,int roundNumber){

        Main.root.getChildren().remove(Main.imageView);
        Main.mission1Button.setVisible(false);
        Main.mission2Button.setVisible(false);
        Main.mediaPlayer.stop();

        for(int i=0;i<8;i++){
            if(Player.getSingleInstance().getPlayerStack()[i] != null){
                Player.getSingleInstance().getPlayerStack()[i].getModel().setCenterX(new Random().nextInt((int)Main.scene.getWidth()/2)+Main.scene.getWidth()/2);
                Player.getSingleInstance().getPlayerStack()[i].getModel().setCenterY(new Random().nextInt((int)Main.scene.getHeight()-160)+20);
                Main.root.getChildren().add(Player.getSingleInstance().getPlayerStack()[i].getModel());
            }
        }

        AnimationTimer checkChosenTarget = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(int i=0;i<8;i++){
                    if(Player.getSingleInstance().getPlayerStack()[i] != null){
                        if(i==chosenTarget){
                            Player.getSingleInstance().getPlayerStack()[i].getModel().setStroke(Color.RED);
                            Player.getSingleInstance().getPlayerStack()[i].getModel().setStrokeWidth(2);
                            continue;
                        }
                        Player.getSingleInstance().getPlayerStack()[i].getModel().setStrokeWidth(0);
                    }
                }
            }
        };
        checkChosenTarget.start();
        EventHandling.sceneEventHandler();
        toolBarHeroes();
        Main.scene.addEventHandler(KeyEvent.KEY_PRESSED,keyEvent -> {
            if(keyEvent.getCode()== KeyCode.SPACE){
                //Main.scene.addEventHandler(KeyEvent.KEY_PRESSED, Event::consume);
                if(lvlNumber==1){
                    Levels.spawnItemsLvl1();
                    switch (roundNumber){
                        case 1:
                            Levels.lvl1Round1();
                            break;
                        case 2:
                            Levels.lvl1Round2();
                            break;
                        case 3:
                            Levels.lvl1Round3();
                            break;
                        case 4:
                            Levels.lvl1Round4();
                            break;
                        case 5:
                            Levels.lvl1Round5();
                            break;
                        case 6:
                            Levels.lvl1Round6();
                            break;
                        case 7:
                            Levels.lvl1Round7();
                            break;
                        case 8:
                            Levels.lvl1Round8();
                            break;
                    }
                }
                else if(lvlNumber==2){

                }
                startRound();
            }
        });
    }

    public static void toolBarHeroes(){
        Design.inGameRecDesign();
        Main.root.getChildren().add(OrganizeSoldier.heroStackRectangle);
        for (Rectangle rectangle:
             OrganizeSoldier.stackHeroes) {
            Main.root.getChildren().add(rectangle);
        }
        toolBarLighten = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(int i=0;i<8;i++){
                    if(Player.getSingleInstance().getPlayerStack()[i] != null){
                        if(i==chosenTarget){
                            OrganizeSoldier.stackHeroes.get(i).setStroke(Color.RED);
                            OrganizeSoldier.stackHeroes.get(i).setStrokeWidth(3);
                            continue;
                        }
                        OrganizeSoldier.stackHeroes.get(i).setStrokeWidth(0);
                    }
                }
            }
        };
        toolBarLighten.start();
    }

    public static void startRound(){
        soldierTargetChooser();
        soldierMovement();
        gameProcess();
    }

    public static void soldierTargetChooser(){
        AnimationTimer enemyTargetChooser = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(int i=0;i<Levels.enemyWave.size();i++){
                    for(int j=0;j<Levels.enemyWave.get(i).getSoldierGroup().size();j++){
                        if(!Levels.enemyWave.get(i).getSoldierGroup().get(j).isAttacked()){
                            if(Levels.enemyWave.get(i).getSoldierGroup().get(j).getTarget()==null){
                                Levels.enemyWave.get(i).getSoldierGroup().get(j).setAttacking(false);
                                Rectangle soldier = Levels.enemyWave.get(i).getSoldierGroup().get(j).getModel();
                                Rectangle item1 = Levels.items.get(0).getModel();
                                Rectangle item2 = Levels.items.get(1).getModel();
                                if(Math.pow((soldier.getX()-item1.getX()),2)+Math.pow((soldier.getY()-item1.getY()),2)>=
                                        Math.pow((soldier.getX()-item2.getX()),2)+Math.pow((soldier.getY()-item2.getY()),2)
                                ){
                                    Levels.enemyWave.get(i).getSoldierGroup().get(j).setTarget(Levels.items.get(1));
                                } else {
                                    Levels.enemyWave.get(i).getSoldierGroup().get(j).setTarget(Levels.items.get(0));
                                }
                            }
                        } else {
                            for(int k=0;k<8;k++){
                                if(Player.getSingleInstance().getPlayerStack()[k]  != null && Player.getSingleInstance().getPlayerStack()[k].getTarget()  != null){
                                    if(Player.getSingleInstance().getPlayerStack()[k].getTarget().equals(Levels.enemyWave.get(i).getSoldierGroup().get(j))){
                                        Levels.enemyWave.get(i).getSoldierGroup().get(j).setTarget(Player.getSingleInstance().getPlayerStack()[k]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        };
        enemyTargetChooser.start();

        AnimationTimer allyTargetChooser = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(int i=0;i<8;i++){
                    if(Player.getSingleInstance().getPlayerStack()[i] != null){
                        AllySoldier soldier = Player.getSingleInstance().getPlayerStack()[i];
                        if(!soldier.isAttacking() && soldier.isAlive()){
                            if(soldier.getTarget() == null){
                                for(int j=0;j<Levels.enemyWave.size();j++){
                                    for(int k=0;k<Levels.enemyWave.get(j).getSoldierGroup().size();k++){
                                        EnemySoldier enemySoldier = Levels.enemyWave.get(j).getSoldierGroup().get(k);
                                        if(soldier.getFieldOfView()*M >= Math.sqrt((Math.pow(soldier.getModel().getCenterX()-enemySoldier.getModel().getX(),2))+(Math.pow(soldier.getModel().getCenterY()-enemySoldier.getModel().getY(),2)))){
                                            soldier.setTarget(enemySoldier);
                                            for(int z=0;z<Levels.enemyWave.get(j).getSoldierGroup().size();z++){
                                                Levels.enemyWave.get(j).getSoldierGroup().get(z).setTarget(soldier);
                                                Levels.enemyWave.get(j).getSoldierGroup().get(z).setAttacked(true);
                                            }
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        };
        allyTargetChooser.start();
    }

    public static void soldierMovement(){

        AnimationTimer enemyMovement = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(int i=0;i<Levels.enemyWave.size();i++){
                    for(int j=0;j<Levels.enemyWave.get(i).getSoldierGroup().size();j++){
                        EnemySoldier soldier =Levels.enemyWave.get(i).getSoldierGroup().get(j);
                        if(!soldier.isAttacking()){
                            if(soldier.getTarget().getClass().equals(Container.class) ||
                                    soldier.getTarget().getClass().equals(Van.class)  ||
                                    soldier.getTarget().getClass().equals(Truck.class)){
                                Item item = (Item)(soldier.getTarget());
                                if(soldier.getModel().getX() + soldier.getAttackRange()*K>= item.getModel().getX()){
                                    soldier.setAttacking(true);
                                    continue;
                                }
                                double deltaX = soldier.getModel().getX() - item.getModel().getX();
                                double deltaY;
                                if(soldier.getModel().getY()>item.getModel().getY()){
                                    deltaY = soldier.getModel().getY() - item.getModel().getY();
                                }
                                else if ( soldier.getModel().getY() < item.getModel().getY() + item.getModel().getHeight()){
                                    deltaY = item.getModel().getY() - soldier.getModel().getY();
                                } else{
                                    deltaY=0;
                                }
                                soldier.getModel().setX(soldier.getModel().getX() + V*soldier.getSpeed()*Math.abs(Math.atan(deltaX/deltaY)));
                                soldier.getModel().setY(soldier.getModel().getY() + V*soldier.getSpeed()*Math.abs(Math.atan(deltaY/deltaX)));
                            } else if(soldier.getTarget().getClass().equals(AllySoldier.class)){
                                AllySoldier allySoldier =(AllySoldier)soldier.getTarget();
                                if(soldier.getAttackRange()*K>Math.sqrt((Math.pow(soldier.getModel().getX()-allySoldier.getModel().getCenterX(),2))+(Math.pow(soldier.getModel().getY()-allySoldier.getModel().getCenterY(),2)))){
                                    double deltaX = soldier.getModel().getX() - allySoldier.getModel().getCenterX();
                                    double deltaY = soldier.getModel().getX() - allySoldier.getModel().getCenterX();
                                    soldier.getModel().setX(soldier.getModel().getX() + V*soldier.getSpeed()*Math.abs(Math.atan(deltaX/deltaY)));
                                    soldier.getModel().setY(soldier.getModel().getY() + V*soldier.getSpeed()*Math.abs(Math.atan(deltaY/deltaX)));
                                }
/*                                else {
                                    soldier.setAttacking(true);
                                }*/
                            }
                        }
                    }
                }
            }
        };
        enemyMovement.start();


        AnimationTimer allyMovement = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(int i=0;i<8;i++){
                    if(Player.getSingleInstance().getPlayerStack()[i] != null){
                        AllySoldier soldier = Player.getSingleInstance().getPlayerStack()[i];
                        if(soldier.getTarget() != null && soldier.isAlive()){
                            System.out.println("0");
                            if(!soldier.isAttacking()){
                                EnemySoldier target = (EnemySoldier) soldier.getTarget();
                                System.out.println("1");
                                if(soldier.getAttackRange()*K>= Math.sqrt((Math.pow(soldier.getModel().getCenterX()-target.getModel().getX(),2)+(Math.pow(soldier.getModel().getCenterY()-target.getModel().getY(),2))))){
                                    soldier.setAttacking(true);
                                    System.out.println("2");
                                    for(int j=0;j<Levels.enemyWave.size();j++){
                                        for(int k=0;k<Levels.enemyWave.get(j).getSoldierGroup().size();k++){
                                            if(Levels.enemyWave.get(j).getSoldierGroup().get(k).equals(target)){
                                                target.setAttacked(true);
                                                for(int z=0;z<Levels.enemyWave.get(j).getSoldierGroup().size();z++){
                                                    Levels.enemyWave.get(j).getSoldierGroup().get(z).setTarget(soldier);
                                                }
                                                break;
                                            }
                                        }
                                    }
                                }
                                else{
                                    double deltaX = soldier.getModel().getCenterX() - target.getModel().getX();
                                    double deltaY = soldier.getModel().getCenterY() - target.getModel().getY();
                                    soldier.getModel().setCenterX(soldier.getModel().getCenterX() - V*soldier.getSpeed()*Math.abs(Math.atan(deltaX/deltaY)));
                                    soldier.getModel().setCenterY(soldier.getModel().getCenterY() - V*soldier.getSpeed()*Math.abs(Math.atan(deltaY/deltaX)));
                                }
                            }
                        }
                    }
                }
            }
        };
        allyMovement.start();

        AnimationTimer checker = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(int i=0;i<Levels.enemyWave.size();i++){
                    for(int j=0;j<Levels.enemyWave.get(i).getSoldierGroup().size();j++){
                        if(Levels.enemyWave.get(i).getSoldierGroup().get(j).isAttacking()){
                            System.out.print("1 ");
                        }
                        else{
                            System.out.print("0 ");
                        }
                    }
                }
                System.out.println("\n----------------------------------------");
            }
        };
        checker.start();
    }

    public static void gameProcess(){

        AnimationTimer enemyHandler = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(int i=0;i<Levels.enemyWave.size();i++){
                    for(int j=0;j<Levels.enemyWave.get(i).getSoldierGroup().size();j++){
                        EnemySoldier enemySoldier = Levels.enemyWave.get(i).getSoldierGroup().get(j);
                        if(enemySoldier.getHealth()<=0){
                            Levels.enemyWave.get(i).getSoldierGroup().remove(j);
                            if(enemySoldier.getTarget().getClass().equals(AllySoldier.class)){
                                AllySoldier target = (AllySoldier) enemySoldier.getTarget();
                                target.setAttacked(false);
                            }
                            continue;
                        }
                        if(enemySoldier.isAttacking() && enemySoldier.getHealth()>0 && enemySoldier.getTarget() != null){
                            enemySoldier.getTarget().setHealth(enemySoldier.getTarget().getHealth() - enemySoldier.getDamage());
                        }
                    }
                }
            }
        };
        enemyHandler.start();

        AnimationTimer allyHandler = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(int i=0;i<8;i++){
                    if(Player.getSingleInstance().getPlayerStack()[i] != null){
                        AllySoldier allySoldier = Player.getSingleInstance().getPlayerStack()[i];
                        if(allySoldier.getHealth()<=0){
                            Main.root.getChildren().remove(allySoldier.getModel());
                            allySoldier.setAlive(false);
                            if(allySoldier.getTarget().getClass().equals(EnemySoldier.class)){
                                EnemySoldier target = (EnemySoldier) allySoldier.getTarget();
                                target.setAttacked(false);
                            }
                            continue;
                        }
                        if(allySoldier.isAttacking() && allySoldier.isAttacking() && allySoldier.getTarget() != null){
                            allySoldier.getTarget().setHealth(allySoldier.getTarget().getHealth() - allySoldier.getDamage());
                        }
                    }
                }
            }
        };
        allyHandler.start();
    }
}
