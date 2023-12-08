package ZooFantastique.controllers;

import ZooFantastique.ZooMain;
import ZooFantastique.models.Age;
import ZooFantastique.models.ZooFantastique;
import ZooFantastique.models.creatures.Creature;
import ZooFantastique.models.creatures.Etat;
import ZooFantastique.models.enclos.Aquarium;
import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.enclos.Voliere;
import ZooFantastique.models.interfaces.IFly;
import ZooFantastique.models.interfaces.IRun;
import ZooFantastique.models.interfaces.ISwim;
import ZooFantastique.view.CreatureView;
import ZooFantastique.view.EnclosView;
import ZooFantastique.view.TransfereCreatureView;
import controllers.Exceptions.EnclosFullException;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import org.controlsfx.control.Notifications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * La classe CreatureController gère les opérations liées aux créatures dans le zoo.
 */
public class CreatureController {

    /**
     * Émet le son de la créature donnée et l'affiche dans une notification.
     *
     * @param creature La créature pour laquelle émettre un son.
     */
    public void emettreSon(Creature creature){
        CreatureView creatureView = new CreatureView(creature);
        Notifications.create().text(creature.getSonEmit()).title(creature.getNom()).showInformation();
    }
    /**
     * Soigne la créature donnée, met à jour la vue et affiche une notification.
     *
     * @param creature La créature à soigner.
     */
    public void healCreature(Creature creature){
        creature.heal();
        visiterCreature(creature);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Notifications.create().title("Soigner").text("La creature " + creature.getNom() + " a été soignée !").showError();
            }
        });
    }
    /**
     * Nourrit la créature donnée, met à jour la vue.
     *
     * @param creature La créature à nourrir.
     */
    public void nourrirCreature(Creature creature){
        creature.feed();
        visiterCreature(creature);
    }
    /**
     * Visite la vue de la créature donnée.
     *
     * @param creature La créature à visiter.
     */
    public void visiterCreature(Creature creature){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/CreatureViewFXML.fxml"));
        loader.setControllerFactory(c -> new CreatureView(creature));

        try{
            ZooMain.getPrimaryStage().setScene(new Scene(loader.load()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Soigne ou affiche un message en fonction de la santé de la créature donnée.
     *
     * @param creature La créature à soigner.
     */
    public void soignerCreature(Creature creature){
        CreatureView creatureView =  new CreatureView(creature);
        if(creature.getSante() == creature.getSanteMax()){
            creatureView.displayCreatureFullHealthMessage();
        }else{
            creature.heal();
            creatureView.displayHealMessage();
        }
    }
    /**
     * Transfère la créature donnée vers un enclos sélectionné.
     *
     * @param creature La créature à transférer.
     */
    public void transfererCreature(Creature creature){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/TransfererCreatureView.fxml"));
        loader.setControllerFactory(c -> new TransfereCreatureView(creature,getEnclosPossibles(creature)));

        try{
            ZooMain.getPrimaryStage().setScene(new Scene(loader.load()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Transfère la créature donnée vers l'enclos spécifié.
     *
     * @param creature La créature à transférer.
     * @param enclos   L'enclos cible.
     */
    public void transfererCreature(Creature creature, Enclos enclos){
        creature.leaveEnclos();
        try{
            enclos.addCreature(creature);
            creature.setEnclos(enclos);
            Notifications.create().title("Transfert").text("Transféré avec succés").showConfirm();
        }catch (EnclosFullException e){
            Notifications.create().title("Enclos plein").text("L'enclos " + enclos.getNom() + " est plein").showError();
        }

        new EnclosController().examinerEnclos(creature.getEnclos());
    }
    /**
     * Récupère la liste des enclos possibles pour la créature en fonction de ses capacités.
     *
     * @param creature La créature pour laquelle trouver les enclos possibles.
     * @return Une liste d'enclos possibles pour la créature.
     */
    private ArrayList<Enclos> getEnclosPossibles(Creature creature){
        ArrayList<Enclos> enclosList = new ArrayList<>();
        for(Enclos enclos : ZooMain.getZoo().getListeDesEnclos()){
            if(creature instanceof ISwim && enclos instanceof Aquarium){
                enclosList.add(enclos);
            }
            else if(creature instanceof IFly && enclos instanceof Voliere){
                enclosList.add(enclos);
            }
            else if(creature instanceof IRun && !(enclos instanceof Aquarium) && !(enclos instanceof Voliere)){
                enclosList.add(enclos);
            }
        }
        return enclosList;
    }
    /**
     * Récupère la liste des enclos possibles pour le transfert de la créature.
     *
     * @param creature La créature à transférer.
     * @return Une liste d'enclos possibles pour le transfert de la créature.
     */
    private ArrayList<Enclos> getEnclosForTransfer(Creature creature){
        ZooFantastique zooFantastique = ZooMain.getZoo();
        ArrayList<Enclos> enclosPossible = new ArrayList<>();
        for(Enclos enclos : zooFantastique.getListeDesEnclos()){
            if(enclos.isEmpty()) enclosPossible.add(enclos);
            else{
                if(enclos.getCreaturesPresentes().get(0).getNomEspece().equals(creature.getNomEspece())){
                    if(enclos.getNbCreaturePresente() < enclos.getNbCreatureMax()){
                        enclosPossible.add(enclos);
                    }
                }
            }
        }
        System.out.println(enclosPossible.size());
        return enclosPossible;
    }
    /**
     * Fait vieillir la créature et affiche une notification en cas de décès ou de vieillissement.
     *
     * @param creature La créature à faire vieillir.
     */
    public void viellir(Creature creature){
        creature.vieillir();
        if(creature.getEtat() == Etat.MORT){
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Notifications.create().title("Mort").text("La creature " + creature.getNom() + " est mort dans " + creature.getEnclos().getNom()).showError();
                }
            });
        }else{
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Notifications.create().title(creature.getNom()).text(creature.getNom() + " a pris de l'age").showError();
                }
            });
        }
    }
}
