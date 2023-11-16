package controllers;

import models.Enclos;
import view.EnclosView;

public class EnclosController {

    public void examinerEnclos(){
        EnclosView enclosView = new EnclosView(null);
        enclosView.displayEnclos();
    }

}
