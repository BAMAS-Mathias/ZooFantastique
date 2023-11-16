package models.creatures.ovipares;

import models.Oeuf;
import models.Ovipare;
import models.interfaces.IFly;
import models.interfaces.IRevive;
;

/**
 * La classe {@code Phoenix} représente une créature légendaire de type ovipare
 * qui a la capacité de voler et d'être ressuscitée. Elle étend les fonctionnalités
 * de la classe {@link Ovipare} et implémente les interfaces {@link IFly} et {@link IRevive}.
 * <p>
 * Le Phoenix peut pondre des œufs, voler majestueusement et revivre par magie.
 * </p>
 * <p>
 * @author [Raphael]
 * @version 1.0
 * @see Ovipare
 * @see IFly
 * @see IRevive
 */
public class Phoenix extends Ovipare implements IRevive, IFly {

    /**
     * Pond des œufs en tant que Phoenix.
     */
    @Override
    public Oeuf pondre() {
        return new Oeuf(this);
    }

    /**
     * Permet au Phoenix de voler majestueusement.
     */
    @Override
    public void fly() {
        System.out.println("Le phoenix vole");
    }

    /**
     * Ressuscite le Phoenix par magie.
     */
    @Override
    public void revive() {
        System.out.println("Le phoenix revit par magie");
    }
}