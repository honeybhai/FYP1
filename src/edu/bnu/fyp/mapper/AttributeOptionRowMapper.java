package edu.bnu.fyp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.bnu.fyp.entity.AttributeOption;
import edu.bnu.fyp.entity.CategoryAttribute;

public class AttributeOptionRowMapper implements RowMapper<AttributeOption> {

	@Override
	public AttributeOption mapRow(ResultSet rs, int rowNum) throws SQLException {
		AttributeOption attributeOption=new AttributeOption();
		
		attributeOption.setAttributeOption(rs.getString("attribute_option"));
		
		
		if(rs.getString("category_attribute_name")!=null){
			CategoryAttribute categoryAttribute=new CategoryAttribute();
			categoryAttribute.setCategoryAttributeName(rs.getString("category_attribute_name"));
			attributeOption.setCategoryAttribute(categoryAttribute);
		}
		
		return attributeOption;
	}

}
