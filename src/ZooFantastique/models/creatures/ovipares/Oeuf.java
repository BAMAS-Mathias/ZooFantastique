package ZooFantastique.models.creatures.ovipares;

import ZooFantastique.models.creatures.Creature;
import ZooFantastique.models.creatures.CreatureFactory;
import ZooFantastique.models.enclos.Enclos;
import javafx.application.Platform;
import org.controlsfx.control.Notifications;


public class Oeuf extends Creature implements Runnable{

    private Ovipare mother;

    public Oeuf(String nom, Enclos enclos, String sonEmit, Ovipare mother) {
        super("Oeuf", enclos, "rrrr");
        this.mother = mother;
        Thread oeufThread = new Thread(this);
        oeufThread.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Notifications.create().text("Un oeuf a eclos !").showInformation();
            }
        });
        this.leaveEnclos();
        new CreatureFactory().createCreature(mother.getNom(), mother.getEnclos());
    }

}
