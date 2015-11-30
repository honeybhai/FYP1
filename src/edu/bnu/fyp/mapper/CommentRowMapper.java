package edu.bnu.fyp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.bnu.fyp.entity.Buyer;
import edu.bnu.fyp.entity.Comment;
import edu.bnu.fyp.entity.Message;
import edu.bnu.fyp.entity.User;

public class CommentRowMapper implements RowMapper<Comment> {
	
	@Override
	public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Comment comment=new Comment();
		
		comment.setComment(rs.getString("comment"));
		
		
		comment.setCommentId(rs.getLong("comment_id"));
		comment.setBuyerId(rs.getLong("buyer_id"));
		comment.setItemId(rs.getLong("item_id"));
		if(rs.getString("buyer_name")!=null){
			Buyer buyer=new Buyer();
		   	buyer.setBuyerName(rs.getString("buyer_name"));
			buyer.setBuyerId(rs.getLong("buyer_id"));
			comment.setBuyer(buyer);
		}
		
		return comment;
	}

}
