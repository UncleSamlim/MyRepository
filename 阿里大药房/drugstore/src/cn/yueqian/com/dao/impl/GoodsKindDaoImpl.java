package cn.yueqian.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.yueqian.com.dao.IGoodsKindDao;
import cn.yueqian.com.dao.entity.Goods;
import cn.yueqian.com.dao.entity.GoodsKind;
import cn.yueqian.com.dao.utils.JdbcUtil;

public class GoodsKindDaoImpl implements IGoodsKindDao{

	@Override
	public int addGoodsKind(GoodsKind goodskind) {
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement psmt = null;
		String sql="INSERT INTO goodskind_list(kindname,superkind) VALUES (?,?)";
		int sign = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, goodskind.getKindName());
			psmt.setInt(2, goodskind.getSuperKind());
			sign = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeAll(null, psmt, conn);
		}
		
		return sign;
	}

	@Override
	public int delAllGoodsKind() {
		Connection conn = JdbcUtil.getConnection();
		Statement stmt = null;
		int sign = 0;
		try {
			stmt = conn.createStatement();
			String sql = "DELETE FROM goodskind_list";
			sign = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(null, stmt, conn);
		}
		
		return sign;
	}

	@Override
	public int delGoodsKindById(int goodskindid) {
		String sql = "DELETE FROM goodskind_list  WHERE id = ? ";
		Object[] params = {goodskindid};
		int row = JdbcUtil.executeUpdate(sql, params);
		return row;
	}

	@Override
	public int updateGoodsKindById(GoodsKind goodskind) {
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement psmt = null;
		String sql="update goodskind_list set kindname=?,superkind=? where id=?";
				Object[]  params = {goodskind.getKindName(),goodskind.getSuperKind(),goodskind.getId()};
		int rows = JdbcUtil.executeUpdate(sql, params);
		return rows;
	}

	@Override
	public List<GoodsKind> selAllGoodsKind() {
		// TODO Auto-generated method stub
		List<GoodsKind> list = new ArrayList<GoodsKind>();
		Connection conn = JdbcUtil.getConnection();
		Statement  stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from goodskind_list";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				GoodsKind goodskind = new GoodsKind();
				goodskind.setId(rs.getInt("id"));
				goodskind.setKindName(rs.getString("kindname"));
				goodskind.setSuperKind(rs.getInt("superkind"));
				list.add(goodskind);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, stmt, conn);
		}
		
		return list;
	}

	@Override
	public GoodsKind selGoodsKindById(int goodskindid) {
		GoodsKind goodskind = new GoodsKind();
		Connection conn = JdbcUtil.getConnection();
		Statement  stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from goodskind_list where id="+goodskindid;
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				goodskind.setId(rs.getInt("id"));
				goodskind.setKindName(rs.getString("kindname"));
				goodskind.setSuperKind(rs.getInt("superkind"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, stmt, conn);
		}
		
		return goodskind;
	}

	@Override
	public List<GoodsKind> getAllSuperKind() {
		// TODO Auto-generated method stub
		List<GoodsKind> list = new ArrayList<GoodsKind>();
		Connection conn = JdbcUtil.getConnection();
		Statement  stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM goodskind_list where superkind is null";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				GoodsKind goodskind = new GoodsKind();
				goodskind.setId(rs.getInt("id"));
				goodskind.setKindName(rs.getString("kindname"));
				goodskind.setSuperKind(rs.getInt("superkind"));
				list.add(goodskind);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, stmt, conn);
		}
		return list;
	}

	@Override
	public List<GoodsKind> getKindBySuperKind(String superkind) {
		// TODO Auto-generated method stub
		List<GoodsKind> list = new ArrayList<GoodsKind>();
		Connection conn = JdbcUtil.getConnection();
		Statement  stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String sql = "select first.id,first.kindname,first.superkind "+
						"from goodskind_list first , goodskind_list second "+
						"where first.superkind = second.id and second.kindname='"+superkind+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				GoodsKind goodskind = new GoodsKind();
				goodskind.setId(rs.getInt("id"));
				goodskind.setKindName(rs.getString("kindname"));
				goodskind.setSuperKind(rs.getInt("superkind"));
				list.add(goodskind);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, stmt, conn);
		}
		return list;
	}

}
