package ZooFantastique.controllers;

import ZooFantastique.models.ZooFantastique;
import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.view.EnclosView;
import ZooFantastique.ZooMain;

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
        // TODO Afficher les creatures
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

}