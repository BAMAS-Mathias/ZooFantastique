package ZooFantastique.models.enclos;

/**
 * La classe {@code Voliere} représente un type spécifique d'enclos destiné à héberger
 * des créatures volantes. Elle étend les fonctionnalités de la classe {@link Enclos}
 * et ajoute une méthode spécifique d'entretien du toit de la volière.
 * <p>
 */
public class Voliere extends Enclos {

    /**
     *
     * @param nom
     */
    public Voliere(String nom) {
        super(nom);
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
