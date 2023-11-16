package models.creatures;

import models.Vivipare;
import models.interfaces.ISwim;

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
    public void mettreBas() {
        // Implémentation spécifique de la mise bas pour la Sirène
    }

    /**
     * Permet à la Sirène de nager avec grâce.
     */
    @Override
    public void swim() {
        // Implémentation spécifique de la nage pour la Sirène
    }
}

