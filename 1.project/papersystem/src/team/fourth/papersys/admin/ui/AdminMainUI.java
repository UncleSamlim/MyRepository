package team.fourth.papersys.admin.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import team.fourth.papersys.pojo.Admin;
import team.fourth.papersys.util.JFrameUtil;

public class AdminMainUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Admin admin;
	
	public AdminMainUI() {}
	
	public AdminMainUI(Admin admin) {
		this.admin = admin;
		init();
	}
	
	private void init(){
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setTitle("������̨����ϵͳ");
		Container container = this.getContentPane();
		JPanel head = createHead();
		JPanel foot = createFoot();
		JPanel userManager = new UserManagerPanel(15, 1);
		JPanel paperManager = new PaperManagerPanel(10, 1);
		JPanel OrderManager = new OrderManagerPanel();
		JPanel countManager = new CountManager();
		JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		jTabbedPane.addTab("�û���Ϣ����", userManager);
		jTabbedPane.addTab("������Ϣ����", paperManager);
		jTabbedPane.addTab("������Ϣ����", OrderManager);
		if ("��������Ա".equals(admin.getRole())) {
			JPanel adminManager = new AdminManagerPanel();
			jTabbedPane.addTab("����Ա��Ϣ����", adminManager);
		}
		jTabbedPane.addTab("ͳ�Ʊ���", countManager);
		container.add(head,BorderLayout.NORTH);
		container.add(foot,BorderLayout.SOUTH);
		container.add(jTabbedPane, BorderLayout.CENTER);
		JFrameUtil.init(this, 1000, 600, JFrame.EXIT_ON_CLOSE);
	}
	
	private JPanel createHead() {
		JPanel firstPane = new JPanel();
		JPanel secondPane = new JPanel();
		firstPane.setLayout(new BorderLayout());
		JLabel label = new JLabel("�������ĺ�̨����ϵͳ");
		JButton exitButton = new JButton("�˳�");
		Font font = new Font("����",Font.ITALIC,16);
		label.setFont(font);
		secondPane.add(label, BorderLayout.CENTER);
		firstPane.add(secondPane, BorderLayout.CENTER);
		firstPane.add(exitButton, BorderLayout.EAST);
		exitButton.addActionListener(event -> this.dispose());
		return firstPane;
	}
	
	private JPanel createFoot() {
		JPanel jPanel = new JPanel();
		JLabel label = new JLabel("��ϵͳ�ɼ����167-A131-��λ�������������");
		Font font = new Font("����", Font.ITALIC, 16);
		label.setFont(font);
		jPanel.add(label);
		return jPanel;
	}
}
