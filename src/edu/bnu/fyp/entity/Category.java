/**
 * 
 */
package edu.bnu.fyp.entity;

import java.util.List;

/**
 * @author Honey
 *
 */
public class Category {
	private long categoryId;
	private String categoryName;
	private List<Item> itemsList;
	private List<CategoryAttribute> cateogryAttributesList;
	
	public List<Item> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<Item> itemsList) {
		this.itemsList = itemsList;
	}
	public List<CategoryAttribute> getCateogryAttributesList() {
		return cateogryAttributesList;
	}
	public void setCateogryAttributesList(
			List<CategoryAttribute> cateogryAttributesList) {
		this.cateogryAttributesList = cateogryAttributesList;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	

}
