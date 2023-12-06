package ZooFantastique.models.creatures.vivipares.lycanthrope;

import java.util.ArrayList;
import java.util.Random;

public class CoupleAlpha {

    private Lycanthrope maleAlpha;
    private Lycanthrope femelleAlpha;

    public CoupleAlpha(Lycanthrope maleAlpha, Lycanthrope femelleAlpha) {
        this.maleAlpha = maleAlpha;
        this.femelleAlpha = femelleAlpha;
    }

    public Lycanthrope getMaleAlpha() {
        return maleAlpha;
    }

    public void setMaleAlpha(Lycanthrope maleAlpha) {
        this.maleAlpha = maleAlpha;
    }

    public Lycanthrope getFemelleAlpha() {
        return femelleAlpha;
    }

    public void setFemelleAlpha(Lycanthrope femelleAlpha) {
        this.femelleAlpha = femelleAlpha;
    }

    public ArrayList<Lycanthrope> reproduce(){
        int nbChildren = new Random().nextInt(1,7);
        ArrayList<Lycanthrope> childrenList = new ArrayList<>();
        for(int i = 0; i < nbChildren; i++){
            childrenList.add(new Lycanthrope(maleAlpha.getEnclos()));
        }
        return childrenList;
    }
}
