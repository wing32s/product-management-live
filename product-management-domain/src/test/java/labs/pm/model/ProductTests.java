package labs.pm.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

class ProductTests {

	@Test
	void testDefault() {
		Product p = new TestProduct();
		assertEquals(0, p.getId());
		assertEquals("no name", p.getName());
		assertEquals(0, p.getPrice().intValue());
		assertEquals(0, p.getDiscount().intValue());
		assertEquals(Rating.NOT_RATED, p.getRating());
	}
	
	@Test
	void testIdNamePrice() { 
		Product p = new TestProduct(101, "Tea", BigDecimal.valueOf(1.99));
		assertEquals(101, p.getId());
		assertEquals("Tea", p.getName());
		assertEquals(1.99, p.getPrice().doubleValue());
		assertEquals(0.2, p.getDiscount().doubleValue());
		assertEquals(Rating.NOT_RATED, p.getRating());
	}
	
	@Test
	void testIdNamePriceRating() { 
		Product p = new TestProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.TWO_STAR, LocalDate.now());
		assertEquals(101, p.getId());
		assertEquals("Tea", p.getName());
		assertEquals(1.99, p.getPrice().doubleValue());
		assertEquals(0.2, p.getDiscount().doubleValue());
		assertEquals(Rating.TWO_STAR, p.getRating());
	}
	
	@Test
	void testSetId() { 
		//Product p = new TestProduct();
		//p.setId(101);
		Product p = new TestProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.TWO_STAR, LocalDate.now());

		assertEquals(101, p.getId());
	}

	@Test
	void testSetName() { 
		//Product p = new TestProduct();
		//p.setName("Tea");
		Product p = new TestProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.TWO_STAR, LocalDate.now());

		assertEquals("Tea", p.getName());
	}

	@Test
	void testSetPrice() {
		//Product p = new TestProduct();
		//p.setPrice(BigDecimal.valueOf(1.99));
		Product p = new TestProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.TWO_STAR, LocalDate.now());

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
		//Product p = new TestProduct();
		//p.setPrice(BigDecimal.valueOf(price));
		Product p = new TestProduct(101, "Tea", BigDecimal.valueOf(price), Rating.TWO_STAR, LocalDate.now());

		assertEquals(discount, p.getDiscount().doubleValue());
	}

	@Test
	void testApplyRating() { 
		Product p = new TestProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.TWO_STAR, LocalDate.now());
		Product p2 = p.applyRating(Rating.THREE_STAR);

		assertEquals(p, p2);
		assertEquals(101, p2.getId());
		assertEquals("Tea", p2.getName());
		assertEquals(1.99, p2.getPrice().doubleValue());
		assertEquals(0.2, p2.getDiscount().doubleValue());
		assertEquals(Rating.THREE_STAR, p2.getRating());
	}
	
	@Test
	void testProductToString() {
		Product p = new TestProduct(101, "Tea", BigDecimal.valueOf(1.99),
 			Rating.TWO_STAR, LocalDate.now());
		String expectedString = "101 Tea 1.99 0.20 " 
 			+ Rating.TWO_STAR.getStars() + " " + LocalDate.now();
		assertEquals(expectedString, p.toString());
	}

	@Test
	void testProductHashCode() {
		Product p1 = new TestProduct(101, "Tea", BigDecimal.valueOf(1.99), 
				Rating.TWO_STAR, LocalDate.now());
		Product p2 = new TestProduct(103, "Cake", BigDecimal.valueOf(3.99), 
				Rating.FOUR_STAR, LocalDate.now());
		Product p3 = new TestProduct(101, "Tea", BigDecimal.valueOf(1.59), 
				Rating.ONE_STAR, LocalDate.now());
		Product p4 = p1.applyRating(Rating.THREE_STAR);
		Product p5 = p1;
		Product p6 = new TestProduct(101, "TEA", BigDecimal.valueOf(1.59), 
				Rating.ONE_STAR, LocalDate.now());

		// diff id and name 
		assertNotEquals(p1.hashCode(), p2.hashCode()); 
		// same id and name
		assertEquals(p1.hashCode(), p3.hashCode());    
		// apply rating
		assertEquals(p1.hashCode(), p4.hashCode());    
		// same instance 
		assertEquals(p1.hashCode(), p5.hashCode());
		// same id diff name    
		assertNotEquals(p1.hashCode(), p6.hashCode()); 
		
		Food f1 = new Food(103, "Cake", BigDecimal.valueOf(3.99), 
				Rating.FOUR_STAR, LocalDate.now());
		Product f2 = new Food(103, "Cake", BigDecimal.valueOf(3.99), 
				Rating.FOUR_STAR, LocalDate.now());

		assertEquals(p2.hashCode(), f1.hashCode()); // diff class (Food)
		assertEquals(p2.hashCode(), f2.hashCode()); // diff class same type

	}

	@Test
	void testProductEquals() {
		Product p1 = new TestProduct(101, "Tea", BigDecimal.valueOf(1.99), 
				Rating.TWO_STAR, LocalDate.now());
		Product p2 = new TestProduct(103, "Cake", BigDecimal.valueOf(3.99), 
				Rating.FOUR_STAR, LocalDate.now());
		Product p3 = new TestProduct(101, "Tea", BigDecimal.valueOf(1.59), 
				Rating.ONE_STAR, LocalDate.now());
		Product p4 = p1.applyRating(Rating.THREE_STAR);
		Product p5 = p1;
		Product p6 = new TestProduct(101, "TEA", BigDecimal.valueOf(1.59), 
				Rating.ONE_STAR, LocalDate.now());

		assertFalse(p1.equals(p2));  // diff id and name
		assertTrue(p1.equals(p3));   // same id and name
		assertTrue(p1.equals(p4));   // apply rating
		assertTrue(p1.equals(p5));   // same instance
		assertFalse(p1.equals(p6));  // same id diff name
		
		Food f1 = new Food(103, "Cake", BigDecimal.valueOf(3.99), 
				Rating.FOUR_STAR, LocalDate.now());
		Product f2 = new Food(103, "Cake", BigDecimal.valueOf(3.99), 
				Rating.FOUR_STAR, LocalDate.now());
		assertFalse(p2.equals(f1));  // diff class (Food)
		assertFalse(p2.equals(f2));  // diff class same type
		assertTrue(f1.equals(f2));   // same id and name, diff type

	}
	
}
