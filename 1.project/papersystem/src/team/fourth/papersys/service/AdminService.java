package team.fourth.papersys.service;

import java.util.List;

import team.fourth.papersys.pojo.Admin;

public interface AdminService {

	int addAdmin(Admin admin);

	Admin findAdminByName(String name);
	
	List<Admin> findAllAdmins();

	List<Admin> findAdminsByName(String name);
	
	List<Admin> findAdminsByPhone(String phone);

	int removeAdmin(String[] ids);

	int modifyAdminById(String adminId, String newValue, int column);
}
