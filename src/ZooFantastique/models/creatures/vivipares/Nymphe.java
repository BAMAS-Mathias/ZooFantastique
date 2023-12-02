package ZooFantastique.models.creatures.vivipares;

import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.interfaces.IRevive;

/**
 * La classe {@code Nymphe} représente une créature fantastique de type vivipare
 * qui a la capacité d'être ressuscitée. Elle étend les fonctionnalités de la classe
 * {@link Vivipare} et implémente l'interface {@link IRevive}.
 * <p>
 * La Nymphe peut avoir un processus de mise bas particulier et possède la capacité
 * d'être ressuscitée par une méthode spécifique.
 * </p>
 * <p>
 * @author [Raphael]
 * @version 1.0
 * @see Vivipare
 * @see IRevive
 */
public class Nymphe extends Vivipare implements IRevive {

    public Nymphe(Enclos enclos) {
        super(enclos, "%SON NYMPHE%");
    }

    /**
     * Permet à la Nymphe d'être ressuscitée.
     */
    @Override
    public void revive() {
        // Implémentation spécifique de la résurrection pour la Nymphe
    }
}
