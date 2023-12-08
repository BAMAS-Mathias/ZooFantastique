package ZooFantastique.controllers;

import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.ZooFantastique;
import ZooFantastique.view.CreateEnclosView;
import ZooFantastique.view.MainMenuView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import ZooFantastique.ZooMain;

import java.util.ArrayList;
/**
 * La classe ZooFantastiqueController gère les opérations liées au zoo fantastique.
 */
public class ZooFantastiqueController{

    @FXML
    private TextArea zooNameArea;

    @FXML
    private Button confirmEditButton;

    @FXML
    private Text zooNameText;

    private ZooFantastique zooFantastique;

    /**
     * Constructeur de la classe ZooFantastiqueController.
     *
     * @param zooFantastique Le zoo fantastique à gérer.
     */
    public ZooFantastiqueController(ZooFantastique zooFantastique){
        this.zooFantastique = zooFantastique;
    }
    /**
     * Visite le zoo en affichant la vue du menu principal.
     */
    public void visitZoo(){
        try {
            new MainMenuView().displayView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Démarre le zoo avec le nom spécifié.
     *
     * @param nomZoo Le nom du zoo à démarrer.
     */
    public void startZoo(String nomZoo){
        zooFantastique.setNom(nomZoo);
        ZooMain.getTh().start();

        try{
            new MainMenuView().displayView();
        }catch(Exception e){
            e.printStackTrace();
        }


    }
    /**
     * Crée un nouvel enclos en affichant la vue de création d'enclos.
     */
    public void creerEnclos(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/CreateEnclosViewFXML.fxml"));
        loader.setControllerFactory(c -> new CreateEnclosView());
        try{
            ZooMain.getPrimaryStage().setScene(new Scene(loader.load()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Édite le nom du zoo.
     *
     * @param name Le nouveau nom du zoo.
     */
    public void editName(String name){
        zooFantastique.setNom(name);
        /*new ZooFantastiqueView(zooFantastique).showSuccessfullNameEdit();*/
    }

    /**
     * Liste tous les enclos du zoo.
     */
    public void listerEnclos(){
        ArrayList<Enclos> listeEnclos =  zooFantastique.getListeDesEnclos();
        /*new ZooFantastiqueView(zooFantastique).displayAllEnclos(listeEnclos);*/
    }
}
