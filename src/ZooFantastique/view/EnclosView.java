package ZooFantastique.view;

import ZooFantastique.models.Creature;
import ZooFantastique.models.enclos.Enclos;

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

}
