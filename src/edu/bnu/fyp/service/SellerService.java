package edu.bnu.fyp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bnu.fyp.dao.GenericDAO;
import edu.bnu.fyp.entity.Buyer;
import edu.bnu.fyp.entity.Item;
import edu.bnu.fyp.entity.Seller;
import edu.bnu.fyp.entity.User;

@Service
public class SellerService {

	@Autowired
	private GenericDAO genericDAO;
	
	
	public Seller findSellerByUserId(Long sellerId) throws Exception {
		String sql = "SELECT * FROM seller WHERE user_id = ?";
		return (Seller) genericDAO.findById(sql, Seller.class, sellerId);
	}
	public Seller findSellerBySellerId(Long sellerId) throws Exception {
		String sql = "SELECT * FROM seller WHERE seller_id = ?";
		return (Seller) genericDAO.findById(sql, Seller.class, sellerId);
	}
	public List<Seller> getSellersBySellersName(String sellerId) throws Exception {
		String sql = "SELECT * FROM seller WHERE seller_first_name like ?;";
		return (List<Seller>) genericDAO.findAll(sql, Seller.class, sellerId);
	}
	public boolean addSeller(Seller user) throws Exception {
		String sql = "INSERT INTO seller (seller_first_name, seller_last_name, seller_location, seller_mobile,seller_type, user_id) VALUES (:sellerFirstName,:sellerLastName, :sellerLocation, :sellerMobile, :sellerType, :userId)";
		int n = genericDAO.insertOrUpdate(sql, user);
		return n > 0;
	}
}
