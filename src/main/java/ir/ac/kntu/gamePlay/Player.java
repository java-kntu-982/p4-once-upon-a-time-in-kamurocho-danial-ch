package ir.ac.kntu.gamePlay;

import ir.ac.kntu.units.allies.AllySoldier;

public class Player {

    private int money;
    private boolean lvl1Passed;
    private boolean lvl2Passed;
    private static Player singleInstance = null;
    private AllySoldier[] playerStack = new AllySoldier[8];

    public static Player getSingleInstance() {
        if(singleInstance == null){
            singleInstance = new Player();
        }
        return singleInstance;
    }

    private Player() {
        lvl1Passed=false;
        lvl2Passed=false;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isLvl1Passed() {
        return lvl1Passed;
    }

    public void setLvl1Passed(boolean lvl1Passed) {
        this.lvl1Passed = lvl1Passed;
    }

    public boolean isLvl2Passed() {
        return lvl2Passed;
    }

    public void setLvl2Passed(boolean lvl2Passed) {
        this.lvl2Passed = lvl2Passed;
    }

    public AllySoldier[] getPlayerStack() {
        return playerStack;
    }

    public void setPlayerStack(AllySoldier[] playerStack) {
        this.playerStack = playerStack;
    }
}
