package models;

public abstract class Creature extends Enclos {

    private String nom;
    private Sexe sexe;
    private double poids;
    private double taille;
    private int age;
    private boolean isHungry;
    private boolean isSleeping;

    public abstract void manger();
    public abstract void emettreSon();
    public abstract void soin();
    public abstract void WakeUpOrSleep();
    public abstract void vieillir();
}
