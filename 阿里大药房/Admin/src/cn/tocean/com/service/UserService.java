package cn.tocean.com.service;


import cn.tocean.com.dao.entity.User;
import cn.tocean.com.utils.Page;

public interface UserService {

	public int add(User user);
	public int deleteById(int id);
	public int update(User user);
	public Page<User> getPages(String condition,int currentPage,int pageSize);
}
