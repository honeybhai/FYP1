/**
 * 
 */
package edu.bnu.fyp.entity;

/**
 * @author Honey
 *
 */
public class Wishlist {
	private Long wishlistId;
	private Long buyerId;
	private Long itemId;
	private Item item;
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(Long wishlistId) {
		this.wishlistId = wishlistId;
	}
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	

}
