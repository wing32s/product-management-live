/**
 * 
 */
package labs.pm.model;

import java.math.BigDecimal;

/**
 * {@code Drink} class represents properties and behaviors of
 * drink products in the Product Management System.
 * <br>
 * Each drink product has an id, name, price, and rating.
 * 
 * @version 5.0
 * @author oracle
 */
public class Drink extends Product {
	/**
	 * Create a new {@code Drink} instance with the provided id, 
	 * name, price, and rating.
	 * 
	 * @param id
	 * @param name
	 * @param price
	 * @param rating
	 */
	public Drink(int id, String name, BigDecimal price, Rating rating) {
		super(id, name, price, rating);
	}

}
