package ZooFantastique.models;

import ZooFantastique.models.creatures.vivipares.lycanthrope.Lycanthrope;
import javafx.application.Platform;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

import java.util.ArrayList;
import java.util.Arrays;

public class TimeManager implements Runnable {

    private static int jour;
    private static String mois;
    private static int annee;
    private final EventManager eManager = new EventManager();

    private final ArrayList<String> listeMois = new ArrayList<>(Arrays.asList("Janvier", "Février", "Mars", "Avril", "Mai", "Juin",
            "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"));

    public TimeManager() {
        jour = 1;
        mois = "Janvier";
        annee = 2023;
    }

    public String getDate(){
        return jour + " " + mois + " " + annee;
    }

    @Override
    public void run() {
        ArrayList<String> mois31Jours = new ArrayList<>(Arrays.asList("Janvier", "Mars", "Mai", "Juillet", "Août", "Octobre", "Décembre"));

        while(true) {
            try {
                Thread.sleep(150);
                if (jour == 28 && mois.equals("Fevrier")) {
                    jour = 1;
                    mois = "Mars";
                } else if (jour == 30 && !mois31Jours.contains(mois)) {
                    jour = 1;
                    mois = listeMois.get((listeMois.indexOf(mois) + 1) % 12);
                } else if (jour == 31 && mois31Jours.contains(mois)) {
                    if (mois.equals("Décembre")) {
                        annee++;
                    }
                    jour = 1;
                    mois = listeMois.get((listeMois.indexOf(mois) + 1) % 12);
                } else {
                    jour++;
                    eManager.handleZooEvent();
                }

                if(jour == 1 && mois.equals(Lycanthrope.getMoisSaisonAmour().get(0))){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Notifications.create().text("Debut de la saison des amours").position(Pos.TOP_CENTER).showInformation();
                        }
                    });
                }
                if(jour == 30 && mois.equals(Lycanthrope.getMoisSaisonAmour().get(Lycanthrope.getMoisSaisonAmour().size()-1))){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Notifications.create().text("Fin de la saison des amours").position(Pos.TOP_CENTER).showInformation();
                        }
                    });
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getMois() {
        return mois;
    }
}
