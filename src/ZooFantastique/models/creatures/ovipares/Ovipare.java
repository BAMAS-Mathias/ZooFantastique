package ZooFantastique.models.creatures.ovipares;

import ZooFantastique.models.creatures.Creature;
import ZooFantastique.models.enclos.Enclos;

import java.util.ArrayList;

public abstract class Ovipare extends Creature {

    private int gestatingTime;
    public static int nbOvipare = 0;

    public Ovipare(String nom, Enclos enclos, String sonEmit) {
        super(nom, enclos, sonEmit);
    }

    public int getGestatingTime(){
        return gestatingTime;
    }

    public void setGestatingTime(int value) {
        gestatingTime = value;
    }

    public Oeuf lay(){
        return new Oeuf("Oeuf",this.getEnclos(),"rrrrr",this);
    }
}
