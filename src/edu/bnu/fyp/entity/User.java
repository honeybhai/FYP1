/**
 * @author Muhammad Haris
 * Nov 2, 2013
 */
package edu.bnu.fyp.entity;

import java.util.List;

/**
 *
 */
public class User {

	private Long userId;
	private String userName;
	private String password;
	private Long role;
	private String userEmail;
	
	 
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	private List<Message> messagesList;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getRole() {
		return role;
	}
	public void setRole(Long role) {
		this.role = role;
	}
	public List<Message> getMessagesList() {
		return messagesList;
	}
	public void setMessagesList(List<Message> messagesList) {
		this.messagesList = messagesList;
	}
	

	
}
