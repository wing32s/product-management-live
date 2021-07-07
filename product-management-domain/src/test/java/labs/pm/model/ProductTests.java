package labs.pm.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProductTests {

	@Test
	void testDefault() {
		Product p = new Product();
		assertEquals(0, p.getId());
		assertEquals("no name", p.getName());
		assertEquals(0, p.getPrice().intValue());
		assertEquals(0, p.getDiscount().intValue());
		assertEquals(Rating.NOT_RATED, p.getRating());
	}
	
	@Test
	void testIdNamePrice() { 
		Product p = new Product(101, "Tea", BigDecimal.valueOf(1.99));
		assertEquals(101, p.getId());
		assertEquals("Tea", p.getName());
		assertEquals(1.99, p.getPrice().doubleValue());
		assertEquals(0.2, p.getDiscount().doubleValue());
		assertEquals(Rating.NOT_RATED, p.getRating());
	}
	
	@Test
	void testIdNamePriceRating() { 
		Product p = new Product(101, "Tea", BigDecimal.valueOf(1.99), Rating.TWO_STAR);
		assertEquals(101, p.getId());
		assertEquals("Tea", p.getName());
		assertEquals(1.99, p.getPrice().doubleValue());
		assertEquals(0.2, p.getDiscount().doubleValue());
		assertEquals(Rating.TWO_STAR, p.getRating());
	}
	
	@Test
	void testSetId() { 
		//Product p = new Product();
		//p.setId(101);
		Product p = new Product(101, "Tea", BigDecimal.valueOf(1.99), Rating.TWO_STAR);

		assertEquals(101, p.getId());
	}

	@Test
	void testSetName() { 
		//Product p = new Product();
		//p.setName("Tea");
		Product p = new Product(101, "Tea", BigDecimal.valueOf(1.99), Rating.TWO_STAR);

		assertEquals("Tea", p.getName());
	}

	@Test
	void testSetPrice() {
		//Product p = new Product();
		//p.setPrice(BigDecimal.valueOf(1.99));
		Product p = new Product(101, "Tea", BigDecimal.valueOf(1.99), Rating.TWO_STAR);

		assertEquals(1.99, p.getPrice().doubleValue());
		assertEquals(0.2, p.getDiscount().doubleValue()); // add this
	}

	@ParameterizedTest
	@CsvSource({
		"0, 0",
		"2.00, 0.2",
		"1.99, 0.2",
		"1.45, 0.15",
		"1.44, 0.14"
	})
	void testDiscount(double price, double discount) {
		//Product p = new Product();
		//p.setPrice(BigDecimal.valueOf(price));
		Product p = new Product(101, "Tea", BigDecimal.valueOf(price), Rating.TWO_STAR);

		assertEquals(discount, p.getDiscount().doubleValue());
	}

	@Test
	void testApplyRating() { 
		Product p = new Product(101, "Tea", BigDecimal.valueOf(1.99), Rating.TWO_STAR);
		Product p2 = p.applyRating(Rating.THREE_STAR);

		assertNotEquals(p, p2);
		assertEquals(101, p2.getId());
		assertEquals("Tea", p2.getName());
		assertEquals(1.99, p2.getPrice().doubleValue());
		assertEquals(0.2, p2.getDiscount().doubleValue());
		assertEquals(Rating.THREE_STAR, p2.getRating());
	}
}
