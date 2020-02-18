package team.fourth.papersys.dao;

import java.util.List;

import team.fourth.papersys.pojo.Admin;
/**
 * ����Ա���ݷ��ʽӿ�
 * @author linyanbin
 *
 * 2018��3��14������8:55:58
 */
public interface AdminDao {
	/**
	 * �������Ա��Ϣ
	 * @param admin
	 * @return
	 */
	int insertAdmin(Admin admin);
	
	/**
	 * ����������ѯ����Ա
	 * @param name
	 * @param isFuzzyQuery
	 * @return
	 */
	Admin selectAdminByName(String name);
	
	/**
	 * ��ѯ���Թ���Ա��Ϣ
	 * @param phone
	 * @return
	 */
	List<Admin> selectAllAdmin();

	/**
	 * ��������ģ����ѯ
	 * @param name
	 * @return
	 */
	List<Admin> fuzzySelectAdminsByName(String name);
	
	/**
	 * �����ֻ���ģ����ѯ
	 * @param phone
	 * @return
	 */
	List<Admin> fuzzySelectAdminsByPhone(String phone);
	/**
	 * ɾ������Ա��Ϣ��������ɾ��
	 * @param ids
	 * @return
	 */
	int deleteAdmin(String[] ids);
	/**
	 * �޸Ĺ���Աĳһ�е���Ϣ
	 * @param adminId
	 * @param newValue
	 * @return
	 */
	int updateAdminById(String adminId, String newValue, int column);
}
