package ZooFantastique.models.creatures.vivipares.lycanthrope;


import ZooFantastique.ZooMain;
import ZooFantastique.models.Sexe;
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

    public void notifyHurlement(Lycanthrope lycanthrope){
        for (int i = 0; i < getMembres().size(); i++){
            if(membres.get(i) != lycanthrope){
                membres.get(i).hurlementRetour();
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

    public Lycanthrope getStrongestMale(){
        Lycanthrope strongest = membres.get(0);
        for(Lycanthrope membre : membres){
            if(membre.getSexe() == Sexe.MALE && membre.getForce() > strongest.getForce()){
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


    public ArrayList<Lycanthrope> getMembres() {
        return membres;
    }

}
