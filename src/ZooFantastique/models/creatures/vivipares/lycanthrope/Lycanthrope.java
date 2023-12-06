package ZooFantastique.models.creatures.vivipares.lycanthrope;

import ZooFantastique.models.creatures.vivipares.Vivipare;
import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.interfaces.IRun;

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

    private double force;
    private double facteurDomination;
    private RangDomination rang;
    private double niveau;
    private double impétuosité;
    private Meute meute;

    public Lycanthrope(Enclos enclos) {
        super("Lycanthrope", enclos, "%SON LYCANTHROPE%");
    }

    /**
     * Permet au Lycanthrope de courir avec agilité.
     */
    @Override
    public void run() {
        // Implémentation spécifique de la course pour le Lycanthrope
    }

    public void hurler() {
        meute.notifyHurlement(this);
    }

    public void quitterMeute() {
        // TODO : Implémenter le départ du Lycanthrope de la meute
    }

    public void transformer() {
        // TODO : Implémenter la transformation du Lycanthrope
    }

    public void hurlementRetour() {
        // TODO : Implémenter le hurlement de retour du Lycanthrope
    }

    public void baisserRang(){
        this.rang = rang.previousRang();
    }

    public void augmenterRang(){
        this.rang = rang.nextRang();
    }


}