import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholTestStudent {

    private Alcohol alcohol1, alcohol2;

    @BeforeEach
    void setUp() throws Exception {
        alcohol1 = new Alcohol("Whiskey", Size.MEDIUM, true);
        alcohol2 = new Alcohol("Vodka", Size.LARGE, false);
    }

    @AfterEach
    void tearDown() throws Exception {
        alcohol1 = null;
        alcohol2 = null;
    }

    @Test
    void testCalcPrice() {
        assertEquals(3.6, alcohol1.calcPrice(), 0.01);
        assertEquals(3.0, alcohol2.calcPrice(), 0.01);
    }

    @Test
    void testToString() {
        String expected1 = "Whiskey MEDIUM Offered 3.6";
        assertTrue(alcohol1.toString().contains("Offered"));
        assertEquals(expected1, alcohol1.toString());
    }

    @Test
    void testEqualsObject() {
        assertFalse(alcohol1.equals(alcohol2));
    }

    @Test
    void testAlcohol() {
        assertEquals("Whiskey", alcohol1.getName());
        assertEquals(Size.MEDIUM, alcohol1.getSize());
        assertTrue(alcohol1.getOffered());
    }

    @Test
    void testSetOffered() {
        assertTrue(alcohol1.getOffered());
        alcohol1.setOffered(false);
        assertFalse(alcohol1.getOffered());
    }

    @Test
    void testGetOffered() {
        assertTrue(alcohol1.getOffered());
    }
}
