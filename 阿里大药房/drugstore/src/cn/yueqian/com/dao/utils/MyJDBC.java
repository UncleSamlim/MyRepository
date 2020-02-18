package cn.yueqian.com.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class MyJDBC<T> {

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/drugstore", "root","123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 统一的更新方法
	 */
	public int update(String sql, Object[] obj) {
		int row = 0;
		try {
			pst = getConnection().prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i + 1, obj[i]);
				}
			}
			row = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getClose(conn, pst, rs);
		}
		return row;
	}
	/**
	 * 统一的查询方法
	 */
	public List<T> query(String sql,Object[] obj){
		List<T> list = new ArrayList<>();
		try {
			pst = getConnection().prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i + 1, obj[i]);
				}
			}
			rs = pst.executeQuery();
			while(rs.next()){
				T t = getEntity(rs);
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getClose(conn, pst, rs);
		}
		return list;
	}

	// 根据子类重写父类抽象方法获取到对应的实体类对象
	public abstract T getEntity(ResultSet rs);

	/**
	 * 统一的关闭
	 */
	private void getClose(Connection conn, PreparedStatement pst, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if(pst!=null)
				pst.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
