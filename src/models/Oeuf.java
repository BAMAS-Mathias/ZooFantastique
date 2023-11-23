package models;

import models.creatures.ovipares.Dragon;
import models.creatures.ovipares.Kraken;
import models.creatures.ovipares.Megalodon;
import models.creatures.ovipares.Phoenix;

import java.util.Random;

public class Oeuf {

    private static int nbEgg = 0;
    private long hatchingTime;

    private Ovipare mere;
    private Sexe sexe;
    Random random = new Random();

    public Oeuf(Ovipare mere){
        nbEgg++;
        this.mere = mere;
        if(random.nextInt(0, 1) == 1){
            sexe = Sexe.MALE;
        } else {
            sexe = Sexe.FEMELLE;
        }
    }

    public static int getNbEgg() {
        return nbEgg;
    }

    public static void setNbEgg(int value) {
        nbEgg = value;
    }

    public Ovipare getMere() {
        return mere;
    }

    public Ovipare hatch() {
        if(mere.getEggList().contains(this)) {
            mere.getEggList().remove(this);
            if(mere instanceof Dragon){
                return new Dragon();
            } else if (mere instanceof Kraken){
                return new Kraken();
            } else if (mere instanceof Megalodon) {
                return new Megalodon();
            } else {
                return new Phoenix();
            }
        } else {
            return null;
        }
    }
}
