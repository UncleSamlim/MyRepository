package LoginInterface;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Finally extends JFrame {
	private static final long serialVersionUID = 1L;

	public Finally() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		JFrame f = new JFrame("报刊订阅管理系统");
		JPanel pane = new JPanel();
		JPanel pan1 = new JPanel();
		JButton register = new JButton("用户注册");
		JButton login = new JButton("用户登陆");
		JButton Administratorlogin = new JButton("管理员登陆");
		CardLayout card = new CardLayout(5, 5);

		pan1.add(register);
		pan1.add(login);
		pan1.add(Administratorlogin);
		pane.setLayout(card);
		pane.add(new Register(), "zc");
		pane.add(new UserLogin(), "glydl");
		pane.add(new AdminLogin(), "dl");

		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(pane, "zc");
			}
		});
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(pane, "glydl");
			}
		});
		Administratorlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(pane, "dl");
			}
		});

		f.getContentPane().add(pane);
		f.getContentPane().add(pan1, BorderLayout.SOUTH);
		f.setLocation(250, 100);
		f.setSize(800, 500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public static void main(String[] args) throws Exception{
		new Finally();
	}
}
