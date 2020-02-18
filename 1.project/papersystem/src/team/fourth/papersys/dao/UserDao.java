package team.fourth.papersys.dao;

import java.util.Vector;

import team.fourth.papersys.pojo.User;
/**
 * 用户数据访问接口
 * @author linyanbin
 *
 * 2018年3月13日下午8:28:46
 */
public interface UserDao {
	/**
	 * 根据传入的手机号或用户名统计人数
	 * @param userNameOrPhone
	 * @return
	 */
	int countUsers(String username, String phone);
	/**
	 * 根据传入的手机号分页查询用户
	 * @param userNameOrPhone
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public Vector<Vector<String>> selectUsers(String username, String phone, int pageSize, int currentPage);
	/**
	 * 根据用户id删除用户
	 * @param userId
	 * @return
	 */
	int deleteUserById(String ids[]);
	/**
	 * 添加用户
	 * @param username
	 * @param password
	 * @param phone
	 * @return
	 */
	int insertUser(User user);
	/**
	 * 根据用户Id查询用户
	 * @param userId
	 * @return
	 */
	User selectUserById(String userId);
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	int updateUser(String userId, User user);
}
