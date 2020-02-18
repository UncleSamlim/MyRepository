package cn.tocean.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.tocean.com.dao.CommentDao;
import cn.tocean.com.dao.utils.JdbcUtil;
import cn.yueqian.com.entity.Comment;

public class CommentDaoImpl implements CommentDao {

	@Override
	public int add(Comment comment) {
		String sql = "INSERT into comment_list (user_id,goods_id,pic,content,ip,date) VALUES(?,?,?,?,?,?)";
		Object[] params= {comment.getUser_id(),comment.getGoods_id(),comment.getPic(),comment.getContent(),comment.getIp(),comment.getDate()};
		int row = JdbcUtil.executeUpdate(sql, params);
		return row;
	}

	@Override
	public int deleteById(int id) {
		String sql = "DELETE FROM comment_list  WHERE id = ? ";
		Object[] params = {id};
		int row = JdbcUtil.executeUpdate(sql, params);
		return row;
		
	}

	@Override
	public int update(Comment comment) {
		// TODO Auto-generated method stub
		String sql = "UPDATE comment_list SET user_id=?,goods_id=?,pic=?,content=?,ip=?,date=? WHERE id=? ";
		Object[] params= {comment.getUser_id(),comment.getGoods_id(),comment.getPic(),comment.getContent(),comment.getIp(),comment.getDate(),comment.getId()};
		int row = JdbcUtil.executeUpdate(sql, params);
		return row;
	}

	@Override
	public List<Comment> getCommentByUserId(int user_id) {
		List<Comment> comments = new  ArrayList<Comment>();
		Connection connection = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * from comment_list WHERE user_id=?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setObject(1, user_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Comment comment = new Comment();
				comment.setId(rs.getInt("id"));
				comment.setUser_id(user_id);
				comment.setGoods_id(rs.getInt("goods_id"));
				comment.setContent(rs.getString("content"));
				comment.setPic(rs.getString("pic"));
				comment.setDate(rs.getString("date"));
				comment.setIp(rs.getString("ip"));
				comments.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, ps, connection);
		}
		
		return comments;
	}

	@Override
	public List<Comment> getCommentByCommentId(int comment_id) {
		List<Comment> comments = new  ArrayList<Comment>();
		Connection connection = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * from comment_list WHERE id=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setObject(1, comment_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Comment comment = new Comment();
				comment.setId(rs.getInt(comment_id));
				comment.setUser_id(rs.getInt("user_id"));
				comment.setGoods_id(rs.getInt("goods_id"));
				comment.setContent(rs.getString("content"));
				comment.setPic(rs.getString("pic"));
				comment.setDate(rs.getString("date"));
				comment.setIp(rs.getString("ip"));
				comments.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, ps, connection);
		}
		
		return comments;
	}

}
