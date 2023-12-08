package ZooFantastique.controllers;

import ZooFantastique.models.creatures.vivipares.lycanthrope.Lycanthrope;
import ZooFantastique.models.creatures.vivipares.lycanthrope.RangDomination;

public class LycantropeController {

    public void attempDomination(Lycanthrope dominant, Lycanthrope dominé){
        boolean dominationSuccess = dominant.attemptDomination(dominé);
        if(dominé.getRang() == RangDomination.α && dominationSuccess){
            System.out.println("Le lycantrope de rang " + dominé.getRang() + " est devenu le nouveau male du couple alpha");
        }else if(dominationSuccess){
            System.out.println("Lycantrope de rang " + dominant.getRang() + " a dominé le lycantrope de rang " + dominé.getRang());
        }else{
            System.out.println("Lycantrope de rang " + dominant.getRang() + " n'a pas dominé le lycantrope de rang " + dominé.getRang());
        }
    }
}
