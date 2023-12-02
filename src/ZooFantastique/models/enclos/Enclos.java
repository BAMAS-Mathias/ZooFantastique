package ZooFantastique.models.enclos;

import ZooFantastique.models.creatures.Creature;

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
     *
     * @param nom
     * @param supperficie
     * @param nbCreatureMax
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
        return "[Enclos] " + nom + ", superficie :" + superficie + ", nombre de créature : " + nbCreaturePresente;
    }

    public String getNom() {
        return nom;
    }

    /**
     * Ajoute une créature à la liste des créatures présentes dans l'enclos.
     *
     * @param creature La créature à ajouter.
     */
    public void addCreature(Creature creature) {
        nbCreaturePresente++;
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
        for(Creature creature : creaturesPresentes) {
            creature.nourrir();
        }
        System.out.println("Les créatures ont été nourries avec succès.");
    }

    public ArrayList<Creature> getCreaturesPresentes() {
        return creaturesPresentes;
    }

    /**
     * Effectue l'entretien de l'enclos en fonction de certaines conditions.
     */
    public void entretient() {
        if (creaturesPresentes.isEmpty() && propreteDegre.equals(Proprete.MAUVAIS)) {
            propreteDegre = Proprete.BON;
        }
    }

    public boolean isEmpty() {
        return creaturesPresentes.isEmpty();
    }

    public void setName(String s) {
        this.nom= s;
    }

    public int getNbCreatureMax(){
        return nbCreatureMax;
    }

    public int getNbCreaturePresente(){
        return nbCreaturePresente;
    }

    public Proprete getPropreteDegre(){
        return propreteDegre;
    }

    public void clean(){
        propreteDegre = Proprete.BON;
    }

}


