package ZooFantastique.models.creatures.vivipares.lycanthrope;


import ZooFantastique.ZooMain;
import ZooFantastique.models.Sexe;

import java.util.ArrayList;

public class Meute {

    private ArrayList<Lycanthrope> membres;
    private CoupleAlpha coupleAlpha;

    public Meute(Lycanthrope male, Lycanthrope femelle){
        membres = new ArrayList<Lycanthrope>();
        male.rejoindreMeute(this);
        femelle.rejoindreMeute(this);
        male.setRang(RangDomination.α);
        femelle.setRang(RangDomination.α);
        coupleAlpha = new CoupleAlpha(male, femelle);
        ZooMain.getColonie().add(this);
    }

    public void notifyHurlement(Lycanthrope lycanthrope){
        for (Lycanthrope membre : membres){
            if(membre != lycanthrope){
                membre.hurlementRetour();
            }
        }
    }

    public boolean containsRang(RangDomination rang){
        for(Lycanthrope membre : getMembres()){
            if(membre.getRang() == rang) return true;
        }return false;
    }

    public CoupleAlpha getCoupleAlpha() {
        return coupleAlpha;
    }

    public void updateCoupleAlpha(Lycanthrope newAlphaMale){
        getCoupleAlpha().setMaleAlpha(newAlphaMale);
        getCoupleAlpha().setFemelleAlpha(getStrongestFemale());
    }

    public Lycanthrope getStrongestFemale(){
        Lycanthrope strongest = membres.get(0);
        for(Lycanthrope membre : membres){
            if(membre.getSexe() == Sexe.FEMELLE && membre.getForce() > strongest.getForce()){
                strongest = membre;
            }
        }
        return strongest;
    }

    public ArrayList<Lycanthrope> getMembres() {
        return membres;
    }

}
