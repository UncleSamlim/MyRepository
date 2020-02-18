package team.fourth.papersys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import team.fourth.papersys.pojo.Newspaper;
import team.fourth.papersys.pojo.Order;
import team.fourth.papersys.pojo.OrderItem;
import team.fourth.papersys.util.C3P0Utils;
import team.fourth.papersys.util.DateConvertUtil;

public class OrderDaoImpl implements OrderDao {

	@Override
	public List<Order> selectAllOrders() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = C3P0Utils.getConnection();
		String sql = "select order_id,user_id,receiver,phone,address,money,order_date,status from orders order by order_id desc";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			LinkedList<Order> orderList = setListData(rs);
			return orderList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, stmt, rs);
		}
		return null;
	}

	@Override
	public List<Order> fuzzySelectOrdersById(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = C3P0Utils.getConnection();
		String sql = "select order_id,user_id,receiver,phone,address,money,order_date,status from orders where order_id like "+ "'" + id + "%'"+" order by order_id desc";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			LinkedList<Order> orderList = setListData(rs);
			return orderList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, stmt, rs);
		}
		return null;
	}

	@Override
	public List<Order> selectOrdersByStatus(String status) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = C3P0Utils.getConnection();
		String sql = "select order_id,user_id,receiver,phone,address,money,order_date,status from orders where status=? order by order_id desc";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, status);
			rs = pstmt.executeQuery();
			LinkedList<Order> orderList = setListData(rs);
			return orderList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, pstmt, rs);
		}
		return null;
	}
	
	private LinkedList<Order> setListData(ResultSet rs) {
		LinkedList<Order>list = new LinkedList<Order>();
		try {
			while (rs.next()) {
				Order order = new Order();
				order.setOrderId(rs.getString(1));
				order.setUserId(rs.getString(2));
				order.setReceiver(rs.getString(3));
				order.setPhone(rs.getString(4));
				order.setAddress(rs.getString(5));
				order.setMoney(rs.getDouble(6));
				order.setOrderDate(DateConvertUtil.StringToDate(rs.getString(7)));
				order.setStatus(rs.getString(8));
				list.add(order);
			}
			return list;
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteOrderById(String[] ids) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = C3P0Utils.getConnection();
		int result = 0;
		String sql = "delete from orders where order_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < ids.length; i++) {
				pstmt.setString(1, ids[i]);
				pstmt.addBatch();
			}
			int[] res = pstmt.executeBatch();
			for (int i = 0; i < res.length; i++) {
				result += res[i];
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, pstmt, null);
		}
		return 0;
	}

	@Override
	public int updateOrderStatus(String[] ids, String status) {
		Connection conn = null;
		PreparedStatement selectStmt = null;
		PreparedStatement updateStmt = null;
		ResultSet rs = null;
		conn = C3P0Utils.getConnection();
		int result = 0;
		String selectSql = "select paper_id,num from order_item where order_id=?";
		String updatePaperSql = "update newspaper set storage_num = storage_num - ? where paper_id = ?";
		String updateOrderSql = "update orders set status=? where order_id=?";
		try {
			selectStmt = conn.prepareStatement(selectSql);
			for (int i = 0; i < ids.length; i++) {
				selectStmt.setString(1, ids[i]);
				rs = selectStmt.executeQuery();
				conn.setAutoCommit(false);
				while(rs.next()) {
					updateStmt = conn.prepareStatement(updatePaperSql);
					updateStmt.setString(1, rs.getString("num"));
					updateStmt.setString(2, rs.getString("paper_id"));
					updateStmt.executeUpdate();
				}
				updateStmt = conn.prepareStatement(updateOrderSql);
				updateStmt.setString(1, status);
				updateStmt.setString(2, ids[i]);
				int res = updateStmt.executeUpdate();
				if(res>0) {
					conn.commit();
					result += res;
				}
			}
			updateStmt.close();
			return result;
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			C3P0Utils.release(conn, selectStmt, null);
		}
		return 0;
	}

	@Override
	public Order selectOrderById(String orderId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = C3P0Utils.getConnection();
		String sql = "select receiver,phone,address from orders where order_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Order order = new Order();
				order.setReceiver(rs.getString(1));
				order.setPhone(rs.getString(2));
				order.setAddress(rs.getString(3));
				return order;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, pstmt, null);
		}
		return null;
	}

	@Override
	public int updateOrder(String orderId, String receiver, String phone, String address) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = C3P0Utils.getConnection();
		String sql = "update orders set receiver=?,phone=?,address=? where order_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, receiver);
			pstmt.setString(2, phone);
			pstmt.setString(3, address);
			pstmt.setString(4, orderId);
			int res = pstmt.executeUpdate();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, pstmt, null);
		}
		return 0;
	}

	@Override
	public List<OrderItem> selectAllOrderItem() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = C3P0Utils.getConnection();
		String sql = "select order_id,paper_id,num from order_item order by order_id desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			LinkedList<OrderItem> itemList = new LinkedList<OrderItem>();
			while (rs.next()) {
				OrderItem item = new OrderItem();
				Order order = new Order();
				Newspaper paper = new Newspaper();
				String orderId = rs.getString(1);
				String paperId = rs.getString(2);
				int num = rs.getInt(3);
				order.setOrderId(orderId);
				paper.setPaperId(paperId);
				item.setOrder(order);
				item.setPaper(paper);
				item.setNum(num);
				itemList.add(item);
			}
			return itemList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.release(conn, pstmt, rs);
		}
		return null;
	}

	@Override
	public List<OrderItem> selcetOrderItemsById(String orderId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = C3P0Utils.getConnection();
		String sql = "select order_id,paper_id,num from order_item where order_id=?";
		List<OrderItem>list = new ArrayList<OrderItem>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderItem item = new OrderItem();
				Order order = new Order();
				Newspaper paper = new Newspaper();
				order.setOrderId(rs.getString(1));
				paper.setPaperId(rs.getString(2));
				item.setOrder(order);
				item.setPaper(paper);
				item.setNum(rs.getInt(3));
				list.add(item);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
