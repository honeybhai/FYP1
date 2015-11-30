/**
 * 
 */
package edu.bnu.fyp.entity;

/**
 * @author Honey
 *
 */
public class Admin {
	private Long adminId;
	private Long userId;
	private String adminName;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	

}
