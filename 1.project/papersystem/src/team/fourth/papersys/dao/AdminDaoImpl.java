package team.fourth.papersys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


import team.fourth.papersys.pojo.Admin;
import team.fourth.papersys.util.C3P0Utils;

public class AdminDaoImpl implements AdminDao {

	@Override
	public int insertAdmin(Admin admin) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		conn = C3P0Utils.getConnection();
		String sql = "insert into admin values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, admin.getAdminId());
			pstmt.setString(2, admin.getAdminName());
			pstmt.setString(3, admin.getPassword());
			pstmt.setString(4, admin.getRole());
			pstmt.setString(5, admin.getPhone());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, pstmt, null);
		}
		return res;
	}

	@Override
	public Admin selectAdminByName(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Admin admin = null;
		conn = C3P0Utils.getConnection();
		String sql = "select admin_id,admin_name,password,role,phone from admin where admin_name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				admin = new Admin();
				admin.setAdminId(rs.getString(1));
				admin.setAdminName(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setRole(rs.getString(4));
				admin.setPhone(rs.getString(5));
			}
			return admin;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, pstmt, rs);
		}
		return null;
	}

	@Override
	public List<Admin> fuzzySelectAdminsByName(String name) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = C3P0Utils.getConnection();
		String sql = "select admin_id,admin_name,password,phone,role from admin where admin_name like "+"'%"+ name + "%'"+" order by admin_id";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			LinkedList<Admin>list = new LinkedList<Admin>();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getString(1));
				admin.setAdminName(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setPhone(rs.getString(4));
				admin.setRole(rs.getString(5));
				list.addFirst(admin);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, stmt, rs);
		}
		return null;
	}

	@Override
	public List<Admin> fuzzySelectAdminsByPhone(String phone) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = C3P0Utils.getConnection();
		String sql = "select admin_id,admin_name,password,phone,role phone from admin where phone like "+"'"+ phone + "%'"+" order by admin_id";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			LinkedList<Admin>list = new LinkedList<Admin>();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getString(1));
				admin.setAdminName(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setPhone(rs.getString(4));
				admin.setRole(rs.getString(5));
				list.addFirst(admin);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, stmt, rs);
		}
		return null;
	}

	@Override
	public List<Admin> selectAllAdmin() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = C3P0Utils.getConnection();
		String sql = "select admin_id,admin_name,password,phone,role from admin order by admin_id";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			LinkedList<Admin>list = new LinkedList<Admin>();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getString(1));
				admin.setAdminName(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setPhone(rs.getString(4));
				admin.setRole(rs.getString(5));
				list.addFirst(admin);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, pstmt, rs);
		}
		return null;
	}

	@Override
	public int deleteAdmin(String[] ids) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = C3P0Utils.getConnection();
		String sql = "delete from admin where admin_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < ids.length; i++) {
				pstmt.setString(1, ids[i]);
				pstmt.addBatch();
			}
			int[] result = pstmt.executeBatch();
			return result.length;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, pstmt, null);
		}
		return 0;
	}

	@Override
	public int updateAdminById(String adminId, String newValue, int column) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = C3P0Utils.getConnection();
		String sql = "";
		switch (column) {
		case 0:
			sql = "update admin set admin_id=? where admin_id=?";
			break;
		case 1:
			sql = "update admin set admin_name=? where admin_id=?";
			break;
		case 2:
			sql = "update admin set password=? where admin_id=?";
			break;
		case 3:
			sql = "update admin set phone=? where admin_id=?";
			break;
		case 4:
			sql = "update admin set role=? where admin_id=?";
			break;
		default:
			break;
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newValue);
			pstmt.setString(2, adminId);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, pstmt, null);
		}
		return 0;
	}

}
