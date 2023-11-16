package models;

public abstract class Creature {

    private String nom;
    private Sexe sexe;
    private double poids;
    private double taille;
    private Age age;
    private boolean isHungry;
    private boolean isSleeping;
    private double sante;

    public abstract void manger();
    public abstract void emettreSon();
    public abstract void soin();
    public abstract void wakeUpOrSleep();
    public abstract void vieillir();

}
