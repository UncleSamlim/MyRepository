package team.fourth.papersys.admin.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import team.fourth.papersys.util.JFrameUtil;

public class OrderManagerPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JPanel southPane;
	private JPanel centerPane;
	private ModifyOrderPanel modifyOrderPane;
	private OrderListPanel orderListPane;
	private CardLayout cardLayout;
	
	
	public OrderManagerPanel() {
		southPane = new JPanel();
		centerPane = new JPanel();
		modifyOrderPane = new ModifyOrderPanel();
		orderListPane = new OrderListPanel();
		cardLayout = new CardLayout();
		this.setLayout(new BorderLayout());
		init();
	}
	
	public void init() {
		initCenterPane();
		initSouthPane();
	}
	
	public void initCenterPane() {
		centerPane.setLayout(cardLayout);
		centerPane.add(orderListPane, "orderList");
		centerPane.add(modifyOrderPane, "modifyOrder");
		orderListPane.setBackground(Color.BLUE);
		this.add(centerPane, BorderLayout.CENTER);
	}
	
	public void initSouthPane() {
		southPane.setLayout(new BorderLayout());
		JButton modifyButton = new JButton("修改订单");
		JButton listButton = new JButton("订单列表");
		JPanel panel = new JPanel();
		panel.add(listButton);
		panel.add(modifyButton);
		southPane.add(panel, BorderLayout.CENTER);
		listButton.addActionListener(event -> cardLayout.show(centerPane, "orderList"));
		modifyButton.addActionListener(event -> cardLayout.show(centerPane, "modifyOrder"));
		this.add(southPane, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new OrderManagerPanel());
		JFrameUtil.init(frame, 600, 600, JFrame.EXIT_ON_CLOSE);
	}
}
