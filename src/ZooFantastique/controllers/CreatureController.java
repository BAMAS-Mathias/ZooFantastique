package ZooFantastique.controllers;

import ZooFantastique.ZooMain;
import ZooFantastique.models.ZooFantastique;
import ZooFantastique.models.creatures.Creature;
import ZooFantastique.models.enclos.Aquarium;
import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.enclos.Voliere;
import ZooFantastique.models.interfaces.IFly;
import ZooFantastique.models.interfaces.IRun;
import ZooFantastique.models.interfaces.ISwim;
import ZooFantastique.view.CreatureView;
import ZooFantastique.view.EnclosView;
import ZooFantastique.view.TransfereCreatureView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import org.controlsfx.control.Notifications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CreatureController {


    public void emettreSon(Creature creature){
        CreatureView creatureView = new CreatureView(creature);
        Notifications.create().text(creature.getSonEmit()).title(creature.getNom()).showInformation();
    }

    public void nourrirCreature(Creature creature){
        creature.feed();
        visiterCreature(creature);
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/TransfererCreatureView.fxml"));
        loader.setControllerFactory(c -> new TransfereCreatureView(creature,getEnclosPossibles(creature)));

        try{
            ZooMain.getPrimaryStage().setScene(new Scene(loader.load()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void transfererCreature(Creature creature, Enclos enclos){
        creature.leaveEnclos();
        enclos.addCreature(creature);
        creature.setEnclos(enclos);
        new EnclosController().examinerEnclos(creature.getEnclos());
        Notifications.create().title("Transfert").text("Transféré avec succés").showConfirm();
    }

    private ArrayList<Enclos> getEnclosPossibles(Creature creature){
        ArrayList<Enclos> enclosList = new ArrayList<>();
        for(Enclos enclos : ZooMain.getZoo().getListeDesEnclos()){
            if(creature instanceof ISwim && enclos instanceof Aquarium){
                enclosList.add(enclos);
            }
            else if(creature instanceof IFly && enclos instanceof Voliere){
                enclosList.add(enclos);
            }
            else if(creature instanceof IRun && !(enclos instanceof Aquarium) && !(enclos instanceof Voliere)){
                enclosList.add(enclos);
            }
        }
        return enclosList;
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
