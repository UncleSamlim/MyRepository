package LoginInterface;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import obj.User;

public class UserLoginSucceed extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserLoginSucceed(User user) {
		super("登陆成功");
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JLabel jla = new JLabel("登陆成功");
		JButton jbu = new JButton("确定");
		p.add(jla);
		p1.add(jbu);
		this.add(p);
		this.add(p1);
		this.setLayout(new GridLayout(2, 1));
		this.setLocation(600, 200);
		this.setSize(200, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jbu.addActionListener(this);// 进入界面跳转
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		// new Frist( );
	}
}