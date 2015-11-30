/**
 * @author Muhammad Haris
 * Nov 14, 2013
 */
package edu.bnu.fyp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bnu.fyp.dao.GenericDAO;
import edu.bnu.fyp.entity.User;

/**
 *
 */
@Service
public class UserService {

	@Autowired
	private GenericDAO genericDAO;

	/* To insert a single user */
	public boolean addUser(User user) throws Exception {
		String sql = "INSERT INTO Users (user_name, password, role, user_email) VALUES (:userName,:password,:role,:userEmail)";
		int n = genericDAO.insertOrUpdate(sql, user);
		return n > 0;
	}

	/* To update a single user */
	public boolean updateUser(User user) throws Exception {
		String sql = "UPDATE Users SET first_name = :firstName, last_name = :lastName, gender = :gender, city = :city WHERE user_id = :userId";
		int n = genericDAO.insertOrUpdate(sql, user);
		return n > 0;
	}
	public Long getMaxUserId()throws Exception{
		String sql="SELECT MAX(user_id) FROM users;";
		return genericDAO.getMax(sql);
		
	}

	/* To insert or update list of records */
	public void addUsers(List<User> users) throws Exception {
		String sql = "INSERT INTO Users (first_name, last_name, gender, city) VALUES (:firstName,:lastName,:gender,:city)";
		genericDAO.insertOrUpdateAll(sql, users);
	}

	/* To find a single record against given value */
	public User findUserById(Long userId) throws Exception {
		String sql = "SELECT * FROM Users WHERE user_id = ?";
		return (User) genericDAO.findById(sql, User.class, userId);
	}
	public User findUserByEmail(String email) throws Exception {
		String sql = "SELECT * FROM users WHERE user_email = ?";
		return (User) genericDAO.findByEmail(sql, User.class, email);
	}

	public List<User> getAllUsers() throws Exception {
		String sql = "SELECT * FROM Users ";
		return (List<User>) genericDAO.findAll(sql, User.class);
	}
}
