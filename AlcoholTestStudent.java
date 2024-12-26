import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholTestStudent {

	@Test
	public void testCalcPrice_SmallSizeWeekday() {
	    Alcohol alcohol = new Alcohol("Beer", Size.SMALL, false);
	    double expectedPrice = alcohol.getBasePrice();
	    assertEquals(expectedPrice, alcohol.calcPrice(), 0.01);
	}

	@Test
	public void testCalcPrice_MediumSizeWeekday() {
	    Alcohol alcohol = new Alcohol("Wine", Size.MEDIUM, false);
	    double expectedPrice = alcohol.getBasePrice() + alcohol.getSizePrice();
	    assertEquals(expectedPrice, alcohol.calcPrice(), 0.01);
	}

	@Test
	public void testCalcPrice_LargeSizeWeekday() {
	    Alcohol alcohol = new Alcohol("Whiskey", Size.LARGE, false);
	    double expectedPrice = alcohol.getBasePrice() + 2 * alcohol.getSizePrice();
	    assertEquals(expectedPrice, alcohol.calcPrice(), 0.01);
	}

	@Test
	public void testCalcPrice_SmallSizeWeekend() {
	    Alcohol alcohol = new Alcohol("Beer", Size.SMALL, true);
	    double expectedPrice = alcohol.getBasePrice() + alcohol.getWeekendFee();
	    assertEquals(expectedPrice, alcohol.calcPrice(), 0.01);
	}

	@Test
	public void testCalcPrice_MediumSizeWeekend() {
	    Alcohol alcohol = new Alcohol("Wine", Size.MEDIUM, true);
	    double expectedPrice = alcohol.getBasePrice() + alcohol.getSizePrice() + alcohol.getWeekendFee();
	    assertEquals(expectedPrice, alcohol.calcPrice(), 0.01);
	}

	@Test
	public void testCalcPrice_LargeSizeWeekend() {
	    Alcohol alcohol = new Alcohol("Whiskey", Size.LARGE, true);
	    double expectedPrice = alcohol.getBasePrice() + 2 * alcohol.getSizePrice() + alcohol.getWeekendFee();
	    assertEquals(expectedPrice, alcohol.calcPrice(), 0.01);
	}

	@Test
	public void testIsWeekend() {
	    Alcohol alcohol = new Alcohol("Beer", Size.SMALL, true);
	    assertTrue(alcohol.isWeekend());
	    Alcohol alcohol2 = new Alcohol("Beer", Size.SMALL, false);
	    assertFalse(alcohol2.isWeekend());
	}

	@Test
	public void testGetWeekendFee() {
	    Alcohol alcohol = new Alcohol("Beer", Size.SMALL, true);
	    assertEquals(0.6, alcohol.getWeekendFee(), 0.01);
	}

	@Test
	public void testToString() {
	    Alcohol alcohol = new Alcohol("Beer", Size.SMALL, true);
	    String expectedString = "Name: Beer, Size: SMALL, Weekend Offer: true, $" + alcohol.calcPrice();
	    assertEquals(expectedString, alcohol.toString());
	}

	@Test
	public void testEquals() {
	    Alcohol alcohol1 = new Alcohol("Beer", Size.SMALL, true);
	    Alcohol alcohol2 = new Alcohol("Beer", Size.SMALL, true);
	    assertEquals(alcohol1, alcohol2);
	    Alcohol alcohol3 = new Alcohol("Wine", Size.MEDIUM, false);
	    assertNotEquals(alcohol1, alcohol3);
	}

}
