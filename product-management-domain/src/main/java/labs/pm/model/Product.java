/**
 * 
 */
package labs.pm.model;

import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;

/**
 * {@code Product} class represents properties and behaviors of
 * product objects in the Product Management System.
 * <br>
 * Each product has an id, name, price, and rating.
 * <br> 
 * Each product can have a discount, calculation based on a 
 * {@link DISCOUNT_RATE discount rate}
 * 
 * @version 5.0
 * @author oracle
 */
public class Product {
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

	/**
	 * Create a new {@code Product} instance with default values.
	 */
	public Product() {
		this(0, "no name", BigDecimal.ZERO);
	}
	/**
	 * Create a new {@code Product} instance with the provided id, 
	 * name, and price.
	 * 
	 * @param id
	 * @param name
	 * @param price
	 */
	protected Product(int id, String name, BigDecimal price) {
		this(id, name, price, Rating.NOT_RATED);
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
	Product(int id, String name, BigDecimal price, Rating rating) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.rating = rating;
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
	public Product applyRating(Rating rating) {
		return new Product(id, name, price, rating);
	}
}
