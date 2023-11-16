package models;

import java.util.ArrayList;

public class Enclos {

    private String nom;
    private double supperficie;
    private int nbCreatureMax;
    private int nbCreaturePresente;
    private Proprete propreteDegre;
    private ArrayList<Creature> creaturesPresentes;


    public Enclos(String nom, double supperficie, int nbCreatureMax, int nbCreaturePresente, Proprete propreteDegre) {
        this.nom = nom;
        this.supperficie = supperficie;
        this.nbCreatureMax = nbCreatureMax;
        this.nbCreaturePresente = nbCreaturePresente;
        this.propreteDegre = propreteDegre;
        creaturesPresentes = new ArrayList<Creature>();
    }

    @Override
    public String toString() {
        return "Enclos{" +
                "nom='" + nom + '\'' +
                ", supperficie=" + supperficie +
                ", nbCreatureMax=" + nbCreatureMax +
                ", nbCreaturePresente=" + nbCreaturePresente +
                ", propreteDegre=" + propreteDegre +
                '}';
    }

    public void addCreature(Creature creature){
        creaturesPresentes.add(creature);
    }

    public void removeCreature(Creature creature){
        creaturesPresentes.remove(creature);
    }

    public void feedCreature(){
        // TODO Feed all creature
    }

    public void entretient(){
        if(creaturesPresentes.isEmpty() && propreteDegre.equals(Proprete.MAUVAIS)){
            propreteDegre = Proprete.BON;
        }
    }

}


