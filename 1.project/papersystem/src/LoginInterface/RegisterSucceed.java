package LoginInterface;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RegisterSucceed extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegisterSucceed() {
		super("Success");
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JLabel jla = new JLabel("注册成功");
		JLabel jlab = new JLabel("请按确认进行退出再重新登陆");
		JButton jbu = new JButton("确定");
		p.add(jla);
		p1.add(jlab);
		p1.add(jbu);
		this.add(p);
		this.add(p1);
		this.setLayout(new GridLayout(2, 1));
		this.setLocation(600, 200);
		this.setSize(200, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jbu.addActionListener(this);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
	}

}
