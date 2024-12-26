import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTestStudent {

	@BeforeEach
    public void setUp() {
    }

    @Test
    public void testOrderConstructor() {
        Order order1 = new Order(12, Day.MONDAY, new Customer("John Doe", 25));
        Order order2 = new Order(15, Day.FRIDAY, new Customer("Jane Smith", 30));
        assertNotNull(order1);
        assertEquals(12, order1.getOrderTime());
        assertEquals(Day.MONDAY, order1.getOrderDay());
        assertEquals("John Doe", order1.getCustomer().getName());
        assertEquals(25, order1.getCustomer().getAge());
        assertNotNull(order1.getOrderNo());
        assertNotNull(order2);
        assertEquals(15, order2.getOrderTime());
        assertEquals(Day.FRIDAY, order2.getOrderDay());
        assertEquals("Jane Smith", order2.getCustomer().getName());
        assertEquals(30, order2.getCustomer().getAge());
        assertNotNull(order2.getOrderNo());
    }

    @Test
    public void testGenerateOrder() {
        Order order1 = new Order(12, Day.MONDAY, new Customer("John Doe", 25));
        Order order2 = new Order(15, Day.FRIDAY, new Customer("Jane Smith", 30));
        int orderNumber1 = order1.getOrderNumber();
        int orderNumber2 = order2.getOrderNumber();
        assertTrue(orderNumber1 >= 10000 && orderNumber1 <= 90000);
        assertTrue(orderNumber2 >= 10000 && orderNumber2 <= 90000);
        assertNotEquals(orderNumber1, orderNumber2);
    }

    @Test
    public void testAddNewBeverageCoffee() {
        Order order1 = new Order(12, Day.MONDAY, new Customer("John Doe", 25));
        order1.addNewBeverage("Latte", Size.MEDIUM, true, false);
        assertEquals(1, order1.getTotalItems());
        assertTrue(order1.getBeverage(0) instanceof Coffee);
        assertEquals("Latte", order1.getBeverage(0).getBevName());
    }

    @Test
    public void testAddNewBeverageAlcohol() {
        Order order1 = new Order(12, Day.MONDAY, new Customer("John Doe", 25));
        order1.addNewBeverage("Wine", Size.SMALL);
        assertEquals(1, order1.getTotalItems());
        assertTrue(order1.getBeverage(0) instanceof Alcohol);
        assertEquals("Wine", order1.getBeverage(0).getBevName());
        assertFalse(((Alcohol) order1.getBeverage(0)).isWeekend());
    }

    @Test
    public void testAddNewBeverageSmoothie() {
        Order order1 = new Order(12, Day.MONDAY, new Customer("John Doe", 25));
        order1.addNewBeverage("Berry Smoothie", Size.LARGE, 3, true);
        assertEquals(1, order1.getTotalItems());
        assertTrue(order1.getBeverage(0) instanceof Smoothie);
        assertEquals("Berry Smoothie", order1.getBeverage(0).getBevName());
        assertEquals(3, ((Smoothie) order1.getBeverage(0)).getNumOfFruits());
        assertTrue(((Smoothie) order1.getBeverage(0)).getAddProtein());
    }

    @Test
    public void testCalcOrderTotal() {
        Order order1 = new Order(12, Day.MONDAY, new Customer("John Doe", 25));
        order1.addNewBeverage("Latte", Size.MEDIUM, true, false);
        order1.addNewBeverage("Wine", Size.SMALL);
        order1.addNewBeverage("Berry Smoothie", Size.LARGE, 3, true);
        double total = order1.calcOrderTotal();
        assertTrue(total > 0); // Replace with expected total if prices are known.
    }

    @Test
    public void testIsWeekend() {
        Order weekendOrder = new Order(10, Day.SATURDAY, new Customer("John Doe", 25));
        assertTrue(weekendOrder.isWeekend());
        Order weekdayOrder = new Order(10, Day.MONDAY, new Customer("John Doe", 25));
        assertFalse(weekdayOrder.isWeekend());
    }

    @Test
    public void testFindNumOfBeveType() {
        Order order1 = new Order(12, Day.MONDAY, new Customer("John Doe", 25));
        order1.addNewBeverage("Latte", Size.MEDIUM, true, false);
        order1.addNewBeverage("Wine", Size.SMALL);
        order1.addNewBeverage("Berry Smoothie", Size.LARGE, 3, true);
        assertEquals(1, order1.findNumOfBeveType(Type.COFFEE));
        assertEquals(1, order1.findNumOfBeveType(Type.ALCOHOL));
        assertEquals(1, order1.findNumOfBeveType(Type.SMOOTHIE));
    }

    @Test
    public void testCompareTo() {
        Order order1 = new Order(12, Day.MONDAY, new Customer("John Doe", 25));
        Order order2 = new Order(15, Day.FRIDAY, new Customer("Jane Smith", 30));
        assertNotEquals(order1.getOrderNumber(), order2.getOrderNumber());
        assertTrue(order1.compareTo(order2) != 0);
    }

    @Test
    public void testGetOrderNo() {
        Order order1 = new Order(12, Day.MONDAY, new Customer("John Doe", 25));
        assertEquals(order1.getOrderNumber(), order1.getOrderNo());
    }

    @Test
    public void testGetOrderTime() {
        Order order1 = new Order(12, Day.MONDAY, new Customer("John Doe", 25));
        assertEquals(12, order1.getOrderTime());
    }

    @Test
    public void testGetOrderDay() {
        Order order1 = new Order(12, Day.MONDAY, new Customer("John Doe", 25));
        assertEquals(Day.MONDAY, order1.getOrderDay());
    }

    @Test
    public void testGetCustomer() {
        Order order1 = new Order(12, Day.MONDAY, new Customer("John Doe", 25));
        Customer retrievedCustomer = order1.getCustomer();
        assertEquals("John Doe", retrievedCustomer.getName());
        assertEquals(25, retrievedCustomer.getAge());
    }

    @Test
    public void testGetTotalItems() {
        Order order1 = new Order(12, Day.MONDAY, new Customer("John Doe", 25));
        assertEquals(0, order1.getTotalItems());
        order1.addNewBeverage("Latte", Size.MEDIUM, true, false);
        assertEquals(1, order1.getTotalItems());
    }

}
