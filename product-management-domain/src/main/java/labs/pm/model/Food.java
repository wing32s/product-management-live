/**
 * 
 */
package labs.pm.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * {@code Food} class represents properties and behaviors of
 * food products in the Product Management System.
 * <br>
 * Each food product has a customizable best before date.
 * 
 * @version 6.0
 * @author oracle
 */
final class Food extends Product {
	
	/**
	 * Create a new {@code Food} instance with the provided id, 
	 * name, price, rating, and best before date.
	 * 
	 * @param id
	 * @param name
	 * @param price
	 * @param rating
	 * @param bestBeforeDate
	 */
	Food(int id, String name, BigDecimal price, Rating rating, 
			LocalDate bestBeforeDate) {
		super(id, name, price, rating, bestBeforeDate);
	}
	
	/** 
	 * Calculates discount based on product price and
	 * {@link DISCOUNT_RATE discount rate}.  The discount price is zero
	 * while the current date comes before or is the same as the 
	 * {@link getBestBeforeDate() best before date}.
	 *
	 * @return a {@link java.math.BigDecimal BigDecimal} value 
        * of the discount
	 */
	@Override 
	public BigDecimal getDiscount() { 
		if (LocalDate.now().isAfter(getBestBeforeDate())) {
			return super.getDiscount();
		} else {
			return BigDecimal.ZERO;
		}
	}

	/**
	 * {@docRoot}
	 */
	@Override
	public Food applyRating(Rating rating) {
		// TODO Auto-generated method stub
		return new Food(getId(), getName(), getPrice(), rating, getBestBeforeDate());
	}

}
