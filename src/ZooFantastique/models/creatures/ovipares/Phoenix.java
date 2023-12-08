package ZooFantastique.models.creatures.ovipares;

import ZooFantastique.models.Age;
import ZooFantastique.models.creatures.Etat;
import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.interfaces.IFly;
import ZooFantastique.models.interfaces.IRevive;
import javafx.application.Platform;
import org.controlsfx.control.Notifications;
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

    public Phoenix(Enclos enclos) {
        super("Phoenix", enclos, "%SON PHOENIX%");
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
        super.setSante(getSanteMax());
        setEtat(Etat.PLEINE_FORME);
        setAge(Age.JEUNE);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Notifications.create().title("Resurrection").text("Le phoenix renait de ses cendres").showInformation();
            }
        });
    }

    @Override
    public void setSante(double sante){
        super.setSante(sante);
        if(sante == 0) this.revive();
    }

    @Override
    public void die(){
        this.revive();
    }
}