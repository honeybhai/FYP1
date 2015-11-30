/**
 * 
 */
package edu.bnu.fyp.entity;

import java.util.List;

/**
 * @author Honey
 *
 */
public class Seller {
	private long sellerId;
	private long categoryId;
	private String sellerFirstName;
	private String sellerLastName;
	private String sellerLocation;
	private String sellerMobile;
	private String sellerType;
	private Long userId;
	private List<Item> itemsList;
	private List<Subsription> subsriptionsList;
	private List<Message> messagesList;
	private List<ReportedProfile> reportedProfileList;
	
	
	public List<Item> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<Item> itemsList) {
		this.itemsList = itemsList;
	}
	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getSellerId() {
		return sellerId;
	}
	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getSellerFirstName() {
		return sellerFirstName;
	}
	public void setSellerFirstName(String sellerFirstName) {
		this.sellerFirstName = sellerFirstName;
	}
	public String getSellerLastName() {
		return sellerLastName;
	}
	public void setSellerLastName(String sellerLastName) {
		this.sellerLastName = sellerLastName;
	}
	public String getSellerLocation() {
		return sellerLocation;
	}
	public void setSellerLocation(String sellerLocation) {
		this.sellerLocation = sellerLocation;
	}
	public String getSellerMobile() {
		return sellerMobile;
	}
	public void setSellerMobile(String sellerMobile) {
		this.sellerMobile = sellerMobile;
	}
	public String getSellerType() {
		return sellerType;
	}
	public void setSellerType(String sellerType) {
		this.sellerType= sellerType;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<Subsription> getSubsriptionsList() {
		return subsriptionsList;
	}
	public void setSubsriptionsList(List<Subsription> subsriptionsList) {
		this.subsriptionsList = subsriptionsList;
	}
	public List<Message> getMessagesList() {
		return messagesList;
	}
	public void setMessagesList(List<Message> messagesList) {
		this.messagesList = messagesList;
	}
	public List<ReportedProfile> getReportedProfileList() {
		return reportedProfileList;
	}
	public void setReportedProfileList(List<ReportedProfile> reportedProfileList) {
		this.reportedProfileList = reportedProfileList;
	}
	
	
	
	
}
