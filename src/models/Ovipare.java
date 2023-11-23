package models;

import java.util.ArrayList;

public abstract class Ovipare extends Creature{

    private ArrayList<Oeuf> eggList = new ArrayList<>();
    private int gestatingTime;
    public static int nbOvipare = 0;

    public ArrayList<Oeuf> getEggList() {
        return eggList;
    }

    public int getGestatingTime(){
        return gestatingTime;
    }

    public void setGestatingTime(int value) {
        gestatingTime = value;
    }

    public abstract Oeuf lay();
}
