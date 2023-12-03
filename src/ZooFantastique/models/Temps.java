package ZooFantastique.models;

import java.util.Random;

public class Temps implements Runnable {

    private int secondes;
    private int minutes;
    private int heures;

    public Temps() {
        this.secondes = 0;
        this.minutes = 0;
        this.heures = 0;
    }

    public long getSecondes() {
        return secondes;
    }

    public void setSecondes(int secondes) {
        this.secondes = secondes;
    }

    public double getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public double getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(50);
                ++secondes;
                if(secondes >= 60){
                    ++minutes;
                    secondes = 0;
                }
                if(minutes >= 60){
                    ++heures;
                    minutes = 0;
                }
                if(heures >= 24) {
                    secondes = 0;
                    minutes = 0;
                    heures = 0;
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", heures, minutes, secondes);
    }
}
