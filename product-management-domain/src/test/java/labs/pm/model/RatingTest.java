package labs.pm.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RatingTest {

	@Test
	void test() {
		assertEquals("\u2606\u2606\u2606\u2606\u2606", Rating.NOT_RATED.getStars());
		assertEquals("\u2605\u2606\u2606\u2606\u2606", Rating.ONE_STAR.getStars());
		assertEquals("\u2605\u2605\u2606\u2606\u2606", Rating.TWO_STAR.getStars());
		assertEquals("\u2605\u2605\u2605\u2606\u2606", Rating.THREE_STAR.getStars());
		assertEquals("\u2605\u2605\u2605\u2605\u2606", Rating.FOUR_STAR.getStars());
		assertEquals("\u2605\u2605\u2605\u2605\u2605", Rating.FIVE_STAR.getStars());
	}

}
