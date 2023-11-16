package models;

import java.util.ArrayList;

public class ZooFantastique {

    private String nom;
    private MaitreDeZoo proprietaire;
    private int nbMaxEnclos;
    private ArrayList<Enclos> listeDesEnclos;

    @Override
    public String toString() {
        return "ZooFantastique{" +
                "nom='" + nom + '\'' +
                ", proprietaire=" + proprietaire +
                ", nbMaxEnclos=" + nbMaxEnclos +
                ", listeDesEnclos=" + listeDesEnclos +
                '}';
    }

    public void updateZoo(){
        // TODO Update du Zoo
    }
}
