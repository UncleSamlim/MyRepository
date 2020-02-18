package Homepage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import obj.User;

public class Frist extends JFrame {

	private static final long serialVersionUID = 1L;

	public Frist(User user) {
		super("报刊订阅管理系统");
		// 对象实例化
		JTabbedPane tab = new JTabbedPane(JTabbedPane.LEFT);
		// 容器
		Container container = this.getLayeredPane();
		// 对象化面板

		tab.add(new FristInterfaceOne(user), "主页");
		tab.add(new SecondInterface(user), "更改用户信息");
		tab.add(new ThirdInterface(user), "更改订单信息"); 
		tab.add(new FourthInterface( user), "注销用户信息");
		
		container.setLayout(new BorderLayout());
		container.add(tab, BorderLayout.CENTER);
		this.setBounds(250, 100, 800, 500);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				/*s*/
			}
		});

		this.setVisible(true);
	}

}
