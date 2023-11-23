package models.creatures.vivipares;

import models.Vivipare;
import models.interfaces.IRevive;

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

    /**
     * Méthode abstraite représentant le processus de mise bas chez la Nymphe.
     * La mise en œuvre spécifique doit être fournie dans les classes dérivées.
     */
    @Override
    public Nymphe giveBirth() {
        try {
            if(this.isReadyToGiveBirth(true)) {
                return new Nymphe();
            } else {
                throw new BirthException("Cette Nymphe ne peut pas mettre bas");
            }
        } catch (BirthException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Permet à la Nymphe d'être ressuscitée.
     */
    @Override
    public void revive() {
        // Implémentation spécifique de la résurrection pour la Nymphe
    }
}
