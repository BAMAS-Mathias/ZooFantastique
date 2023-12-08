package ZooFantastique.controllers;

import ZooFantastique.ZooMain;
import ZooFantastique.models.creatures.vivipares.lycanthrope.Meute;
import ZooFantastique.view.EnclosView;
import ZooFantastique.view.MeuteView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class MeuteController {

    public void visitMeute(Meute meute){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/MeuteView.fxml"));
        loader.setControllerFactory(c -> new MeuteView(meute));

        try{
            ZooMain.getPrimaryStage().setScene(new Scene(loader.load()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
