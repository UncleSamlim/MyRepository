package team.fourth.papersys.service;

import java.util.List;
import team.fourth.papersys.pojo.Order;
import team.fourth.papersys.pojo.OrderItem;

public interface OrderService {

	List<Order> findOrdersById(String id);

	List<Order> findOrdersByStatus(String status);

	List<Order> findAllOrders();

	int removeOrderById(String[] ids);

	int modifyOrderStatus(String[] ids, String status);

	Order findOrderById(String orderId);

	int modifyOrder(String orderId, String receiver, String phone, String address);

	List<OrderItem> findAllOrderItem();

	List<OrderItem> findOrderItemsById(String orderId);
	
}
