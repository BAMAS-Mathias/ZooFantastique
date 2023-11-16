package models.creatures.ovipares;

import models.Oeuf;
import models.Ovipare;
import models.interfaces.IFly;
import models.interfaces.IRevive;
import models.interfaces.IRun;
import models.interfaces.ISwim;

/**
 * La classe {@code Dragon} représente une créature fantastique qui étend les
 * fonctionnalités de la classe {@link Ovipare} et implémente plusieurs interfaces
 * pour définir ses capacités spécifiques.
 * <p>
 * Le dragon peut pondre des œufs, voler, courir, nager et être ressuscité par magie.
 * </p>
 * <p>
 *
 * @author [Rapahel]
 * @version 1.0
 * @see Ovipare
 * @see IRun
 * @see ISwim
 * @see IFly
 * @see IRevive
 */
public class Dragon extends Ovipare implements IRun, ISwim, IFly, IRevive {

    /**
     * Pond des œufs en tant que dragon.
     */
    @Override
    public Oeuf pondre() {
        return new Oeuf(this);
    }

    /**
     * Permet au dragon de voler.
     */
    @Override
    public void fly() {
        System.out.println("Le dragon vole");
    }

    /**
     * Ressuscite le dragon par magie.
     */
    @Override
    public void revive() {
        System.out.println("Le dragon revis par magie");
    }

    /**
     * Fait courir le dragon.
     */
    @Override
    public void run() {
        System.out.println("Le dragon court");
    }

    /**
     * Permet au dragon de nager.
     */
    @Override
    public void swim() {
        System.out.println("Le dragon nage");
    }

}