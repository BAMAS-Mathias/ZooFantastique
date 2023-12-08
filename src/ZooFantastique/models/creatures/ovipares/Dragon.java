package ZooFantastique.models.creatures.ovipares;

import ZooFantastique.models.Age;
import ZooFantastique.models.creatures.Etat;
import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.interfaces.IFly;
import ZooFantastique.models.interfaces.IRevive;
import ZooFantastique.models.interfaces.IRun;
import ZooFantastique.models.interfaces.ISwim;
import javafx.application.Platform;
import org.controlsfx.control.Notifications;

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


    public Dragon(Enclos enclos) {
        super("Dragon", enclos, "%SON DRAGON%");
    }

    /**
     * Permet au dragon de voler.
     */
    @Override
    public void fly() {
        System.out.println("Le dragon vole");
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

    public void revive() {
        super.setSante(getSanteMax());
        setEtat(Etat.PLEINE_FORME);
        setAge(Age.JEUNE);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Notifications.create().title("Resurrection").text("Le dragon ressucite").showInformation();
            }
        });
    }

    @Override
    public void die(){
        this.revive();
    }

}
