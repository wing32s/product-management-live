package labs.pm.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ProductManagerTests {

	static private ProductManager pm = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		pm = new ProductManager();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		pm = null;
	}

	@Test
	void testProductManager() {
	}

	@Test
	void testCreateProductIntStringBigDecimalRatingLocalDate() {
		Food newFood = new Food(100, "Cake", BigDecimal.valueOf(3.99), 
				Rating.FOUR_STAR, LocalDate.ofYearDay(2021, 5));
		Product factoryFood = pm.createProduct(100, "Cake", 
				BigDecimal.valueOf(3.99), Rating.FOUR_STAR, 
				LocalDate.ofYearDay(2021, 5));
		
		assertTrue(newFood.equals(factoryFood));
		assertEquals(newFood.getId(), factoryFood.getId());
		assertEquals(newFood.getName(), factoryFood.getName());
		assertEquals(newFood.getPrice(), factoryFood.getPrice());
		assertEquals(newFood.getRating(), factoryFood.getRating());
		assertEquals(newFood.getBestBeforeDate(), 
				factoryFood.getBestBeforeDate());
	}

	@Test
	void testCreateProductIntStringBigDecimalRating() {
		Drink newDrink = new Drink(101, "Tea", BigDecimal.valueOf(1.99), 
				Rating.TWO_STAR);
		Product factoryDrink = pm.createProduct(101, "Tea", 
				BigDecimal.valueOf(1.99), Rating.TWO_STAR);
		
		assertTrue(newDrink.equals(factoryDrink));
		assertEquals(newDrink.getId(), factoryDrink.getId());
		assertEquals(newDrink.getName(), factoryDrink.getName());
		assertEquals(newDrink.getPrice(), factoryDrink.getPrice());
		assertEquals(newDrink.getRating(), factoryDrink.getRating());
		assertEquals(newDrink.getBestBeforeDate(), 
				factoryDrink.getBestBeforeDate());
	}

}
