

import ZooFantastique.models.creatures.ovipares.Dragon;
import ZooFantastique.models.enclos.Enclos;
import org.junit.*;
import org.junit.Test;

import static junit.framework.TestCase.*;
public class DragonTest {

    private Dragon  dragon;
    private Enclos enclos;
    @Before
    public void setUp() {
        enclos = new Enclos("");
        dragon = new Dragon(enclos);
    }

    @Test
    public void testPondrePereMere() {
        assertEquals(dragon, dragon.lay().getMere());
    }
}
