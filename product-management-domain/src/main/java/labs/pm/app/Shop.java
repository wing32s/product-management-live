/**
 * 
 */
package labs.pm.app;

import java.math.BigDecimal;
import java.time.LocalDate;

import labs.pm.model.Drink;
import labs.pm.model.Food;
import labs.pm.model.Product;
import labs.pm.model.Rating;

/** 
 *  {@code Shop} class represents an application that manages Products
 * @version 4.0
 * @author oracle
 */
public class Shop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Product p = new Product();
		
		Product p1 = new Drink(101, "Tea", BigDecimal.valueOf(1.99), 
				Rating.TWO_STAR);
		Product p2 = new Drink(102, "Coffee", BigDecimal.valueOf(1.99), 
				Rating.THREE_STAR);
		Product p3 = new Food(103, "Cake", BigDecimal.valueOf(3.99), 
				Rating.FOUR_STAR, LocalDate.now().plusDays(2));
		Product p4 = p2.applyRating(Rating.FOUR_STAR);
		Product p5 = p3.applyRating(Rating.ONE_STAR);
		
		System.out.println(p);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p5);
		
		/*
		System.out.printf("%d %s %.2f %.2f %s %n", 
				p.getId(), p.getName(), p.getPrice(), p.getDiscount(), 
				p.getRating().getStars());
		System.out.printf("%d %s %.2f %.2f %s %n", 
				p1.getId(), p1.getName(), p1.getPrice(), p1.getDiscount(), 
				p1.getRating().getStars());
		System.out.printf("%d %s %.2f %.2f %s %n", 
				p2.getId(), p2.getName(), p2.getPrice(), p2.getDiscount(), 
				p2.getRating().getStars());
		System.out.printf("%d %s %.2f %.2f %s %n", 
				p3.getId(), p3.getName(), p3.getPrice(), p3.getDiscount(), 
				p3.getRating().getStars());
		System.out.printf("%d %s %.2f %.2f %s %n", 
				p4.getId(), p4.getName(), p4.getPrice(), p4.getDiscount(), 
				p4.getRating().getStars());
		System.out.printf("%d %s %.2f %.2f %s %n", 
				p5.getId(), p5.getName(), p5.getPrice(), p5.getDiscount(), 
				p5.getRating().getStars());
				*/
	}

}
