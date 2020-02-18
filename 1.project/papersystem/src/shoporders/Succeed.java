package shoporders;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Succeed extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Succeed() {
		super("金额结算");
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JLabel jla = new JLabel("结算成功");
		JLabel jlab = new JLabel("按确认进行退出");
		JButton jbu = new JButton("确认");
		p.add(jla);
		p1.add(jlab);
		p1.add(jbu);
		this.add(p);
		this.add(p1);
		this.setLayout(new GridLayout(2, 1));
		this.setLocation(600, 200);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jbu.addActionListener(this);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
	}

}
