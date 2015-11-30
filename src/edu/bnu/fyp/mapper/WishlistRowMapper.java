package edu.bnu.fyp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.bnu.fyp.entity.Item;
import edu.bnu.fyp.entity.Wishlist;

public class WishlistRowMapper implements RowMapper<Wishlist> {
	
	@Override
	public Wishlist mapRow(ResultSet rs, int rowNum) throws SQLException {
		Wishlist wishlist=new Wishlist();
		
		wishlist.setItemId(rs.getLong("item_id"));
		wishlist.setWishlistId(rs.getLong("wishlist_id"));
		wishlist.setBuyerId(rs.getLong("buyer_id"));
		
		if(rs.getString("item_name")!=null){
			Item item=new Item();
			item.setSellerId(rs.getLong("seller_id"));
			item.setCategoryId(rs.getLong("category_id"));
			item.setItemName(rs.getString("item_name"));
			item.setItemId(rs.getLong("item_id"));
			item.setPrice(rs.getLong("price"));
			wishlist.setItem(item);
			
			
		}
		
		return wishlist;
	}

}
