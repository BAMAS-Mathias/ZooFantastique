package ZooFantastique.models.creatures.vivipares;

import ZooFantastique.models.creatures.Creature;
import ZooFantastique.models.creatures.CreatureFactory;
import ZooFantastique.models.enclos.Enclos;

import java.util.ArrayList;

public abstract class Vivipare extends Creature {

    private ArrayList<Vivipare> listBabies = new ArrayList<>();
    private boolean isReadyToGiveBirth = false;
    private int gestatingTime;

    public Vivipare(String nom, Enclos enclos, String sonEmit) {
        super(nom, enclos, sonEmit);
    }

    public Vivipare(String nom, String sonEmit) {
        super(nom, sonEmit);
    }

    public int getGestatingTime(){
        return gestatingTime;
    }


    public void setGestatingTime(int value) {
        gestatingTime = value;
    }

    public boolean isReadyToGiveBirth(boolean state) {
        return isReadyToGiveBirth == state;
    }

    public void setIsReadyToGivebirth(boolean state) {
        isReadyToGiveBirth = state;
    }

    public void giveBirth(){
        Creature baby = new CreatureFactory().createCreature(this.getNom(), this.getEnclos());
    }

}
