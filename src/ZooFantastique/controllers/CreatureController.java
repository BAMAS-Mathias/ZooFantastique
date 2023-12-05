package ZooFantastique.controllers;

import ZooFantastique.ZooMain;
import ZooFantastique.models.ZooFantastique;
import ZooFantastique.models.creatures.Creature;
import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.view.CreatureView;
import ZooFantastique.view.EnclosView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.Scanner;

public class CreatureController {


    public void emettreSon(Creature creature){
        CreatureView creatureView = new CreatureView(creature);
        creatureView.displayCreatureSound(creature.getSonEmit());
    }

    public void visiterCreature(Creature creature){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/CreatureViewFXML.fxml"));
        loader.setControllerFactory(c -> new CreatureView(creature));

        try{
            ZooMain.getPrimaryStage().setScene(new Scene(loader.load()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void soignerCreature(Creature creature){
        CreatureView creatureView =  new CreatureView(creature);
        if(creature.getSante() == creature.getSanteMax()){
            creatureView.displayCreatureFullHealthMessage();
        }else{
            creature.heal();
            creatureView.displayHealMessage();
        }
    }

    public void transfererCreature(Creature creature){
        CreatureView creatureView = new CreatureView(creature);
        Scanner scanner = new Scanner(System.in);
        ArrayList<Enclos> enclosPossible = getEnclosForTransfer(creature);
        for(int i = 0; i < enclosPossible.size(); ++i){
            System.out.println(i+1 + " - " + enclosPossible.get(i).getNom());
        }

        try{
            int nbInput = Character.getNumericValue(scanner.next().charAt(0)) - 1;
            Enclos e = enclosPossible.get(nbInput);
            e.addCreature(creature);
            e.removeCreature(creature);
            creature.setEnclos(e);
            creatureView.displaySuccessTransferMessage();
        }catch(Exception e){
            e.printStackTrace();
            creatureView.displayInputErrorMessage();
        }
    }

    private ArrayList<Enclos> getEnclosForTransfer(Creature creature){
        ZooFantastique zooFantastique = ZooMain.getZoo();
        ArrayList<Enclos> enclosPossible = new ArrayList<>();
        for(Enclos enclos : zooFantastique.getListeDesEnclos()){
            if(enclos.isEmpty()) enclosPossible.add(enclos);
            else{
                if(enclos.getCreaturesPresentes().get(0).getNomEspece().equals(creature.getNomEspece())){
                    if(enclos.getNbCreaturePresente() < enclos.getNbCreatureMax()){
                        enclosPossible.add(enclos);
                    }
                }
            }
        }
        System.out.println(enclosPossible.size());
        return enclosPossible;
    }
}
