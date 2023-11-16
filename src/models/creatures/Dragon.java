package models.creatures;

import models.Ovipare;
import models.interfaces.IFly;
import models.interfaces.IRevive;
import models.interfaces.IRun;
import models.interfaces.ISwim;

public class Dragon extends Ovipare implements IRun, ISwim, IFly, IRevive {

    @Override
    public void pondre() {
        System.out.println("Le dragon met bas");
    }

    @Override
    public void fly() {
        System.out.println("Le dragon vole");
    }

    @Override
    public void revive() {
        System.out.println("Le dragon revis par magie");
    }

    @Override
    public void run() {
        System.out.println("Le dragon court");
    }

    @Override
    public void swim() {
        System.out.println("Le dragon nage");
    }

}