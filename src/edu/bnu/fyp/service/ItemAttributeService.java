/**
 * 
 */
package edu.bnu.fyp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bnu.fyp.dao.GenericDAO;
import edu.bnu.fyp.entity.CategoryAttribute;
import edu.bnu.fyp.entity.ItemAttribute;
import edu.bnu.fyp.mapper.ItemAttributeRowMapper;




/**
 * @author Honey
 *
 */
@Service
public class ItemAttributeService {
	@Autowired
	private GenericDAO genericDAO;
	
	
	public List<ItemAttribute> getItemAttributessByItemId(Long sellerId) throws Exception {
		String sql = "SELECT * FROM item_attribute WHERE item_id = ?";
		return (List<ItemAttribute>) genericDAO.findAll(sql, ItemAttribute.class, sellerId);
	}
	public List<ItemAttribute> getCategoryAttributeListByCategoryId(Long categoryId) throws Exception {
		String sql = "SELECT category_attribute_id FROM category_attribute WHERE category_id = ?";
		return (List<ItemAttribute>) genericDAO.findAll(sql, CategoryAttribute.class, categoryId);
	}
	public void addItemAttributes(List<ItemAttribute> itemAttributes) throws Exception {
		String sql = "INSERT INTO item_attribute (category_attribute_id, item_id,attribute_option) VALUES (:categoryAttributeId,:itemId,:attributeOption)";
		genericDAO.insertOrUpdateAll(sql, itemAttributes);
	}
	public List<ItemAttribute> getItemAttributeOptionListForProduct(Long itemId) throws Exception {
		String sql = "SELECT  attribute_option,category_attribute_name FROM "+ 
					 "category_attribute INNER JOIN item_attribute ON "+
					 "category_attribute.category_attribute_id=item_attribute.category_attribute_id "+ 
					 "WHERE item_attribute.item_id=?; ";
		return (List<ItemAttribute>) genericDAO.findByQuery(sql, new ItemAttributeRowMapper(), itemId);
	}
	public void deleteItemAttributes(Long itemId) throws Exception {
		String sql = "delete from item_attribute where item_id=?;";
		genericDAO.delete(sql, itemId);
		
	}
	public boolean updateItemAttribute(ItemAttribute itemAttribute) throws Exception {
		String sql = "UPDATE item_attribute SET attribute_option = :attributeOption WHERE item_attribute_id = :itemAttributeId;";
		int n = genericDAO.insertOrUpdate(sql, itemAttribute);
		return n > 0;
	}
	public void updateItemAttributes(List<ItemAttribute> itemAttributes) throws Exception {
		//String sql = "UPDATE item_attribute (attribute_option,item_id,category_attribute_id,item_attribute_id) VALUES (:attributeOption,:itemId,:categoryAttributeId,:itemAttributeId)";
		String sql = "UPDATE item_attribute SET attribute_option = :attributeOption WHERE item_attribute_id = :itemAttributeId;";
		genericDAO.insertOrUpdateAll(sql, itemAttributes);
	}

}
