package cn.yueqian.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.yueqian.com.dao.IGoodsDao;
import cn.yueqian.com.dao.entity.Goods;
import cn.yueqian.com.dao.utils.JdbcUtil;

public class GoodsDaoImpl implements IGoodsDao{

	@Override
	public int addGoods(Goods goods) {
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement psmt = null;
		String sql="INSERT INTO goods_list(name,"
				+ "price,previousprice,pic,"
				+ "shortdescription,longdescription,catscore,"
				+ "goodskind_id,saleamount,amount) VALUES (?,?,?,?,?,?,?,?,?,?)";
		int sign = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, goods.getName());
			psmt.setDouble(2, goods.getPrice());
			psmt.setDouble(3, goods.getPreviousPrice());
			psmt.setString(4, goods.getPic());
			psmt.setString(5, goods.getShortDescription());
			psmt.setString(6, goods.getLongDesctiption());
			psmt.setInt(7, goods.getCatscore());
			psmt.setInt(8, goods.getGoodsKindId());
			psmt.setInt(9, goods.getSaleamount());
			psmt.setInt(10, goods.getAmount());
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
	public int delGoodsById(int goodid) {
		String sql = "DELETE FROM goods_list  WHERE id = ? ";
		Object[] params = {goodid};
		int row = JdbcUtil.executeUpdate(sql, params);
		return row;
	}

	@Override
	public int delAllGoods() {
		Connection conn = JdbcUtil.getConnection();
		Statement stmt = null;
		int sign = 0;
		try {
			stmt = conn.createStatement();
			String sql = "DELETE FROM goods_list";
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
	public int updateGoods(Goods goods) {
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement psmt = null;
		String sql="update goods_list set name=?,price=?,previousprice=?,"
				+ "pic=?,shortdescription=?,longdescription=?,catscore=?,goodskind_id=?,saleamount=?,amount=? where id=?";
				Object[]  params = {goods.getName(),goods.getPrice(),goods.getPreviousPrice(),goods.getPic()
						,goods.getShortDescription(),goods.getLongDesctiption(),goods.getCatscore()
						,goods.getGoodsKindId(),goods.getSaleamount(),goods.getAmount(),goods.getId()};
		int rows = JdbcUtil.executeUpdate(sql, params);
		return rows;
	}

	@Override
	public List<Goods> selAllGoods() {
		// TODO Auto-generated method stub
		List<Goods> list = new ArrayList<Goods>();
		Connection conn = JdbcUtil.getConnection();
		Statement  stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from goods_list order by saleamount desc";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Goods goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				goods.setPreviousPrice(rs.getDouble("previousprice"));
				goods.setPic(rs.getString("pic"));
				goods.setShortDescription(rs.getString("shortdescription"));
				goods.setLongDesctiption(rs.getString("longdescription"));
				goods.setCatscore(rs.getInt("catscore"));
				goods.setGoodsKindId(rs.getInt("goodskind_id"));
				goods.setSaleamount(rs.getInt("saleamount"));
				goods.setAmount(rs.getInt("amount"));
				list.add(goods);
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
	public Goods selGoodsById(int id) {
		// TODO Auto-generated method stub
		Goods goods = new Goods();
		Connection conn = JdbcUtil.getConnection();
		Statement  stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from goods_list where id="+id;
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				goods.setPreviousPrice(rs.getDouble("previousprice"));
				goods.setPic(rs.getString("pic"));
				goods.setShortDescription(rs.getString("shortdescription"));
				goods.setLongDesctiption(rs.getString("longdescription"));
				goods.setCatscore(rs.getInt("catscore"));
				goods.setGoodsKindId(rs.getInt("goodskind_id"));
				goods.setSaleamount(rs.getInt("saleamount"));
				goods.setAmount(rs.getInt("amount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, stmt, conn);
		}
		
		return goods;
	}

	@Override
	public List<Goods> selGoodsByKindId(int KindId) {
		List list = new ArrayList();
		Connection conn = JdbcUtil.getConnection();
		Statement  stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from goods_list where goodskind_id="+KindId+" order by saleamount desc";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Goods goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				goods.setPreviousPrice(rs.getDouble("previousprice"));
				goods.setPic(rs.getString("pic"));
				goods.setShortDescription(rs.getString("shortdescription"));
				goods.setLongDesctiption(rs.getString("longdescription"));
				goods.setCatscore(rs.getInt("catscore"));
				goods.setGoodsKindId(rs.getInt("goodskind_id"));
				goods.setSaleamount(rs.getInt("saleamount"));
				goods.setAmount(rs.getInt("amount"));
				list.add(goods);
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
	public List<Goods> selGoodsBySId(int SuperId) {
		List list = new ArrayList();
		Connection conn = JdbcUtil.getConnection();
		Statement  stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * "+
					"From goodskind_list flist_gk, goodskind_list slist_gk,goods_list g "+
					"WHERE flist_gk.superkind = slist_gk.id AND g.goodskind_id=flist_gk.id AND slist_gk.id="+SuperId+" order by saleamount desc";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Goods goods = new Goods();
				goods.setId(rs.getInt("g.id"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getDouble("price"));
				goods.setPreviousPrice(rs.getDouble("previousprice"));
				goods.setPic(rs.getString("pic"));
				goods.setShortDescription(rs.getString("shortdescription"));
				goods.setLongDesctiption(rs.getString("longdescription"));
				goods.setCatscore(rs.getInt("catscore"));
				goods.setGoodsKindId(rs.getInt("goodskind_id"));
				goods.setSaleamount(rs.getInt("saleamount"));
				goods.setAmount(rs.getInt("amount"));
				list.add(goods);
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
