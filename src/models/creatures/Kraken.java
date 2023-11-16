package models.creatures;

import models.Ovipare;
import models.interfaces.ISwim;

public class Kraken extends Ovipare implements ISwim {

    @Override
    public void pondre() {
        System.out.println("Kraken met bas");
    }

    @Override
    public void swim() {
        System.out.println("Kraken nage");
    }
}