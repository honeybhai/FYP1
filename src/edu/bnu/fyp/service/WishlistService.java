package edu.bnu.fyp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bnu.fyp.dao.GenericDAO;
import edu.bnu.fyp.entity.Item;
import edu.bnu.fyp.entity.User;
import edu.bnu.fyp.entity.Wishlist;
import edu.bnu.fyp.mapper.WishlistRowMapper;

@Service
public class WishlistService {
	@Autowired
	private GenericDAO genericDAO;
	public boolean addWishlist(Wishlist wishlist) throws Exception {
		String sql = "INSERT INTO wishlist (buyer_id, item_id) VALUES (:buyerId,:itemId)";
		int n = genericDAO.insertOrUpdate(sql, wishlist);
		return n > 0;
	}
	public List<Wishlist> getWishlist(Long buyerId) throws Exception {
		String sql = "SELECT * FROM item JOIN wishlist ON wishlist.item_id=item.item_id WHERE wishlist.buyer_id=?;";
		return (List<Wishlist>) genericDAO.findByQuery(sql, new WishlistRowMapper(),buyerId);
	}
	public void deleteWishlist(Long itemId) throws Exception {
		String sql = "delete from wishlist where wishlist_id=?;";
		genericDAO.delete(sql, itemId);
		
	}
}
