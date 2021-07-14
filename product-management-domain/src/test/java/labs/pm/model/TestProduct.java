package labs.pm.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestProduct extends Product {

	public TestProduct() {
		this(0, "no name", BigDecimal.ZERO);
	}

	public TestProduct(int id, String name, BigDecimal price) {
		super(id, name, price);
	}

	public TestProduct(int id, String name, BigDecimal price, Rating rating, 
			LocalDate bestBeforeDate) {
		super(id, name, price, rating, bestBeforeDate);
	}

	@Override
	public Product applyRating(Rating rating) {
		return new TestProduct(getId(), getName(), getPrice(), 
				rating, getBestBeforeDate());
	}

}
