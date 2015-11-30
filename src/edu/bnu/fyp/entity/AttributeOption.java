/**
 * 
 */
package edu.bnu.fyp.entity;

/**
 * @author Honey
 *
 */
public class AttributeOption {

	private Long attributeOptionId;
	private String attributeOption;
	private Long categoryAttributeId;
	private CategoryAttribute categoryAttribute;
	
	public CategoryAttribute getCategoryAttribute() {
		return categoryAttribute;
	}
	public void setCategoryAttribute(CategoryAttribute categoryAttribute) {
		this.categoryAttribute = categoryAttribute;
	}
	public AttributeOption() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getAttributeOptionId() {
		return attributeOptionId;
	}
	public void setAttributeOptionId(Long attributeOptionId) {
		this.attributeOptionId = attributeOptionId;
	}
	public String getAttributeOption() {
		return attributeOption;
	}
	public void setAttributeOption(String attributeOption) {
		this.attributeOption = attributeOption;
	}
	public Long getCategoryAttributeId() {
		return categoryAttributeId;
	}
	public void setCategoryAttributeId(Long categoryAttributeId) {
		this.categoryAttributeId = categoryAttributeId;
	}
	
	
}
