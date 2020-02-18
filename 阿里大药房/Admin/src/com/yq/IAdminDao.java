package com.yq;

import java.util.List;

import com.yq.entity.Admin;


public interface IAdminDao {
	
	public int add(Admin admin);
	
	public int delete(int id);
	
	public int update(Admin admin);
	
	public List<Admin> listAll(Admin admin);

}
