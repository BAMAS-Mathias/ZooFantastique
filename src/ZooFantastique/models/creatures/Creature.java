package ZooFantastique.models.creatures;

import ZooFantastique.models.Age;
import ZooFantastique.models.Sexe;
import ZooFantastique.models.enclos.Enclos;

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

    private String sonEmit;

    public Creature(Enclos enclos, String sonEmit){
        this.enclos = enclos;
        this.sonEmit = sonEmit;
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
        // Implémentation spécifique pour chaque créature
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
}