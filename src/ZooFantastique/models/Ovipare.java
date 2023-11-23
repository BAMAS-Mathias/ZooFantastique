package ZooFantastique.models;

import java.util.ArrayList;

public abstract class Ovipare extends Creature{

    private ArrayList<Oeuf> listeOeufCreature = new ArrayList<>();

    public ArrayList<Oeuf> getListeOeufCreature() {
        return listeOeufCreature;
    }

    public abstract Oeuf pondre();
}
