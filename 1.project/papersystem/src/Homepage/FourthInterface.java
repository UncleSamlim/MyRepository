package Homepage;

import java.awt.Frame;
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

import obj.User;
import util.c3p0utils;

public class FourthInterface extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel p0 = null, p1 = null;
	private JButton jbu = null;
	private JLabel jla = null;
	private String userid;

	public FourthInterface(User user) {

		userid = user.getUser_id();

		p0 = new JPanel();
		p1 = new JPanel();
		jla = new JLabel("确定要注销用户信息并退出登陆吗？");
		jbu = new JButton("确定");
		p0.add(jla);
		p1.add(jbu);

		this.add(p0);
		this.add(p1);
		this.setLayout(new GridLayout(2, 1));
		jbu.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		int res = 0;
		try {
			conn = c3p0utils.getConnection();
			ps = conn.prepareStatement("delete from user where user_id =?");
			ps.setString(1, userid);
			res = ps.executeUpdate();
		} catch (SQLException a) {
			a.printStackTrace();
		} finally {
			c3p0utils.release(conn, ps, rs);
		}
		System.out.println(res);
		Frame f = JOptionPane.getFrameForComponent(this);
		f.dispose();
		new ExitSucceed();
	}
}
