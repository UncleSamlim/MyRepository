package team.fourth.papersys.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import team.fourth.papersys.dao.OrderDao;
import team.fourth.papersys.dao.OrderDaoImpl;
import team.fourth.papersys.pojo.Order;
import team.fourth.papersys.pojo.OrderItem;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao = new OrderDaoImpl();
	
	@Override
	public List<Order> findOrdersById(String id) {
		if (StringUtils.isEmpty(id)) {
			return null;
		}
		return orderDao.fuzzySelectOrdersById(id);
	}

	@Override
	public List<Order> findOrdersByStatus(String status) {
		if (StringUtils.isEmpty(status)) {
			return null;
		}
		return orderDao.selectOrdersByStatus(status);
	}

	@Override
	public List<Order> findAllOrders() {
		return orderDao.selectAllOrders();
	}

	@Override
	public int removeOrderById(String[] ids) {
		return orderDao.deleteOrderById(ids);
	}

	@Override
	public int modifyOrderStatus(String[] ids, String status) {
		return orderDao.updateOrderStatus(ids, status);
	}

	@Override
	public Order findOrderById(String orderId) {
		return orderDao.selectOrderById(orderId);
	}

	@Override
	public int modifyOrder(String orderId, String receiver, String phone, String address) {
		return orderDao.updateOrder(orderId, receiver, phone, address);
	}

	@Override
	public List<OrderItem> findAllOrderItem() {
		return orderDao.selectAllOrderItem();
	}

	@Override
	public List<OrderItem> findOrderItemsById(String orderId) {
		return orderDao.selcetOrderItemsById(orderId);
	}
	
}
