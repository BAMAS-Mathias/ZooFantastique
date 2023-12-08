package ZooFantastique.models.creatures.vivipares.lycanthrope;


import ZooFantastique.ZooMain;
import ZooFantastique.models.Sexe;
import ZooFantastique.models.creatures.Etat;
import javafx.application.Platform;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

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

    public void dissoudreMeute(){
        getMembres().get(0).getEnclos().setMeute(null);
        for(Lycanthrope lycanthrope : getMembres()){
            lycanthrope.setMeute(null);
        }
        membres.clear();
        ZooMain.getColonie().remove(this);
    }

    public void notifyHurlement(Lycanthrope lycanthrope){
        for (int i = 0; i < getMembres().size(); i++){
            Lycanthrope membre = getMembres().get(i);
            if(membre.isSleeping() || membre.getEtat() == Etat.MALADE) continue;

            if(membre != lycanthrope){
                membre.hurlementRetour();
            }
            
            if(i == 4){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Notifications.create().position(Pos.TOP_LEFT).title("Hurlement").text("Le reste de la meute hurle").showInformation();
                    }
                });
                break;
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
        Lycanthrope strongestFemale = getStrongestFemale();
        if(newAlphaMale == null || strongestFemale == null) {
            dissoudreMeute();
            return;
        }
        getCoupleAlpha().setMaleAlpha(newAlphaMale);
        getCoupleAlpha().setFemelleAlpha(strongestFemale);
    }

    public Lycanthrope getStrongestFemale(){
        Lycanthrope strongest = null;
        for(Lycanthrope membre : membres){
            if(membre.getSexe() == Sexe.FEMELLE && (strongest == null || membre.getForce() > strongest.getForce())){
                strongest = membre;
            }
        }
        return strongest;
    }

    public Lycanthrope getStrongestMale(){
        Lycanthrope strongest = null;
        for(Lycanthrope membre : membres){
            if(membre.getSexe() == Sexe.MALE && (strongest == null || membre.getForce() > strongest.getForce())){
                strongest = membre;
            }
        }
        return strongest;
    }

    public ArrayList<Lycanthrope> getLycanthropesPerDominationRank(){
        ArrayList<Lycanthrope> lycanthropes = new ArrayList<Lycanthrope>();
        for(RangDomination rang : RangDomination.values()){
            for(Lycanthrope membre : getMembres()){
                if(membre.getRang() == rang){
                    lycanthropes.add(membre);
                }
            }
        }
        return lycanthropes;
    }

    public void removeMembre(Lycanthrope lycanthrope){
        getMembres().remove(lycanthrope);
        if(lycanthrope.getRang() != null && lycanthrope.getRang() == RangDomination.α){
            if(lycanthrope.getSexe() == Sexe.FEMELLE){
                updateCoupleAlpha(this.getCoupleAlpha().getMaleAlpha());
            }
            else{
                updateCoupleAlpha(getStrongestMale());
            }
        }
    }


    public ArrayList<Lycanthrope> getMembres() {
        return membres;
    }

}
