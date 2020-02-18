package team.fourth.papersys.dao;

import java.util.Vector;

import team.fourth.papersys.pojo.User;
/**
 * �û����ݷ��ʽӿ�
 * @author linyanbin
 *
 * 2018��3��13������8:28:46
 */
public interface UserDao {
	/**
	 * ���ݴ�����ֻ��Ż��û���ͳ������
	 * @param userNameOrPhone
	 * @return
	 */
	int countUsers(String username, String phone);
	/**
	 * ���ݴ�����ֻ��ŷ�ҳ��ѯ�û�
	 * @param userNameOrPhone
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public Vector<Vector<String>> selectUsers(String username, String phone, int pageSize, int currentPage);
	/**
	 * �����û�idɾ���û�
	 * @param userId
	 * @return
	 */
	int deleteUserById(String ids[]);
	/**
	 * ����û�
	 * @param username
	 * @param password
	 * @param phone
	 * @return
	 */
	int insertUser(User user);
	/**
	 * �����û�Id��ѯ�û�
	 * @param userId
	 * @return
	 */
	User selectUserById(String userId);
	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return
	 */
	int updateUser(String userId, User user);
}
