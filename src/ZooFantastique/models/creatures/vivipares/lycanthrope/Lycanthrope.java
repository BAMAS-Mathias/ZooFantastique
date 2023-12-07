package ZooFantastique.models.creatures.vivipares.lycanthrope;

import ZooFantastique.models.Sexe;
import ZooFantastique.models.creatures.vivipares.Vivipare;
import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.interfaces.IRun;
import javafx.application.Platform;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

import java.util.Random;

/**
 * La classe {@code Lycanthrope} représente une créature fantastique de type vivipare,
 * possiblement un être capable de se transformer en une forme animale, qui a la
 * capacité de courir. Elle étend les fonctionnalités de la classe {@link Vivipare}
 * et implémente l'interface {@link IRun}.
 * <p>
 * Le Lycanthrope peut avoir un processus de mise bas particulier et possède une
 * agilité notable pour courir.
 * </p>
 * <p>
 * @author [Raphael]
 * @version 1.0
 * @see Vivipare
 * @see IRun
 */
public class Lycanthrope extends Vivipare implements IRun {

    private double force;
    private double facteurDomination;
    private RangDomination rang;
    private double niveau;
    private double impétuosité;
    private Meute meute;


    public Lycanthrope(Enclos enclos) {
        super("Lycanthrope", enclos, "%SON LYCANTHROPE%");
        Random random = new Random();
        rang = RangDomination.values()[random.nextInt(1,RangDomination.values().length)];
        initStats();
    }

    public Lycanthrope(Enclos enclos, Sexe sexe){
        this(enclos);
        this.setSexe(sexe);
    }

    public Lycanthrope(Enclos enclos, RangDomination rang){
        this(enclos);
        this.rang = rang;
        initStats();
    }

    public void initStats(){
        Random random = new Random();
        impétuosité = random.nextDouble();
        facteurDomination = 10;
        force = random.nextInt(1,50);
        niveau = force * facteurDomination * rang.getRangPuissance();
    }

    /**
     * Permet au Lycanthrope de courir avec agilité.
     */
    @Override
    public void run() {
        // Implémentation spécifique de la course pour le Lycanthrope
    }

    public void hurler() {
        meute.notifyHurlement(this);
    }

    public void rejoindreMeute(Meute meute) {
        this.meute = meute;
        meute.getMembres().add(this);
    }

    public void quitterMeute() {
        meute.getMembres().remove(this);
        meute = null;
        rang = null;
    }

    public boolean canDominate(Lycanthrope lycanthrope){
        if(lycanthrope.getSexe() == Sexe.FEMELLE && lycanthrope.rang == RangDomination.α) return false;
        if(lycanthrope.getRang() == RangDomination.α && this.getRang() == RangDomination.α) return false;
        if(lycanthrope == this) return false;
        if(lycanthrope.getSexe() == Sexe.MALE && lycanthrope.rang == RangDomination.α) return true;
        return (this.force >= lycanthrope.force);
    }

    public boolean attemptDomination(Lycanthrope lycanthrope){
        System.out.println(this.getSexe() + " " + this.getRang() + " " + this.niveau);
        System.out.println(lycanthrope.getSexe() + " " + lycanthrope.getRang() + " " + lycanthrope.niveau);
        if(this.niveau > lycanthrope.niveau){
            achieveDomination(lycanthrope);
            return true;
        }
        return false;
    }


    public void achieveDomination(Lycanthrope lycanthrope){
        if(lycanthrope.getRang() == RangDomination.α){
            this.getMeute().updateCoupleAlpha(this);
        }

        /* Echange des rangs de domination */
        if(getRang().isInferior(lycanthrope.getRang())){
            RangDomination rangA = getRang();
            setRang(lycanthrope.getRang());
            lycanthrope.setRang(rangA);
        }

        /* Mise a jour des facteurs de domination */
        double dominationFactorToTake = new Random().nextInt(3) + 1;
        lycanthrope.facteurDomination = dominationFactorToTake;
        facteurDomination+=dominationFactorToTake;
    }



    public void transformer() {
        // TODO : Implémenter la transformation du Lycanthrope
    }

    public void hurlementRetour() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Notifications.create().position(Pos.TOP_LEFT).title("Hurlement").text("Un lycanthrope hurle au loin").showInformation();

            }
        });
    }

    public void baisserRang(){
        this.rang = rang.previousRang();
    }

    public void augmenterRang(){
        this.rang = rang.nextRang();
    }

    public RangDomination getRang() {
        return rang;
    }

    public void setRang(RangDomination rang) {
        this.rang = rang;
    }

    public Meute getMeute() {
        return meute;
    }

    public double getForce() {
        return force;
    }

    public void setNiveau(double niveau) {
        this.niveau = niveau;
    }
}