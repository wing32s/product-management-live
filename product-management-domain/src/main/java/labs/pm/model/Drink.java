/**
 * 
 */
package labs.pm.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * {@code Drink} class represents properties and behaviors of
 * drink products in the Product Management System.
 * <br>
 * Each drink product has a best before date of today.
 * 
 * @version 6.0
 * @author oracle
 */
final class Drink extends Product {
	static public final LocalTime START_DISCOUNT_TIME = LocalTime.of(16, 30);
	static public final LocalTime END_DISCOUNT_TIME = LocalTime.of(17, 30);
		
	/**
	 * Create a new {@code Drink} instance with the provided id, 
	 * name, price, and rating.
	 * 
	 * @param id
	 * @param name
	 * @param price
	 * @param rating
	 */
	Drink(int id, String name, BigDecimal price, Rating rating) {
		super(id, name, price, rating, LocalDate.now());
	}

	/** 
	 * Calculates discount based on product price and
	 * {@link DISCOUNT_RATE discount rate}.  The discount price is zero
	 * while the current time comes before 4:30p or after 5:30p local time.
	 *
	 * @return a {@link java.math.BigDecimal BigDecimal} value 
        * of the discount
	 */
	@Override 
	public BigDecimal getDiscount() {
		return getDiscount(LocalTime.now());
	}

	/**
	 * Calculates discount based on product price and
	 * {@link DISCOUNT_RATE discount rate}.  The discount price is zero
	 * while the current time comes before 4:30p or after 5:30p local time.
	 * 
	 * @param compareTime a {@link LocalTime time} to use to perform the
        * check.
	 * @return a {@link java.math.BigDecimal BigDecimal} value 
        * of the discount
	 */
	BigDecimal getDiscount(LocalTime compareTime) {
		boolean outRange = (compareTime.isBefore(START_DISCOUNT_TIME) 
				|| compareTime.isAfter(END_DISCOUNT_TIME));
		
		return outRange ? BigDecimal.ZERO : super.getDiscount();
	}

	/**
	 * {@docRoot}
	 */
	@Override
	public Drink applyRating(Rating rating) {
		// TODO Auto-generated method stub
		return new Drink(getId(), getName(), getPrice(), rating);
	}

}
