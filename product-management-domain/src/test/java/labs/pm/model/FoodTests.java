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
}
