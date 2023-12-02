package ZooFantastique.models.creatures.vivipares;

import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.interfaces.IRun;

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

    public Licorne(Enclos enclos) {
        super(enclos,"%SON LICORNE%");
    }


    /**
     * Permet à la Licorne de courir avec agilité.
     */
    @Override
    public void run() {
        // Implémentation spécifique de la course pour la Licorne
    }
}