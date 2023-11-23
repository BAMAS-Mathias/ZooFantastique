
import models.creatures.ovipares.Dragon;
import models.creatures.vivipares.Sirene;
import org.junit.*;
import org.junit.Test;

import static junit.framework.TestCase.*;
public class DragonTest {

    private Sirene sirene;

    @Before
    public void setUp() {
        sirene = new Sirene();
    }

    @Test
    public void testGiveBirth() {
        sirene.setIsReadyToGivebirth(false);
        Sirene bebe = sirene.giveBirth();
        assertNotSame(sirene, bebe);
    }
}
