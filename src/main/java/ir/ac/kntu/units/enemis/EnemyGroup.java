package ir.ac.kntu.units.enemis;

import java.util.LinkedList;

public class EnemyGroup {

    private LinkedList<EnemySoldier> soldierGroup;

    public EnemyGroup(LinkedList<EnemySoldier> soldierGroup) {
        this.soldierGroup = soldierGroup;
    }

    public LinkedList<EnemySoldier> getSoldierGroup() {
        return soldierGroup;
    }

    public void setSoldierGroup(LinkedList<EnemySoldier> soldierGroup) {
        this.soldierGroup = soldierGroup;
    }
}
