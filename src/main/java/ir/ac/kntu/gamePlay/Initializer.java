package ir.ac.kntu.gamePlay;

import ir.ac.kntu.graghic.Main;
import ir.ac.kntu.units.allies.*;

import java.util.LinkedList;

public class Initializer {

    public static LinkedList<AllySoldier> heroes = new LinkedList<>();

    public static void Initialize(){

        heroes.add(DaigoDojima.getSingleInstance());
        heroes.add(GoroMajima.getSingleInstance());
        heroes.add(JiroKawara.getSingleInstance());
        heroes.add(FutoshiShimano.getSingleInstance());
        heroes.add(KaoruSayama.getSingleInstance());
        heroes.add(MakotoDate.getSingleInstance());
        heroes.add(OsamuKashiwagi.getSingleInstance());
        heroes.add(RyoTakashima.getSingleInstance());
        heroes.add(RyujiGoda.getSingleInstance());
        heroes.add(ShintaroKazama.getSingleInstance());
        heroes.add(SoheiDojima.getSingleInstance());
        heroes.add(TaigaSaejima.getSingleInstance());

        Player.getSingleInstance().getPlayerStack()[0]= JiroKawara.getSingleInstance();
        Player.getSingleInstance().getPlayerStack()[1]= RyoTakashima.getSingleInstance();
        Player.getSingleInstance().getPlayerStack()[2]= OsamuKashiwagi.getSingleInstance();
        Player.getSingleInstance().getPlayerStack()[3]= MakotoDate.getSingleInstance();
    }

    public static void mainMenu(){
        Main.missionButton.setVisible(true);
        Main.organizationButton.setVisible(true);
        Main.trainButton.setVisible(true);
        Main.fortifyHQButton.setVisible(true);
        Main.exitButton.setVisible(true);
    }
}
