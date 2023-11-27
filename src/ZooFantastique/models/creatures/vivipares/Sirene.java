package ZooFantastique.models.creatures.vivipares;

import ZooFantastique.models.Vivipare;
import ZooFantastique.models.interfaces.ISwim;
import controllers.Exceptions.BirthException;

/**
 * La classe {@code Sirene} représente une créature fantastique de type vivipare
 * qui a la capacité de nager. Elle étend les fonctionnalités de la classe
 * {@link Vivipare} et implémente l'interface {@link ISwim}.
 * <p>
 * La Sirène peut avoir un processus de mise bas particulier et possède la capacité
 * de nager avec grâce.
 * </p>
 * <p>
 * @author [Raphael]
 * @version 1.0
 * @see Vivipare
 * @see ISwim
 */
public class Sirene extends Vivipare implements ISwim {

    /**
     * Méthode abstraite représentant le processus de mise bas chez la Sirène.
     * La mise en œuvre spécifique doit être fournie dans les classes dérivées.
     */
    @Override
    public Sirene giveBirth() {
        try {
            if(this.isReadyToGiveBirth(true)) {
                return new Sirene();
            } else {
                throw new BirthException("Cette Sirène ne peut pas mettre bas");
            }
        } catch (BirthException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Permet à la Sirène de nager avec grâce.
     */
    @Override
    public void swim() {
        // Implémentation spécifique de la nage pour la Sirène
    }
}

