import controllers.ZooFantastiqueController;
import models.Enclos;
import models.ZooFantastique;

import java.util.Scanner;

public class Main {

    private static ZooFantastique zoo = new ZooFantastique(10);

    public static void main(String[] args) {
        zoo.addEnclos(new Enclos("Enclos 1"));
        zoo.addEnclos(new Enclos("Enclos 2"));
        zoo.addEnclos(new Enclos("Enclos de rayan"));
        editZooName();

        interactWithZoo();
    }

    public static void interactWithZoo(){
        System.out.println("Bienvenue dans le zoo : " + zoo.getNom() + "\n");
        System.out.println("Entrez une commande pour intéragir\n");
        System.out.println("E - Lister tous les enclos");
        System.out.println("V [n] - Visiter un enclos");

        Scanner scanner = new Scanner(System.in);

        switch (scanner.next().charAt(0)){
            case 'E':
                new ZooFantastiqueController(zoo).listerEnclos();
                break;
        }

        interactWithZoo();
    }

    public static void editZooName(){
        Scanner scanner = new Scanner(System.in);

        if(!zoo.hasName()){
            System.out.println("Merci de changer le nom de votre zoo");
            new ZooFantastiqueController(zoo).editName(scanner.nextLine());
        }
    }


}
