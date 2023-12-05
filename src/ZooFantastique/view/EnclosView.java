package ZooFantastique.view;

import ZooFantastique.ZooMain;
import ZooFantastique.controllers.ZooFantastiqueController;
import ZooFantastique.models.creatures.Creature;
import ZooFantastique.models.enclos.Enclos;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EnclosView implements Initializable {

    @FXML
    private Text enclosName;

    @FXML
    private GridPane creaturesContainer;

    @FXML
    private Button returnButton;

    private Enclos enclos;
    private final int creaturePerRow = 3;

    public EnclosView(){}

    public EnclosView(Enclos enclos){
        this.enclos = enclos;
    }

    public void displayEnclosVisitMessage(){
        System.out.println("Vous entrez dans l'enclos " + enclos.getNom());
    }

    public void displayCreaturesInside(){
        for (Creature creature : enclos.getCreaturesPresentes()){
            creature.toString();
        }
    }

    public void displayPossibleCreatureToAdd(ArrayList<String> createNameList){
        for(int i = 0; i < createNameList.size(); i++){
            System.out.println( (i+1) + " - " + createNameList.get(i));
        }
    }

    public void displayCreatures(ArrayList<Creature> creatures){
        for (Creature creature : creatures){
            System.out.println(creature.toString());
        }
    }

    public void displayEnclosPossibleActions(){
        System.out.println("Q - Quitter l'enclos");
        if(enclos.getNbCreaturePresente() < enclos.getNbCreatureMax()){
            System.out.println("A - Ajouter une créature");
        }
        System.out.println("D - Afficher les créatures");

    }

    public void displayCreatureSelectionError(){
        System.out.println("Mauvais identifiant de créature");
    }

    public void displayEnclosAlreadyCleanMessage(){
        System.out.println("L'enclos est déja propre !");
    }

    public void displayEmptyNameError(){
        System.out.println("Nom invalide, l'enclos ne peut pas avoir un nom vide");
    }

    public void displaySuccessFullNameEditMessage(){
        System.out.println("Le nom de l'enclos a été changé avec succès");
    }

    public void displaySuccessFeedMessage(){
        System.out.println("Toutes les créature ont été nourries avec succès");
    }

    public void displayCreatures(){
        for(int i = 0; i < enclos.getNbCreaturePresente(); ++i){
            Creature creature = enclos.getCreaturesPresentes().get(i);
            VBox creatureVBbox = new VBox();
            creatureVBbox.getChildren().add(new Text(creature.getNom()));
            creatureVBbox.setPrefSize(100, 100);
            creatureVBbox.setStyle("-fx-background-color: green");
            creatureVBbox.setCursor(Cursor.HAND);
            creaturesContainer.add(creatureVBbox, i%creaturePerRow, i/creaturePerRow);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            enclosName.setText(enclos.getNom());
            displayCreatures();
            returnButton.setOnAction(event -> {
                new ZooFantastiqueController(ZooMain.getZoo()).visitZoo();
            });
        });
    }

    public EnclosView setEnclos(Enclos enclos){
        this.enclos = enclos;
        return this;
    }
}
