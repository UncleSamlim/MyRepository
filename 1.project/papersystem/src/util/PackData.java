package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import obj.Bookinfo;
import obj.Order;
	 
public class PackData {
	private double price;
	
	public List<Bookinfo> findbookinfo() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Bookinfo> list = new ArrayList<Bookinfo>();
		try {
			conn = c3p0utils.getConnection();
			ps = conn.prepareStatement("Select * from newspaper");
			rs = ps.executeQuery();
			while (rs.next()) {
				Bookinfo bookinfo = new Bookinfo();
				bookinfo.setPaper_id(rs.getString(1));
				bookinfo.setCategory(rs.getString(2));
				bookinfo.setBookName(rs.getString(3));
				bookinfo.setPublishing(rs.getString(4));
				bookinfo.setPrice(rs.getDouble(5));
				bookinfo.setPublishnumber(rs.getString(6));
				bookinfo.setPublishdate(rs.getString(7));
				bookinfo.setImg(rs.getString(8));
				bookinfo.setStoragenum(rs.getInt(9));
				list.add(bookinfo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c3p0utils.release(conn, ps, rs);
		}
		return list;
	}

	public List<Bookinfo> findbookinfobyname(String name) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Bookinfo> list = new ArrayList<Bookinfo>();
		try {
			conn = c3p0utils.getConnection();
			ps = conn
					.prepareStatement("Select * from newspaper where paper_name=?");
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				Bookinfo bookinfo = new Bookinfo();
				bookinfo.setPaper_id(rs.getString(1));
				bookinfo.setCategory(rs.getString(2));
				bookinfo.setBookName(rs.getString(3));
				bookinfo.setPublishing(rs.getString(4));
				bookinfo.setPrice(rs.getDouble(5));
				bookinfo.setPublishnumber(rs.getString(6));
				bookinfo.setPublishdate(rs.getString(7));
				bookinfo.setImg(rs.getString(8));
				bookinfo.setStoragenum(rs.getInt(9));
				list.add(bookinfo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c3p0utils.release(conn, ps, rs);
		}
		return list;
	}

	public List<Bookinfo> findbookinfobypublisher(String publisher) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Bookinfo> list = new ArrayList<Bookinfo>();
		try {
			conn = c3p0utils.getConnection();
			ps = conn
					.prepareStatement("Select * from newspaper where publisher=?");
			ps.setString(1, publisher);
			rs = ps.executeQuery();
			while (rs.next()) {
				Bookinfo bookinfo = new Bookinfo();
				bookinfo.setPaper_id(rs.getString(1));
				bookinfo.setCategory(rs.getString(2));
				bookinfo.setBookName(rs.getString(3));
				bookinfo.setPublishing(rs.getString(4));
				bookinfo.setPrice(rs.getDouble(5));
				bookinfo.setPublishnumber(rs.getString(6));
				bookinfo.setPublishdate(rs.getString(7));
				bookinfo.setImg(rs.getString(8));
				bookinfo.setStoragenum(rs.getInt(9));
				list.add(bookinfo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c3p0utils.release(conn, ps, rs);
		}
		return list;
	}
	
	public List<Order> findorderchecked(String user_id) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Order> list = new ArrayList<Order>();
		try {
			conn = c3p0utils.getConnection();
			ps = conn.prepareStatement("SELECT orders.order_id,orders.user_id,orders.receiver,orders.phone,orders.address,order_item.num,orders.money,orders.order_date,orders.status  FROM orders ,order_item WHERE orders.order_id = order_item.order_id and orders.status= ? AND  user_id =?");
			ps.setString(1, "已审核");
			ps.setString(2, user_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order. setOrder_id(rs.getString(1));
				order.setUser_id(rs.getString(2));
				order.setReceiver(rs.getString(3));
				order.setPhone(rs.getString(4));
				order.setAddress(rs.getString(5));
				order.setNumber(rs.getInt(6));
				order.setMoney(rs.getDouble(7));
				order.setOrder_date(rs.getDate(8));
				order.setStatus(rs.getString(9));
				list.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c3p0utils.release(conn, ps, rs);
		}
		return list;
	}
	public List<Order> findorderunchecked(String user_id) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Order> list = new ArrayList<Order>();
		try {
			conn = c3p0utils.getConnection();
			ps = conn.prepareStatement(" SELECT orders.order_id,orders.user_id,orders.receiver,orders.phone,orders.address,order_item.num,orders.money,orders.order_date,orders.status  FROM orders ,order_item WHERE orders.order_id = order_item.order_id AND orders.status=? AND user_id =?");
			ps.setString(1, "未审核");
			ps.setString(2, user_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order. setOrder_id(rs.getString(1));
				order.setUser_id(rs.getString(2));
				order.setReceiver(rs.getString(3));
				order.setPhone(rs.getString(4));
				order.setAddress(rs.getString(5));
				order.setNumber(rs.getInt(6));
				order.setMoney(rs.getDouble(7));
				order.setOrder_date(rs.getDate(8));
				order.setStatus(rs.getString(9));
				list.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c3p0utils.release(conn, ps, rs);
		}
		return list;
	}
	
	public Order findorder(String order_id) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = c3p0utils.getConnection();
			ps = conn.prepareStatement("  SELECT  orders.receiver,orders.phone,orders.address,order_item.num,orders.order_id FROM orders ,order_item WHERE orders.order_id = order_item.order_id AND orders.order_id =?");
			ps.setString(1, order_id);
			rs = ps.executeQuery();
		if (rs.next()) {
			Order order = new Order();
				order.setReceiver(rs.getString(1));
				order.setPhone(rs.getString(2));
				order.setAddress(rs.getString(3));
				order.setNumber(rs.getInt(4));
				order.setOrder_id(rs.getString(5));
				return order;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c3p0utils.release(conn, ps, rs);
		}
		return null;
	}
	
	public double findprice(String order_id) {
		Connection conn = null;
		Connection conn1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		String paperid;
		try {
			conn = c3p0utils.getConnection();
			ps = conn.prepareStatement("  SELECT paper_id from order_item where order_id=?  ");
			ps.setString(1, order_id);
			rs = ps.executeQuery();
		if (rs.next()) {
			paperid=rs.getString(1);
			try {
				conn1 = c3p0utils.getConnection();
				ps1 = conn.prepareStatement("  SELECT price from newspaper where paper_id=?  ");
				ps1.setString(1, paperid);
				rs1 = ps1.executeQuery();
				if (rs1.next()) {
					  return price=rs1.getDouble(1);
				}
			}catch (SQLException e) {
					e.printStackTrace();
				} finally {
					c3p0utils.release(conn1, ps1, rs1);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c3p0utils.release(conn, ps, rs);
		}
		return  price;
	}
}
