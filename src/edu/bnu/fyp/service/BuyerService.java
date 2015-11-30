package edu.bnu.fyp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bnu.fyp.dao.GenericDAO;
import edu.bnu.fyp.entity.Buyer;
import edu.bnu.fyp.entity.User;

@Service
public class BuyerService {
	@Autowired
	private GenericDAO genericDAO;
	public Buyer findBuyerByBuyerId(Long sellerId) throws Exception {
		String sql = "SELECT * FROM buyer WHERE buyer_id = ?";
		return (Buyer) genericDAO.findById(sql, Buyer.class, sellerId);
	}
	public Buyer findBuyerByUserId(Long sellerId) throws Exception {
		String sql = "SELECT * FROM buyer WHERE user_id = ?";
		return (Buyer) genericDAO.findById(sql, Buyer.class, sellerId);
	}
	public boolean addBuyer(Buyer user) throws Exception {
		String sql = "INSERT INTO buyer (buyer_name, buyer_email, buyer_mobile, user_id) VALUES (:buyerName,:buyerEmail,:buyerMobile,:userId)";
		int n = genericDAO.insertOrUpdate(sql, user);
		return n > 0;
	}

}
