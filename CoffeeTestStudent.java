import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeTestStudent {
    Coffee coffee;

    @BeforeEach
    void setUp() throws Exception {
        coffee = new Coffee("Latte", Size.MEDIUM, false, false);
    }

    @AfterEach
    void tearDown() throws Exception {
        coffee = null;
    }

    @Test
    void testCalcPrice() {
        coffee.setExtraShot(true);
        coffee.setExtraSyrup(true);
        assertEquals(5.0, coffee.calcPrice(), 0.01);
    }

    @Test
    void testToString() {
        coffee.setExtraShot(true);
        coffee.setExtraSyrup(false);
        assertTrue(coffee.toString().contains("Latte"));
        assertTrue(coffee.toString().contains("Extra shot: true"));
    }

    @Test
    void testEqualsObject() {
        Coffee coffee1 = new Coffee("Latte", Size.MEDIUM, true, false);
        Coffee coffee2 = new Coffee("Latte", Size.MEDIUM, true, false);
        assertTrue(coffee1.equals(coffee2));
        Coffee coffee3 = new Coffee("Mocha", Size.LARGE, false, false);
        assertFalse(coffee1.equals(coffee3));
    }

    @Test
    void testCoffee() {
        Coffee newCoffee = new Coffee("Espresso", Size.SMALL, true, true);
        assertNotNull(newCoffee);
        assertEquals("Espresso", newCoffee.getBevName());
        assertEquals(Size.SMALL, newCoffee.getSize());
        assertTrue(newCoffee.getExtraShot());
        assertTrue(newCoffee.getExtraSyrup());
    }

    @Test
    void testSetExtraShot() {
        coffee.setExtraShot(true);
        assertTrue(coffee.getExtraShot());
        coffee.setExtraShot(false);
        assertFalse(coffee.getExtraShot());
    }

    @Test
    void testSetExtraSyrup() {
        coffee.setExtraSyrup(true);
        assertTrue(coffee.getExtraSyrup());
        coffee.setExtraSyrup(false);
        assertFalse(coffee.getExtraSyrup());
    }

    @Test
    void testGetExtraShot() {
        coffee.setExtraShot(true);
        assertTrue(coffee.getExtraShot());
    }

    @Test
    void testGetExtraSyrup() {
        coffee.setExtraSyrup(true);
        assertTrue(coffee.getExtraSyrup());
    }
}
