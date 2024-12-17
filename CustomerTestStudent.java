import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTestStudent {

    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    void setUp() throws Exception {
        customer1 = new Customer("Alice", 25);
        customer2 = new Customer(customer1);
    }

    @AfterEach
    void tearDown() throws Exception {
        customer1 = null;
        customer2 = null;
    }

    @Test
    void testCustomerStringInt() {
        Customer customer = new Customer("Bob", 30);
        assertEquals("Bob", customer.getName());
        assertEquals(30, customer.getAge());
    }

    @Test
    void testCustomerCustomer() {
        assertEquals("Alice", customer2.getName());
        assertEquals(25, customer2.getAge());
    }

    @Test
    void testToString() {
        assertEquals("Alice 25", customer1.toString());
    }

    @Test
    void testSetName() {
        customer1.setName("Charlie");
        assertEquals("Charlie", customer1.getName());
    }

    @Test
    void testSetAge() {
        customer1.setAge(35);
        assertEquals(35, customer1.getAge());
    }

    @Test
    void testGetName() {
        assertEquals("Alice", customer1.getName());
    }

    @Test
    void testGetAge() {
        assertEquals(25, customer1.getAge());
    }
}
