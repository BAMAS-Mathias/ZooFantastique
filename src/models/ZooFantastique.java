package models;

import java.util.ArrayList;

public class ZooFantastique {

    private String nom;
    private MaitreDeZoo proprietaire;
    private int nbMaxEnclos;
    private ArrayList<Enclos> listeDesEnclos;

    public ZooFantastique(int nbMaxEnclos) {
        this.nbMaxEnclos = nbMaxEnclos;
        this.listeDesEnclos = new ArrayList<Enclos>();
    }

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

    public boolean hasName(){
        return nom != null;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Enclos> getListeDesEnclos() {
        return listeDesEnclos;
    }

    public void addEnclos(Enclos enclos){
        listeDesEnclos.add(enclos);
    }
}
