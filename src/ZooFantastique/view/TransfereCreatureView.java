package ZooFantastique.view;

import ZooFantastique.controllers.CreatureController;
import ZooFantastique.models.creatures.Creature;
import ZooFantastique.models.enclos.Enclos;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TransfereCreatureView implements Initializable {


    @FXML
    private HBox enclosPossibleContainer;

    private Creature creature;
    private ArrayList<Enclos> enclosPossibles;

    public TransfereCreatureView(Creature creature, ArrayList<Enclos> enclosPossibles) {
        this.creature = creature;
        this.enclosPossibles = enclosPossibles;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(Enclos enclos : enclosPossibles){
            Enclos current = enclos;
            VBox vbox = new VBox();
            vbox.getChildren().add(new Text(enclos.getNom()));
            vbox.getChildren().add(new Text(String.valueOf(enclos.getNbCreaturePresente())));
            vbox.setOnMouseReleased(mouseEvent -> {
                new CreatureController().transfererCreature(creature, current);
            });
            enclosPossibleContainer.getChildren().add(vbox);
        }
    }

}
