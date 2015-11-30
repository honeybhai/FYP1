/**
 * 
 */
package edu.bnu.fyp.entity;

import java.util.List;

/**
 * @author Honey
 *
 */
public class CategoryAttribute {

	private Long categoryAttributeId;
	private String categoryAttributeName;
	private String categoryAttributeType;
	private Long categoryId;
	private List<AttributeOption> attributeOptionsList;
	private List<ItemAttribute> itemAttributesList;
	
	
	public List<AttributeOption> getAttributeOptionsList() {
		return attributeOptionsList;
	}
	public void setAttributeOptionsList(List<AttributeOption> attributeOptionsList) {
		this.attributeOptionsList = attributeOptionsList;
	}
	public List<ItemAttribute> getItemAttributesList() {
		return itemAttributesList;
	}
	public void setItemAttributesList(List<ItemAttribute> itemAttributesList) {
		this.itemAttributesList = itemAttributesList;
	}
	public CategoryAttribute() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getCategoryAttributeId() {
		return categoryAttributeId;
	}
	public void setCategoryAttributeId(Long categoryAttributeId) {
		this.categoryAttributeId = categoryAttributeId;
	}
	public String getCategoryAttributeName() {
		return categoryAttributeName;
	}
	public void setCategoryAttributeName(String categoryAttributeName) {
		this.categoryAttributeName = categoryAttributeName;
	}
	public String getCategoryAttributeType() {
		return categoryAttributeType;
	}
	public void setCategoryAttributeType(String categoryAttributeType) {
		this.categoryAttributeType = categoryAttributeType;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
}
