package labs.pm.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductManager {

	/**
	 * {@code ProductManager} class provides a set of factory methods 
	 * generate products.  
	 * 
	 * @version 6.0
	 * @author oracle
	 */
	public ProductManager() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a {@link Food food} instance based on the provided 
	 * parameters.
	 * 
	 * @param id
	 * @param name
	 * @param price
	 * @param rating
	 * @param bestBeforeDate
	 * 
	 * @return a new {@link Food food} instance
	 */
	public Product createProduct(int id, String name, BigDecimal price,
 			Rating rating, LocalDate bestBeforeDate) {
		
		return new Food(id, name, price, rating, bestBeforeDate);
	}

	/**
	 * Creates a {@link Drink drink} instance based on the provided 
	 * parameters.
	 * 
	 * @param id
	 * @param name
	 * @param price
	 * @param rating
	 * 
	 * @return a new {@link Drink drink} instance
	 */
	public Product createProduct(int id, String name, BigDecimal price, 
			Rating rating) {
		
		return new Drink(id, name, price, rating);
	}

}
