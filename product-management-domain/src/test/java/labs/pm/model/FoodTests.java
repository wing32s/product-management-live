package labs.pm.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class FoodTests {

	@Test 
	void testIdNamePriceRatingBeforeDate() {
		Food f = new Food(100, "Cake", BigDecimal.valueOf(3.99), 
				Rating.FOUR_STAR, LocalDate.ofYearDay(2021, 1));
		
		assertEquals(100, f.getId());
		assertEquals("Cake", f.getName());
		assertEquals(3.99, f.getPrice().doubleValue());
		assertEquals(0.4, f.getDiscount().doubleValue());
		assertEquals(Rating.FOUR_STAR, f.getRating());
		assertEquals(1, f.getBestBeforeDate().getDayOfYear());
		assertEquals(2021, f.getBestBeforeDate().getYear());
	}
	
	@Test
	void testFoodToString() {
		Food f = new Food(100, "Cake", BigDecimal.valueOf(3.99), 
				Rating.FOUR_STAR, LocalDate.ofYearDay(2021, 5));

		String expectedString = "100 Cake 3.99 0.40 " 
				+ Rating.FOUR_STAR.getStars() + " 2021-01-05";
		assertEquals(expectedString, f.toString());
	}

	@Test
	void testFoodDiscount() { 
		Food beforeFood = new Food(100, "Cake", BigDecimal.valueOf(3.99), 
				Rating.FOUR_STAR, LocalDate.now().minusDays(3));
		Food todayFood = new Food(100, "Cake", BigDecimal.valueOf(3.99), 
				Rating.FOUR_STAR, LocalDate.now());
		Food afterFood = new Food(100, "Cake", BigDecimal.valueOf(3.99), 
				Rating.FOUR_STAR, LocalDate.now().plusDays(3));
		
		assertEquals(0.40, beforeFood.getDiscount().doubleValue());
		assertEquals(0, todayFood.getDiscount().doubleValue());
		assertEquals(0, afterFood.getDiscount().doubleValue());
	}

	@Test
	void testFoodApplyRating() { 
		Food f = new Food(100, "Cake", BigDecimal.valueOf(3.99), 
				Rating.FOUR_STAR, LocalDate.ofYearDay(2021, 5));
		Product f2 = f.applyRating(Rating.THREE_STAR);
		
		assertEquals(f, f2);
		assertEquals(LocalDate.ofYearDay(2021, 5), 
				f2.getBestBeforeDate()); 

	}

}
