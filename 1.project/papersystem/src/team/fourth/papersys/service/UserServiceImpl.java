package team.fourth.papersys.service;

import java.util.Vector;
import team.fourth.papersys.dao.UserDao;
import team.fourth.papersys.dao.UserDaoImpl;
import team.fourth.papersys.pojo.User;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = new UserDaoImpl();

	@Override
	public int countUsers(String username, String phone) {
		return userDao.countUsers(username, phone);
	}

	@Override
	public Vector<Vector<String>> findUsers(String username, String phone, int pageSize, int currentPage) {
		return userDao.selectUsers(username, phone, pageSize, currentPage);
	}

	@Override
	public int removeUserById(String ids[]) {
		return userDao.deleteUserById(ids);
	}

	@Override
	public int addUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public User findUserById(String userId) {
		return userDao.selectUserById(userId);
	}

	@Override
	public int modifyUser(String userId, User user) {
		return userDao.updateUser(userId, user);
	}
	
}
