/**
 * 
 */
package edu.bnu.fyp.entity;

import java.util.List;

/**
 * @author Honey
 *
 */
public class Item {
	private Long price;
	private Long itemId;
	private Long sellerId;
	private String itemName;
	private Long categoryId;
	private List<Rating> ratingsList;
	private List<ItemAttribute> itemAttributeList;
	private List<Comment> commentsList;
	private List<Advertisement> advertisementsList;
	private List<Wishlist> wishlistList;
	private Category category;
	

	
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public List<Rating> getRatingsList() {
		return ratingsList;
	}
	public void setRatingsList(List<Rating> ratingsList) {
		this.ratingsList = ratingsList;
	}
	public List<ItemAttribute> getItemAttributeList() {
		return itemAttributeList;
	}
	public void setItemAttributeList(List<ItemAttribute> itemAttributeList) {
		this.itemAttributeList = itemAttributeList;
	}
	public List<Comment> getCommentsList() {
		return commentsList;
	}
	public void setCommentsList(List<Comment> commentsList) {
		this.commentsList = commentsList;
	}
	public List<Advertisement> getAdvertisementsList() {
		return advertisementsList;
	}
	public void setAdvertisementsList(List<Advertisement> advertisementsList) {
		this.advertisementsList = advertisementsList;
	}
	public List<Wishlist> getWishlistList() {
		return wishlistList;
	}
	public void setWishlistList(List<Wishlist> wishlistList) {
		this.wishlistList = wishlistList;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
