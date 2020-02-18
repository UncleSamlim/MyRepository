package Homepage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UpdateSucceed extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UpdateSucceed() {
		super("用户信息修改");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JLabel jla1 = new JLabel("用户信息修改成功！");
		JButton j = new JButton("确认");

		j.addActionListener(this);

		p1.add(jla1);
		p2.add(j);
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
	}
}
