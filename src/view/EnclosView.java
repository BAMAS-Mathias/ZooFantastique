package view;

import models.enclos.Enclos;

public class EnclosView {

    private Enclos enclos;

    public EnclosView(Enclos enclos){
        this.enclos = enclos;
    }

    public void displayEnclos(){
        System.out.println(enclos.toString());
    }
}
