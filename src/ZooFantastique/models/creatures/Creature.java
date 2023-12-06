package ZooFantastique.models.creatures;

import ZooFantastique.models.Age;
import ZooFantastique.models.Sexe;
import ZooFantastique.models.enclos.Enclos;

import java.util.Random;

/**
 * La classe abstraite {@code Creature} représente une entité vivante générique
 * avec des caractéristiques telles que le nom, le sexe, le poids, la taille, l'âge,
 * la faim, le sommeil, la santé, etc. Elle définit des méthodes pour des actions
 * courantes telles que manger, émettre un son, recevoir des soins, se réveiller ou
 * dormir, et vieillir.
 * <p>
 * @author [Raphael]
 * @version 1.0
 * @see Creature
 * @see Sexe
 * @see Age
 */
public abstract class Creature {

    private static int nbCreature = 0;

    private Etat etat;

    /**
     * Le nom de la créature.
     */
    private String nom;

    /**
     * Le sexe de la créature.
     */
    private Sexe sexe;

    /**
     * Le poids de la créature.
     */
    private double poids;

    /**
     * La taille de la créature.
     */
    private double taille;

    /**
     * L'âge de la créature.
     */
    private Age age;

    /**
     * Indique si la créature a faim.
     */
    private boolean isHungry;

    /**
     * Indique si la créature est endormie.
     */
    private boolean isSleeping;

    private Enclos enclos;

    /**
     * La santé de la créature.
     */
    private double sante;

    private double santeMax;

    private String sonEmit;

    public Creature(String nom, Enclos enclos, String sonEmit){
        this.enclos = enclos;
        this.sonEmit = sonEmit;
        this.nom = nom;
        this.sante = santeMax;
        isSleeping = false;
        isHungry = false;
        age = Age.JEUNE;
        taille = 10;
        poids = 10;
        enclos.addCreature(this);
        etat = Etat.PLEINE_FORME;
        ++nbCreature;

        if(new Random().nextInt(2) == 0) sexe = Sexe.FEMELLE;
        else{
            sexe = Sexe.MALE;
        }

    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    /**
     * Permet à la créature de manger.
     */
    public void nourrir() {
        // Implémentation spécifique pour chaque créature
    }

    /**
     * Permet à la créature d'émettre un son.
     */
    public void emettreSon(){
        System.out.println(sonEmit);
    }


    /**
     * Permet à la créature de recevoir des soins.
     */
    public void soin() {
        // Implémentation spécifique pour chaque créature
    }

    /**
     * Permet à la créature de se réveiller ou de dormir.
     */
    public void wakeUpOrSleep() {
        // Implémentation spécifique pour chaque créature
    }

    /**
     * Permet à la créature de vieillir.
     */
    public void vieillir() {
        if(age == Age.JEUNE){
            age = Age.ADULTE;
        } else if (age == Age.ADULTE){
            age = Age.VIEUX;
        }
    }

    public boolean isDead() {
        return sante == 0;
    }

    public Age getAge() {
        return age;
    }

    public String getNom() {
        return nom;
    }

    public String getSonEmit(){
        return sonEmit;
    }

    public Enclos getEnclos(){
        return enclos;
    }

    public double getSante(){
        return sante;
    }

    public double getSanteMax(){
        return santeMax;
    }

    public void heal(){
        sante = santeMax;
    }

    public String getNomEspece(){
        return nom;
    }

    public void setEnclos(Enclos enclos){
        this.enclos = enclos;
    }

    public void feed(){
        isHungry = false;
    }

    public static int getNbCreature() {
        return nbCreature;
    }


    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public void setSante(double sante) {
        this.sante = sante;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void leaveEnclos(){
        this.enclos.removeCreature(this);
        enclos = null;
    }

    public double getPoids() {
        return poids;
    }

    public double getTaille() {
        return taille;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public boolean isSleeping() {
        return isSleeping;
    }
}