import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BevShopTestStudent {
    BevShop shop;

    @BeforeEach
    void setUp() throws Exception {
        shop = new BevShop();
    }

    @AfterEach
    void tearDown() throws Exception {
        shop = null;
    }

    @Test
    void testBevShop() {
        assertNotNull(shop);
    }

    @Test
    void testIsValidTime() {
        assertTrue(shop.isValidTime(10));
        assertFalse(shop.isValidTime(23));
    }

    @Test
    void testGetMaxNumOfFruits() {
        assertEquals(5, shop.getMaxNumOfFruits());
    }

    @Test
    void testGetMinAgeForAlcohol() {
        assertEquals(21, shop.getMinAgeForAlcohol());
    }

    @Test
    void testIsMaxFruit() {
        assertTrue(shop.isMaxFruit(5));
        assertFalse(shop.isMaxFruit(3));
    }

    @Test
    void testGetMaxOrderForAlcohol() {
        assertEquals(3, shop.getMaxOrderForAlcohol());
    }

    @Test
    void testIsEligibleForMore() {
        shop.startNewOrder(10, Day.MONDAY, "John", 25);
        shop.processAlcoholOrder("Wine", Size.LARGE);
        shop.processAlcoholOrder("Beer", Size.SMALL);
        assertTrue(shop.isEligibleForMore());
        shop.processAlcoholOrder("Vodka", Size.MEDIUM);
        assertFalse(shop.isEligibleForMore());
    }

    @Test
    void testGetNumOfAlcoholDrink() {
        shop.startNewOrder(12, Day.FRIDAY, "Jake", 30);
        shop.processAlcoholOrder("Whiskey", Size.LARGE);
        assertEquals(1, shop.getNumOfAlcoholDrink());
    }

    @Test
    void testIsValidAge() {
        assertTrue(shop.isValidAge(25));
        assertFalse(shop.isValidAge(19));
    }

    @Test
    void testStartNewOrder() {
        shop.startNewOrder(11, Day.SATURDAY, "Anna", 28);
        assertNotNull(shop.getCurrentOrder());
    }

    @Test
    void testProcessCoffeeOrder() {
        shop.startNewOrder(9, Day.SUNDAY, "Tom", 23);
        shop.processCoffeeOrder("Latte", Size.MEDIUM, true, false);
        assertEquals(1, shop.getCurrentOrder().getTotalItems());
    }

    @Test
    void testProcessAlcoholOrder() {
        shop.startNewOrder(10, Day.FRIDAY, "Jane", 22);
        shop.processAlcoholOrder("Wine", Size.LARGE);
        assertEquals(1, shop.getNumOfAlcoholDrink());
    }

    @Test
    void testProcessSmoothieOrder() {
        shop.startNewOrder(12, Day.MONDAY, "Sam", 20);
        shop.processSmoothieOrder("Green Smoothie", Size.LARGE, 2, true);
        assertEquals(1, shop.getCurrentOrder().getTotalItems());
    }

    @Test
    void testFindOrder() {
        shop.startNewOrder(9, Day.THURSDAY, "Chris", 27);
        int orderNo = shop.getCurrentOrder().getOrderNo();
        assertNotNull(shop.findOrder(orderNo));
    }

    @Test
    void testTotalOrderPrice() {
        shop.startNewOrder(11, Day.WEDNESDAY, "Sara", 26);
        shop.processAlcoholOrder("Beer", Size.SMALL);
        shop.processCoffeeOrder("Espresso", Size.LARGE, true, false);
        assertTrue(shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo()) > 0);
    }

    @Test
    void testTotalMonthlySale() {
        shop.startNewOrder(10, Day.TUESDAY, "Mike", 25);
        shop.processAlcoholOrder("Whiskey", Size.LARGE);
        shop.startNewOrder(12, Day.FRIDAY, "Alice", 30);
        shop.processCoffeeOrder("Cappuccino", Size.SMALL, false, true);
        assertTrue(shop.totalMonthlySale() > 0);
    }

    @Test
    void testTotalNumOfMonthlyOrders() {
        shop.startNewOrder(11, Day.SATURDAY, "Eve", 22);
        shop.startNewOrder(13, Day.SUNDAY, "John", 35);
        assertEquals(2, shop.totalNumOfMonthlyOrders());
    }

    @Test
    void testGetCurrentOrder() {
        shop.startNewOrder(10, Day.MONDAY, "Mary", 28);
        assertNotNull(shop.getCurrentOrder());
    }

    @Test
    void testGetOrderAtIndex() {
        shop.startNewOrder(10, Day.TUESDAY, "Jake", 20);
        assertNotNull(shop.getOrderAtIndex(0));
    }

    @Test
    void testSortOrders() {
        shop.startNewOrder(9, Day.SATURDAY, "Tom", 22);
        shop.startNewOrder(10, Day.SUNDAY, "Anna", 26);
        shop.sortOrders();
        assertTrue(shop.getOrderAtIndex(0).getOrderNo() < shop.getOrderAtIndex(1).getOrderNo());
    }

    @Test
    void testToString() {
        shop.startNewOrder(12, Day.THURSDAY, "Brian", 30);
        assertTrue(shop.toString().contains("Brian"));
    }
}
