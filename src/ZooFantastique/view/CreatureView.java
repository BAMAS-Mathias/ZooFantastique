package ZooFantastique.view;

import ZooFantastique.controllers.CreatureController;
import ZooFantastique.controllers.EnclosController;
import ZooFantastique.models.creatures.Creature;
import ZooFantastique.models.creatures.Etat;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CreatureView implements Initializable {

    @FXML
    private Button returnButton;

    @FXML
    private Button transfererButton;

    @FXML
    private HBox actionButtonList;

    @FXML
    private Text creatureNameText;

    @FXML
    private Text creatureSexeText;

    @FXML
    private Text creaturePoidsText;

    @FXML
    private Text creatureSizeText;

    @FXML
    private Text creatureAgeText;

    @FXML
    private Text creatureHealthText;

    @FXML
    private Text creatureHungryText;

    @FXML
    private Text creatureSleepText;

    @FXML
    private Text creatureEtatText;

    @FXML
    private VBox creatureImageContainer;

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
        BackgroundImage myBI= new BackgroundImage(new Image("/assets/creaturePictures/" + creature.getNom() + ".png",700,500,false,true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        creatureImageContainer.setBackground(new Background(myBI));

        creatureNameText.setText(creature.getNom());
        creatureSexeText.setText(creature.getSexe().toString());
        creatureAgeText.setText(String.valueOf(creature.getAge()));
        creatureHealthText.setText(String.valueOf(creature.getSante()));
        creaturePoidsText.setText(String.valueOf(creature.getPoids()));
        creatureSizeText.setText(String.valueOf(creature.getTaille()));
        creatureEtatText.setText(creature.getEtat().toString());

        if(!creature.isHungry()){
            creatureHungryText.setVisible(false);
        }
        if(!creature.isSleeping()){
            creatureSleepText.setVisible(false);
        }

        Button emettreSonButton = new Button("Emettre son");
        emettreSonButton.setPrefSize(120,40);
        emettreSonButton.setOnAction(actionEvent -> {
            new CreatureController().emettreSon(creature);
        });

        transfererButton.setOnAction(actionEvent -> {
            new CreatureController().transfererCreature(creature);
        });


        actionButtonList.getChildren().add(emettreSonButton);

        if(creature.isHungry() && !creature.isSleeping()){
            Button feedCretureButton = new Button("Nourrir");
            feedCretureButton.setPrefSize(120,40);
            feedCretureButton.setOnAction(actionEvent -> {
                new CreatureController().nourrirCreature(creature);
            });
            actionButtonList.getChildren().add(feedCretureButton);
        }

        if(creature.getSante() < creature.getSanteMax() || creature.getEtat() == Etat.MALADE){
            Button healCretureButton = new Button("Soigner");
            healCretureButton.setPrefSize(120,40);
            healCretureButton.setOnAction(actionEvent -> {
                new CreatureController().healCreature(creature);
            });
            actionButtonList.getChildren().add(healCretureButton);
        }








    }
}
