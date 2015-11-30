/**
 * 
 */
package edu.bnu.fyp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bnu.fyp.dao.GenericDAO;
import edu.bnu.fyp.entity.Item;
import edu.bnu.fyp.entity.Message;
import edu.bnu.fyp.entity.Seller;
import edu.bnu.fyp.mapper.MessageRowMapper;

/**
 * @author Honey
 *
 */
@Service
public class MessageService {
	@Autowired
	private GenericDAO genericDAO;
	
	public List<Message> getDistinctUserFromMessages(long rId)throws Exception{
		String sql="SELECT DISTINCT  user_id,user_name FROM users JOIN messages ON messages.receiver_user_id=users.user_id OR messages.sender_user_id=users.user_id WHERE ((messages.sender_user_id=? OR messages.receiver_user_id=?) AND (users.user_id!=?));";
		return (List<Message>) genericDAO.findByQuery(sql, new MessageRowMapper(), rId, rId, rId);
	}
	public List<Message> getMessagesBySenderId(long senderId, long receiverId) throws Exception {
		
		String sql = "SELECT * FROM messages WHERE (sender_user_id=? AND receiver_user_id=?) OR (receiver_user_id=? AND sender_user_id=?) ORDER BY  DATETIME ASC;";
		return (List<Message>) genericDAO.findAll(sql, Message.class, senderId, receiverId, senderId,receiverId);
	}
	public boolean addMessage(Message message) throws Exception {
		String sql = "INSERT INTO messages (message, sender_role, sender_user_id, receiver_role,receiver_user_id) VALUES (:message,:senderRole, :senderUserId, :receiverRole, :receiverUserId)";
		int n = genericDAO.insertOrUpdate(sql, message);
		return n > 0;
	}
	public void deleteThread(Long senderId, Long receiverId) throws Exception {
		String sql = "delete from messages where (sender_user_id=? AND receiver_user_id=?) OR (receiver_user_id=? AND sender_user_id=?)";
		genericDAO.delete(sql,  senderId, receiverId, senderId,receiverId);
		
	}
}
