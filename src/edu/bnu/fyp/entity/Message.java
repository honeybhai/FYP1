/**
 * 
 */
package edu.bnu.fyp.entity;

import java.sql.Date;

import javax.print.attribute.standard.DateTimeAtCreation;

/**
 * @author Honey
 *
 */
public class Message {
	private Long messageId;
	private Long senderUserId;
	private Long senderRole;
	private Long receiverRole;
	private Long receiverUserId;
	private String message;
	private Date dateTime;
	private User user;
	private Seller seller;
	private Buyer buyer;
	private Admin admin;
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getMessageId() {
		return messageId;
	}
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	public Long getSenderUserId() {
		return senderUserId;
	}
	public void setSenderUserId(Long senderUserId) {
		this.senderUserId = senderUserId;
	}
	public Long getSenderRole() {
		return senderRole;
	}
	public void setSenderRole(Long senderRole) {
		this.senderRole = senderRole;
	}
	public Long getReceiverRole() {
		return receiverRole;
	}
	public void setReceiverRole(Long receiverRole) {
		this.receiverRole = receiverRole;
	}
	public Long getReceiverUserId() {
		return receiverUserId;
	}
	public void setReceiverUserId(Long receiverUserId) {
		this.receiverUserId = receiverUserId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
	
	

}
