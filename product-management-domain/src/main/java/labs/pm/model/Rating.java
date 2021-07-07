package labs.pm.model;

/**
 * (@code Rating} enumeration represents a list of possible ratings that
 * can be assigned to a {@link Product Product} instance.
 *
 * @author oracle
 * @version 5.0
 */
public enum Rating {
	NOT_RATED("\u2606\u2606\u2606\u2606\u2606"), 
	ONE_STAR("\u2605\u2606\u2606\u2606\u2606"), 
	TWO_STAR("\u2605\u2605\u2606\u2606\u2606"), 
	THREE_STAR("\u2605\u2605\u2605\u2606\u2606"), 
	FOUR_STAR("\u2605\u2605\u2605\u2605\u2606"), 
	FIVE_STAR("\u2605\u2605\u2605\u2605\u2605");
	
	private String stars;
	
	Rating(String stars) {
		this.stars = stars;
	}

	/**
	 * @return the stars
	 */
	public String getStars() {
		return stars;
	}
}
