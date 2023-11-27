package ZooFantastique.view;

import ZooFantastique.models.Creature;
import ZooFantastique.models.enclos.Enclos;

import java.util.ArrayList;

public class EnclosView {

    private Enclos enclos;

    public EnclosView(Enclos enclos){
        this.enclos = enclos;
    }

    public void displayEnclos(){
        System.out.println(enclos.toString());
    }

    public void displayEnclosVisitMessage(){
        System.out.println("Vous entrez dans l'enclos " + enclos.getNom());
    }

    public void displayCreaturesInside(){
        for (Creature creature : enclos.getCreaturesPresentes()){
            creature.toString();
        }
    }

    public void displayPossibleCreatureToAdd(ArrayList<String> createNameList){
        for(int i = 0; i < createNameList.size(); i++){
            System.out.println( (i+1) + " - " + createNameList.get(i));
        }
    }

    public void displayCreatures(ArrayList<Creature> creatures){
        for (Creature creature : creatures){
            System.out.println(creature.toString());
        }
    }

}
