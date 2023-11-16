package models;

public class Aquarium extends Enclos{

    private double profondeur;
    private double salinite;

    public Aquarium(String nom, double supperficie, int nbCreatureMax, int nbCreaturePresente, Proprete propreteDegre, double profondeur, double salinite) {
        super(nom, supperficie, nbCreatureMax, nbCreaturePresente, propreteDegre);
        this.profondeur = profondeur;
        this.salinite = salinite;
    }


    @Override
    public void entretient(){
        //TODO VERIF PROFONDEUR ET SALINITE
        super.entretient();
    }

}
