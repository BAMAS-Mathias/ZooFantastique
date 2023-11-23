package view;

import models.enclos.Enclos;

public class EnclosView {

    private Enclos enclos;

    public EnclosView(Enclos enclos) {
        this.enclos = enclos;
    }

    public void displayEnclos() {
        if (enclos != null) {
            System.out.println(enclos.toString());
        } else {
            System.out.println("Aucun enclos à afficher.");
        }
    }
}