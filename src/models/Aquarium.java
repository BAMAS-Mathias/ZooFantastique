package models;

/**
 * La classe {@code Aquarium} représente un type d'enclos spécifique destiné à
 * héberger des créatures aquatiques. Elle étend les fonctionnalités de la classe
 * {@link Enclos} et ajoute des attributs spécifiques tels que la profondeur et la
 * salinité de l'aquarium.
 * <p>
 * @author [Raphael]
 * @version 1.0
 * @see Enclos
 */
public class Aquarium extends Enclos {

    /**
     * La profondeur de l'aquarium.
     */
    private double profondeur;

    /**
     * La salinité de l'eau dans l'aquarium.
     */
    private double salinite;

    /**
     * Construit un nouvel aquarium avec les paramètres spécifiés.
     *
     * @param nom                Le nom de l'aquarium.
     * @param superficie         La superficie de l'aquarium.
     * @param nbCreatureMax      Le nombre maximum de créatures pouvant être hébergées.
     * @param nbCreaturePresente Le nombre actuel de créatures présentes.
     * @param propreteDegre      Le degré de propreté de l'aquarium.
     * @param profondeur         La profondeur de l'aquarium.
     * @param salinite           La salinité de l'eau dans l'aquarium.
     */

    public Aquarium(String nom, double supperficie, int nbCreatureMax, double profondeur, double salinite) {
        super(nom, supperficie, nbCreatureMax);
        this.profondeur = profondeur;
        this.salinite = salinite;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Implémente la logique d'entretien spécifique pour un aquarium, vérifiant
     * la profondeur et la salinité.
     * </p>
     */
    @Override
    public void entretient() {
        // TODO: Vérifier la profondeur et la salinité lors de l'entretien de l'aquarium
        super.entretient();
    }

}
