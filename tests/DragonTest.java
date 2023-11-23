
import ZooFantastique.models.creatures.ovipares.Dragon;
import org.junit.*;
import org.junit.Test;

import static junit.framework.TestCase.*;
public class DragonTest {

    private Dragon dragon;

    @Before
    public void setUp() {
        dragon = new Dragon();
    }

    @Test
    public void testPondrePereMere() {
        assertEquals(dragon, dragon.pondre().getMere());
    }
}
