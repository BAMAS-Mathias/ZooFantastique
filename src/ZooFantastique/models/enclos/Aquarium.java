package ZooFantastique.models.enclos;

import java.util.Random;

/**
 * La classe {@code Aquarium} représente un type d'enclos spécifique destiné à
 * héberger des créatures aquatiques. Elle étend les fonctionnalités de la classe
 * {@link Enclos} et ajoute des attributs spécifiques tels que la profondeur et la
 * salinité de l'aquarium.
 * <p>
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
     */

    public Aquarium(String nom) {
        super(nom);
        this.profondeur = new Random().nextInt(20) + 20;
        this.salinite = 35 + new Random().nextInt(5);
    }

    public double getSalinite() {
        return salinite;
    }

    public void setSalinite(double salinite) {
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
