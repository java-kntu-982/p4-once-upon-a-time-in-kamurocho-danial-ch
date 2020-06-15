package ir.ac.kntu.gamePlay;

import ir.ac.kntu.graghic.Design;
import ir.ac.kntu.graghic.EventHandling;
import ir.ac.kntu.graghic.Main;
import ir.ac.kntu.units.Unit;
import ir.ac.kntu.units.allies.*;
import ir.ac.kntu.units.enemis.EnemyGroup;
import ir.ac.kntu.units.enemis.EnemySoldier;
import ir.ac.kntu.units.items.Container;
import ir.ac.kntu.units.items.Item;
import ir.ac.kntu.units.items.Truck;
import ir.ac.kntu.units.items.Van;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mission {

    public static int chosenTarget = 0;
    public static AnimationTimer toolBarLighten;
    public static final double V=0.3;
    public static final double K=30;
    public static final double M=60;
    public static final double A=0.005;
    static AnimationTimer targetChooser;
    static AnimationTimer enemyMovement;
    static AnimationTimer allyMovement;
    static AnimationTimer unitHandler;
    static AnimationTimer checkIfEnemyIsAttacking;
    static AnimationTimer checkGameEnd;

    public static void preparation(int lvlNumber,int roundNumber){

        if(roundNumber == 1){

            Main.inGameBg.setVisible(true);
            Main.menuBg.setVisible(false);
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

        }

        Main.scene.addEventHandler(KeyEvent.KEY_PRESSED,keyEvent -> {
            if(keyEvent.getCode()== KeyCode.SPACE){
                levelChooser(lvlNumber,roundNumber);
            }
        });
    }

    public static void levelChooser(int lvlNumber,int roundNumber){
        System.out.println(roundNumber);
        if(roundNumber>1){
            Player.getSingleInstance().setMoney(Player.getSingleInstance().getMoney()+100);
        }
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
            Levels.spawnItemsLvl2();
            switch (roundNumber){
                case 1:
                    Levels.lvl2Round1();
                    break;
                case 2:
                    Levels.lvl2Round2();
                    break;
                case 3:
                    Levels.lvl2Round3();
                    break;
                case 4:
                    Levels.lvl2Round4();
                    break;
                case 5:
                    Levels.lvl2Round5();
                    break;
                case 6:
                    Levels.lvl2Round6();
                    break;
                case 7:
                    Levels.lvl2Round7();
                    break;
                case 8:
                    Levels.lvl2Round8();
                    break;
            }
        }
        startRound(lvlNumber,roundNumber);
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

    public static boolean checkEnemyTarget(EnemySoldier enemySoldier){
        if(enemySoldier.getTarget() != null){
            return enemySoldier.getTarget().getClass().equals(ShintaroKazama.class) ||
                    enemySoldier.getTarget().getClass().equals(DaigoDojima.class) ||
                    enemySoldier.getTarget().getClass().equals(FutoshiShimano.class) ||
                    enemySoldier.getTarget().getClass().equals(GoroMajima.class) ||
                    enemySoldier.getTarget().getClass().equals(JiroKawara.class) ||
                    enemySoldier.getTarget().getClass().equals(KaoruSayama.class) ||
                    enemySoldier.getTarget().getClass().equals(MakotoDate.class) ||
                    enemySoldier.getTarget().getClass().equals(OsamuKashiwagi.class) ||
                    enemySoldier.getTarget().getClass().equals(RyoTakashima.class) ||
                    enemySoldier.getTarget().getClass().equals(RyujiGoda.class) ||
                    enemySoldier.getTarget().getClass().equals(SoheiDojima.class) ||
                    enemySoldier.getTarget().getClass().equals(TaigaSaejima.class);

        }
        return false;
    }

    public static boolean checkEnemyTargetItem(EnemySoldier enemySoldier){
        if(enemySoldier.getTarget() != null){
            return enemySoldier.getTarget().getClass().equals(Container.class) ||
                    enemySoldier.getTarget().getClass().equals(Truck.class) ||
                    enemySoldier.getTarget().getClass().equals(Van.class);

        }
        return false;
    }

    public static void startRound(int lvlNumber,int roundNumber){
        soldierTargetChooser();
        soldierMovement();
        checkIfEnemyIsAttacking();
        gameProcess();
        checkEndRound(lvlNumber,roundNumber);
    }

    public static void soldierTargetChooser(){

        targetChooser = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(int i=0;i<8;i++){
                    if(Player.getSingleInstance().getPlayerStack()[i] != null && Player.getSingleInstance().getPlayerStack()[i].getTarget() != null){
                        AllySoldier soldier = Player.getSingleInstance().getPlayerStack()[i];
                        System.out.print(soldier.getClass().getSimpleName() + "/ is attacking " + soldier.isAttacking()+ "/ is attacked " + soldier.isAttacked() + "/ health" + soldier.getHealth());
                        if(soldier.getTarget() != null){
                            System.out.println(" and has target");
                        } else {
                            System.out.println(" and doesn't have target");
                        }
                    }

                }
                allyTargetChooser();
                enemyTargetChooser();
                checkIfMemberIsAttacked();
            }
        };
        targetChooser.start();

    }

    public static void allyTargetChooser(){
        for(int i=0;i<8;i++){
            if(Player.getSingleInstance().getPlayerStack()[i] != null){
                AllySoldier soldier = Player.getSingleInstance().getPlayerStack()[i];
                if(!soldier.isAttacking() && soldier.isAlive() && soldier.getTarget() == null){
                    for(int j=0;j<Levels.enemyWave.size();j++){
                        for(int k=0;k<Levels.enemyWave.get(j).getSoldierGroup().size();k++){
                            EnemySoldier enemySoldier = Levels.enemyWave.get(j).getSoldierGroup().get(k);
                            if(soldier.getFieldOfView()*M >= Math.sqrt(
                                    (Math.pow(soldier.getModel().getCenterX()-enemySoldier.getModel().getX(),2))+
                                            (Math.pow(soldier.getModel().getCenterY()-enemySoldier.getModel().getY(),2)))){
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

    public static void enemyTargetChooser(){
        for(int i=0;i<Levels.enemyWave.size();i++){
            for(int j=0;j<Levels.enemyWave.get(i).getSoldierGroup().size();j++){
                if(!Levels.enemyWave.get(i).getSoldierGroup().get(j).isAttacked()){
                    if(Levels.enemyWave.get(i).getSoldierGroup().get(j).getTarget()==null){
                        Levels.enemyWave.get(i).getSoldierGroup().get(j).setAttacking(false);
                        Rectangle soldier = Levels.enemyWave.get(i).getSoldierGroup().get(j).getModel();
                        if(Levels.items.size()==2){
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
                        else if(Levels.items.size()==1){
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

    public static void checkIfMemberIsAttacked(){
        for(int i=0;i<Levels.enemyWave.size();i++){
            for(int j=0;j<Levels.enemyWave.get(i).getSoldierGroup().size();j++){
                if(checkEnemyTarget(Levels.enemyWave.get(i).getSoldierGroup().get(j))){
                    changeGroupTarget(Levels.enemyWave.get(i),(AllySoldier)Levels.enemyWave.get(i).getSoldierGroup().get(j).getTarget());
                    return;
                }
            }
        }
    }

    public static void changeGroupTarget(EnemyGroup group, AllySoldier target){
        for(int i=0;i<group.getSoldierGroup().size();i++){
            group.getSoldierGroup().get(i).setTarget(target);
        }
    }

    public static void soldierMovement(){

        enemyMovement = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(int i=0;i<Levels.enemyWave.size();i++){
                    for(int j=0;j<Levels.enemyWave.get(i).getSoldierGroup().size();j++){
                        EnemySoldier soldier =Levels.enemyWave.get(i).getSoldierGroup().get(j);
                        if(!soldier.isAttacking()){
                            if(checkEnemyTargetItem(soldier)){
                                Item item = (Item)(soldier.getTarget());
                                if(soldier.getAttackRange()*K>=
                                        Math.sqrt((Math.pow(soldier.getModel().getX()-item.getModel().getX(),2))+
                                        (Math.pow(soldier.getModel().getY()-item.getModel().getY(),2)))){
                                    soldier.setAttacking(true);
                                    continue;
                                }
                                double deltaX = item.getModel().getX() - soldier.getModel().getX();
                                double deltaY = item.getModel().getY() - soldier.getModel().getY();
                                double angle = Math.atan(deltaX/deltaY);
                                if(soldier.getModel().getY()>item.getModel().getY()){
                                    soldier.getModel().setX(soldier.getModel().getX() - V*soldier.getSpeed()*Math.sin(angle));
                                    soldier.getModel().setY(soldier.getModel().getY() - V*soldier.getSpeed()*Math.cos(angle));
                                } else{
                                    soldier.getModel().setX(soldier.getModel().getX() + V*soldier.getSpeed()*Math.sin(angle));
                                    soldier.getModel().setY(soldier.getModel().getY() + V*soldier.getSpeed()*Math.cos(angle));
                                }

                            } else if(checkEnemyTarget(soldier)){
                                AllySoldier allySoldier =(AllySoldier)soldier.getTarget();
                                if(soldier.getAttackRange()*K<
                                        Math.sqrt((Math.pow(soldier.getModel().getX()-allySoldier.getModel().getCenterX(),2))+
                                                (Math.pow(soldier.getModel().getY()-allySoldier.getModel().getCenterY(),2)))){
                                    double deltaX = allySoldier.getModel().getCenterX() - soldier.getModel().getX();
                                    double deltaY = allySoldier.getModel().getCenterY() - soldier.getModel().getY();
                                    double angle = Math.atan(deltaX/deltaY);
                                    if(soldier.getModel().getY()>allySoldier.getModel().getCenterY()){
                                        soldier.getModel().setX(soldier.getModel().getX() - V*soldier.getSpeed()*Math.sin(angle));
                                        soldier.getModel().setY(soldier.getModel().getY() - V*soldier.getSpeed()*Math.cos(angle));
                                    } else{
                                        soldier.getModel().setX(soldier.getModel().getX() + V*soldier.getSpeed()*Math.sin(angle));
                                        soldier.getModel().setY(soldier.getModel().getY() + V*soldier.getSpeed()*Math.cos(angle));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        };
        enemyMovement.start();


        allyMovement = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(int i=0;i<8;i++){
                    if(Player.getSingleInstance().getPlayerStack()[i] != null){
                        AllySoldier soldier = Player.getSingleInstance().getPlayerStack()[i];
                        if(soldier.getTarget() != null && soldier.isAlive()){
                            if(!soldier.isAttacking()){
                                EnemySoldier target = (EnemySoldier) soldier.getTarget();
                                if(soldier.getAttackRange()*K>= Math.sqrt((Math.pow(soldier.getModel().getCenterX()-target.getModel().getX(),2)+(Math.pow(soldier.getModel().getCenterY()-target.getModel().getY(),2))))){
                                    System.out.println("1");
                                    soldier.setAttacking(true);
                                    for(int j=0;j<Levels.enemyWave.size();j++){
                                        for(int k=0;k<Levels.enemyWave.get(j).getSoldierGroup().size();k++){
                                            if(Levels.enemyWave.get(j).getSoldierGroup().get(k).equals(target)){
                                                target.setAttacked(true);
                                            }
                                        }
                                    }
                                }
                                else{
                                    double deltaX = target.getModel().getX() - soldier.getModel().getCenterX();
                                    double deltaY = target.getModel().getY() - soldier.getModel().getCenterY();
                                    double angle = Math.atan(deltaX/deltaY);
                                    if(soldier.getModel().getCenterY()>target.getModel().getY()){
                                        soldier.getModel().setCenterX(soldier.getModel().getCenterX() - V*soldier.getSpeed()*Math.sin(angle));
                                        soldier.getModel().setCenterY(soldier.getModel().getCenterY() - V*soldier.getSpeed()*Math.cos(angle));
                                    } else{
                                        soldier.getModel().setCenterX(soldier.getModel().getCenterX() + V*soldier.getSpeed()*Math.sin(angle));
                                        soldier.getModel().setCenterY(soldier.getModel().getCenterY() + V*soldier.getSpeed()*Math.cos(angle));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        };
        allyMovement.start();

    }

    public static void allyHandler(){
        for(int i=0;i<8;i++){
            if(Player.getSingleInstance().getPlayerStack()[i] != null){
                AllySoldier allySoldier = Player.getSingleInstance().getPlayerStack()[i];
                if(allySoldier.getHealth()<=0){
                    Main.root.getChildren().remove(allySoldier.getModel());
                    OrganizeSoldier.shiftHeroesInStack(i);
                    allySoldier.setAlive(false);
                    if(allySoldier.getTarget() != null){
                        EnemySoldier target = (EnemySoldier) allySoldier.getTarget();
                        target.setAttacked(false);
                        target.setAttacking(false);
                        target.setTarget(null);
                    }
                    continue;
                }
                if(allySoldier.isAttacking() && allySoldier.getTarget() != null){
                    allySoldier.getTarget().setHealth((int) (allySoldier.getTarget().getHealth() - A*allySoldier.getDamage()));
                }
            }
        }
    }

    public static void enemyHandler(){
        for(int i=0;i<Levels.enemyWave.size();i++){
            for(int j=0;j<Levels.enemyWave.get(i).getSoldierGroup().size();j++){
                EnemySoldier enemySoldier = Levels.enemyWave.get(i).getSoldierGroup().get(j);
                if(enemySoldier.getHealth()<=0){
                    Main.root.getChildren().remove(enemySoldier.getModel());
                    Levels.enemyWave.get(i).getSoldierGroup().remove(j);
                    if(checkEnemyTarget(enemySoldier)){
                        AllySoldier target = (AllySoldier) enemySoldier.getTarget();
                        target.setAttacked(false);
                        target.setAttacking(false);
                        target.setTarget(null);
                    }
                    continue;
                }
                if(enemySoldier.isAttacking() && enemySoldier.getHealth()>0 && enemySoldier.getTarget() != null){
                    if(checkEnemyTarget(enemySoldier)){
                        enemySoldier.getTarget().setHealth((int) (enemySoldier.getTarget().getHealth() - 0.05*A*enemySoldier.getDamage()));
                    }
                    else {
                        enemySoldier.getTarget().setHealth((int) (enemySoldier.getTarget().getHealth() - 0.1*A*enemySoldier.getDamage()));
                    }

                }
            }
        }
    }

    public static void itemHandler(){
        for(int i=0;i<Levels.items.size();i++){
            if(Levels.items.get(i).getHealth()<=0){
                Main.root.getChildren().remove(Levels.items.get(i).getModel());
                Levels.items.remove(i);
            }
        }
    }

    public static void gameProcess(){

        unitHandler = new AnimationTimer() {
            @Override
            public void handle(long l) {
                allyHandler();
                enemyHandler();
                itemHandler();
            }
        };
        unitHandler.start();
    }

    public static void checkIfEnemyIsAttacking(){

        checkIfEnemyIsAttacking = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(int i=0;i<Levels.enemyWave.size();i++) {
                    for (int j = 0; j < Levels.enemyWave.get(i).getSoldierGroup().size(); j++) {
                        EnemySoldier enemySoldier = Levels.enemyWave.get(i).getSoldierGroup().get(j);
                        if (enemySoldier.getTarget() != null && enemySoldier.getTarget().getHealth() <= 0) {
                            enemySoldier.setTarget(null);
                            enemySoldier.setAttacked(false);
                            enemySoldier.setAttacking(false);
                        }
                        if (enemySoldier.getTarget() != null) {
                            if (checkEnemyTarget(enemySoldier)) {
                                if (enemySoldier.getAttackRange() * K >= Math.sqrt(
                                        (Math.pow(enemySoldier.getModel().getX() - ((AllySoldier) enemySoldier.getTarget()).getModel().getCenterX(), 2)) +
                                                (Math.pow(enemySoldier.getModel().getY() - ((AllySoldier) enemySoldier.getTarget()).getModel().getCenterY(), 2)))) {
                                    enemySoldier.setAttacking(true);
                                } else {
                                    enemySoldier.setAttacking(false);
                                }
                            } else {
                                if (enemySoldier.getAttackRange() * K >= Math.sqrt(
                                        (Math.pow(enemySoldier.getModel().getX() - ((Item) enemySoldier.getTarget()).getModel().getX(), 2)) +
                                                (Math.pow(enemySoldier.getModel().getY() - ((Item) enemySoldier.getTarget()).getModel().getY(), 2)))) {
                                    enemySoldier.setAttacking(true);
                                } else {
                                    enemySoldier.setAttacking(false);
                                }
                            }
                        }
                    }
                }

                for(int i=0;i<8;i++){
                    if(Player.getSingleInstance().getPlayerStack()[i] != null && Player.getSingleInstance().getPlayerStack()[i].getTarget() != null){
                        AllySoldier allySoldier = Player.getSingleInstance().getPlayerStack()[i];
                        allySoldier.setAttacking(false);
                        for(int j=0;j<Levels.enemyWave.size();j++){
                            for(int k=0;k<Levels.enemyWave.get(j).getSoldierGroup().size();k++){
                                EnemySoldier enemySoldier = Levels.enemyWave.get(j).getSoldierGroup().get(k);
                                if(allySoldier.getAttackRange() * K >= Math.sqrt(
                                        (Math.pow(enemySoldier.getModel().getX() - allySoldier.getModel().getCenterX(), 2)) +
                                                (Math.pow(enemySoldier.getModel().getY() - allySoldier.getModel().getCenterY(), 2)))){
                                    allySoldier.setAttacking(true);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        };
        checkIfEnemyIsAttacking.start();

    }


    public static void checkEndRound(int lvlNumber,int roundNumber){

        checkGameEnd = new AnimationTimer() {
            @Override
            public void handle(long l) {
                boolean flagWin=false;
                for(int i=0;i<Levels.enemyWave.size();i++){
                    if(Levels.enemyWave.get(i).getSoldierGroup().size()!=0){
                        flagWin=true;
                        break;
                    }
                }
                if(!flagWin){
                    if(roundNumber<8){
                        int temp = 1 + roundNumber;
                        checkGameEnd.stop();
                        endTimers();
                        levelChooser(lvlNumber,temp);

                    } else {
                        checkGameEnd.stop();
                        if(lvlNumber==1){
                            Player.getSingleInstance().setLvl1Passed(true);
                            Player.getSingleInstance().setMoney(Player.getSingleInstance().getMoney()+300);
                        } else if(lvlNumber ==2){
                            Player.getSingleInstance().setLvl2Passed(true);
                            Player.getSingleInstance().setMoney(Player.getSingleInstance().getMoney()+600);
                        }
                        System.out.println("victory");
                        Text victory = new Text("Victory");
                        Rectangle grayRec = new Rectangle();

                        grayRec.setWidth(Main.scene.getWidth());
                        grayRec.setHeight(Main.scene.getHeight());
                        grayRec.setFill(Color.grayRgb(170));

                        victory.setX(400);
                        victory.setY(250);
                        victory.setFill(Color.GREEN);
                        victory.setFont(Font.font("none", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,50));

                        Main.root.getChildren().add(grayRec);
                        Main.root.getChildren().add(victory);

                        Timeline showLost = new Timeline(new KeyFrame(Duration.ZERO), new KeyFrame(Duration.seconds(3)));
                        showLost.setCycleCount(1);
                        showLost.play();
                        showLost.setOnFinished(actionEvent -> {
                            Main.root.getChildren().remove(grayRec);
                            Main.root.getChildren().remove(victory);
                        });
                        backToMenu();
                    }
                }

                else if(Levels.items.size()==0){
                    checkGameEnd.stop();
                    System.out.println("gg");
                    Text youLost = new Text("You Lost");
                    Rectangle blackRec = new Rectangle();

                    blackRec.setWidth(Main.scene.getWidth());
                    blackRec.setHeight(Main.scene.getHeight());
                    blackRec.setFill(Color.BLACK);

                    youLost.setX(400);
                    youLost.setY(250);
                    youLost.setFill(Color.RED);
                    youLost.setFont(Font.font("none", FontWeight.EXTRA_BOLD, FontPosture.REGULAR,50));

                    Main.root.getChildren().add(blackRec);
                    Main.root.getChildren().add(youLost);

                    Timeline showLost = new Timeline(new KeyFrame(Duration.ZERO), new KeyFrame(Duration.seconds(3)));
                    showLost.setCycleCount(1);
                    showLost.play();
                    showLost.setOnFinished(actionEvent -> {
                        Main.root.getChildren().remove(blackRec);
                        Main.root.getChildren().remove(youLost);
                    });
                    backToMenu();
                }
            }
        };
        checkGameEnd.start();
    }

    public static void endTimers(){
        targetChooser.stop();
        enemyMovement.stop();
        allyMovement.stop();
        unitHandler.stop();
        checkIfEnemyIsAttacking.stop();
    }

    public static void backToMenu(){
        for(int i=0;i<Levels.enemyWave.size();i++){
            for(int j=0;j<Levels.enemyWave.get(i).getSoldierGroup().size();j++){
                Main.root.getChildren().remove(Levels.enemyWave.get(i).getSoldierGroup().get(j).getModel());
            }
        }

        for(int i=0;i<8;i++){
            if(Player.getSingleInstance().getPlayerStack()[i] != null){
                Main.root.getChildren().remove(Player.getSingleInstance().getPlayerStack()[i].getModel());
            }
        }

        for(int i=0;i<Levels.items.size();i++){
            Main.root.getChildren().remove(Levels.items.get(i).getModel());
        }

        Main.root.getChildren().remove(OrganizeSoldier.heroStackRectangle);
        for (Rectangle rectangle:
                OrganizeSoldier.stackHeroes) {
            Main.root.getChildren().remove(rectangle);
        }

        Main.inGameBg.setVisible(false);
        Main.menuBg.setVisible(true);
        Main.missionButton.setVisible(true);
        Main.organizationButton.setVisible(true);
        Main.trainButton.setVisible(true);
        Main.fortifyHQButton.setVisible(true);
        Main.unlockButton.setVisible(true);
        Main.exitButton.setVisible(true);

        Main.mediaPlayer.play();
    }

}
