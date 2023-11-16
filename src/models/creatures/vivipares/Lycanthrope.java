package models.creatures.vivipares;

import models.Vivipare;
import models.interfaces.IRun;

/**
 * La classe {@code Lycanthrope} représente une créature fantastique de type vivipare,
 * possiblement un être capable de se transformer en une forme animale, qui a la
 * capacité de courir. Elle étend les fonctionnalités de la classe {@link Vivipare}
 * et implémente l'interface {@link IRun}.
 * <p>
 * Le Lycanthrope peut avoir un processus de mise bas particulier et possède une
 * agilité notable pour courir.
 * </p>
 * <p>
 * @author [Raphael]
 * @version 1.0
 * @see Vivipare
 * @see IRun
 */
public class Lycanthrope extends Vivipare implements IRun {

    /**
     * Méthode abstraite représentant le processus de mise bas chez le Lycanthrope.
     * La mise en œuvre spécifique doit être fournie dans les classes dérivées.
     */
    @Override
    public void mettreBas() {
        // Implémentation spécifique de la mise bas pour le Lycanthrope
    }

    /**
     * Permet au Lycanthrope de courir avec agilité.
     */
    @Override
    public void run() {
        // Implémentation spécifique de la course pour le Lycanthrope
    }
}