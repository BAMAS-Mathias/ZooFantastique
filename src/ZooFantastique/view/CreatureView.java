package ZooFantastique.view;

import ZooFantastique.controllers.EnclosController;
import ZooFantastique.models.creatures.Creature;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class CreatureView implements Initializable {

    @FXML
    private Button returnButton;

    private Creature creature;

    public void displayActions(){
        System.out.println("E - Emettre un son");
        System.out.println("Q - Retourner dans l'enclos");
    }

    public void displayCreatureSound(String son){
        System.out.println(son);
    }

    public void displayHealMessage(){
        System.out.println("La creature a été soignée avec succès ");
    }

    public void displayCreatureFullHealthMessage(){
        System.out.println("La santé de la créature est déja au maximum");
    }

    public void displayInputErrorMessage(){
        System.out.println("La valeur entrée est incorrect");
    }

    public void displaySuccessTransferMessage(){
        System.out.println("La créature a été transférée avec succès");
    }

    public CreatureView(Creature creature){
        this.creature = creature;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        returnButton.setOnAction(event -> {
            new EnclosController().examinerEnclos(creature.getEnclos());
        });


    }
}
