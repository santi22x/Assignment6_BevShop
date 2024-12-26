import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeTestStudent {

	@Test
    public void testConstructorAndGetters() {
        Coffee coffee = new Coffee("Espresso", Size.SMALL, true, false);
        assertEquals("Espresso", coffee.getBevName());
        assertEquals(Size.SMALL, coffee.getSize());
        assertEquals(Type.COFFEE, coffee.getType());
        assertTrue(coffee.getExtraShot());
        assertFalse(coffee.getExtraSyrup());
        assertEquals(0.5, coffee.getShotCost(), 0.01);
        assertEquals(0.5, coffee.getSyrupCost(), 0.01);
    }

    @Test
    public void testCalcPriceSmall() {
        Coffee coffee = new Coffee("Espresso", Size.SMALL, true, true);
        double expectedPrice = coffee.getBasePrice() + coffee.getShotCost() + coffee.getSyrupCost();
        assertEquals(expectedPrice, coffee.calcPrice(), 0.01);
    }

    @Test
    public void testCalcPriceMedium() {
        Coffee coffee = new Coffee("Latte", Size.MEDIUM, true, false);
        double expectedPrice = coffee.getBasePrice() + coffee.getSizePrice() + coffee.getShotCost();
        assertEquals(expectedPrice, coffee.calcPrice(), 0.01);
    }

    @Test
    public void testCalcPriceLarge() {
        Coffee coffee = new Coffee("Cappuccino", Size.LARGE, false, true);
        double expectedPrice = coffee.getBasePrice() + 2 * coffee.getSizePrice() + coffee.getSyrupCost();
        assertEquals(expectedPrice, coffee.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
    	Coffee coffee = new Coffee("Mocha", Size.LARGE, true, true);
        String expectedString = "Name: Mocha, Size: LARGE, Extra Shot: true, Extra Syrup: true, $" + coffee.calcPrice();
        assertEquals(expectedString, coffee.toString());
    }

    @Test
    public void testEquals() {
        Coffee coffee1 = new Coffee("Latte", Size.SMALL, true, true);
        Coffee coffee2 = new Coffee("Latte", Size.SMALL, true, true);
        Coffee coffee3 = new Coffee("Latte", Size.MEDIUM, true, true);

        assertEquals(coffee1, coffee2);
        assertNotEquals(coffee1, coffee3);
    }

    @Test
    public void testSetExtraShot() {
        Coffee coffee = new Coffee("Americano", Size.SMALL, false, false);
        assertFalse(coffee.getExtraShot());
        coffee.setExtraShot(true);
        assertTrue(coffee.getExtraShot());
    }

    @Test
    public void testSetExtraSyrup() {
        Coffee coffee = new Coffee("Macchiato", Size.SMALL, false, false);
        assertFalse(coffee.getExtraSyrup());
        coffee.setExtraSyrup(true);
        assertTrue(coffee.getExtraSyrup());
    }
}
