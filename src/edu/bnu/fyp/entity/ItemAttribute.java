/**
 * 
 */
package edu.bnu.fyp.entity;

/**
 * @author Honey
 *
 */
public class ItemAttribute {

	private Long itemAttributeId;
	private Long categoryAttributeId;
	private Long itemId;
	private String attributeOption;
	private CategoryAttribute categoryAttribute;
	
	
	public CategoryAttribute getCategoryAttribute() {
		return categoryAttribute;
	}

	public void setCategoryAttribute(CategoryAttribute categoryAttribute) {
		this.categoryAttribute = categoryAttribute;
	}

	public ItemAttribute() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getItemAttributeId() {
		return itemAttributeId;
	}

	public void setItemAttributeId(Long itemAttributeId) {
		this.itemAttributeId = itemAttributeId;
	}

	public Long getCategoryAttributeId() {
		return categoryAttributeId;
	}
	public void setCategoryAttributeId(Long categoryAttributeId) {
		this.categoryAttributeId = categoryAttributeId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getAttributeOption() {
		return attributeOption;
	}

	public void setAttributeOption(String attributeOption) {
		this.attributeOption = attributeOption;
	}

	
	
	
	
}
