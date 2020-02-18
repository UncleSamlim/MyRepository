package team.fourth.papersys.dao;

import java.util.List;

import team.fourth.papersys.pojo.Admin;
/**
 * 管理员数据访问接口
 * @author linyanbin
 *
 * 2018年3月14日上午8:55:58
 */
public interface AdminDao {
	/**
	 * 插入管理员信息
	 * @param admin
	 * @return
	 */
	int insertAdmin(Admin admin);
	
	/**
	 * 根据姓名查询管理员
	 * @param name
	 * @param isFuzzyQuery
	 * @return
	 */
	Admin selectAdminByName(String name);
	
	/**
	 * 查询所以管理员信息
	 * @param phone
	 * @return
	 */
	List<Admin> selectAllAdmin();

	/**
	 * 根据姓名模糊查询
	 * @param name
	 * @return
	 */
	List<Admin> fuzzySelectAdminsByName(String name);
	
	/**
	 * 根据手机号模糊查询
	 * @param phone
	 * @return
	 */
	List<Admin> fuzzySelectAdminsByPhone(String phone);
	/**
	 * 删除管理员信息，可批量删除
	 * @param ids
	 * @return
	 */
	int deleteAdmin(String[] ids);
	/**
	 * 修改管理员某一列的信息
	 * @param adminId
	 * @param newValue
	 * @return
	 */
	int updateAdminById(String adminId, String newValue, int column);
}
