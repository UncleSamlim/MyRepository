package LoginInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import obj.User;
import util.c3p0utils;
import Homepage.Frist;

public class UserLogin extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pan1 = null, pan2 = null, pan3 = null, pane = null;
	private JLabel name = null, password = null, bt = null;
	private JTextField jf1 = null;
	private String nameorphone, password2 = null;
	private char[] password1 = null;
	private JPasswordField text = null;

	// private User user=null;
	public UserLogin() {

		pane = new JPanel();
		pan1 = new JPanel();
		pan2 = new JPanel();
		pan3 = new JPanel();
		bt = new JLabel("用户登陆");
		name = new JLabel("名字");
		password = new JLabel("密码");

		jf1 = new JTextField("", 20);
		text = new JPasswordField();
		text.setEchoChar('*');

		Font f = new Font("楷体", Font.PLAIN, 16);
		bt.setFont(f);
		bt.setForeground(Color.red);

		// Container con = this.getContentPane();// 容器
		pan1.add(bt);
		pane.add(pan1);
		pan2.add(name);
		pan2.add(jf1);
		pan2.add(password);
		pan2.add(text);
		pan2.setLayout(new GridLayout(2, 1));
		pane.add(pan2);
		// con.add(pan1);

		JButton jbt1 = new JButton("登陆");
		pan3.add(jbt1);
		pane.add(pan3);
		// con.add(pan2);
		pane.setLayout(new GridLayout(3, 1));
		// con.setLayout(new GridLayout(2, 1));

		jbt1.addActionListener(this);

		this.add(pane);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		nameorphone = jf1.getText();
		password1 = text.getPassword();
		password2 = String.valueOf(password1);
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = c3p0utils.getConnection();
			ps = conn
					.prepareStatement("select * from user where username=? and password=?");
			ps.setString(1, nameorphone);
			ps.setString(2, password2);
			rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUser_id(rs.getString(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setGender(rs.getString(5));
				user.setAge(rs.getInt(6));
				user.setJob(rs.getString(7));
				user.setEmail(rs.getString(8));
				/*Frame frame = JOptionPane.getFrameForComponent(this);
				frame.dispose();*/
				new UserLoginSucceed(user);
				new Frist(user);
			}else {
				JOptionPane.showMessageDialog(this,"用户名或密码错误，请重试！");
			}
		} catch (SQLException a) {
			a.printStackTrace();
		} finally {
			c3p0utils.release(conn, ps, rs);
		}
	}
}