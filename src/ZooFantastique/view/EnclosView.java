package ZooFantastique.view;

import ZooFantastique.models.creatures.Creature;
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

    public void displayEnclosPossibleActions(){
        System.out.println("Q - Quitter l'enclos");
        if(enclos.getNbCreaturePresente() < enclos.getNbCreatureMax()){
            System.out.println("A - Ajouter une créature");
        }
        System.out.println("D - Afficher les créatures");

    }

    public void displayCreatureSelectionError(){
        System.out.println("Mauvais identifiant de créature");
    }

    public void displayEnclosAlreadyCleanMessage(){
        System.out.println("L'enclos est déja propre !");
    }
}
