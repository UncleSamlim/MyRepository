package cn.tocean.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.tocean.com.dao.UserDao;
import cn.tocean.com.dao.entity.User;
import cn.tocean.com.dao.utils.JdbcUtil;
import cn.tocean.com.utils.Page;

public class UserDaoImpl implements UserDao {

	@Override
	public int add(User user) {
		String sql = "INSERT into user_list (name,pwd,realname, age,sex,phone, address,lasttime) VALUES(?,?,?,?,?,?,?,?)";
		Object[] params= {user.getName(),user.getPwd(),user.getRealname(),user.getAge(),user.getSex(),user.getPhone(),user.getAddress(),user.getLasttime()};
		int row = JdbcUtil.executeUpdate(sql, params);
		return row;
	}

	@Override
	public int deleteById(int id) {
		String sql = "DELETE FROM user_list  WHERE id = ? ";
		Object[] params = {id};
		int row = JdbcUtil.executeUpdate(sql, params);
		return row;
	}

	@Override
	public int update(User user) {
		String sql = "UPDATE user_list SET name=?,pwd=?,realname=?, age=?,sex=?,phone=?, address=?,lasttime=? WHERE id=?";
		Object[] params= {user.getName(),user.getPwd(),user.getRealname(),user.getAge(),user.getSex(),user.getPhone(),user.getAddress(),user.getLasttime(),user.getId()};
		int row = JdbcUtil.executeUpdate(sql, params);
		return row;
	}
	
	
	//得到分页的总记录数
		@Override
		public int getCount(String condition) {
			int rows = -1;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Connection conn = JdbcUtil.getConnection();
			String sql = "SELECT COUNT(1) as shuliang FROM user_list WHERE name LIKE ?";
			try {
				ps  = conn.prepareStatement(sql);
				ps.setObject(1, "%"+condition+"%");
				rs = ps.executeQuery();
				if (rs.next()) {
					//rows = rs.getInt(1);
					rows = rs.getInt("shuliang");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.closeAll(rs, ps, conn);
			}
			
			return rows;
		}

		
		@Override
		public List<User> listOnePageInfo(String condition, int currentPage,int pageSize) {
			//SELECT * FROM emp WHERE ename LIKE '%%' LIMIT (currentPage-1)*pageSize , pageSize
			
			List<User> empList  =  new ArrayList<User>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			Connection conn = JdbcUtil.getConnection();
			//SELECT COUNT(1) FROM emp WHERE ename LIKE '%s%'
			String sql = "SELECT * FROM user_list WHERE name LIKE ?   LIMIT ? , ? ";
			try {
				ps  = conn.prepareStatement(sql);
				ps.setObject(1, "%"+condition+"%");
				ps.setObject(2, (currentPage-1)*pageSize);
				ps.setObject(3, pageSize);
				rs = ps.executeQuery();
				while (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setPwd(rs.getString("pwd"));
					user.setRealname(rs.getString("realname"));
					user.setAge(rs.getInt("age"));
					user.setSex(rs.getString("sex"));
					user.setPhone(rs.getString("phone"));
					user.setAddress(rs.getString("address"));
					user.setLasttime(rs.getDate("lasttime"));
					empList.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.closeAll(rs, ps, conn);
			}
			return empList;
		}
		//得到一页中的全部信息
		@Override
		public Page<User> getPage(String condition, int currentPage,int pageSize) {
			int count = this.getCount(condition);
			List<User> list = this.listOnePageInfo(condition, currentPage, pageSize);
			Page<User> page = new Page<User>(currentPage, pageSize, count, list);
			return page;
		}

		@Override
		public User selById(int id) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			User user = new User();
			Connection conn = JdbcUtil.getConnection();
			//SELECT COUNT(1) FROM emp WHERE ename LIKE '%s%'
			String sql = "SELECT * FROM user_list WHERE id=? ";
			try {
				ps  = conn.prepareStatement(sql);
				ps.setObject(1, id);
				rs = ps.executeQuery();
				if (rs.next()) {
					
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setPwd(rs.getString("pwd"));
					user.setRealname(rs.getString("realname"));
					user.setAge(rs.getInt("age"));
					user.setSex(rs.getString("sex"));
					user.setPhone(rs.getString("phone"));
					user.setAddress(rs.getString("address"));
					user.setLasttime(rs.getDate("lasttime"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.closeAll(rs, ps, conn);
			}
			return user;
		}
}
