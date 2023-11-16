package models;

/**
 * La classe {@code Voliere} représente un type spécifique d'enclos destiné à héberger
 * des créatures volantes. Elle étend les fonctionnalités de la classe {@link Enclos}
 * et ajoute une méthode spécifique d'entretien du toit de la volière.
 * <p>
 * @author [Raphael]
 * @version 1.0
 * @see Enclos
 */
public class Voliere extends Enclos {

    /**
     * Construit une nouvelle volière avec les paramètres spécifiés.
     *
     * @param nom                Le nom de la volière.
     * @param superficie         La superficie de la volière.
     * @param nbCreatureMax      Le nombre maximal de créatures autorisées.
     * @param nbCreaturePresente Le nombre actuel de créatures présentes.
     * @param propreteDegre      Le degré de propreté de la volière.
     */
    public Voliere(String nom, double superficie, int nbCreatureMax, int nbCreaturePresente, Proprete propreteDegre) {
        super(nom, superficie, nbCreatureMax, nbCreaturePresente, propreteDegre);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Implémente la logique d'entretien spécifique pour une volière, y compris
     * l'entretien du toit.
     * </p>
     */
    @Override
    public void entretient() {
        entretientToit();
        super.entretient();
    }

    /**
     * Effectue l'entretien du toit de la volière.
     * TODO : Implémenter la logique d'entretien du toit spécifique.
     */
    private void entretientToit() {
        // TODO : Implémenter la logique d'entretien du toit spécifique.
    }
}