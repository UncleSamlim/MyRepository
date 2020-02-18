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
import team.fourth.papersys.admin.ui.AdminMainUI;
import team.fourth.papersys.pojo.Admin;
import util.c3p0utils;

public class AdminLogin extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel pan1 = null, pan2 = null,pan3=null, pane = null;
	private JLabel nameLabel = null, passwordLabel = null,bt=null;
	private JTextField jf1 = null;
	private JPasswordField jf2 = null;

	public AdminLogin() {
		pane = new JPanel();
		pan1 = new JPanel();
		pan2 = new JPanel();
		pan3 = new JPanel();
		bt = new JLabel("管理员登陆");
		nameLabel = new JLabel("姓名");
		passwordLabel = new JLabel("密码");
		// Container con = this.getContentPane();// 容器

		Font f = new Font("楷体", Font.PLAIN, 16);
		bt.setFont(f);
		bt.setForeground(Color.red);
		
		jf1 = new JTextField("", 20);
		jf2 = new JPasswordField(20);
		pan1.add(bt);
		pane.add(pan1);
		pan2.add(nameLabel);
		pan2.add(jf1);
		pan2.add(passwordLabel);
		pan2.add(jf2);
		pan2.setLayout(new GridLayout(2, 1));
		// con.add(pan1);
		pane.add(pan2);
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
	public void actionPerformed(ActionEvent e) {
		String name = jf1.getText();
		String password = String.valueOf(jf2.getPassword());
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = c3p0utils.getConnection();
		String sql = "select * from admin where admin_name=? and password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			Admin admin = null;
			if (rs.next()) {
				admin =  new Admin();
				admin.setAdminId(rs.getString(1));
				admin.setAdminName(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setRole(rs.getString(4));
				admin.setPhone(rs.getString(5));
			}
			if (admin!=null) {
				new AdminMainUI(admin);
				JOptionPane.getFrameForComponent(this);
			}else {
				JOptionPane.showMessageDialog(this,"用户名或密码错误，请重试！");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}