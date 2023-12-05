package ZooFantastique.view;

import ZooFantastique.ZooMain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuView implements Initializable {

    @FXML
    private Text zooNameText;

    public MainMenuView() {

    }

    public void displayView() throws IOException {
        AnchorPane scene = FXMLLoader.load(getClass().getResource("../fxml/MainZooView.fxml"));
        ZooMain.getPrimaryStage().setScene(new Scene(scene));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        zooNameText.setText(ZooMain.getZoo().getNom());
    }
}
