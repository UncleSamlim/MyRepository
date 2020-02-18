package LoginInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import util.RandomIdFactory;
import util.c3p0utils;

public class Register extends JPanel implements ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pan1 = null, pan2 = null, pane = null, pan3 = null,
			pan4 = null, pan5 = null;
	private JLabel name = null, password = null, email = null, phone = null,
			age = null, job = null, gender = null, bq = null;
	private JTextField jf1 = null, jf2 = null, jf4 = null, jf5 = null,
			jf6 = null;
	private JButton jbu = null;
	private String name1, password2, phone1, gender1, age1, job1, email1;
	private char[] password1;
	private JPasswordField text = null;

	public Register() {

		pane = new JPanel();
		pan1 = new JPanel();
		pan2 = new JPanel();
		pan3 = new JPanel();
		pan4 = new JPanel();
		pan5 = new JPanel();
		bq = new JLabel("用户注册");
		name = new JLabel("用户名");
		password = new JLabel("密码");
		phone = new JLabel("手机号");
		gender = new JLabel("性别");
		age = new JLabel("年龄");
		job = new JLabel("工作");
		email = new JLabel("邮箱");
		jbu = new JButton("注册");

		Font f = new Font("楷体", Font.PLAIN, 16);
		bq.setFont(f);
		bq.setForeground(Color.red);

		jf1 = new JTextField("", 20);
		jf2 = new JTextField("", 20);
		// jf3 = new JTextField("", 20);
		text = new JPasswordField();
		text.setEchoChar('*');

		jf4 = new JTextField("", 20);
		jf5 = new JTextField("", 20);
		jf6 = new JTextField("", 20);
		JRadioButton jb1 = new JRadioButton("男");
		JRadioButton jb2 = new JRadioButton("女");

		ButtonGroup bg = new ButtonGroup();
		bg.add(jb1);
		bg.add(jb2);

		pan4.add(bq);
		pane.add(pan4);

		pan1.add(name);
		pan1.add(jf1);
		pan1.add(password);
		pan1.add(text);
		pan1.add(phone);
		pan1.add(jf2);
		pane.add(pan1);
		pan1.setLayout(new GridLayout(3, 1));
		// pan1.add(gender);

		pan2.add(gender);
		pan2.add(jb1);
		pan2.add(jb2);
		pane.add(pan2);

		pan3.add(age);
		pan3.add(jf4);
		pan3.add(job);
		pan3.add(jf5);
		pan3.add(email);
		pan3.add(jf6);
		pan3.setLayout(new GridLayout(3, 1));
		// pan2.add(jbu);
		pane.add(pan3);

		pan5.add(jbu);
		pane.add(pan5);

		// pane.add(pan2);
		// con.add(pan);
		pane.setLayout(new GridLayout(5, 1));

		jb1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getSource() == jb1) {
					gender1 = "男";
				} else if (e.getSource() == jb2) {
					gender1 = "女";
				}
			}
		});

		jbu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name1 = jf1.getText();
				password1 = text.getPassword();
				password2 = String.valueOf(password1);
				phone1 = jf2.getText();
				age1 = jf4.getText();
				job1 = jf5.getText();
				email1 = jf6.getText();
				Connection conn = null;
				ResultSet rs = null;
				int res = 0;
				PreparedStatement ps = null;
				try {
					conn = c3p0utils.getConnection();
					ps = conn
							.prepareStatement("insert into user values(?,?,?,?,?,?,?,?)");
					ps.setString(1, RandomIdFactory.getRandomId());
					ps.setString(2, name1);
					ps.setString(3, password2);
					ps.setString(4, phone1);
					ps.setString(5, gender1);
					ps.setString(6, age1);
					ps.setString(7, job1);
					ps.setString(8, email1);
					res = ps.executeUpdate();
				} catch (SQLException a) {
					a.printStackTrace();
				} finally {
					c3p0utils.release(conn, ps, rs);
				}
				System.out.println(res);
				new RegisterSucceed();
			}

		});
		this.add(pane);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

	}
}