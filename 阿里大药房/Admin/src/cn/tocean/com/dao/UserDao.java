package cn.tocean.com.dao;

import java.util.List;

import cn.tocean.com.dao.entity.User;
import cn.tocean.com.utils.Page;

public interface UserDao {

	public int add(User user);
	public int deleteById(int id);
	public int update(User user);
	public User selById(int id);
	
	public int getCount(String condition);
	public Page<User> getPage(String condition, int currentPage,int pageSize);
	public List<User> listOnePageInfo(String condition, int currentPage,int pageSize);
}
