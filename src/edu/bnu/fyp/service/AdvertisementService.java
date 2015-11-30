package edu.bnu.fyp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bnu.fyp.dao.GenericDAO;
import edu.bnu.fyp.entity.Advertisement;
import edu.bnu.fyp.entity.Item;
import edu.bnu.fyp.mapper.AdvertisementRowMapper;

@Service
public class AdvertisementService {

	@Autowired
	private GenericDAO genericDAO;
	
	public List<Advertisement> getAllAdvertisedItem() throws Exception {
		String sql = "SELECT * FROM item JOIN advertisement ON item.item_id=advertisement.item_id";
		return (List<Advertisement>) genericDAO.findByQuery(sql,new AdvertisementRowMapper() );
	}
	public boolean addNewAdvertisement(Advertisement advertisement) throws Exception {
		String sql = "INSERT INTO advertisement (item_id) VALUES (:itemId)";
		int n = genericDAO.insertOrUpdate(sql, advertisement);
		return n > 0;
	}
}
