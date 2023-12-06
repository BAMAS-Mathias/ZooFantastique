package ZooFantastique;

import ZooFantastique.controllers.CreatureController;
import ZooFantastique.controllers.EnclosController;
import ZooFantastique.controllers.ZooFantastiqueController;
import ZooFantastique.models.TimeManager;
import ZooFantastique.models.creatures.Creature;
import ZooFantastique.models.creatures.ovipares.Phoenix;
import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.ZooFantastique;
import ZooFantastique.view.CreatureView;
import ZooFantastique.view.ZooWelcomeView;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class ZooMain extends Application {

    private static ZooFantastique zoo = new ZooFantastique(10);
    private static Stage primaryStage;
    private static TimeManager tps = new TimeManager();
    private static Thread th = new Thread(tps);

    @FXML
    private Button button;

    @FXML
    private TextArea text;

    @Override
    public void start(Stage primaryStage) throws IOException {
        ZooMain.primaryStage = primaryStage;
        th.start();
        zoo.addEnclos(new Enclos("Enclos 1"));
        zoo.addEnclos(new Enclos("Enclos 2"));
        zoo.addEnclos(new Enclos("Enclos de rayan"));
        zoo.getListeDesEnclos().get(0).addCreature(new Phoenix(zoo.getListeDesEnclos().get(0)));
        primaryStage.setTitle("Zoo Fantastique");
        new ZooWelcomeView().displayView();
        primaryStage.show();
    }

    /*
    public static void main(String[] args) {
        th.start();
        clearScreen();
        zoo.addEnclos(new Enclos("Enclos 1"));
        zoo.addEnclos(new Enclos("Enclos 2"));
        zoo.addEnclos(new Enclos("Enclos de rayan"));
        editZooName();

        System.out.println("Bienvenue dans le zoo : " + zoo.getNom() + "\n");

        interactWithZoo();
    }*/

    public static void interactWithZoo(){
        System.out.println("Entrez une commande pour intéragir\n");
        System.out.println("E - Lister tous les enclos");
        System.out.println("V [n] - Visiter un enclos");
        System.out.println("Q - Quitter le zoo ");
        System.out.println("C - Creer un enclos");
        System.out.println("Nombre total de créature : " + Creature.getNbCreature());
        System.out.println("Temps actuel : " + tps.toString());


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
                /*new EnclosController(zoo).visiterEnclos(Character.getNumericValue(input.charAt(2)));*/
                break;
            case 'C':
                new EnclosController().creerEnclos("Nom de l'enclos", "test");
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
        System.out.println("D - Renommer enclos");



        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch(Character.toUpperCase(input.charAt(0))){
            case 'Q':
                clearScreen();
                interactWithZoo();
                break;
            case 'A':
                /*new EnclosController().ajouterCreature(enclos);*/
                interactWithEnclos(enclos);
                break;
            case 'D':
                new EnclosController().afficherCreatures(enclos);
                interactWithEnclos(enclos);
                break;
            case 'C':
                new CreatureController().visiterCreature(null);
                break;
            case 'N':
                new EnclosController().nettoyerEnclos(enclos);
                break;
            case 'R':
                new EnclosController().renameEnclos(enclos);
                break;
            case 'F':
                new EnclosController().nourrirAllCreatures(enclos);
                break;

        }
        interactWithEnclos(enclos);
    }

    public static void interactWithCreature(Creature creature){
        clearScreen();
        (new CreatureView(creature)).displayActions();

        Scanner scanner = new Scanner(System.in);

        switch(Character.toUpperCase(scanner.next().charAt(0))){
            case 'Q':
                interactWithEnclos(creature.getEnclos());
                break;
            case 'E':
                new CreatureController().emettreSon(creature);
                break;
            case 'S':
                new CreatureController().soignerCreature(creature);
                break;
            case 'T':
                new CreatureController().transfererCreature(creature);
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

    public static ZooFantastique getZoo(){
        return zoo;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static TimeManager getTps() {
        return tps;
    }
}
