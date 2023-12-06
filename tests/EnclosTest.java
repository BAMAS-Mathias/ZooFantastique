
import ZooFantastique.models.creatures.ovipares.Dragon;
import ZooFantastique.models.creatures.vivipares.Sirene;
import ZooFantastique.models.enclos.Enclos;
import ZooFantastique.models.enclos.Proprete;
import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class EnclosTest {


    @Test
    public void testClean() {
        Enclos enclos = new Enclos();
        enclos.clean();
        assertEquals(Proprete.BON, enclos.getPropreteDegre());

    }
    @Test
    public void testAddCreature() {
        Enclos enclos = new Enclos();
        Dragon dragon = new Dragon(enclos);

        enclos.addCreature(dragon);

        assertEquals(1, enclos.getNbCreaturePresente());
        assertTrue(enclos.getCreaturesPresentes().contains(dragon));
        System.out.println("Le test testAddCreature a réussi!");

    }
    @Test
    public void testfeedAllCreature() {
        Enclos enclos = new Enclos();
        Dragon dragon = new Dragon(enclos);
        Sirene sirene = new Sirene(enclos);

        enclos.addCreature(dragon);
        dragon.setHungry(true);
        sirene.setHungry(true);
        enclos.addCreature(sirene);

        enclos.nourrirAllCreature();

        assertFalse(dragon.isHungry());
        assertFalse(sirene.isHungry());
    }

    @Test
    public void testSizeEnclos() {
        Enclos enclos = new Enclos();
        Dragon dragon = new Dragon(enclos);
        int tailInitiale = enclos.getNbCreaturePresente();
        enclos.addCreature(dragon);
        assertEquals(tailInitiale + 1, enclos.getNbCreaturePresente());
    }


}





