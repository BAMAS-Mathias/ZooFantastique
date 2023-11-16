package models;

import java.util.ArrayList;

import java.util.ArrayList;

/**
 * La classe {@code ZooFantastique} représente un zoo fantastique, avec un nom,
 * un propriétaire de type {@link MaitreDeZoo}, un nombre maximal d'enclos, et
 * une liste d'enclos.
 * <p>
 * @author [Raphael]
 * @version 1.0
 * @see MaitreDeZoo
 * @see Enclos
 */
public class ZooFantastique {

    /**
     * Le nom du zoo fantastique.
     */
    private String nom;

    /**
     * Le propriétaire du zoo, de type {@code MaitreDeZoo}.
     */
    private MaitreDeZoo proprietaire;

    /**
     * Le nombre maximal d'enclos autorisés dans le zoo.
     */
    private int nbMaxEnclos;

    /**
     * La liste des enclos présents dans le zoo.
     */
    private ArrayList<Enclos> listeDesEnclos;

    /**
     * Construit un nouveau zoo fantastique avec les paramètres spécifiés.
     *
     * @param nom         Le nom du zoo fantastique.
     * @param proprietaire Le propriétaire du zoo.
     * @param nbMaxEnclos Le nombre maximal d'enclos autorisés dans le zoo.
     */
    public ZooFantastique(String nom, MaitreDeZoo proprietaire, int nbMaxEnclos) {
        this.nom = nom;
        this.proprietaire = proprietaire;
        this.nbMaxEnclos = nbMaxEnclos;
        this.listeDesEnclos = new ArrayList<>();
    }

    /**
     * Renvoie une représentation sous forme de chaîne de caractères du zoo fantastique.
     *
     * @return Une représentation du zoo fantastique.
     */
    @Override
    public String toString() {
        return "ZooFantastique{" +
                "nom='" + nom + '\'' +
                ", proprietaire=" + proprietaire +
                ", nbMaxEnclos=" + nbMaxEnclos +
                ", listeDesEnclos=" + listeDesEnclos +
                '}';
    }

    /**
     * Met à jour le zoo fantastique.
     * TODO : Implémenter la logique de mise à jour spécifique.
     */
    public void updateZoo() {
        // TODO : Implémenter la logique de mise à jour spécifique.
    }
}