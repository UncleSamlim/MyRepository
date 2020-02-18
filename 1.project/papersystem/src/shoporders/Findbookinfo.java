package shoporders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.c3p0utils;

public class Findbookinfo {
	public static int FindbookStorage(String newspaper_id) {

		int storage = 0;

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = c3p0utils.getConnection();
			ps = conn
					.prepareStatement("select storage_num from newspaper where paper_id=?");
			ps.setString(1, newspaper_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException a) {
			a.printStackTrace();
		} finally {
			c3p0utils.release(conn, ps, rs);
		}
		return storage;
	}

	public static double Findbookprice(String newspaper_id) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = c3p0utils.getConnection();
			ps = conn
					.prepareStatement("select price from newspaper where paper_id=?");
			ps.setString(1, newspaper_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getDouble(1);
			}
		} catch (SQLException a) {
			a.printStackTrace();
		} finally {
			c3p0utils.release(conn, ps, rs);
		}
		return 0;
	}

}
