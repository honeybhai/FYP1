/**
 * 
 */
package edu.bnu.fyp.entity;

import java.sql.Date;

/**
 * @author Honey
 *
 */
public class Advertisement {
	private Long advertisementId;
	private Long itemId;
	private Date date;
	private Item item;
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Advertisement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getAdvertisementId() {
		return advertisementId;
	}
	public void setAdvertisementId(Long advertisementId) {
		this.advertisementId = advertisementId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	

}
