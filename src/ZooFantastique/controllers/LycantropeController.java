package ZooFantastique.controllers;

import ZooFantastique.models.creatures.vivipares.lycanthrope.Lycanthrope;
import ZooFantastique.models.creatures.vivipares.lycanthrope.RangDomination;

public class LycantropeController {

    public void attempDomination(Lycanthrope dominant, Lycanthrope dominé){
        if(dominé.getRang() == RangDomination.α && dominant.attemptDomination(dominé)){
            System.out.println("Le lycantrope de rang " + dominé.getRang() + " est devenu le nouveau male du couple alpha");
        }else if(dominant.attemptDomination(dominé)){
            System.out.println("Lycantrope de rang " + dominant.getRang() + " a dominé le lycantrope de rang " + dominé.getRang());
        }else{
            System.out.println("Lycantrope de rang " + dominant.getRang() + " n'a pas dominé le lycantrope de rang " + dominé.getRang());
        }
    }
}
