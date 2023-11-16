package models;

public class Voliere extends Enclos{


    public Voliere(String nom, double supperficie, int nbCreatureMax, int nbCreaturePresente, Proprete propreteDegre) {
        super(nom, supperficie, nbCreatureMax, nbCreaturePresente, propreteDegre);
    }

    @Override
    public void entretient(){
        entretientToit();
        super.entretient();
    }

    private void entretientToit(){

    }
}
