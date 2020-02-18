package com.yq.impl;


import java.sql.ResultSet;
import java.util.List;

import com.yq.IAdminDao;
import com.yq.entity.Admin;

import utils.MyJDBC;

public class AdminDaoImpl extends MyJDBC<Admin> implements IAdminDao{

	@Override
	public int add(Admin admin) {
		
		return 0;
	}

	@Override
	public int delete(int id) {
		
		return 0;
	}

	@Override
	public int update(Admin admin) {
		
		return 0;
	}

	@Override
	public List<Admin> listAll(Admin admin) {
		String sql = "select * from admin_list where name=? and pwd=?";
		Object[] object = {admin.getName(),admin.getPwd()};
		return query(sql,object);
	}

	@Override
	public Admin getEntity(ResultSet rs) {
		
		return null;
	}
	
}
