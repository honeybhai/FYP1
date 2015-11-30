/**
 * 
 */
package edu.bnu.fyp.entity;

/**
 * @author Honey
 *
 */
public class Rating {
	private Long ratingId;
	private Long itemId;
	private Long rating;
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getRatingId() {
		return ratingId;
	}
	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getRating() {
		return rating;
	}
	public void setRating(Long rating) {
		this.rating = rating;
	}
		
}
