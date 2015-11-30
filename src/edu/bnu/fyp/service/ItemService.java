package edu.bnu.fyp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bnu.fyp.dao.GenericDAO;
import edu.bnu.fyp.entity.Comment;
import edu.bnu.fyp.entity.Item;



@Service
public class ItemService {
	@Autowired
	private GenericDAO genericDAO;
	
	
	public List<Item> getItemsBySellerId(Long sellerId) throws Exception {
		String sql = "SELECT * FROM item WHERE seller_id = ?";
		return (List<Item>) genericDAO.findAll(sql, Item.class, sellerId);
	}
	public Item getItemByItemId(Long sellerId) throws Exception {
		String sql = "SELECT * FROM item WHERE item_id = ?";
		return (Item) genericDAO.findById(sql, Item.class, sellerId);
	}
	public boolean addNewItem(Item item) throws Exception {
		String sql = "INSERT INTO item (item_name, category_id, seller_Id, price) VALUES (:itemName,:categoryId,:sellerId,:price)";
		int n = genericDAO.insertOrUpdate(sql, item);
		return n > 0;
	}
	public Long getMaxItemId()throws Exception{
		String sql="SELECT MAX(item_id) FROM item;";
		return genericDAO.getMax(sql);
		
	}
	public void deleteItem(Long itemId) throws Exception {
		String sql = "delete from item where item_id=?;";
		genericDAO.delete(sql, itemId);
		
	}
	public List<Item> getItemsByItemName(String sellerId) throws Exception {
		String sql = "SELECT * FROM item WHERE item_name like ? order by item_name asc;";
		return (List<Item>) genericDAO.findAll(sql, Item.class, sellerId);
	}
	public boolean updateItem(Item item) throws Exception {
		String sql = "UPDATE item SET item_name = :itemName, price = :price WHERE item_id = :itemId";
		int n = genericDAO.insertOrUpdate(sql, item);
		return n > 0;
	}
	public boolean addComment(Comment item) throws Exception {
		String sql = "INSERT INTO comments (comment, buyer_id, item_id) VALUES (:comment,:buyerId,:itemId)";
		int n = genericDAO.insertOrUpdate(sql, item);
		return n > 0;
	}
}
