package ZooFantastique.models;

import ZooFantastique.models.creatures.Creature;
import ZooFantastique.models.creatures.Etat;
import ZooFantastique.models.creatures.ovipares.Ovipare;
import ZooFantastique.models.creatures.vivipares.lycanthrope.Lycanthrope;
import ZooFantastique.models.enclos.Aquarium;
import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.enclos.Proprete;
import ZooFantastique.ZooMain;
import ZooFantastique.models.interfaces.IRevive;
import javafx.application.Platform;
import org.controlsfx.control.Notifications;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventManager {

    private Random random;
    private final double P_ENCLOS_DEGRADE_BASE = 0.01;
    private final double P_ENCLOS_SALINITE_BASE = 0.01;
    private final double P_CREATURE_DORT = 0.05;
    private final double P_CREATURE_VIEILLIR = 0.005;
    private final double P_CREATURE_MALADE = 0.01;
    private final double P_CREATURE_MALADE_PERD_SANTE = 0.1;
    private final double P_CREATURE_A_FAIM = 0.01;
    private final double P_OVIPARE_POND = 0.001;

    // Mettre les probas en variable final private avec le nom en majuscule
    //Ne pas oublier de mettre les notif pour les evenements
    // Cette classe est éxécute tout les x secondes
    public void handleZooEvent(){
        CopyOnWriteArrayList<Enclos> enclosListe = new CopyOnWriteArrayList<>(ZooMain.getZoo().getListeDesEnclos());
        CopyOnWriteArrayList<Creature> creatureListe = new CopyOnWriteArrayList<>();
        for (Enclos i : enclosListe){
            handleEnclotEvent(i);
        }
    }

    public void handleEnclotEvent(Enclos enclos){
        CopyOnWriteArrayList<Creature> creatureList = new CopyOnWriteArrayList<>(enclos.getCreaturesPresentes());
        Iterator<Creature> iterator = creatureList.iterator();

        while(iterator.hasNext()){
            Creature creature = iterator.next();
            handleCreatureEvent(creature);
        }

        if(enclos.getPropreteDegre() != Proprete.MAUVAIS && new Random().nextDouble() <= P_ENCLOS_DEGRADE_BASE * enclos.getNbCreaturePresente()){
            enclos.lowerProperty();
            sendNotification("Enclos", "L'enclos \"" + enclos.getNom() + "\" se dégrade !\n" + "Pensez à le nettoyer !");
        }


    }

    /**
     * Gère les évènements liés a une créature
     */
    public void handleCreatureEvent(Creature creature){
        random = new Random();

        /* ----- La créature vieillit ----- */
        if(random.nextDouble() <= P_CREATURE_VIEILLIR) {
            creature.vieillir();
        }

        /* ----- La créature dort ----- */
        if(random.nextDouble() <= P_CREATURE_DORT) {
            if(creature.isSleeping()){
                creature.wakeUp();
            } else {
                creature.sleep();
            }
        }

        /* ----- La créature tombe malade ----- */
        if(random.nextDouble() <= P_CREATURE_MALADE){
            if(creature.getEtat() == Etat.MALADE){
                creature.setEtat(Etat.MALADE);
                sendNotification("Créature", "La créature \"" + creature.getNom() + "\" viens de tomber malade.\nPensez à soigner les créatures malades !");
            }else{
                creature.setSante(creature.getSante() - 1);
            }
        }

        /* ----- La créature a faim ----- */
        if(!creature.isHungry() && random.nextDouble() <= P_CREATURE_A_FAIM){
            creature.setHungry(true);
            sendNotification("Créature", "La créature \"" + creature.getNom() + "\" a faim !");
        }

        /* ----- L'ovipare pond ----- */
        if(creature instanceof Ovipare && random.nextDouble() <= P_OVIPARE_POND){
            Ovipare ovipare = (Ovipare) creature;
            ovipare.lay();
            sendNotification("Créature", "L'ovipare \"" + ovipare.getNom() + "\" a pondu un oeuf !");
        }

    }

    public void handleLycanthropeEvent(Lycanthrope lycanthropes){
        //TODO

    }

    public void sendNotification(String title, String message){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Notifications.create().text(message).showWarning();
            }
        });
    }
}
