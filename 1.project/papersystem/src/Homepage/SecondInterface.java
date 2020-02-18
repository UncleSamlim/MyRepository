package Homepage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import obj.User;
import util.c3p0utils;

public class SecondInterface extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pan1 = null, pan2 = null, pane = null;
	private JLabel name = null, password = null, email = null,
			phonenumber = null, job = null, age = null, gender = null;
	private JTextField jf1 = null, jf3 = null, jf4 = null, jf5 = null,
			jf6 = null, jf7 = null, jf8 = null;
	private JButton jbu = new JButton();
	private String name1, password2, phone1, gender1, age1, job1, email1, id1;
	private char[] password1;
	private JPasswordField text;

	public SecondInterface(User user) {

		pane = new JPanel();
		pan1 = new JPanel();
		pan2 = new JPanel();
		name = new JLabel("用户名");
		password = new JLabel("密码");
		phonenumber = new JLabel("手机号");
		gender = new JLabel("性别");
		age = new JLabel("年龄");
		job = new JLabel("工作");
		email = new JLabel("邮箱");

		jbu = new JButton("确定更改");

		jf1 = new JTextField(user.getUserName(), 20);
		text = new JPasswordField(user.getPassword(), 20);
		text.setEchoChar('*');
		jf3 = new JTextField(user.getPhone(), 20);
		jf4 = new JTextField(user.getGender(), 20);
		jf5 = new JTextField(String.valueOf((user.getAge())), 20);
		jf6 = new JTextField(user.getJob(), 20);
		jf7 = new JTextField(user.getEmail(), 20);
		jf8 = new JTextField(user.getUser_id(), 20);

		pan1.add(name);
		pan1.add(jf1);
		pan1.add(password);
		pan1.add(text);
		pan1.add(phonenumber);
		pan1.add(jf3);
		pan1.add(gender);
		pan1.add(jf4);
		pan1.add(age);
		pan1.add(jf5);
		pan1.add(job);
		pan1.add(jf6);
		pan1.add(email);
		pan1.add(jf7);
		pan1.setLayout(new GridLayout(7, 1));
		pan2.add(jbu);
		pane.add(pan1);
		pane.add(pan2);
		pane.setLayout(new GridLayout(2, 1));

		jbu.addActionListener(this);

		this.add(pane);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		name1 = jf1.getText();
		password1 = text.getPassword();
		password2 = String.valueOf(password1);
		phone1 = jf3.getText();
		gender1 = jf4.getText();
		age1 = jf5.getText();
		job1 = jf6.getText();
		email1 = jf7.getText();
		id1 = jf8.getText();
		Connection conn = null;
		ResultSet rs = null;
		int res = 0;
		PreparedStatement ps = null;
		try {
			conn = c3p0utils.getConnection();
			ps = conn
					.prepareStatement("update user set username=?, password=?, phone=?, gender=?, age=?,job=?, email=? where user_id =?");
			ps.setString(1, name1);
			ps.setString(2, password2);
			ps.setString(3, phone1);
			ps.setString(4, gender1);
			ps.setString(5, age1);
			ps.setString(6, job1);
			ps.setString(7, email1);
			ps.setString(8, id1);
			res = ps.executeUpdate();
		} catch (SQLException a) {
			a.printStackTrace();
		} finally {
			c3p0utils.release(conn, ps, rs);
		}
		System.out.println(res);
		new UpdateSucceed();
	}

}
