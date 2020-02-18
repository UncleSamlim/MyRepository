package cn.tocean.com.service.impl;

import cn.tocean.com.dao.CommentDao;
import cn.tocean.com.dao.UserDao;
import cn.tocean.com.dao.entity.User;
import cn.tocean.com.dao.impl.CommentDaoImpl;
import cn.tocean.com.dao.impl.UserDaoImpl;
import cn.tocean.com.service.UserService;
import cn.tocean.com.utils.Page;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();
	CommentDao commentDao = new CommentDaoImpl();
	@Override
	public int add(User user) {
		int row = userDao.add(user);
		return row;
	}

	@Override
	public int deleteById(int id) {
		commentDao.deleteById(id);
		int row = userDao.deleteById(id);
		return row;
	}

	@Override
	public int update(User user) {
		int row = userDao.update(user);
		return row;
	}

	@Override
	public Page<User> getPages(String condition, int currentPage, int pageSize) {
		Page page = userDao.getPage(condition, currentPage, pageSize);
		return page;
	}

}
