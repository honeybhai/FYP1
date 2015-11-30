/**
 * 
 */
package edu.bnu.fyp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.bnu.fyp.entity.CategoryAttribute;
import edu.bnu.fyp.entity.ItemAttribute;
import edu.bnu.fyp.entity.Message;
import edu.bnu.fyp.entity.User;

/**
 * @author Honey
 *
 */
public class MessageRowMapper implements RowMapper<Message> {
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
		Message message=new Message();
		User user=new User();
		
	
		user.setUserName(rs.getString("user_name"));
		user.setUserId(rs.getLong("user_Id"));
		message.setUser(user);
		
		
		
		return message;
	}

}
