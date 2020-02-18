package cn.yueqian.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yueqian.com.dao.IOrderDao;
import cn.yueqian.com.dao.entity.Order;
import cn.yueqian.com.dao.utils.JdbcUtil;

/**   
*    
* 项目名称：second_program   
* 类名称：OrderDaoImpl   
* 类描述：   订单操作方法实现
* 创建人：Sam  
* 创建时间：2019年12月10日 下午4:56:18   
* @version        
*/
public class OrderDaoImpl implements IOrderDao{
	
	/* 用户添加订单 */
	@Override
	public int addOrders(Order order) {
		// INSERT INTO emp VALUES
		// (3453,'lily','manager','7839','1987-09-08',7655,87,20)
		String sql = "INSERT INTO order_list(user_id,goods_id,destination,status,paymoney,payway,date,goods_number) VALUES (?,?,?,?,?,?,?,?) ";

		Object[] params = {order.getUserId(),order.getGoodsId(),order.getOrderDestination(), order.getOrderStatus(),
				order.getOrderPayMoney(), order.getOrderPayWay(), order.getOrderDate(),order.getGoodsNumber() };
		int rows = JdbcUtil.executeUpdate(sql, params);
		return rows;
	}
	
	/* 用户更新订单 */
	@Override
	public int updateOrders(Order order) {
					String sql = "UPDATE order_list SET user_id=?,destination=?,"
							+ "status=?,paymoney=? ,payway=?,goods_number=?  WHERE id=? ";
					Object[] params = {order.getUserId(),order.getOrderDestination(),order.getOrderStatus(),
							order.getOrderPayMoney(),order.getOrderPayWay(),order.getGoodsNumber(),order.getOrderId()};
					int rows = JdbcUtil.executeUpdate(sql, params);
					return rows;
				
	}

	/* 用户删除订单 */
	@Override
	public int deleteOrders(int orderId) {
		String sql = "DELETE FROM order_list  WHERE id = ? ";
		Object[] params = { orderId };
		int row = JdbcUtil.executeUpdate(sql, params);
		return row;
	}

	/* 管理员查看订单 */
	@Override
	public List<Order> ListAllOrdersToAdmin() {
		// SELECT * FROM emp WHERE empno IN ( SELECT DISTINCT mgr FROM emp WHERE
				// mgr IS NOT NULL)
				List<Order> orders = new ArrayList<Order>();
				PreparedStatement ps = null;
				ResultSet rs = null;
				Connection conn = JdbcUtil.getConnection();
				// SELECT COUNT(1) FROM emp
				String sql = " SELECT * FROM order_list";
				try {
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					while (rs.next()) {
						Order order = new Order();
						order.setOrderId(rs.getInt("id"));
						order.setUserId(rs.getInt("user_id"));
						order.setOrderDestination(rs.getString("destination"));
						order.setOrderStatus(rs.getString("status"));
						order.setOrderPayMoney(rs.getDouble("paymoney"));
						order.setOrderPayWay(rs.getString("payway"));
						order.setOrderDate(rs.getDate("date"));
						order.setGoodsNumber(rs.getInt("goods_number"));
						order.setGoodsId(rs.getInt("goods_id"));
						
						orders.add(order);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JdbcUtil.closeAll(rs, ps, conn);
				}
		return orders;
	}

	/* 用户查看订单 */
	@Override
	public List<Order> ListAllOrdersToUser(int orderId) {
		List<Order> orders = new ArrayList<Order>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = JdbcUtil.getConnection();
		// SELECT COUNT(1) FROM emp
		String sql = " SELECT * FROM order_list where user_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, orderId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOrderId(rs.getInt("id"));
				order.setUserId(rs.getInt("user_id"));
				order.setOrderDestination(rs.getString("destination"));
				order.setOrderStatus(rs.getString("status"));
				order.setOrderPayMoney(rs.getDouble("paymoney"));
				order.setOrderPayWay(rs.getString("payway"));
				order.setOrderDate(rs.getDate("date"));
				order.setGoodsNumber(rs.getInt("goods_number"));
				order.setGoodsId(rs.getInt("goods_id"));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, ps, conn);
		}
return orders;
	}

	/*分页获取信息总数*/
	@Override
	public int getCount() {
		int count = 1;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection connection = JdbcUtil.getConnection();
		String sql = "Select Count(*) as numbers from order_list";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt("numbers");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcUtil.closeAll(rs, ps, connection);
		return count;
	}

	@Override
	public List<Order> onePageInfo(int currentPage, int pagesize) {
		List<Order> orders = new ArrayList<Order>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = JdbcUtil.getConnection();
		String sql = "Select * from order_list limit ?,?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, (currentPage-1)*pagesize);
			ps.setObject(2, pagesize);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOrderId(rs.getInt("id"));
				order.setUserId(rs.getInt("user_id"));
				order.setOrderDestination(rs.getString("destination"));
				order.setOrderStatus(rs.getString("status"));
				order.setOrderPayMoney(rs.getDouble("paymoney"));
				order.setOrderPayWay(rs.getString("payway"));
				order.setOrderDate(rs.getDate("date"));
				order.setGoodsNumber(rs.getInt("goods_number"));
				order.setGoodsId(rs.getInt("goods_id"));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcUtil.closeAll(rs, ps, conn);
		return orders;
		
	}

	@Override
	public Order getOrderById(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Order order = new Order();
		Connection conn = JdbcUtil.getConnection();
		// SELECT COUNT(1) FROM emp
		String sql = " SELECT * FROM order_list where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				order.setOrderId(rs.getInt("id"));
				order.setUserId(rs.getInt("user_id"));
				order.setOrderDestination(rs.getString("destination"));
				order.setOrderStatus(rs.getString("status"));
				order.setOrderPayMoney(rs.getDouble("paymoney"));
				order.setOrderPayWay(rs.getString("payway"));
				order.setOrderDate(rs.getDate("date"));
				order.setGoodsNumber(rs.getInt("goods_number"));
				order.setGoodsId(rs.getInt("goods_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, ps, conn);
		}
return order;
	}
	
}
