package view;

import models.Enclos;
import models.ZooFantastique;

import java.util.ArrayList;

public class ZooFantastiqueView {

    private ZooFantastique zooFantastique;

    public ZooFantastiqueView(ZooFantastique zooFantastique){
        this.zooFantastique = zooFantastique;
    }

    public void showSuccessfullNameEdit(){
        System.out.println("Le nom de votre zoo est maintenant : " + zooFantastique.getNom());
    }

    public void displayAllEnclos(ArrayList<Enclos> listeEnclos) {
        for(Enclos enclos : listeEnclos){
            System.out.println(enclos.toString());
        }
    }
}
