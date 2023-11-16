package models;

public class Aquarium extends Enclos{

    private double profondeur;
    private double salinite;

    public Aquarium(String nom, double supperficie, int nbCreatureMax, double profondeur, double salinite) {
        super(nom, supperficie, nbCreatureMax);
        this.profondeur = profondeur;
        this.salinite = salinite;
    }


    @Override
    public void entretient(){
        //TODO VERIF PROFONDEUR ET SALINITE
        super.entretient();
    }

}
