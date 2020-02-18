package Homepage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import obj.Order;
import util.PackData;
import util.c3p0utils;

public class Modify implements ActionListener {
	private JFrame f;
	private JPanel p, pane, panel;
	private JLabel receiver, phone, address, number;
	private JTextField jte1, jte2, jte3, jte4, jte5;
	private JButton jbu1, jbu2;
	private String receiver1, phone1, address1, number1, order_id1;
	private double price;
	private int num;
	private PackData pd;

	public Modify(String Order_id, Order order) {
		f = new JFrame("修改订单");
		pane = new JPanel();
		p = new JPanel();
		panel = new JPanel();
		receiver = new JLabel("收件人");
		phone = new JLabel("手机号码");
		address = new JLabel("地址");
		number = new JLabel("数量");
		jte1 = new JTextField(order.getReceiver(), 20);
		jte2 = new JTextField(order.getPhone(), 20);
		jte3 = new JTextField(order.getAddress(), 20);
		jte4 = new JTextField(String.valueOf((order.getNumber())), 20);
		jte5 = new JTextField(order.getOrder_id(), 20);
		jbu1 = new JButton("确认修改");
		jbu2 = new JButton("取消");

		pd = new PackData();

		pane.add(receiver);
		pane.add(jte1);
		pane.add(phone);
		pane.add(jte2);
		pane.add(address);
		pane.add(jte3);
		pane.add(number);
		pane.add(jte4);
		pane.setLayout(new GridLayout(4, 1));
		p.add(jbu1);
		p.add(jbu2);
		panel.add(pane);
		panel.add(p);
		panel.setLayout(new GridLayout(2, 1));

		jbu1.addActionListener(this);
		jbu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});

		f.add(panel);
		f.setSize(700, 600); // 界面大小
		f.setLocation(500, 300); // 界面位置
		f.setLayout(new GridLayout(2, 1)); // 边界布局
		f.setVisible(true); // 设置为可见

	}

	public void actionPerformed(ActionEvent e) {
		receiver1 = jte1.getText();
		phone1 = jte2.getText();
		address1 = jte3.getText();
		number1 = jte4.getText();
		order_id1 = jte5.getText();
		price = pd.findprice(order_id1);
		num = Integer.parseInt(number1);
		BigDecimal bd = new BigDecimal(num * price);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		double money = bd.doubleValue();
		int res;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {
			conn = c3p0utils.getConnection();
			ps = conn
					.prepareStatement(" UPDATE orders,order_item SET orders.receiver=?,orders.phone=?,orders.address=?,order_item.num=? WHERE orders.order_id = order_item.order_id AND orders.order_id = ?");
			ps.setString(1, receiver1);
			ps.setString(2, phone1);
			ps.setString(3, address1);
			ps.setString(4, number1);
			ps.setString(5, order_id1);
			res = ps.executeUpdate();
			if (res > 0) {
				String sql = "update orders set money=? where order_id = ?  ";
				PreparedStatement ps1 = conn.prepareStatement(sql);
				ps1.setDouble(1, money);
				ps1.setString(2,order_id1);
				ps1.executeUpdate();
				ps1.close();
		//	conn.commit();
			}
		} catch (SQLException a) {
			a.printStackTrace();
		} finally {
			c3p0utils.release(conn, ps, rs);
		}
		JOptionPane.showMessageDialog(null, "修改成功！");

	}

}
