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

public class ZooFantastiqueController{

    @FXML
    private TextArea zooNameArea;

    @FXML
    private Button confirmEditButton;

    @FXML
    private Text zooNameText;

    private ZooFantastique zooFantastique;


    public ZooFantastiqueController(ZooFantastique zooFantastique){
        this.zooFantastique = zooFantastique;
    }

    public void visitZoo(){
        try {
            new MainMenuView().displayView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startZoo(String nomZoo){
        zooFantastique.setNom(nomZoo);
        ZooMain.getTh().start();

        try{
            new MainMenuView().displayView();
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    public void creerEnclos(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/CreateEnclosViewFXML.fxml"));
        loader.setControllerFactory(c -> new CreateEnclosView());
        try{
            ZooMain.getPrimaryStage().setScene(new Scene(loader.load()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void editName(String name){
        zooFantastique.setNom(name);
        /*new ZooFantastiqueView(zooFantastique).showSuccessfullNameEdit();*/
    }

    public void listerEnclos(){
        ArrayList<Enclos> listeEnclos =  zooFantastique.getListeDesEnclos();
        /*new ZooFantastiqueView(zooFantastique).displayAllEnclos(listeEnclos);*/
    }
}
