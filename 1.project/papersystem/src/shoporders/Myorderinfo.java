package shoporders;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

import obj.User;
import util.c3p0utils;
public class Myorderinfo {

	private JFrame f = new JFrame("报刊订阅信息填写");
	JPanel pane = new JPanel();
	private static JTextField receiver = new JTextField(); // 收件人
	private static JTextField address = new JTextField(); // 地址
	private static JTextField phone = new JTextField(); // 电话
	private static JTextField num = new JTextField(); // 数量

	private JButton ok = new JButton("结算");
	private JButton qx = new JButton("取消");
	private int storage = 0;
	private double price = 0;
	private User user = null;

	public Myorderinfo(String newspaper_id, User user) {
		f.setSize(700, 600); // 界面大小
		f.setLocation(700, 300); // 界面位置
		f.setLayout(new BorderLayout()); // 边界布局
		initFrame(newspaper_id);

		f.setVisible(true); // 设置为可见
		this.user = user;
	}

	private void initFrame(String newspaper_id) {
		// 顶部
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout()); // 流式布局
		titlePanel.add(new JLabel("请填写您的购物信息"));
		f.add(titlePanel, "North");

		// 中部表单
		JPanel fPanel = new JPanel();
		fPanel.setLayout(null);
		JLabel b1 = new JLabel("姓 名:");
		b1.setBounds(250, 110, 50, 30);
		JLabel b2 = new JLabel("地 址:");
		b2.setBounds(250, 150, 50, 30);
		JLabel b3 = new JLabel("电话:");
		b3.setBounds(250, 190, 50, 30);
		JLabel b4 = new JLabel("数量:");
		b4.setBounds(250, 230, 50, 30);

		fPanel.add(b1);
		fPanel.add(b2);
		fPanel.add(b3);
		fPanel.add(b4);

		receiver.setBounds(300, 110, 160, 30);
		address.setBounds(300, 150, 160, 30);
		phone.setBounds(300, 190, 160, 30);
		num.setBounds(300, 230, 160, 30);

		fPanel.add(receiver);
		fPanel.add(address);
		fPanel.add(phone);
		fPanel.add(num);
		f.add(fPanel, "Center");

		// 底部按钮
		JPanel bPanel = new JPanel();
		bPanel.setLayout(new FlowLayout());
		bPanel.add(ok);
		bPanel.add(qx);
		f.add(bPanel, "South");

		storage = Findbookinfo.FindbookStorage(newspaper_id);
		price = Findbookinfo.Findbookprice(newspaper_id);

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mz = receiver.getText();
				String dz = address.getText();
				String hm = phone.getText();
				String userid = user.getUser_id();
				int sl = Integer.parseInt(num.getText());
				Connection conn = null;
				ResultSet rs = null;
				PreparedStatement ps = null;
				
				BigDecimal bd = new BigDecimal(sl * price);
				bd = bd.setScale(2, RoundingMode.HALF_UP);
				double money = bd.doubleValue();
				if (sl > storage) {
					new Failed();
				} else {
					try {
						conn = c3p0utils.getConnection();
						ps = conn
								.prepareStatement("insert into orders(order_id,user_id,address,phone,receiver,money) values (?,?,?,?,?,?)");
						//conn.setAutoCommit(false);
						String orderId = String.valueOf(System
								.currentTimeMillis());
						ps.setString(1, orderId);
						ps.setString(2, userid);
						ps.setString(3, dz);
						ps.setString(4, hm);
						ps.setString(5, mz);
						ps.setDouble(6, money);
						int res = ps.executeUpdate();
						System.out.println(res);
						if (res > 0) {
							String sql2 = "insert into order_item(order_id,paper_id,num) values (?,?,?) ";
							PreparedStatement ps2 = conn.prepareStatement(sql2);
							ps2.setString(1, orderId);
							ps2.setString(2, newspaper_id);
							ps2.setInt(3, sl);

							 int res1= ps2.executeUpdate();
							 System.out.println(res1);
							 System.out.println("doing");
							ps2.close();
						/*	if (res1 > 0) {
								finstoragenum = storage - sl;
								String sql = "update newspaper set storage_num=? where paper_id=?";
								PreparedStatement ps3 = conn
										.prepareStatement(sql);
								ps3.setInt(1, finstoragenum);
								ps3.setString(2, newspaper_id);
								ps3.executeUpdate();
								ps3.close();
								conn.commit();
							}*/
						}
					} catch (SQLException a) {
						a.printStackTrace();
						try {
							conn.rollback();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} finally {
						c3p0utils.release(conn, ps, rs);
					}

					JOptionPane.showMessageDialog(f, money);
					new Succeed();
					f.dispose();
				}
			}
		});

		qx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 f.dispose();
			}
		});
	}

}