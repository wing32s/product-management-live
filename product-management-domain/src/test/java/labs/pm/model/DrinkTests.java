package labs.pm.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

class DrinkTests {

	@Test 
	void testIdNamePriceRating() {
		Drink d = new Drink(101, "Tea", BigDecimal.valueOf(1.99), 
				Rating.THREE_STAR);
		
		assertEquals(101, d.getId());
		assertEquals("Tea", d.getName());
		assertEquals(1.99, d.getPrice().doubleValue());
		assertEquals(getDrinkDiscount(BigDecimal.valueOf(1.99)), 
				d.getDiscount());
		assertEquals(Rating.THREE_STAR, d.getRating());
	}

	@Test
	void testDrinkToString() {
		Drink p = new Drink(101, "Tea", BigDecimal.valueOf(1.99), 
				Rating.TWO_STAR);
		String expectedString = "101 Tea 1.99 " 
				+ getDrinkDiscount(BigDecimal.valueOf(1.99)) + " "
				+ Rating.TWO_STAR.getStars() + " " + LocalDate.now();
		assertEquals(expectedString, p.toString());
	}

	@Test
	void testDrinkDiscount() {
		Drink d = new Drink(101, "Tea", BigDecimal.valueOf(1.99), 
				Rating.TWO_STAR);

		assertEquals(getDrinkDiscount(BigDecimal.valueOf(1.99)), 
				d.getDiscount());
		
		assertEquals(0, d.getDiscount(
				Drink.START_DISCOUNT_TIME.minusMinutes(30)).doubleValue());
		assertEquals(0.2, d.getDiscount(
					Drink.START_DISCOUNT_TIME).doubleValue());
		assertEquals(0.2, d.getDiscount(
					Drink.START_DISCOUNT_TIME.plusMinutes(30)).doubleValue());
		assertEquals(0.2, d.getDiscount(
					Drink.END_DISCOUNT_TIME).doubleValue());
		assertEquals(0, d.getDiscount(
					Drink.END_DISCOUNT_TIME.plusMinutes(30)).doubleValue());
	}

	private BigDecimal getDrinkDiscount(BigDecimal price) {
		if (LocalTime.now().isBefore(Drink.START_DISCOUNT_TIME)
				|| LocalTime.now().isAfter(Drink.END_DISCOUNT_TIME)) {
			return BigDecimal.ZERO;
		} else {
			Product p = new TestProduct(1, "", price);
			return p.getDiscount();
		}
	}
	
}
