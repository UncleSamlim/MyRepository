package cn.tocean.com.dao;

import java.util.List;

import cn.yueqian.com.entity.Comment;

public interface CommentDao {
	public int add(Comment comment);
	public int deleteById(int id);
	public int update(Comment comment);
	public List<Comment> getCommentByUserId(int user_id);
	public List<Comment> getCommentByCommentId(int comment_id);
}
