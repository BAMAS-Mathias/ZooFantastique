package ZooFantastique.models;

import ZooFantastique.models.creatures.Creature;
import ZooFantastique.models.creatures.Etat;
import ZooFantastique.models.creatures.vivipares.lycanthrope.Lycanthrope;
import ZooFantastique.models.enclos.Aquarium;
import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.enclos.Proprete;
import ZooFantastique.ZooMain;
import javafx.application.Platform;
import org.controlsfx.control.Notifications;

import java.util.ArrayList;
import java.util.Random;

public class EventManager {

    private Random random;
    private final double P_ENCLOS_DEGRADE_BASE = 0.01;
    private final double P_ENCLOS_SALINITE_BASE = 0.01;
    private final double P_CREATURE_DORT = 0.05;
    private final double P_CREATURE_VIEILLIR = 0.005;
    private final double P_CREATURE_MALADE = 0.01;
    private final double P_CREATURE_MALADE_PERD_SANTE = 0.1;
    private final double P_CREATURE_MALADE_PLUS_MALADE = 0.05;

    // Mettre les probas en variable final private avec le nom en majuscule
    //Ne pas oublier de mettre les notif pour les evenements
    // Cette classe est éxécute tout les x secondes
    public void handleZooEvent(){
        ArrayList<Enclos> enclosListe = ZooMain.getZoo().getListeDesEnclos();
        ArrayList<Creature> creatureListe = new ArrayList<>();
        for (Enclos i : enclosListe){
            handleEnclotEvent(i);
            for(Creature c : i.getCreaturesPresentes()) {
                handleCreatureEvent(c);
            }
        }

    }

    public void handleEnclotEvent(Enclos enclos){
        random = new Random();
        final double P_ENCLOS_DEGRADE_CREATURE = P_ENCLOS_DEGRADE_BASE + (P_ENCLOS_DEGRADE_BASE * enclos.getNbCreaturePresente());

        if(enclos.getPropreteDegre() != Proprete.MAUVAIS){
            if (random.nextDouble() <= P_ENCLOS_DEGRADE_CREATURE){
                enclos.lowerProperty();
                if(enclos.getPropreteDegre() == Proprete.MAUVAIS){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Notifications.create().text("L'enclos \"" + enclos.getNom() + "\" est en mauvaise état.\nPensez à nettoyer les enclots !").showWarning();
                        }
                    });
                }
            }
        }
        // à régler
        /*if(enclos instanceof Aquarium){
            if(random.nextDouble() <= P_ENCLOS_SALINITE_BASE){
                if(((Aquarium) enclos).getSalinite() > 0) {
                    ((Aquarium)enclos).setSalinite(((Aquarium) enclos).getSalinite() - 1);
                }
                if(((Aquarium) enclos).getSalinite() == 0) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Notifications.create().text("L'enclos \"" + enclos.getNom() + "\" a une salanité très basse.\nNPensez à vous occuper des enclots !").showWarning();
                        }
                    });
                }
            }
        }*/
    }

    /**
     * Gère les évènements liés a une créature
     */
    public void handleCreatureEvent(Creature creature){
        random = new Random();
        if(random.nextDouble() <= P_CREATURE_VIEILLIR) {
            if(creature.getAge() == Age.VIEUX) {
                // MOURIR (à implémenter)
            } else {
                creature.vieillir();
            }
        }

        if(creature.getEtat() == Etat.PLEINE_FORME) {
            if(random.nextDouble() <= P_CREATURE_MALADE) {
                creature.setEtat(Etat.MALADE);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Notifications.create().text("La créature \"" + creature.getNom() + "\" viens de tomber malade.\nPensez à soigner les créatures malades !").showWarning();
                    }
                });
            }
            if(creature.getEtat() == Etat.MALADE){
                if(random.nextDouble() <= P_CREATURE_MALADE_PERD_SANTE){
                    creature.setSante(creature.getSante() - 1);
                }
            }
        }

    }

    public void handleLycanthropeEvent(Lycanthrope lycanthropes){
        //TODO

    }
}
