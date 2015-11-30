package edu.bnu.fyp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.bnu.fyp.entity.CategoryAttribute;
import edu.bnu.fyp.entity.ItemAttribute;

public class ItemAttributeRowMapper implements RowMapper<ItemAttribute> {
	@Override
	public ItemAttribute mapRow(ResultSet rs, int rowNum) throws SQLException {
		ItemAttribute itemAttribute=new ItemAttribute();
		itemAttribute.setAttributeOption(rs.getString("attribute_Option"));
		
		
		
		if(rs.getString("category_attribute_name")!=null){
			CategoryAttribute categoryAttribute=new CategoryAttribute();
			categoryAttribute.setCategoryAttributeName(rs.getString("category_attribute_name"));
			itemAttribute.setCategoryAttribute(categoryAttribute);
		}
		
		return itemAttribute;
	}

}
