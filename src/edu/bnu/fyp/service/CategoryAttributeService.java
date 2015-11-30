/**
 * 
 */
package edu.bnu.fyp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bnu.fyp.dao.GenericDAO;
import edu.bnu.fyp.entity.CategoryAttribute;

/**
 * @author Honey
 *
 */
@Service
public class CategoryAttributeService {
	@Autowired 
	private GenericDAO genericDAO;
	public List<CategoryAttribute> getCategoryAttributeListByCategoryId(Long sellerId) throws Exception {
		String sql = "SELECT * FROM category_attribute WHERE category_id = ?";
		return (List<CategoryAttribute>) genericDAO.findAll(sql, CategoryAttribute.class, sellerId);
	}

}
