package cn.yueqian.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.yueqian.com.dao.IOrderGoodsDao;
import cn.yueqian.com.dao.entity.OrderGoods;
import cn.yueqian.com.dao.utils.JdbcUtil;

public class OrderGoodsImpl implements IOrderGoodsDao {

	@Override
	public void save(OrderGoods orderGoods) {
		PreparedStatement ps = null;
		Connection conn = JdbcUtil.getConnection();
		String sql = "INSERT INTO order_goods_list VALUES (?,?) ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, orderGoods.getOrderId());
			ps.setObject(2, orderGoods.getGoodsId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(OrderGoods orderGoods) {
		PreparedStatement ps = null;
		Connection conn = JdbcUtil.getConnection();
		String sql = "DELETE FROM order_goods_list  WHERE order_id = ? and goods_id = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, orderGoods.getOrderId());
			ps.setObject(2, orderGoods.getGoodsId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public OrderGoods getOrderGoodsObjectById(int id) {
		PreparedStatement ps = null;
		Connection conn = JdbcUtil.getConnection();
		ResultSet rs = null;
		OrderGoods orderGoods = new OrderGoods();
		String sql = "SELECT * FROM order_goods_list  WHERE order_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				orderGoods.setOrderId(rs.getInt("order_id"));
				orderGoods.setGoodsId(rs.getInt("goods_id"));
			}
			return orderGoods;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderGoods;
	}

}
