import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTestStudent {

	@Test
	public void testConstructorAndGetters() {
	    Customer customer = new Customer("John Doe", 30);
	    assertEquals("John Doe", customer.getName());
	    assertEquals(30, customer.getAge());
	}
	@Test
	public void testCopyConstructor() {
	    Customer original = new Customer("Jane Doe", 25);
	    Customer copy = new Customer(original);
	    assertEquals("Jane Doe", copy.getName());
	    assertEquals(25, copy.getAge());
	}

	@Test
	public void testSetName() {
	    Customer customer = new Customer("John Doe", 30);
	    customer.setName("Johnny Doe");
	    assertEquals("Johnny Doe", customer.getName());
	}

	@Test
	public void testSetAge() {
	    Customer customer = new Customer("John Doe", 30);
	    customer.setAge(35);
	    assertEquals(35, customer.getAge());
	}
	@Test
	public void testToString() {
	    Customer customer = new Customer("John Doe", 30);
	    String expectedString = "Customer: John Doe, Age: 30";
	    assertEquals(expectedString, customer.toString());
	}

}
