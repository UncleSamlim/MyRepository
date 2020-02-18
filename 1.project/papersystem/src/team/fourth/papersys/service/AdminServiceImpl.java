package team.fourth.papersys.service;

import java.util.List;

import team.fourth.papersys.dao.AdminDao;
import team.fourth.papersys.dao.AdminDaoImpl;
import team.fourth.papersys.pojo.Admin;

public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao = new AdminDaoImpl();	
	
	@Override
	public int addAdmin(Admin admin) {
		return adminDao.insertAdmin(admin);
	}

	@Override
	public Admin findAdminByName(String name) {
		return adminDao.selectAdminByName(name);
	}

	@Override
	public List<Admin> findAdminsByName(String name) {
		return adminDao.fuzzySelectAdminsByName(name);
	}

	@Override
	public List<Admin> findAdminsByPhone(String phone) {
		return adminDao.fuzzySelectAdminsByPhone(phone);
	}

	@Override
	public List<Admin> findAllAdmins() {
		return adminDao.selectAllAdmin();
	}

	@Override
	public int removeAdmin(String[] ids) {
		return adminDao.deleteAdmin(ids);
	}

	@Override
	public int modifyAdminById(String adminId, String newValue, int column) {
		return adminDao.updateAdminById(adminId, newValue, column);
	}

}
