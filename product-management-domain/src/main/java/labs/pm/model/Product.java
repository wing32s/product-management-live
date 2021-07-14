/**
 * 
 */
package labs.pm.model;

import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * {@code Product} class represents properties and behaviors of
 * product objects in the Product Management System.
 * <br>
 * Each product has an id, name, price, rating, and best before date.
 * <br> 
 * Each product can have a discount, calculation based on a 
 * {@link DISCOUNT_RATE discount rate}
 * 
 * @version 6.0
 * @author oracle
 */
abstract public class Product {
	/**
	 * A constant that  defines a
	 * {@link java.math.BigDecimal BigDecimal} value of the discount rate
	 * <br>
	 * Discount rate is 10%
	 */
	public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
	
	private final int id;
	private final String name;
	private final BigDecimal price;
	private final Rating rating;
	private final LocalDate bestBeforeDate;

	/**
	 * Create a new {@code Product} instance with the provided id, 
	 * name, and price.
	 * 
	 * @param id
	 * @param name
	 * @param price
	 */
	protected Product(int id, String name, BigDecimal price) {
		this(id, name, price, Rating.NOT_RATED, LocalDate.now());
	}
	
	/**
	 * Create a new {@code Product} instance with the provided id, 
	 * name, price, and rating.
	 * 
	 * @param id
	 * @param name
	 * @param price
	 * @param rating
	 */
	Product(int id, String name, BigDecimal price, Rating rating, 
			LocalDate bestBeforeDate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.bestBeforeDate = bestBeforeDate;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * The best before date for the product.
	 * 
	 * @return the {@link java.time.LocalDate date} that the product is best 
	 * used by.  By default, all products expire on the current day.
	 */
	public LocalDate getBestBeforeDate() {
		return bestBeforeDate;
	}

	/** 
	 * Calculates discount based on product price and
	 * {@link DISCOUNT_RATE discount rate}
	 *
	 * @return a {@link java.math.BigDecimal BigDecimal} value 
        * of the discount
	 */ 
	public BigDecimal getDiscount() { 
		return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);	
	}
	
	/**
	 * @return the rating
	 */
	public Rating getRating() {
		return rating;
	}

	/**
	 * Applies the provided rating to a new {@code Product} instance with
	 * the same properties as this instance.
	 * 
	 * @param rating
	 * @return a {@code Product} value with the same id, name, and price as
	 * this instance.
	 */
	abstract public Product applyRating(Rating rating);
	
	@Override
	public String toString() {
		return id + " " + name + " " + price + " " + getDiscount() + " " 
				+ rating.getStars() + " " + bestBeforeDate;
	}

	@Override
	public int hashCode() {
		return 23 * (5 + id) * name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// if same instance, just return true like Object.equals()
		if (super.equals(obj)) {
			return true;
		}
		
		if (getClass() == obj.getClass()) {
			return hashCode() == obj.hashCode();
		}
		
		return false;
	}
	
}
