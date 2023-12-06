package ZooFantastique.models.creatures.ovipares;

import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.interfaces.ISwim;

/**
 * La classe {@code Kraken} représente une créature fantastique de type ovipare
 * qui possède la capacité de nager. Elle étend les fonctionnalités de la classe
 * {@link Ovipare} et implémente l'interface {@link ISwim}.
 * <p>
 * Le Kraken peut pondre des œufs et nager dans les profondeurs marines.
 * </p>
 * <p>
 ISwim
 */
public class Kraken extends Ovipare implements ISwim {

    public Kraken(Enclos enclos) {
        super("Kraken",enclos,"%SON KRAKEN%");
    }

    /**
     * Permet au Kraken de nager.
     */
    @Override
    public void swim() {
        System.out.println("Kraken nage");
    }
}