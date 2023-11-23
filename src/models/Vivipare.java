package models;

import java.util.ArrayList;

public abstract class Vivipare extends Creature{

    private ArrayList<Vivipare> listBabies = new ArrayList<>();
    private boolean isReadyToGiveBirth = false;
    private int gestatingTime;

    public int getGestatingTime(){
        return gestatingTime;
    }


    public void setGestatingTime(int value) {
        gestatingTime = value;
    }

    public boolean isReadyToGiveBirth(boolean state) {
        return isReadyToGiveBirth == state;
    }

    public void setIsReadyToGivebirth(boolean state) {
        isReadyToGiveBirth = state;
    }

    public abstract Vivipare giveBirth();
}
