package labs.pm.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class DrinkTests {

	@Test 
	void testIdNamePriceRating() {
		Drink d = new Drink(101, "Tea", BigDecimal.valueOf(1.99), 
				Rating.THREE_STAR);
		
		assertEquals(101, d.getId());
		assertEquals("Tea", d.getName());
		assertEquals(1.99, d.getPrice().doubleValue());
		assertEquals(0.2, d.getDiscount().doubleValue());
		assertEquals(Rating.THREE_STAR, d.getRating());
	}

}
