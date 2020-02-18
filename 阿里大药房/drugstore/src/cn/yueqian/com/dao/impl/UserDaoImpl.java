package cn.yueqian.com.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import cn.yueqian.com.dao.UserDao;
import cn.yueqian.com.dao.entity.User;
import cn.yueqian.com.dao.utils.MyJDBC;


public class UserDaoImpl extends MyJDBC<User> implements UserDao {

	@Override
	public List<User> find(User user) {
		String sql = "select * from user_list where name=? and pwd=?";
		Object[] obj={user.getName(),user.getPwd()};
		return query(sql, obj);
	}

	@Override
	public boolean add(User user) {
		String sql = "insert into user_list values(null,?,?,?,?,?,?,?,sysdate())";
		Object[] obj={user.getName(),user.getPwd(),user.getRealname(),user.getAge(),user.getSex(),user.getPhone(),user.getAddress()};
		//,user.getLasttime()
		int row = update(sql, obj);
		if(row>0)
			return true;
		return false;
	}

	@Override
	public int update(User user) {
		String sql = "UPDATE user_list SET realname=?,phone=?,address=? WHERE id=? ";
		Object[]  params = {user.getRealname(),user.getPhone(),user.getAddress(),user.getId()};
		int rows =update(sql,params);
		return rows;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getEntity(ResultSet rs) {
		User user = new User();
		try {
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setPwd(rs.getString(3));
			user.setRealname(rs.getString(4));
			user.setAge(rs.getString(5));
			user.setSex(rs.getString(6));
			user.setAddress(rs.getString(8));
			user.setPhone(rs.getString(7));
//			user.setLasttime(rs.getDate(8));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	
}
