package cn.yueqian.com.dao;

import java.util.List;

import cn.yueqian.com.dao.entity.User;

public interface UserDao {
		//用于查询和登录用户
		public List<User> find(User user);
		//添加用户
		public boolean add(User user);
		//修改密码
		public int update(User user);
		//删除用户
		public boolean delete(int id);
		//根据ID查询用户
		public User findById(int id);
}
