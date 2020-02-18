package cn.yueqian.com.dao.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	private static Connection conn = null;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//�õ���ݿ�����
	public static Connection  getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/drugstore?useUnicode=true&characterEncoding=UTF8";
			String userName = "root";
			String password = "123456";
			conn = DriverManager.getConnection(url,userName,password );
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 *  ����˵����ͨ�õ���ɾ�ķ���
	 *    ʹ�÷���������Դ�����ɾ�ĵ�sql�룬�����Ӧ�����飬�������ݸ�ռλ��˳��һ�¡�
	 *    ����sql  ��    INSERT INTO t_admin (adm_id,ADM_USERNAME,ADM_PASSWORD) VALUES (?,?,?);
	 *    Object[] params = {3,�����塱,"7889"};
	 * @param admin
	 * @return
	 */
	public static int executeUpdate(String sql, Object[] params) {
		int rows = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			//String sql = "INSERT INTO t_admin (adm_id,ADM_USERNAME,ADM_PASSWORD) VALUES (?,?,?);";
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			rows = ps.executeUpdate();//����sql���
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(null, ps, conn);
		}
		return rows;
	}
	
	
	public static void closeAll(ResultSet rs,Statement state, Connection conn) {
		try {
			// 3.5�ر���Դ����󿪵ģ����ȹ�
			if (rs!=null) {
				rs.close();
			}
			if (state != null) {
				state.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}