package team.fourth.papersys.admin.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import team.fourth.papersys.listener.UserTableListener;
import team.fourth.papersys.operation.AbstractInfoOperation;
import team.fourth.papersys.operation.UserInfoOperation;
import team.fourth.papersys.util.JFrameUtil;
import team.fourth.papersys.util.UserGlobalObject;
/**
 * �û���Ϣ�����
 * @author linyanbin
 *
 * 2018��3��12������9:41:59
 */
public class UserManagerPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel northPane;	// �������
	private JPanel southPane;	// �ϲ����
	private JScrollPane centerPane;	// �в����
	private AbstractInfoOperation infoOperation = new UserInfoOperation();
	
	public UserManagerPanel() {}
	
	public UserManagerPanel(int pageSize, int currentPage) {
		UserGlobalObject.setPageSize(pageSize);
		UserGlobalObject.setCurrentPage(currentPage);
		init();
	}
	
	public void init() {
		// ���������Ϊ�߿򲼾�
		this.setLayout(new BorderLayout());
		// ��������ӱ������
		createNorthPane();
		// ����������в����
		createCenterPane();
		// ����������ϲ����
		createSouthPane();
	}
	
	// ����������в����
	public void createCenterPane() {
		// ��ʼ���û���Ϣ���
		JTable userTable = infoOperation.initInfo(UserGlobalObject.getPageSize(), UserGlobalObject.getCurrentPage());
		centerPane = new JScrollPane(userTable);	// �в��������
		this.add(centerPane, BorderLayout.CENTER);
		// Ϊ������������¼�
		UserGlobalObject.setjTable(userTable);
		userTable.addMouseListener(new UserTableListener());
		UserGlobalObject.setjScrollPane(centerPane);
	}
	
	// ����������ϲ���壬ʵ�ַ�ҳ����
	public void createSouthPane() {
		southPane = new JPanel();
		// ���徲̬��ǩ�Ͷ�̬��ǩ
		JLabel countStaticLabel = new JLabel();	// �ܼ�¼��
		JLabel currStaticLabel = new JLabel();	// ��ǰҳ��
		JLabel totalStaticLabel = new JLabel();	// ��ǰҳ��
		JLabel countDynamicLabel = new JLabel(String.valueOf(UserGlobalObject.getCount()));
		JLabel currDynamicLabel = new JLabel(String.valueOf(UserGlobalObject.getCurrentPage()));
		JLabel totalDynamicLabel = new JLabel(String.valueOf(UserGlobalObject.getTotalPage()));
		countStaticLabel.setText("�ܼ�¼����");
		currStaticLabel.setText("��ǰҳ����");
		totalStaticLabel.setText("��ҳ����");
		// ���尴ť
		JButton first = new JButton("��ҳ");// ��ҳ
		JButton last = new JButton("βҳ");// βҳ
		JButton previous = new JButton("��һҳ");// ��һҳ
		JButton next = new JButton("��һҳ");// ��һҳ
		// Ϊ��ť��ӵ���¼�
		first.addActionListener(this);
		last.addActionListener(this);
		previous.addActionListener(this);
		next.addActionListener(this);
		// ���������������ӵ������
		southPane.add(countStaticLabel);
		southPane.add(countDynamicLabel);
		southPane.add(currStaticLabel);
		southPane.add(currDynamicLabel);
		southPane.add(totalStaticLabel);
		southPane.add(totalDynamicLabel);
		southPane.add(first);
		southPane.add(previous);
		southPane.add(next);
		southPane.add(last);
		// Ϊ�����������������ʽ
		Component[] components = southPane.getComponents();
		for (Component component : components) {
			component.setFont(new Font("����", Font.ITALIC, 14));
		}
		this.add(southPane,BorderLayout.SOUTH);
	}
	
	// ��������ӱ�����壬�ṩ��ѯ����
	public void createNorthPane() {
		northPane = new JPanel();	// �������
		// ������ǩ������������ʽ
		JLabel usernameJLabel = new JLabel("�û�����");
		JLabel phoneJLabel = new JLabel("�ֻ��ţ�");
		Font font = new Font("����", Font.ITALIC, 14);
		usernameJLabel.setFont(font);
		phoneJLabel.setFont(font);
		// ������ѯ�����ı���Ͳ�ѯ��ť
		JTextField usernameField = new JTextField();
		JTextField phoneField = new JTextField();
		JButton butSearch = new JButton("��ѯ", new ImageIcon("img/search-icon.png"));
		JButton addSearch = new JButton("���", new ImageIcon("img/add-icon.png"));
		butSearch.setFont(font);
		addSearch.setFont(font);
		usernameField.setColumns(15);
		phoneField.setColumns(15);
		
		// ���������������ӵ������
		northPane.add(usernameJLabel);
		northPane.add(usernameField);
		northPane.add(phoneJLabel);
		northPane.add(phoneField);
		northPane.add(butSearch);
		northPane.add(addSearch);
		//����������ڵ�λ��
		this.add(northPane, BorderLayout.NORTH);
		// Ϊ��ѯ��ť��ӵ���¼�
		butSearch.addActionListener(event -> {
			String username = usernameField.getText();
			String phone = phoneField.getText();
			// ����ѯ��������Ϊȫ�ֱ���
			UserGlobalObject.setUsername(username);
			UserGlobalObject.setPhone(phone);
			// ������������
			usernameField.setText("");
			phoneField.setText("");
			// �����ѯĬ����ʾ�ص�һҳ
			UserGlobalObject.setCurrentPage(1);
			infoOperation.reloadInfo(UserGlobalObject.getPageSize(), UserGlobalObject.getCurrentPage(), username, phone);
			// ���¼��ر������
			infoOperation.reloadLabelData(southPane);	
		});
		// Ϊ��Ӱ�ť�ӵ���¼�
		addSearch.addActionListener(event -> {
			JFrame frame = new AddAndModifyUserFrame();
			frame.setTitle("����û�");
			JFrameUtil.init(frame, 700, 600, JFrame.DISPOSE_ON_CLOSE);
		});
	}
	
	// �����ϲ����İ�ť
	@Override
	public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			// ������ȡ��
			String username = UserGlobalObject.getUsername();
			String phone = UserGlobalObject.getPhone();
			int pageSize = UserGlobalObject.getPageSize();
			int currentPage = UserGlobalObject.getCurrentPage();
			int totalPage = UserGlobalObject.getTotalPage();
			
			if(source instanceof JButton) {
				JButton button = (JButton) source;
				String text = button.getText();
				if("��ҳ".equals(text)) {
					if(currentPage==1) {
						JOptionPane.showMessageDialog(this, "��ǰ������ҳ�ˣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE);
						return;
					}
					currentPage = 1;
					// ���¼��ر������
					infoOperation.reloadInfo(pageSize, currentPage, username, phone);
					// �ı䵱ǰҳ����
					UserGlobalObject.setCurrentPage(currentPage);
					// ���¼��ض�̬��ǩ����
					infoOperation.reloadLabelData(southPane);
				}else if ("��һҳ".equals(text)){
					currentPage = currentPage - 1;
					if(currentPage<=0) {
						JOptionPane.showMessageDialog(this, "�Ѿ�����ҳ�ˣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE);
						return;
					}
					infoOperation.reloadInfo(pageSize, currentPage, username, phone);
					UserGlobalObject.setCurrentPage(currentPage);
					infoOperation.reloadLabelData(southPane);
				}else if ("��һҳ".equals(text)){
					currentPage = currentPage + 1;
					if(currentPage>totalPage) {
						JOptionPane.showMessageDialog(this, "�Ѿ������һҳ�ˣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE);
						return;
					}
					infoOperation.reloadInfo(pageSize, currentPage, username, phone);
					UserGlobalObject.setCurrentPage(currentPage);
					infoOperation.reloadLabelData(southPane);
				}else {		// βҳ
					if(currentPage==totalPage) {
						JOptionPane.showMessageDialog(this, "��ǰ�������һҳ�ˣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE);
						return;
					}
					currentPage = totalPage;
					infoOperation.reloadInfo(pageSize, currentPage, username, phone);
					UserGlobalObject.setCurrentPage(currentPage);
					infoOperation.reloadLabelData(southPane);
				}
			}
	}
}
