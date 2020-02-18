package cn.tocean.com.dao;

import cn.tocean.com.dao.entity.Admin;

public interface AdminDao {

	public Admin getAdminByNameAndPassword(String name,String pwd);
}
