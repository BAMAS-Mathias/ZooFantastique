package ZooFantastique.models;

import ZooFantastique.controllers.LycantropeController;
import ZooFantastique.models.creatures.Creature;
import ZooFantastique.models.creatures.Etat;
import ZooFantastique.models.creatures.ovipares.Ovipare;
import ZooFantastique.models.creatures.vivipares.lycanthrope.Lycanthrope;
import ZooFantastique.models.creatures.vivipares.lycanthrope.Meute;
import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.enclos.Proprete;
import ZooFantastique.ZooMain;
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
    private final double P_CREATURE_DORT = 0.0005;
    private final double P_CREATURE_VIEILLIR = 0.005;
    private final double P_CREATURE_MALADE = 0.01;
    private final double P_CREATURE_MALADE_PERD_SANTE = 0.1;
    private final double P_CREATURE_A_FAIM = 0.01;
    private final double P_OVIPARE_POND = 0.001;
    private final double P_LYCANTROPE_HURLE = 0.001;
    private final double P_LYCANTROPE_TENTE_DOMINATION = 0.05;
    private final double P_LYCANTROPE_REPRODUCE = 0.01;

    // Mettre les probas en variable final private avec le nom en majuscule
    //Ne pas oublier de mettre les notif pour les evenements
    // Cette classe est éxécute tout les x secondes
    public void handleZooEvent(){
        CopyOnWriteArrayList<Enclos> enclosListe = new CopyOnWriteArrayList<>(ZooMain.getZoo().getListeDesEnclos());
        CopyOnWriteArrayList<Creature> creatureListe = new CopyOnWriteArrayList<>();
        for (Enclos i : enclosListe){
            handleEnclotEvent(i);
        }
        for(Meute meute : ZooMain.getColonie()){
            handleMeuteEvent(meute);
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

        if(creature instanceof Lycanthrope){
            handleLycanthropeEvent((Lycanthrope) creature);
        }

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
            if(creature.getEtat() != Etat.MALADE){
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

    public void handleLycanthropeEvent(Lycanthrope lycanthrope){
        Random random = new Random();

        if(random.nextDouble() <= P_LYCANTROPE_HURLE){
            lycanthrope.hurler();
        }

        if(random.nextDouble() <= P_LYCANTROPE_TENTE_DOMINATION){
            ArrayList<Lycanthrope> possibleDomination = new ArrayList<>();
            for(Lycanthrope l : lycanthrope.getMeute().getMembres()){
                if(lycanthrope.canDominate(l)) possibleDomination.add(l);
            }
            if(possibleDomination.size() > 0){
                Lycanthrope lycanthropeDomine = possibleDomination.get(random.nextInt(possibleDomination.size()));
                new LycantropeController().attempDomination(lycanthrope, lycanthropeDomine);
            }
        }
    }

    public void handleMeuteEvent(Meute meute){
        Random random = new Random();
        if(random.nextDouble() <= P_LYCANTROPE_REPRODUCE){
            meute.getCoupleAlpha().reproduce();
            sendNotification("Repoduction", "Un couple de lycanthrope a donné naissance à des nouveaux lycanthropes !");
        }
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
