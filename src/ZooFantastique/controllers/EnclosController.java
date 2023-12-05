package ZooFantastique.controllers;

import ZooFantastique.models.creatures.Creature;
import ZooFantastique.models.creatures.CreatureFactory;
import ZooFantastique.models.ZooFantastique;
import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.enclos.EnclosFactory;
import ZooFantastique.models.enclos.Proprete;
import ZooFantastique.view.CreateEnclosView;
import ZooFantastique.view.EnclosView;
import ZooFantastique.ZooMain;
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

    public void ajouterCreature(Enclos enclos){
        EnclosView enclosView = new EnclosView().setEnclos(enclos);
        ArrayList<String> creatureNameList = new ArrayList<>();


        if(!enclos.isEmpty()){ // L'enclos contient deja une creature donc on a seulement un type possible
            creatureNameList.add(enclos.getCreaturesPresentes().get(0).getClass().getName());
        }
        else{ // L'enclos est vide donc on a tous les types possibles
            creatureNameList.addAll(Arrays.asList("Dragon","Kraken","Magalodon","Phoenix","Licorne","Lycanthrope","Nymphe","Sirene"));
        }

        enclosView.displayPossibleCreatureToAdd(creatureNameList);
        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        try{
            int indexCreature = Integer.parseInt(scanner.nextLine());
            CreatureFactory creatureFactory = new CreatureFactory();
            enclos.addCreature(creatureFactory.createCreature(creatureNameList.get(indexCreature - 1), enclos));
        }catch (Exception e){
            System.out.println("Entrer le nom de la creature que vous voulez ajouter : ");
            userInput = scanner.nextLine();
        }
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

}