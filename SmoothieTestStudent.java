import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent {

    private Smoothie smoothie1;
    private Smoothie smoothie2;

    @BeforeEach
    void setUp() throws Exception {
        smoothie1 = new Smoothie("Berry Blast", Size.MEDIUM, 3, true);
        smoothie2 = new Smoothie("Tropical Mix", Size.LARGE, 2, false);
    }

    @AfterEach
    void tearDown() throws Exception {
        smoothie1 = null;
        smoothie2 = null;
    }

    @Test
    void testCalcPrice() {
        assertEquals(5.0, smoothie1.calcPrice(), 0.01);
        assertEquals(4.0, smoothie2.calcPrice(), 0.01);
    }

    @Test
    void testToString() {
        assertTrue(smoothie1.toString().contains("Berry Blast"));
        assertTrue(smoothie1.toString().contains("Protein Powder"));
        assertTrue(smoothie1.toString().contains("Fruits"));
        assertTrue(smoothie2.toString().contains("Tropical Mix"));
        assertTrue(smoothie2.toString().contains("No Protein Powder"));
    }

    @Test
    void testEqualsObject() {
        Smoothie smoothie3 = new Smoothie("Berry Blast", Size.MEDIUM, 3, true);
        assertTrue(smoothie1.equals(smoothie3));
        assertFalse(smoothie1.equals(smoothie2));
    }

    @Test
    void testSmoothie() {
        assertEquals("Berry Blast", smoothie1.getName());
        assertEquals(Size.MEDIUM, smoothie1.getSize());
        assertEquals(3, smoothie1.getNumFruits());
        assertTrue(smoothie1.getProteinPowder());
    }

    @Test
    void testSetNumFruits() {
        smoothie1.setNumFruits(5);
        assertEquals(5, smoothie1.getNumFruits());
    }

    @Test
    void testSetProteinPowder() {
        smoothie1.setProteinPowder(false);
        assertFalse(smoothie1.getProteinPowder());
    }

    @Test
    void testGetNumFruits() {
        assertEquals(3, smoothie1.getNumFruits());
    }

    @Test
    void testGetProteinPowder() {
        assertTrue(smoothie1.getProteinPowder());
    }
}
