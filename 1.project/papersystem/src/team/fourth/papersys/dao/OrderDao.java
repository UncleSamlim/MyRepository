package team.fourth.papersys.dao;

import java.util.List;

import team.fourth.papersys.pojo.Order;
import team.fourth.papersys.pojo.OrderItem;

public interface OrderDao {
	/**
	 * 查询所以订单
	 * @return
	 */
	List<Order> selectAllOrders();
	/**
	 * 根据订单状态查询订单
	 * @param status
	 * @return
	 */
	List<Order> selectOrdersByStatus(String status);
	/**
	 * 根据订单编号模糊查询订单
	 * @param id
	 * @return
	 */
	List<Order> fuzzySelectOrdersById(String id);
	/**
	 * 根据订单编号来删除订单
	 * @param ids
	 * @return
	 */
	int deleteOrderById(String[] ids);
	/**
	 * 根据订单编号修改订单状态
	 * @param ids
	 * @return
	 */
	int updateOrderStatus(String[] ids, String status);
	/**
	 * 查询单个订单
	 * @param orderId
	 * @return
	 */
	Order selectOrderById(String orderId);
	/**
	 * 修改订单信息
	 * @param orderId
	 * @param receiver
	 * @param phone
	 * @param address
	 * @return
	 */
	int updateOrder(String orderId, String receiver, String phone, String address);
	/**
	 * 查询所以订单项
	 * @return
	 */
	List<OrderItem> selectAllOrderItem();
	/**
	 * 模糊查询订单项
	 * @param orderId
	 * @return
	 */
	List<OrderItem> selcetOrderItemsById(String orderId);

}
