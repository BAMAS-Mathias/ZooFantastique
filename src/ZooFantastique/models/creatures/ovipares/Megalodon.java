package ZooFantastique.models.creatures.ovipares;

import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.interfaces.ISwim;

/**
 * La classe {@code Megalodon} représente une créature fantastique de type ovipare
 * qui a la capacité de nager. Elle étend les fonctionnalités de la classe
 * {@link Ovipare} et implémente l'interface {@link ISwim}.
 * <p>
 * Le Megalodon peut pondre des œufs et est capable de nager avec une grande puissance.
 * </p>
 * <p>
 * @author [raphael]
 * @version 1.0
 * @see Ovipare
 * @see ISwim
 */
public class Megalodon extends Ovipare implements ISwim {

    public Megalodon(Enclos enclos) {
        super("Megalodon",enclos, "%SON MEGALODON%");
    }

    /**
     * Permet au Megalodon de nager avec puissance.
     */
    @Override
    public void swim() {
        System.out.println("Le megalodon nage");
    }
}
