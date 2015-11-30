/**
 * 
 */
package edu.bnu.fyp.entity;

import java.util.List;

/**
 * @author Honey
 *
 */
public class Comment {
	private Long commentId;
	private Long ItemId;
	private Long buyerId;
	private String comment;
	private Buyer buyer;
	
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	private List<ReportedComment> repotedList;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public Long getItemId() {
		return ItemId;
	}
	public void setItemId(Long itemId) {
		ItemId = itemId;
	}
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public List<ReportedComment> getRepotedList() {
		return repotedList;
	}
	public void setRepotedList(List<ReportedComment> repotedList) {
		this.repotedList = repotedList;
	}
	

}
