package view;

import models.Enclos;
import models.ZooFantastique;

import java.util.ArrayList;

public class ZooFantastiqueView{

    private ZooFantastique zooFantastique;

    public ZooFantastiqueView(ZooFantastique zooFantastique){
        this.zooFantastique = zooFantastique;
    }

    public void showSuccessfullNameEdit(){
        System.out.println("Le nom de votre zoo est maintenant : " + zooFantastique.getNom());
    }

    public void displayAllEnclos(ArrayList<Enclos> listeEnclos) {
        for(int i = 0; i < listeEnclos.size(); ++i){
            System.out.println(i+1 + " - " + listeEnclos.get(i));
        }
    }


}
