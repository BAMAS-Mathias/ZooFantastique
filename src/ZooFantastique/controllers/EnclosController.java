package ZooFantastique.controllers;

import ZooFantastique.models.creatures.Creature;
import ZooFantastique.models.creatures.CreatureFactory;
import ZooFantastique.models.ZooFantastique;
import ZooFantastique.models.creatures.vivipares.lycanthrope.Lycanthrope;
import ZooFantastique.models.creatures.vivipares.lycanthrope.Meute;
import ZooFantastique.models.enclos.*;
import ZooFantastique.view.AddCreatureView;
import ZooFantastique.view.CreateEnclosView;
import ZooFantastique.view.EnclosView;
import ZooFantastique.ZooMain;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import javax.management.Notification;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * La classe {@code EnclosController} est responsable de contrôler les interactions
 * liées aux enclos dans l'application. Elle facilite la communication entre
 * le modèle ({@link Enclos}) et la vue ({@link ZooFantastique.view.EnclosView}).
 * <p>
 * La principale fonctionnalité fournie par ce contrôleur est d'examiner les enclos
 * en affichant des informations via la {@link ZooFantastique.view.EnclosView} associée.
 * </p>
 * <p>
 *
 * @author [Raphael]
 * @version 1.0
 * @see Enclos
 * @see ZooFantastique.view.EnclosView
 */
public class EnclosController {

    private ZooFantastique zoo;

    public EnclosController() {
        zoo = ZooMain.getZoo();
    }

    /**
     * Affiche des informations sur les enclos en utilisant la {@link ZooFantastique.view.EnclosView} associée.
     */
    public void examinerEnclos(Enclos enclos) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/EnclosViewFXML.fxml"));
        loader.setControllerFactory(c -> new EnclosView(enclos));

        try{
            ZooMain.getPrimaryStage().setScene(new Scene(loader.load()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void afficherCreatures(Enclos enclos){
        ArrayList<Creature> creatures = enclos.getCreaturesPresentes();
        EnclosView enclosView = new EnclosView();
        enclosView.displayCreatures(creatures);
    }

    public void creerEnclos(String nomEnclos, String typeEnclos) {
        Enclos nouvelEnclos = new EnclosFactory().build(typeEnclos, nomEnclos);
        zoo.addEnclos(nouvelEnclos);
    }

    private ArrayList<String> getPossibleCreatureToAdd(Enclos enclos){
        if(!enclos.isEmpty()) return new ArrayList<>(Arrays.asList(enclos.getCreaturesPresentes().get(0).getNom()));
        if(enclos instanceof Aquarium) return new ArrayList<>(Arrays.asList("Kraken","Megalodon", "Sirene"));
        if(enclos instanceof Voliere) return new ArrayList<>(Arrays.asList("Dragon", "Phoenix"));
        else return new ArrayList<>(Arrays.asList("Lycanthrope", "Licorne","Nymphe"));
    }

    public void addCreature(Enclos enclos){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/AddCreatureView.fxml"));
        loader.setControllerFactory(c -> new AddCreatureView(enclos, getPossibleCreatureToAdd(enclos)));

        try{
            ZooMain.getPrimaryStage().setScene(new Scene(loader.load()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addCreature(Enclos enclos, String creatureName){
        CreatureFactory creatureFactory = new CreatureFactory();
        Creature creature = creatureFactory.createCreature(creatureName, enclos);
        examinerEnclos(enclos);
    }


    public void nettoyerEnclos(Enclos enclos){
        EnclosView enclosView = new EnclosView().setEnclos(enclos);
        if(enclos.getPropreteDegre() != Proprete.BON && enclos.isEmpty()){
            enclos.clean();
            Notifications.create().title("Enclos").text("L'enclos a été nettoyé").showInformation();
            examinerEnclos(enclos);
        }

    }

    public void renameEnclos(Enclos enclos){
        System.out.println("Donner le nouveau nom de l'enclos");
        EnclosView enclosView = new EnclosView().setEnclos(enclos);
        Scanner scanner = new Scanner(System.in);
        String enclosName = scanner.nextLine();
        if(enclosName.isEmpty()){
            enclosView.displayEmptyNameError();
        }else{
            enclos.setName(enclosName);
            enclosView.displaySuccessFullNameEditMessage();
        }
    }

    public void nourrirAllCreatures(Enclos enclos){
        EnclosView enclosView = new EnclosView().setEnclos(enclos);
        enclos.nourrirAllCreature();
        enclosView.displaySuccessFeedMessage();
        Notifications.create().title("Enclos").text("Les créatures ont été nourries").hideAfter(Duration.seconds(1)).position(Pos.TOP_RIGHT).showInformation();
    }

    public void creerMeute(Lycanthrope male, Lycanthrope femmelle, Enclos enclos){
        enclos.addMeute(new Meute(male, femmelle));
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Notifications.create().title("Meute créee").text("Une meute a été créee dans l'enclos " + enclos.getNom()).showInformation();
            }
        });
    }

}