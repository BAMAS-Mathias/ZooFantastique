package ZooFantastique.controllers;

import ZooFantastique.models.Creature;
import ZooFantastique.models.CreatureFactory;
import ZooFantastique.models.ZooFantastique;
import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.view.EnclosView;
import ZooFantastique.ZooMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * La classe {@code EnclosController} est responsable de contrôler les interactions
 * liées aux enclos dans l'application. Elle facilite la communication entre
 * le modèle ({@link Enclos}) et la vue ({@link ZooFantastique.view.EnclosView}).
 * <p>
 * La principale fonctionnalité fournie par ce contrôleur est d'examiner les enclos
 * en affichant des informations via la {@link ZooFantastique.view.EnclosView} associée.
 * </p>
 * <p>
 *
 * @author [Raphael]
 * @version 1.0
 * @see Enclos
 * @see ZooFantastique.view.EnclosView
 */
public class EnclosController {

    private ZooFantastique zoo;

    public EnclosController(ZooFantastique zoo) {
        this.zoo = zoo;
    }

    /**
     * Affiche des informations sur les enclos en utilisant la {@link ZooFantastique.view.EnclosView} associée.
     */
    public void examinerEnclos() {
        EnclosView enclosView = new EnclosView(null);
        enclosView.displayEnclos();
    }

    public void visiterEnclos(int indexEnclos){
        System.out.println(indexEnclos);
        Enclos enclos = zoo.getListeDesEnclos().get(indexEnclos - 1);
        EnclosView enclosView = new EnclosView(enclos);
        ZooMain.interactWithEnclos(enclos);
    }

    public void afficherCreatures(Enclos enclos){
        ArrayList<Creature> creatures = enclos.getCreaturesPresentes();
        EnclosView enclosView = new EnclosView(enclos);
        enclosView.displayCreatures(creatures);
    }

    public void creerEnclos(String nomEnclos, int capaciteMaxAnimaux) {
        Enclos nouvelEnclos = new Enclos(nomEnclos, capaciteMaxAnimaux);
        zoo.addEnclos(nouvelEnclos);
        System.out.println("Nouvel enclos créé avec succès : " + nouvelEnclos);
        editEnclosName(nouvelEnclos);

    }

    public void editEnclosName(Enclos enclos){
        System.out.println("Entrer le nom de votre enclos : ");
        Scanner scanner = new Scanner(System.in);
        String enclosName = (scanner.nextLine());
        enclos.setName(enclosName);
        System.out.println("Votre nom d'enclos est: "+ enclosName);
    }

    public void ajouterCreature(Enclos enclos){
        EnclosView enclosView = new EnclosView(enclos);
        ArrayList<String> creatureNameList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String userInput = "";


        if(!enclos.isEmpty()){ // L'enclos contient deja une creature donc on a seulement un type possible
            creatureNameList.add(enclos.getCreaturesPresentes().get(0).getNom());
        }
        else{ // L'enclos est vide donc on a tous les types possibles
            creatureNameList.addAll(Arrays.asList("Dragon","Kraken","Magalodon","Phoenix","Licorne","Lycanthrope","Nymphe","Sirene"));
        }

        enclosView.displayPossibleCreatureToAdd(creatureNameList);
        try{
            int indexCreature = Integer.parseInt(scanner.nextLine());
            CreatureFactory creatureFactory = new CreatureFactory();
            enclos.addCreature(creatureFactory.createCreature(creatureNameList.get(indexCreature - 1)));
        }catch (Exception e){
            System.out.println("Entrer le nom de la creature que vous voulez ajouter : ");
            userInput = scanner.nextLine();
        }
    }

}