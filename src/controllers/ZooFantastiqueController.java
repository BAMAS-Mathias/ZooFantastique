package controllers;

import models.enclos.Enclos;
import models.ZooFantastique;
import view.ZooFantastiqueView;

import java.util.ArrayList;

public class ZooFantastiqueController {

    private ZooFantastique zooFantastique;

    public ZooFantastiqueController(ZooFantastique zooFantastique){
        this.zooFantastique = zooFantastique;
    }

    public void editName(String name){
        zooFantastique.setNom(name);
        new ZooFantastiqueView(zooFantastique).showSuccessfullNameEdit();
    }

    public void listerEnclos(){
        ArrayList<Enclos> listeEnclos =  zooFantastique.getListeDesEnclos();
        new ZooFantastiqueView(zooFantastique).displayAllEnclos(listeEnclos);
    }


}
