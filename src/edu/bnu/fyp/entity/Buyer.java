/**
 * 
 */
package edu.bnu.fyp.entity;

import java.util.List;

/**
 * @author Honey
 *
 */
public class Buyer {
	private String buyerName;
	private String buyerEmail;
	private Long buyerId;
	private Long userId;
	private String buyerMobile;
	private List<Subsription> subsriptionsList;
	private List<Comment> commentsList;
	private List<Wishlist> wishlistList;
	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getBuyerEmail() {
		return buyerEmail;
	}
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getBuyerMobile() {
		return buyerMobile;
	}
	public void setBuyerMobile(String buyerMobile) {
		this.buyerMobile = buyerMobile;
	}
	public List<Subsription> getSubsriptionsList() {
		return subsriptionsList;
	}
	public void setSubsriptionsList(List<Subsription> subsriptionsList) {
		this.subsriptionsList = subsriptionsList;
	}
	public List<Comment> getCommentsList() {
		return commentsList;
	}
	public void setCommentsList(List<Comment> commentsList) {
		this.commentsList = commentsList;
	}
	public List<Wishlist> getWishlistList() {
		return wishlistList;
	}
	public void setWishlistList(List<Wishlist> wishlistList) {
		this.wishlistList = wishlistList;
	}
	
}
