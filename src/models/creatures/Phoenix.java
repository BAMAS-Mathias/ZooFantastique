package models.creatures;

import models.Ovipare;
import models.interfaces.IFly;
import models.interfaces.IRevive;
;

public class Phoenix extends Ovipare implements IRevive, IFly {

    @Override
    public void pondre() {
        System.out.println("Le phoenix met bas ");
    }

    @Override
    public void fly() {
        System.out.println("Le phoenix vole ");
    }

    @Override
    public void revive() {
        System.out.println("Le phoenix revit par magie ");
    }

}
