package ZooFantastique;

import ZooFantastique.controllers.EnclosController;
import ZooFantastique.controllers.ZooFantastiqueController;
import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.ZooFantastique;

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

        System.out.println(input);

        interactWithZoo();
    }

    public static void interactWithEnclos(Enclos enclos){
        clearScreen();
        System.out.println("Vous etes dans l'enclos " + enclos.getNom());
        System.out.println("Q - Quitter l'enclos");

        Scanner scanner = new Scanner(System.in);

        switch(Character.toUpperCase(scanner.next().charAt(0))){
            case 'Q':
                clearScreen();
                interactWithZoo();
                break;
        }
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
