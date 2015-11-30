/**
 * 
 */
package edu.bnu.fyp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bnu.fyp.dao.GenericDAO;
import edu.bnu.fyp.entity.AttributeOption;
import edu.bnu.fyp.entity.Category;
import edu.bnu.fyp.entity.CategoryAttribute;

/**
 * @author Honey
 *
 */
@Service
public class CategoryService {
	@Autowired
	private GenericDAO genericDAO;
	public Category getCategoryByCategoryId(Long sellerId) throws Exception {
		String sql = "SELECT * FROM category WHERE category_id = ?";
		return (Category) genericDAO.findById(sql, Category.class, sellerId);
	}
	public Category getCategoryByCategoryName(String sellerId) throws Exception {
		String sql = "SELECT * FROM category WHERE category_name = ?";
		return (Category) genericDAO.findByEmail(sql, Category.class, sellerId);
	}
	public List<CategoryAttribute> getCategoryAttributeListByCategoryId(Long categoryId) throws Exception {
		String sql = "SELECT category_attribute_id, category_attribute_name FROM category_attribute WHERE category_id = ?";
		return (List<CategoryAttribute>) genericDAO.findAll(sql, CategoryAttribute.class, categoryId);
	}
	public List<Category> getAllCategoriesByCategoryName(String categoryId) throws Exception {
		String sql = "SELECT * FROM category WHERE category_name like ?;";
		return (List<Category>) genericDAO.findAll(sql, Category.class, categoryId);
	}

}
