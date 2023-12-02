package ZooFantastique;

import ZooFantastique.controllers.CreatureController;
import ZooFantastique.controllers.EnclosController;
import ZooFantastique.controllers.ZooFantastiqueController;
import ZooFantastique.models.creatures.Creature;
import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.ZooFantastique;
import ZooFantastique.view.CreatureView;

import java.util.Scanner;

public class ZooMain {

    private static ZooFantastique zoo = new ZooFantastique(10);

    public static void main(String[] args) {
        clearScreen();
        zoo.addEnclos(new Enclos("Enclos 1"));
        zoo.addEnclos(new Enclos("Enclos 2"));
        zoo.addEnclos(new Enclos("Enclos de rayan"));
        editZooName();

        System.out.println("Bienvenue dans le zoo : " + zoo.getNom() + "\n");

        interactWithZoo();
    }

    public static void interactWithZoo(){
        System.out.println("Test Entrez une commande pour intéragir\n");
        System.out.println("E - Lister tous les enclos");
        System.out.println("V [n] - Visiter un enclos");
        System.out.println("Q - Quitter le zoo ");
        System.out.println("C - Creer un enclos");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (Character.toUpperCase(input.charAt(0))){
            case 'E':
                clearScreen();
                new ZooFantastiqueController(zoo).listerEnclos();
                break;
            case 'Q':
                return;
            case 'V':
                clearScreen();
                new EnclosController(zoo).visiterEnclos(Character.getNumericValue(input.charAt(2)));
                break;
            case 'C':
                new EnclosController(zoo).creerEnclos("Nom de l'enclos", 50);
                break;


        }

        interactWithZoo();
    }

    public static void interactWithEnclos(Enclos enclos){
        System.out.println("Vous etes dans l'enclos " + enclos.getNom());
        System.out.println("Q - Quitter l'enclos");
        System.out.println("A - Ajouter une créature");
        System.out.println("D - Afficher les créatures");
        System.out.println("C [n] - Visiter creature");



        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch(Character.toUpperCase(input.charAt(0))){
            case 'Q':
                clearScreen();
                interactWithZoo();
                break;
            case 'A':
                new EnclosController(zoo).ajouterCreature(enclos);
                interactWithEnclos(enclos);
                break;
            case 'D':
                new EnclosController(zoo).afficherCreatures(enclos);
                interactWithEnclos(enclos);
                break;
            case 'C':
                new CreatureController().visiterCreature(Character.getNumericValue(input.charAt(2)), enclos);
                break;

        }
        //interactWithEnclos(enclos);
    }

    public static void interactWithCreature(Creature creature){
        clearScreen();
        (new CreatureView()).displayActions();

        Scanner scanner = new Scanner(System.in);

        switch(Character.toUpperCase(scanner.next().charAt(0))){
            case 'Q':
                interactWithEnclos(creature.getEnclos());
                break;
            case 'E':
                new CreatureController().emettreSon(creature);
                break;
        }
        interactWithCreature(creature);
    }

    public static void editZooName(){
        Scanner scanner = new Scanner(System.in);

        if(!zoo.hasName()){
            System.out.println("Merci de changer le nom de votre zoo");
            new ZooFantastiqueController(zoo).editName(scanner.nextLine());
        }
    }


    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}
