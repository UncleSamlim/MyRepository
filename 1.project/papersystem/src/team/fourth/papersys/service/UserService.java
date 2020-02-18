package team.fourth.papersys.service;

import java.util.Vector;

import team.fourth.papersys.pojo.User;

public interface UserService {
	
	public int countUsers(String username, String phone);
	
	public Vector<Vector<String>> findUsers(String username, String phone, int pageSize, int currentPage);

	public int removeUserById(String ids[]);

	public int addUser(User user);

	public User findUserById(String userId);

	public int modifyUser(String userId, User user);
	
}
