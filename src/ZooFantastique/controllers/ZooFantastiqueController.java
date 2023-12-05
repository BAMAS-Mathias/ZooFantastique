package ZooFantastique.controllers;

import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.ZooFantastique;
import ZooFantastique.view.MainMenuView;
import ZooFantastique.view.ZooFantastiqueView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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

        try{
            new MainMenuView().displayView();
        }catch(Exception e){
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
