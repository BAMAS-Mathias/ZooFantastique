package models.creatures.vivipares;

import controllers.Exceptions.BirthException;
import models.Vivipare;
import models.interfaces.IRun;

/**
 * La classe {@code Licorne} représente une créature fantastique de type vivipare
 * qui a la capacité de courir. Elle étend les fonctionnalités de la classe
 * {@link Vivipare} et implémente l'interface {@link IRun}.
 * <p>
 * La Licorne peut mettre bas et possède une grande agilité pour courir.
 * </p>
 * <p>
 *
 * @author [Raphael]
 * @version 1.0
 * @see Vivipare
 * @see IRun
 */
public class Licorne extends Vivipare implements IRun {

    /**
     * Méthode abstraite représentant le processus de mise bas chez la Licorne.
     * La mise en œuvre spécifique doit être fournie dans les classes dérivées.
     */

    @Override
    public Licorne giveBirth() {
        try {
            if(this.isReadyToGiveBirth(true)) {
                return new Licorne();
            } else {
                throw new BirthException("Cette Licorne ne peut pas mettre bas.");
            }
        } catch (BirthException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Permet à la Licorne de courir avec agilité.
     */
    @Override
    public void run() {
        // Implémentation spécifique de la course pour la Licorne
    }
}