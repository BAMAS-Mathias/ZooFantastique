package ZooFantastique.models.creatures.vivipares.lycanthrope;


import java.util.ArrayList;

public class Meute {

    private ArrayList<Lycanthrope> membres;
    private CoupleAlpha coupleAlpha;

    private void Meute(Lycanthrope maleAlpha, Lycanthrope femelleAlpha){
        membres = new ArrayList<Lycanthrope>();
        membres.add(maleAlpha);
        membres.add(femelleAlpha);
        coupleAlpha = new CoupleAlpha(maleAlpha, femelleAlpha);
    }
}
