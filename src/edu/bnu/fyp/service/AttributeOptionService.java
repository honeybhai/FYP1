package edu.bnu.fyp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bnu.fyp.dao.GenericDAO;
import edu.bnu.fyp.entity.AttributeOption;
import edu.bnu.fyp.entity.CategoryAttribute;
import edu.bnu.fyp.mapper.AttributeOptionRowMapper;

@Service
public class AttributeOptionService {

	
	@Autowired
	private GenericDAO genericDAO;
	
	public List<AttributeOption> getAttributeOptionListForProduct(Long itemId) throws Exception {
		String sql = "SELECT category_attribute_name, attribute_option FROM category_attribute "+ 
"INNER JOIN  attribute_option ON category_attribute.category_attribute_id=attribute_option.category_attribute_id "+ 
"INNER JOIN item_attribute ON item_attribute.value=attribute_option.attribute_option_id WHERE item_attribute.item_id=? ;  ";
		return (List<AttributeOption>) genericDAO.findByQuery(sql, new AttributeOptionRowMapper(), itemId);
	}
	public List<AttributeOption> getAttributeOptionListByCategoryAttributeId(Long sellerId) throws Exception {
		String sql = "SELECT * FROM attribute_option WHERE category_attribute_id = ?";
		return (List<AttributeOption>) genericDAO.findAll(sql, AttributeOption.class, sellerId);
	}
	

}
