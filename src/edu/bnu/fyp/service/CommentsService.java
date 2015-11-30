/**
 * 
 */
package edu.bnu.fyp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bnu.fyp.dao.GenericDAO;
import edu.bnu.fyp.entity.Comment;
import edu.bnu.fyp.mapper.CommentRowMapper;

/**
 * @author Honey
 *
 */
@Service
public class CommentsService {
	@Autowired
	private GenericDAO genericDAO;
	public List<Comment> getCommentsByItemId(Long sellerId) throws Exception {
		String sql = "SELECT * FROM comments  JOIN buyer ON comments.buyer_id=buyer.buyer_id WHERE comments.item_id=?;";
		
		return (List<Comment>) genericDAO.findByQuery(sql,new CommentRowMapper(), sellerId);
	}

}
