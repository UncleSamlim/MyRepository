package Homepage;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import LoginInterface.Finally;

public class ExitSucceed extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExitSucceed() {
		super("退出成功");
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		JLabel jla1 = new JLabel("退出成功！");
		JLabel jla2 = new JLabel("欢迎下次使用！");
		JButton jbu = new JButton("确定");
		p1.setLayout(new GridLayout(2, 1));
		p1.add(jla1);
		p1.add(jla2);

		p2.add(p1);
		p2.add(jbu);
		jbu.addActionListener(this);

		this.add(p1);
		this.add(p2);
		this.setLayout(new GridLayout(2, 1));
		this.setLocation(600, 200);
		this.setSize(200, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.dispose();
		new Finally();
	}
}
