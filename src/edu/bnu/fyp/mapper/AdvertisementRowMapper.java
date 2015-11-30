package edu.bnu.fyp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.bnu.fyp.entity.Advertisement;
import edu.bnu.fyp.entity.Item;

public class AdvertisementRowMapper implements RowMapper<Advertisement> {
	@Override
	public Advertisement mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Advertisement advertisement=new Advertisement();
		
		advertisement.setItemId(rs.getLong("item_id"));
		
		
	
		if(rs.getString("item_name")!=null){
			Item item=new Item();
			item.setItemId(rs.getLong("item_Id"));
			item.setItemName(rs.getString("item_name"));
			item.setPrice(rs.getLong("price"));
			advertisement.setItem(item);
		}
		
		return advertisement;
	}

}
