package models.creatures;

import models.Ovipare;
import models.interfaces.ISwim;

public class Megalodon extends Ovipare implements ISwim {

    @Override
    public void pondre() {
        System.out.println("Le megalodon met bas");
    }

    @Override
    public void swim() {
        System.out.println("Le megalodon nage");
    }
}
