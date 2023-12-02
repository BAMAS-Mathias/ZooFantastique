package ZooFantastique.view;

import ZooFantastique.models.creatures.Creature;

public class CreatureView {

    public void displayActions(){
        System.out.println("E - Emettre un son");
        System.out.println("Q - Retourner dans l'enclos");
    }

    public void displayCreatureSound(String son){
        System.out.println(son);
    }
}
