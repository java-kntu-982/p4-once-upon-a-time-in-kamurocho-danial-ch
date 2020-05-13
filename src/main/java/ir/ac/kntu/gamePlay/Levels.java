package ir.ac.kntu.gamePlay;

import ir.ac.kntu.graghic.Main;
import ir.ac.kntu.units.Soldier;
import ir.ac.kntu.units.enemis.EnemyGroup;
import ir.ac.kntu.units.enemis.EnemySoldier;
import ir.ac.kntu.units.enemis.RedSoldier;
import ir.ac.kntu.units.enemis.YellowSoldier;
import ir.ac.kntu.units.items.Container;
import ir.ac.kntu.units.items.Item;
import ir.ac.kntu.units.items.Van;

import java.util.LinkedList;

public class Levels {

    public static LinkedList<EnemyGroup> enemyWave = new LinkedList<>();
    public static LinkedList<Item> items = new LinkedList<>();

    public static void spawnItemsLvl1(){
        Container container = Container.getSingleInstance();
        container.getModel().setX(960);
        container.getModel().setY(120);
        items.add(container);
        Van van = Van.getSingleInstance();
        van.getModel().setX(960);
        van.getModel().setY(400);
        items.add(van);
        Main.root.getChildren().add(container.getModel());
        Main.root.getChildren().add(van.getModel());
    }

    public static void lvl1Round1(){
        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers1= new LinkedList<>();
        for(int i=0;i<5;i++){
            for(int j=0;j<2;j++){
                RedSoldier soldier = new RedSoldier();
                soldier.getModel().setX(40+(20*j));
                soldier.getModel().setY(30 + (15*i));
                soldiers1.add(soldier);
                Main.root.getChildren().add(soldier.getModel());
            }
        }
        EnemyGroup group1 = new EnemyGroup(soldiers1);
        enemyWave.add(group1);

        LinkedList<EnemySoldier> soldiers2= new LinkedList<>();
        for(int i=0;i<7;i++){
            for(int j=0;j<2;j++){
                YellowSoldier soldier = new YellowSoldier();
                soldier.getModel().setX(60+(20*j));
                soldier.getModel().setY(200 + (20*i));
                soldiers1.add(soldier);
                Main.root.getChildren().add(soldier.getModel());
            }
        }
        EnemyGroup group2 = new EnemyGroup(soldiers2);
        enemyWave.add(group2);
    }

    public static void lvl1Round2(){

    }

    public static void lvl1Round3(){

    }

    public static void lvl1Round4(){

    }

    public static void lvl1Round5(){

    }

    public static void lvl1Round6(){

    }

    public static void lvl1Round7(){

    }

    public static void lvl1Round8(){

    }

}
