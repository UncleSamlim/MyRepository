package team.fourth.papersys.admin.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import team.fourth.papersys.listener.OrderTableListener;
import team.fourth.papersys.pojo.Order;
import team.fourth.papersys.pojo.OrderItem;
import team.fourth.papersys.service.OrderService;
import team.fourth.papersys.service.OrderServiceImpl;
import team.fourth.papersys.util.DateConvertUtil;
import team.fourth.papersys.util.InfoTableModel;

public class OrderListPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private final String[] ordercolumn = {"�������", "�û����", "�ռ���", "��ϵ��ʽ", "��ַ", "�������", "�µ�����", "����״̬"};
	private final String[] orderItemColumn = {"�������", "�������", "��������"};
	private final int SEARCHALL = 0;
	private final int SEARCHBYID = 1;
	private final int SEARCHBYSTATUS = -1;
	
	
	private JPanel northPane;	// �������
	private JPanel centerPane;	//�в����
	private JScrollPane orderPane;
	private JScrollPane orderItemPane;
	private OrderService orderService = new OrderServiceImpl();
	
	public OrderListPanel() {
		northPane = new JPanel();
		centerPane = new JPanel(new GridLayout(2, 1));
		orderPane = new JScrollPane();
		orderItemPane = new JScrollPane();
		init();
	}
	
	public void init() {
		this.setLayout(new BorderLayout());
		initNorthPane();
		initCenterPane();
	}

	private void initCenterPane() {
		// ��ѯ��ˢ���б�
		orderPane.setBorder(BorderFactory.createEtchedBorder());
		searchAndRefreshInfo(null, SEARCHALL);
		centerPane.add(orderPane);
		showOrderItem();
		centerPane.add(orderItemPane);
		this.add(centerPane, BorderLayout.CENTER);
	}

	private void initNorthPane() {
		northPane.setLayout(new BorderLayout());
		JPanel pane = new JPanel();
		JLabel label = new JLabel("�����룺");
		JTextField text = new JTextField(20);
		JButton idSearch = new JButton("��������Ų�ѯ");
		JButton stateSearch = new JButton("������״̬��ѯ");
		JButton listButton = new JButton("��ʾ�����б�");
		stateSearch.addActionListener(event -> searchAndRefreshInfo(text.getText(), SEARCHBYSTATUS));
		idSearch.addActionListener(event -> {
			searchAndRefreshInfo(text.getText(), SEARCHBYID);
		});
		listButton.addActionListener(event -> {
			searchAndRefreshInfo(null, SEARCHALL);
			showOrderItem();
		});
		pane.add(label);
		pane.add(text);
		pane.add(idSearch);
		pane.add(stateSearch);
		pane.add(listButton);
		northPane.add(pane, BorderLayout.CENTER);
		this.add(northPane, BorderLayout.NORTH);
	}
	
	// ��ѯ������Ϣ
	private void searchAndRefreshInfo(String content, int searchWay) {
		List<Order> orderList = new ArrayList<Order>();
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		if (searchWay==SEARCHBYID) {
			orderList = orderService.findOrdersById(content);
			orderItems = orderService.findOrderItemsById(content);
			Vector<Vector<String>> info = transItemsListToTwoDimension(orderItems);
			InfoTableModel tableModel = new InfoTableModel(orderItemColumn, info);
			JTable table = new JTable(tableModel);
			tableModel.setTableStyle(table);
			orderItemPane.setViewportView(table);
		}else if (searchWay==SEARCHBYSTATUS){
			orderList = orderService.findOrdersByStatus(content);
		}else {		// ��ѯ����
			orderList = orderService.findAllOrders();
		}
		Vector<Vector<String>> orderInfo = transListToTwoDimension(orderList);
		InfoTableModel tableModel = new InfoTableModel(ordercolumn, orderInfo);
		JTable table = new JTable(tableModel);
		tableModel.setTableStyle(table);
		table.addMouseListener(new OrderTableListener());
		orderPane.setViewportView(table);
	}
	
	// ��ѯ��������Ϣ
	private void showOrderItem() {
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		orderItemList = orderService.findAllOrderItem();
		Vector<Vector<String>> info = new Vector<Vector<String>>();
		for (OrderItem item : orderItemList) {
			Vector<String>line = new Vector<String>();
			line.add(item.getOrder().getOrderId());
			line.add(item.getPaper().getPaperId());
			line.add(String.valueOf(item.getNum()));
			info.add(line);
		}
		InfoTableModel tableModel = new InfoTableModel(orderItemColumn, info);
		JTable table = new JTable(tableModel);
		tableModel.setTableStyle(table);
		orderItemPane.setViewportView(table);
	}
	
	// �������б�ת��Ϊ��ά���� 
	private Vector<Vector<String>> transListToTwoDimension(List<Order>orderList) {
		Vector<Vector<String>>info = new Vector<Vector<String>>();
		if (orderList==null) {
			return info;
		}
		for (Order order : orderList) {
			Vector<String>line = new Vector<String>();
			line.add(order.getOrderId());
			line.add(order.getUserId());
			line.add(order.getReceiver());
			line.add(order.getPhone());
			line.add(order.getAddress());
			line.add(String.valueOf(order.getMoney()));
			Date orderDate = order.getOrderDate();
			String dateToString = DateConvertUtil.DateToString(orderDate);
			line.add(dateToString);
			line.add(order.getStatus());
			info.add(line);
		}
		return info;
	}
	
	// ���������б�ת��Ϊ��ά���� 
	private Vector<Vector<String>> transItemsListToTwoDimension(List<OrderItem>itemList) {
		Vector<Vector<String>>info = new Vector<Vector<String>>();
		if (itemList==null) {
			return info;
		}
		for (OrderItem item : itemList) {
			Vector<String>line = new Vector<String>();
			line.add(item.getOrder().getOrderId());
			line.add(item.getPaper().getPaperId());
			line.add(String.valueOf(item.getNum()));
			info.add(line);
		}
		return info;
	}
}
