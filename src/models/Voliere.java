package models;

public class Voliere extends Enclos{


    public Voliere(String nom, double supperficie, int nbCreatureMax) {
        super(nom, supperficie, nbCreatureMax );
    }

    @Override
    public void entretient(){
        entretientToit();
        super.entretient();
    }

    private void entretientToit(){

    }
}
