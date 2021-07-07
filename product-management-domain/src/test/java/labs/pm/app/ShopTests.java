package labs.pm.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import labs.pm.model.Product;
import labs.pm.model.Rating;
import labs.pm.model.TestProduct;

class ShopTests {

	@Test
	void test() { 
		new Shop();
		Shop.main(null);
	}

	@Test
	void testProductNoArg() {
		Product p = new TestProduct();
		assertEquals(0, p.getId());
		assertEquals("no name", p.getName());
		assertEquals(0, p.getPrice().intValue());
		assertEquals(0, p.getDiscount().intValue());
		assertEquals(Rating.NOT_RATED, p.getRating());
	}
	
	@Test
	void testProductIdNamePriceArg() {
		Product p = new TestProduct(101, "Tea", BigDecimal.valueOf(1.99));
		assertEquals(101, p.getId());
		assertEquals("Tea", p.getName());
		assertEquals(1.99, p.getPrice().doubleValue());
		assertEquals(Rating.NOT_RATED, p.getRating());
	}
	
	@Test
	void testProductIdNamePriceRatingArg() {
		Product p = new TestProduct(101, "Tea", BigDecimal.valueOf(1.99), 
				Rating.THREE_STAR);
		assertEquals(101, p.getId());
		assertEquals("Tea", p.getName());
		assertEquals(1.99, p.getPrice().doubleValue());
		assertEquals(Rating.THREE_STAR, p.getRating());
	}
}
