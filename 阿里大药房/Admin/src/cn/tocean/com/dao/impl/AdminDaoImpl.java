package cn.tocean.com.dao.impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.tocean.com.dao.AdminDao;
import cn.tocean.com.dao.entity.Admin;
import cn.tocean.com.dao.utils.JdbcUtil;


public class AdminDaoImpl implements AdminDao {

	@Override
	public Admin getAdminByNameAndPassword(String name,String pwd) {
		Connection connection = JdbcUtil.getConnection();
		String sql = "SELECT * from admin_list WHERE name=? and pwd=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin admin = new Admin();
		try {
			ps = connection.prepareStatement(sql);
			ps.setObject(1, name);
			ps.setObject(2, pwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				admin.setPwd(rs.getString("pwd"));
				admin.setPower(rs.getInt("power"));
				admin.setLasttime(rs.getString("lasttime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, ps, connection);
		}
		return admin;
	}

}
