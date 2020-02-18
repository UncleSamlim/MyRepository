package team.fourth.papersys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;

import team.fourth.papersys.pojo.User;
import team.fourth.papersys.util.C3P0Utils;

public class UserDaoImpl implements UserDao{
	
	// 统计用户数
	public int countUsers(String username, String phone) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = C3P0Utils.getConnection();
		StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM USER WHERE 1=1");
		if(!StringUtils.isEmpty(username)) {
			sql.append(" and username like "+"\'%"+username+"%\'");
		}
		if(!StringUtils.isEmpty(phone)) {
			sql.append(" and phone like "+"\'"+phone+"%\'");
		}
		sql.append(" order by user_id");
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());
			// 如果查询成功，返回统计值
			if(rs.next()) {
				return rs.getInt(1);
			}else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, stmt, rs);
		}
		return 0;
	}
	
	// 根据用户名和手机号模糊查询用户
	public Vector<Vector<String>> selectUsers(String username, String phone, int pageSize, int currentPage) {
		// 类似存放数据的二维数组，一维参数为每页显示的记录数，二维参数为所查询的列数
		Vector<Vector<String>>infoVector = new Vector<Vector<String>>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder("SELECT user_id,username,PASSWORD,phone,gender,age,job,email FROM USER where 1=1");
		if(!StringUtils.isEmpty(username)) {
			sql.append(" and username like "+"\'%"+username+"%\'");
		}
		if(!StringUtils.isEmpty(phone)) {
			sql.append(" and phone like "+"\'"+phone+"%\'");
		}
		sql.append(" order by user_id");
		sql.append(" limit "+ (currentPage-1)*pageSize + "," + pageSize);
		try {
			conn = C3P0Utils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());
			while(rs.next()) {
				Vector<String>line = new Vector<String>();
				line.add(rs.getString(1));
				line.add(rs.getString(2));
				line.add(rs.getString(3));
				line.add(rs.getString(4));
				line.add(rs.getString(5));
				if(rs.getInt(6)==0) {
					line.add(null);
				}else {
					line.add(rs.getString(6));
				}
				line.add(rs.getString(7));
				line.add(rs.getString(8));
				infoVector.add(line);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, stmt, rs);
		}
		return infoVector;
	}

	// 删除用户信息
	public int deleteUserById(String ids[]) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		int result = 0;
		conn = C3P0Utils.getConnection();
		String sql = "delete from user where user_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < ids.length; i++) {
				pstmt.setString(1, ids[i]);
				int res = pstmt.executeUpdate();
				result += res;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, pstmt, null);
		}
		return result;
	}
	
	// 插入用户信息
	@Override
	public int insertUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		conn = C3P0Utils.getConnection();
		String sql = "insert into user values(?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
 			pstmt.setString(1, user.getUserId());
 			pstmt.setString(2, user.getUsername());
 			pstmt.setString(3, user.getPassword());
 			pstmt.setString(4, user.getPhone());
 			pstmt.setString(5, user.getGender());
 			pstmt.setInt(6, user.getAge());
 			pstmt.setString(7, user.getJob());
 			pstmt.setString(8, user.getEmail());
 			int res = pstmt.executeUpdate();
 			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, null, null);
		}
		return 0;
	}

	@Override
	public User selectUserById(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		User user = null;
		conn = C3P0Utils.getConnection();
		String sql = "select * from user where user_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setUserId(resultSet.getString(1));
				user.setUsername(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
				user.setPhone(resultSet.getString(4));
				user.setGender(resultSet.getString(5));
				if (resultSet.getString(6)!=null) {
					user.setAge(Integer.parseInt(resultSet.getString(6)));
				}
				user.setJob(resultSet.getString(7));
				user.setEmail(resultSet.getString(8));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, pstmt, null);
		}
		return user;
	}

	@Override
	public int updateUser(String userId, User user) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		conn = C3P0Utils.getConnection();
		String sql = "update user set username=?,password=?,phone=?,gender=?,age=?,job=?,email=? where user_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getGender());
			pstmt.setInt(5, user.getAge());
			pstmt.setString(6, user.getJob());
			pstmt.setString(7, user.getEmail());
			pstmt.setString(8, userId);
			int res = pstmt.executeUpdate();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, pstmt, null);
		}
		return 0;
	}
}
