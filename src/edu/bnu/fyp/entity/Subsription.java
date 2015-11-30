/**
 * 
 */
package edu.bnu.fyp.entity;

/**
 * @author Honey
 *
 */
public class Subsription {

	private Long subsriptionId;
	private Long buyerId;
	private Long sellerId;
	public Long getSubsriptionId() {
		return subsriptionId;
	}
	public void setSubsriptionId(Long subsriptionId) {
		this.subsriptionId = subsriptionId;
	}
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public Subsription() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
