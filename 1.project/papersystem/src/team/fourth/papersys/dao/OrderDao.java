package team.fourth.papersys.dao;

import java.util.List;

import team.fourth.papersys.pojo.Order;
import team.fourth.papersys.pojo.OrderItem;

public interface OrderDao {
	/**
	 * ��ѯ���Զ���
	 * @return
	 */
	List<Order> selectAllOrders();
	/**
	 * ���ݶ���״̬��ѯ����
	 * @param status
	 * @return
	 */
	List<Order> selectOrdersByStatus(String status);
	/**
	 * ���ݶ������ģ����ѯ����
	 * @param id
	 * @return
	 */
	List<Order> fuzzySelectOrdersById(String id);
	/**
	 * ���ݶ��������ɾ������
	 * @param ids
	 * @return
	 */
	int deleteOrderById(String[] ids);
	/**
	 * ���ݶ�������޸Ķ���״̬
	 * @param ids
	 * @return
	 */
	int updateOrderStatus(String[] ids, String status);
	/**
	 * ��ѯ��������
	 * @param orderId
	 * @return
	 */
	Order selectOrderById(String orderId);
	/**
	 * �޸Ķ�����Ϣ
	 * @param orderId
	 * @param receiver
	 * @param phone
	 * @param address
	 * @return
	 */
	int updateOrder(String orderId, String receiver, String phone, String address);
	/**
	 * ��ѯ���Զ�����
	 * @return
	 */
	List<OrderItem> selectAllOrderItem();
	/**
	 * ģ����ѯ������
	 * @param orderId
	 * @return
	 */
	List<OrderItem> selcetOrderItemsById(String orderId);

}
