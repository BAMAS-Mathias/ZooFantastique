package ZooFantastique.models;

import ZooFantastique.models.creatures.ovipares.Dragon;
import ZooFantastique.models.creatures.ovipares.Kraken;
import ZooFantastique.models.creatures.ovipares.Megalodon;
import ZooFantastique.models.creatures.ovipares.Phoenix;
import ZooFantastique.models.creatures.vivipares.Licorne;
import ZooFantastique.models.creatures.vivipares.Lycanthrope;
import ZooFantastique.models.creatures.vivipares.Nymphe;
import ZooFantastique.models.creatures.vivipares.Sirene;

public class CreatureFactory {

    public Creature createCreature(String nom){
        switch (nom){
            case "Dragon":
                return new Dragon();
            case "Kraken":
                return new Kraken();
            case "Megalodon":
                return new Megalodon();
            case "Phoenix":
                return new Phoenix();
            case "Licorne":
                return new Licorne();
            case "Lycanthrope":
                return new Lycanthrope();
            case "Nymphe":
                return new Nymphe();
            case "Sirene":
                return new Sirene();
            default:
                return null;

        }
    }
}
