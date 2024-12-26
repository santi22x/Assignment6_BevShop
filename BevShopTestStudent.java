import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BevShopTestStudent {
	private BevShop bevShop;

    @BeforeEach
    public void setUp() {
        bevShop = new BevShop();
    }

    @Test
    public void testConstructor() {
        assertNotNull(bevShop.orders);
        assertEquals(0, bevShop.orders.size());
    }

    @Test
    public void testGetMaxNumOfFruits() {
        assertEquals(BevShopInterface.MAX_FRUIT, bevShop.getMaxNumOfFruits());
    }

    @Test
    public void testGetMinAgeForAlcohol() {
        assertEquals(BevShopInterface.MIN_AGE_FOR_ALCOHOL, bevShop.getMinAgeForAlcohol());
    }

    @Test
    public void testIsValidTime() {
        assertTrue(bevShop.isValidTime(8));
        assertTrue(bevShop.isValidTime(23));
        assertFalse(bevShop.isValidTime(24));
        assertFalse(bevShop.isValidTime(7));
    }

    @Test
    public void testIsMaxFruit() {
        assertTrue(bevShop.isMaxFruit(BevShopInterface.MAX_FRUIT + 1));
        assertFalse(bevShop.isMaxFruit(BevShopInterface.MAX_FRUIT));
    }

    @Test
    public void testGetNumOfAlcoholDrink() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        assertEquals(0, bevShop.getNumOfAlcoholDrink());
    }

    @Test
    public void testStartNewOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        assertEquals(1, bevShop.orders.size());
        assertEquals("John Doe", bevShop.getCurrentOrder().getCustomer().getName());
        assertEquals(Day.MONDAY, bevShop.getCurrentOrder().getOrderDay());
        assertEquals(10, bevShop.getCurrentOrder().getOrderTime());
    }

    @Test
    public void testProcessCoffeeOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
        assertEquals("Latte", bevShop.getCurrentOrder().getBeverage(0).getBevName());
    }

    @Test
    public void testProcessAlcoholOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        bevShop.processAlcoholOrder("Beer", Size.SMALL);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
        assertEquals("Beer", bevShop.getCurrentOrder().getBeverage(0).getBevName());
    }

    @Test
    public void testProcessSmoothieOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        bevShop.processSmoothieOrder("Strawberry", Size.LARGE, 2, true);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
        assertEquals("Strawberry", bevShop.getCurrentOrder().getBeverage(0).getBevName());
    }

    @Test
    public void testFindOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        int orderNo = bevShop.getCurrentOrder().getOrderNumber();
        assertEquals(0, bevShop.findOrder(orderNo));
        assertEquals(-1, bevShop.findOrder(orderNo + 1));
    }

    @Test
    public void testTotalOrderPrice() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
        double expectedPrice = bevShop.getCurrentOrder().calcOrderTotal();
        assertEquals(expectedPrice, bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNumber()), 0.01);
    }

    @Test
    public void testTotalMonthlySale() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
        double expectedPrice = bevShop.getCurrentOrder().calcOrderTotal();
        assertEquals(expectedPrice, bevShop.totalMonthlySale(), 0.01);
    }

    @Test
    public void testTotalNumOfMonthlyOrders() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        bevShop.startNewOrder(12, Day.TUESDAY, "Jane Doe", 28);
        assertEquals(2, bevShop.totalNumOfMonthlyOrders());
    }

    @Test
    public void testGetCurrentOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        assertNotNull(bevShop.getCurrentOrder());
    }

    @Test
    public void testGetOrderAtIndex() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        assertNotNull(bevShop.getOrderAtIndex(0));
    }

    @Test
    public void testSortOrders() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        bevShop.startNewOrder(12, Day.TUESDAY, "Jane Doe", 28);
        bevShop.sortOrders();
        assertTrue(bevShop.orders.get(0).getOrderNo() < bevShop.orders.get(1).getOrderNo());
    }

    @Test
    public void testToString() {
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
        String expectedString = "Monthly Orders\n";
        expectedString += bevShop.getCurrentOrder().toString();
        expectedString += "Total Sale: " + bevShop.totalMonthlySale();
        assertEquals(expectedString, bevShop.toString());
    }
}
