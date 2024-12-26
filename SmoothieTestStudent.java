import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent {

	@Test
	public void testConstructorAndGetters() {
	    Smoothie smoothie = new Smoothie("Tropical Smoothie", Size.SMALL, 3, true);
	    assertEquals("Tropical Smoothie", smoothie.getBevName());
	    assertEquals(Size.SMALL, smoothie.getSize());
	    assertEquals(3, smoothie.getNumOfFruits());
	    assertTrue(smoothie.getAddProtein());
	}

	@Test
	public void testSetNumOfFruits() {
	    Smoothie smoothie = new Smoothie("Berry Smoothie", Size.MEDIUM, 2, false);
	    smoothie.setNumOfFruits(4);
	    assertEquals(4, smoothie.getNumOfFruits());
	}

	@Test
	public void testSetAddProtein() {
	    Smoothie smoothie = new Smoothie("Green Smoothie", Size.LARGE, 1, false);
	    smoothie.setAddProtein(true);
	    assertTrue(smoothie.getAddProtein());
	}

	@Test
	public void testCalcPrice_SmallSize() {
	    Smoothie smoothie = new Smoothie("Tropical Smoothie", Size.SMALL, 3, true);
	    double expectedPrice = smoothie.getBasePrice() + 3 * 0.5 + 1.5; // Base price + fruit cost + protein cost
	    assertEquals(expectedPrice, smoothie.calcPrice(), 0.01);
	}

	@Test
	public void testCalcPrice_MediumSize() {
	    Smoothie smoothie = new Smoothie("Berry Smoothie", Size.MEDIUM, 2, false);
	    double expectedPrice = smoothie.getBasePrice() + smoothie.getSizePrice() + 2 * 0.5; // Base price + size price + fruit cost
	    assertEquals(expectedPrice, smoothie.calcPrice(), 0.01);
	}

	@Test
	public void testCalcPrice_LargeSize() {
	    Smoothie smoothie = new Smoothie("Green Smoothie", Size.LARGE, 1, true);
	    double expectedPrice = smoothie.getBasePrice() + 2 * smoothie.getSizePrice() + 1 * 0.5 + 1.5; // Base price + size price + fruit cost + protein cost
	    assertEquals(expectedPrice, smoothie.calcPrice(), 0.01);
	}

	@Test
	public void testToString() {
	    Smoothie smoothie = new Smoothie("Tropical Smoothie", Size.SMALL, 3, true);
	    String expectedString = "Name: Tropical Smoothie, Size: SMALL, Number of fruits: 3, Protein Powder: true, $" + smoothie.calcPrice();
	    assertEquals(expectedString, smoothie.toString());
	}

	@Test
	public void testEquals() {
	    Smoothie smoothie1 = new Smoothie("Tropical Smoothie", Size.SMALL, 3, true);
	    Smoothie smoothie2 = new Smoothie("Tropical Smoothie", Size.SMALL, 3, true);
	    assertEquals(smoothie1, smoothie2);

	    Smoothie smoothie3 = new Smoothie("Berry Smoothie", Size.MEDIUM, 2, false);
	}

}
