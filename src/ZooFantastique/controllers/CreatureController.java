package ZooFantastique.controllers;

import ZooFantastique.ZooMain;
import ZooFantastique.models.creatures.Creature;
import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.view.CreatureView;
import ZooFantastique.view.EnclosView;

public class CreatureController {


    public void emettreSon(Creature creature){
        CreatureView creatureView = new CreatureView();
        creatureView.displayCreatureSound(creature.getSonEmit());
    }

    public void visiterCreature(int creatureIndex, Enclos enclos){
        try{
            Creature creature = enclos.getCreaturesPresentes().get(creatureIndex - 1);
            ZooMain.interactWithCreature(creature);
        }catch (IndexOutOfBoundsException e){
            new EnclosView(enclos).displayCreatureSelectionError();
        }
    }
}
