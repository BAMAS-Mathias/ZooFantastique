package models;

import java.util.ArrayList;

/**
 * La classe {@code Enclos} représente un espace clos destiné à héberger des créatures.
 * Elle contient des informations telles que le nom, la superficie, le nombre maximal
 * de créatures autorisées, le nombre actuel de créatures présentes, le degré de propreté,
 * et la liste des créatures présentes.
 * <p>
 * @author [Votre Nom]
 * @version 1.0
 * @see Creature
 * @see Proprete
 */
public class Enclos {

    /**
     * Le nom de l'enclos.
     */
    private String nom;

    /**
     * La superficie de l'enclos.
     */
    private double superficie;

    /**
     * Le nombre maximal de créatures autorisées dans l'enclos.
     */
    private int nbCreatureMax;

    /**
     * Le nombre actuel de créatures présentes dans l'enclos.
     */
    private int nbCreaturePresente;

    /**
     * Le degré de propreté de l'enclos.
     */
    private Proprete propreteDegre;

    /**
     * La liste des créatures présentes dans l'enclos.
     */
    private ArrayList<Creature> creaturesPresentes;

    /**
     * Construit un nouvel enclos avec les paramètres spécifiés.
     *
     * @param nom             Le nom de l'enclos.
     * @param superficie      La superficie de l'enclos.
     * @param nbCreatureMax   Le nombre maximal de créatures autorisées.
     * @param nbCreaturePresente Le nombre actuel de créatures présentes.
     * @param propreteDegre   Le degré de propreté de l'enclos.
     */

    public Enclos(String nom, double supperficie, int nbCreatureMax) {
        this.nom = nom;
        this.superficie = supperficie;
        this.nbCreatureMax = nbCreatureMax;
        this.nbCreaturePresente = 0;
        this.propreteDegre = Proprete.BON;
        creaturesPresentes = new ArrayList<Creature>();
    }

    public Enclos(String nom, double supperficie) {
        this(nom, supperficie, 10);
    }

    public Enclos(String nom) {
        this(nom, 50);
    }


    @Override
    public String toString() {
        return "[Enclos] " + nom + ", superficie :" + supperficie + ", nombre de créature : " + nbCreaturePresente;
    }

    /**
     * Ajoute une créature à la liste des créatures présentes dans l'enclos.
     *
     * @param creature La créature à ajouter.
     */
    public void addCreature(Creature creature) {
        creaturesPresentes.add(creature);
    }

    /**
     * Supprime une créature de la liste des créatures présentes dans l'enclos.
     *
     * @param creature La créature à supprimer.
     */
    public void removeCreature(Creature creature) {
        creaturesPresentes.remove(creature);
    }

    /**
     * Nourrit toutes les créatures présentes dans l'enclos.
     * TODO : Implémenter la logique de nourrissage spécifique.
     */
    public void feedCreature() {
        // TODO : Implémenter la logique de nourrissage spécifique.
    }

    /**
     * Effectue l'entretien de l'enclos en fonction de certaines conditions.
     */
    public void entretient() {
        if (creaturesPresentes.isEmpty() && propreteDegre.equals(Proprete.MAUVAIS)) {
            propreteDegre = Proprete.BON;
        }
    }

}


