package ir.ac.kntu.gamePlay;

import ir.ac.kntu.graghic.Main;
import ir.ac.kntu.units.Soldier;
import ir.ac.kntu.units.enemis.*;
import ir.ac.kntu.units.items.Container;
import ir.ac.kntu.units.items.Item;
import ir.ac.kntu.units.items.Truck;
import ir.ac.kntu.units.items.Van;

import java.util.LinkedList;

public class Levels {

    public static LinkedList<EnemyGroup> enemyWave = new LinkedList<>();
    public static LinkedList<Item> items = new LinkedList<>();

    public static void spawnItemsLvl1(){
        items.clear();
        Container container = Container.getSingleInstance();
        container.getModel().setX(960);
        container.getModel().setY(120);
        items.add(container);
        Van van = Van.getSingleInstance();
        van.getModel().setX(960);
        van.getModel().setY(400);
        items.add(van);
        Main.root.getChildren().remove(container.getModel());
        Main.root.getChildren().remove(van.getModel());
        Main.root.getChildren().add(container.getModel());
        Main.root.getChildren().add(van.getModel());
    }

    public static void lvl1Round1(){
        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers1= new LinkedList<>();
        spawnEnemy(soldiers1,1,2,12,40,50);
        EnemyGroup group1 = new EnemyGroup(soldiers1);
        enemyWave.addLast(group1);

    }

    public static void lvl1Round2(){
        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers1= new LinkedList<>();
        spawnEnemy(soldiers1,3,3,5,40,100);
        EnemyGroup group1 = new EnemyGroup(soldiers1);
        enemyWave.addLast(group1);
    }

    public static void lvl1Round3(){
        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers1= new LinkedList<>();
        spawnEnemy(soldiers1,1,2,5,40,100);
        EnemyGroup group1 = new EnemyGroup(soldiers1);
        enemyWave.addLast(group1);

        LinkedList<EnemySoldier> soldiers2= new LinkedList<>();
        spawnEnemy(soldiers2,3,2,7,70,300);
        EnemyGroup group2 = new EnemyGroup(soldiers2);
        enemyWave.addLast(group2);
    }

    public static void lvl1Round4(){
        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers1= new LinkedList<>();
        spawnEnemy(soldiers1,1,2,2,40,100);
        EnemyGroup group1 = new EnemyGroup(soldiers1);
        enemyWave.addLast(group1);

        LinkedList<EnemySoldier> soldiers2= new LinkedList<>();
        spawnEnemy(soldiers2,3,2,3,70,200);
        EnemyGroup group2 = new EnemyGroup(soldiers2);
        enemyWave.addLast(group2);

        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers3= new LinkedList<>();
        spawnEnemy(soldiers3,2,2,2,40,400);
        EnemyGroup group3 = new EnemyGroup(soldiers3);
        enemyWave.addLast(group3);

    }

    public static void lvl1Round5(){
        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers1= new LinkedList<>();
        spawnEnemy(soldiers1,2,2,5,70,50);
        EnemyGroup group1 = new EnemyGroup(soldiers1);
        enemyWave.addLast(group1);

        LinkedList<EnemySoldier> soldiers2= new LinkedList<>();
        spawnEnemy(soldiers2,3,2,5,70,300);
        EnemyGroup group2 = new EnemyGroup(soldiers2);
        enemyWave.addLast(group2);
    }

    public static void lvl1Round6(){
        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers1= new LinkedList<>();
        spawnEnemy(soldiers1,1,1,8,40,100);
        EnemyGroup group1 = new EnemyGroup(soldiers1);
        enemyWave.addLast(group1);

        LinkedList<EnemySoldier> soldiers2= new LinkedList<>();
        spawnEnemy(soldiers2,3,1,5,100,120);
        EnemyGroup group2 = new EnemyGroup(soldiers2);
        enemyWave.addLast(group2);

        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers3= new LinkedList<>();
        spawnEnemy(soldiers3,4,1,2,200,200);
        EnemyGroup group3 = new EnemyGroup(soldiers3);
        enemyWave.addLast(group3);

    }

    public static void lvl1Round7(){
        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers1= new LinkedList<>();
        spawnEnemy(soldiers1,2,1,10,40,100);
        EnemyGroup group1 = new EnemyGroup(soldiers1);
        enemyWave.addLast(group1);

        LinkedList<EnemySoldier> soldiers2= new LinkedList<>();
        spawnEnemy(soldiers2,4,1,3,100,250);
        EnemyGroup group2 = new EnemyGroup(soldiers2);
        enemyWave.addLast(group2);
    }

    public static void lvl1Round8(){
        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers1= new LinkedList<>();
        spawnEnemy(soldiers1,1,2,5,40,100);
        EnemyGroup group1 = new EnemyGroup(soldiers1);
        enemyWave.addLast(group1);
    }


    public static void spawnItemsLvl2(){
        items.clear();
        Truck truck = Truck.getSingleInstance();
        truck.getModel().setX(960);
        truck.getModel().setY(120);
        items.add(truck);
        Van van = Van.getSingleInstance();
        van.getModel().setX(960);
        van.getModel().setY(400);
        items.add(van);
        Main.root.getChildren().remove(truck.getModel());
        Main.root.getChildren().remove(van.getModel());
        Main.root.getChildren().add(truck.getModel());
        Main.root.getChildren().add(van.getModel());
    }

    public static void lvl2Round1(){
        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers1= new LinkedList<>();
        spawnEnemy(soldiers1,1,2,12,40,50);
        EnemyGroup group1 = new EnemyGroup(soldiers1);
        enemyWave.addLast(group1);

    }

    public static void lvl2Round2(){
        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers1= new LinkedList<>();
        spawnEnemy(soldiers1,3,3,5,40,100);
        EnemyGroup group1 = new EnemyGroup(soldiers1);
        enemyWave.addLast(group1);
    }

    public static void lvl2Round3(){
        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers1= new LinkedList<>();
        spawnEnemy(soldiers1,1,2,5,40,100);
        EnemyGroup group1 = new EnemyGroup(soldiers1);
        enemyWave.addLast(group1);

        LinkedList<EnemySoldier> soldiers2= new LinkedList<>();
        spawnEnemy(soldiers2,3,2,7,70,300);
        EnemyGroup group2 = new EnemyGroup(soldiers2);
        enemyWave.addLast(group2);
    }

    public static void lvl2Round4(){
        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers1= new LinkedList<>();
        spawnEnemy(soldiers1,1,2,2,40,100);
        EnemyGroup group1 = new EnemyGroup(soldiers1);
        enemyWave.addLast(group1);

        LinkedList<EnemySoldier> soldiers2= new LinkedList<>();
        spawnEnemy(soldiers2,3,2,3,70,200);
        EnemyGroup group2 = new EnemyGroup(soldiers2);
        enemyWave.addLast(group2);

        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers3= new LinkedList<>();
        spawnEnemy(soldiers3,2,2,2,40,400);
        EnemyGroup group3 = new EnemyGroup(soldiers3);
        enemyWave.addLast(group3);

    }

    public static void lvl2Round5(){
        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers1= new LinkedList<>();
        spawnEnemy(soldiers1,2,2,5,70,50);
        EnemyGroup group1 = new EnemyGroup(soldiers1);
        enemyWave.addLast(group1);

        LinkedList<EnemySoldier> soldiers2= new LinkedList<>();
        spawnEnemy(soldiers2,3,2,5,70,300);
        EnemyGroup group2 = new EnemyGroup(soldiers2);
        enemyWave.addLast(group2);
    }

    public static void lvl2Round6(){
        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers1= new LinkedList<>();
        spawnEnemy(soldiers1,1,1,8,40,100);
        EnemyGroup group1 = new EnemyGroup(soldiers1);
        enemyWave.addLast(group1);

        LinkedList<EnemySoldier> soldiers2= new LinkedList<>();
        spawnEnemy(soldiers2,3,1,5,100,120);
        EnemyGroup group2 = new EnemyGroup(soldiers2);
        enemyWave.addLast(group2);

        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers3= new LinkedList<>();
        spawnEnemy(soldiers3,4,1,2,200,200);
        EnemyGroup group3 = new EnemyGroup(soldiers3);
        enemyWave.addLast(group3);

    }

    public static void lvl2Round7(){
        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers1= new LinkedList<>();
        spawnEnemy(soldiers1,2,1,10,40,100);
        EnemyGroup group1 = new EnemyGroup(soldiers1);
        enemyWave.addLast(group1);

        LinkedList<EnemySoldier> soldiers2= new LinkedList<>();
        spawnEnemy(soldiers2,4,1,3,100,250);
        EnemyGroup group2 = new EnemyGroup(soldiers2);
        enemyWave.addLast(group2);
    }

    public static void lvl2Round8(){
        enemyWave.clear();
        LinkedList<EnemySoldier> soldiers1= new LinkedList<>();
        spawnEnemy(soldiers1,1,2,5,40,100);
        EnemyGroup group1 = new EnemyGroup(soldiers1);
        enemyWave.addLast(group1);
    }

    public static void spawnEnemy(LinkedList<EnemySoldier> soldiers,int type,int width,int length,int initX,int initY){
        for(int i=0;i<width;i++){
            for(int j=0;j<length;j++){
                EnemySoldier soldier = new EnemySoldier();
                switch (type){
                    case 1:
                        soldier = new RedSoldier();
                        break;
                    case 2:
                        soldier = new GraySoldier();
                        break;
                    case 3:
                        soldier = new YellowSoldier();
                        break;
                    case 4:
                        soldier = new BossLvl1();
                        break;
                    case 5:
                        soldier = new BossLvl2();
                        break;
                }
                soldier.getModel().setX(initX +(i*40));
                soldier.getModel().setY(initY + (j*35));
                soldiers.add(soldier);
                Main.root.getChildren().add(soldier.getModel());
            }
        }
    }
}
