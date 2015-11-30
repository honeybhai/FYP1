package edu.bnu.fyp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bnu.fyp.dao.GenericDAO;
import edu.bnu.fyp.entity.Admin;
import edu.bnu.fyp.entity.Buyer;
@Service
public class AdministratorService {
	@Autowired
	private GenericDAO genericDAO;
	public Admin findAdministratorByAdministratorId(Long sellerId) throws Exception {
		String sql = "SELECT * FROM admin WHERE admin_id = ?";
		return (Admin) genericDAO.findById(sql, Admin.class, sellerId);
	}
	public Admin findAdminByUserId(Long sellerId) throws Exception {
		String sql = "SELECT * FROM admin WHERE user_id = ?";
		return (Admin) genericDAO.findById(sql, Admin.class, sellerId);
	}
	
}
