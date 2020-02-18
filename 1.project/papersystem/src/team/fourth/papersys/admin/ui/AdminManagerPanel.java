package team.fourth.papersys.admin.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.apache.commons.lang.StringUtils;

import team.fourth.papersys.pojo.Admin;
import team.fourth.papersys.service.AdminService;
import team.fourth.papersys.service.AdminServiceImpl;
import team.fourth.papersys.util.FontStyleUtil;
import team.fourth.papersys.util.InfoTableModel;
import team.fourth.papersys.util.RandomIdFactory;

public class AdminManagerPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final int SEARCHALL = 0;
	private final int SEARCHBYNAME = 1;
	private final int SEARCHBYPHONE = -1;
	private final String[] columnHeader = {"����ԱID", "����", "����", "�ֻ���", "��ɫ"};
	
	private JPanel northPane;	// �������
	private JPanel southPane;	// �ϲ����
	private JScrollPane centerPane;	//�в����
	private JTable table;
	private AdminService adminService = new AdminServiceImpl();
	
	public AdminManagerPanel() {
		northPane = new JPanel();
		southPane = new JPanel();
		init();
	}

	private void init() {
		// ���������Ϊ�߿򲼾�
		this.setLayout(new BorderLayout());
		// �������
		createNorthPane();
		// �ϲ����
		createSouthPane();
		// �в����
		createCenterPane();
	}

	private void createSouthPane() {
		// �ϲ����
		JLabel findLabel = new JLabel("�����룺");
		JLabel blankLabel = new JLabel("        ");
		JTextField textField = new JTextField(20);
		JButton nameButton = new JButton("������ѯ");
		JButton phoneButton = new JButton("�ֻ��Ų�ѯ");
		JButton refreshButton = new JButton("ˢ���б�");
		JButton deleteButton = new JButton("ɾ��");
		JButton modifyButton = new JButton("�޸�");
		southPane.add(findLabel);
		southPane.add(textField);
		southPane.add(nameButton);
		southPane.add(phoneButton);
		southPane.add(refreshButton);
		southPane.add(blankLabel);
		southPane.add(deleteButton);
		southPane.add(modifyButton);
		nameButton.addActionListener(this);
		phoneButton.addActionListener(this);
		refreshButton.addActionListener(this);
		deleteButton.addActionListener(this);
		modifyButton.addActionListener(this);
		// ͳһ�������������ʽ
		Font font = new Font("����", Font.ITALIC, 14);
		FontStyleUtil.setFontStyle(southPane, font);
		this.add(southPane, BorderLayout.SOUTH);
	}

	private void createCenterPane() {
		// ��ѯ��ˢ���б�
		centerPane = new JScrollPane();
		searchAndRefreshInfo(null, SEARCHALL);
		this.add(centerPane, BorderLayout.CENTER);
	}
	
	private void createNorthPane() {
		JLabel nameLabel = new JLabel("�ʺţ�");
		JLabel pwdLabel = new JLabel("���룺");
		JLabel phoneLabel = new JLabel("�ֻ��ţ�");
		JLabel roleLabel = new JLabel("��ɫ��");
		JLabel blankLabel = new JLabel("          ");
		JComboBox<String>selectBox = new JComboBox<String>(new String[] {"��ͨ����Ա", "��������Ա"});
		JTextField nameText = new JTextField(15);
		JPasswordField pwdText = new JPasswordField(15);
		JTextField phoneText = new JTextField(15);
		JButton addButton = new JButton("ȷ�����");
		northPane.add(nameLabel);
		northPane.add(nameText);
		northPane.add(pwdLabel);
		northPane.add(pwdText);
		northPane.add(phoneLabel);
		northPane.add(phoneText);
		northPane.add(roleLabel);
		northPane.add(selectBox);
		northPane.add(blankLabel);
		northPane.add(addButton);
		// ͳһ�������������ʽ
		Font font = new Font("����", Font.ITALIC, 14);
		FontStyleUtil.setFontStyle(northPane, font);
		addButton.addActionListener(event -> {
			String name = nameText.getText();
			char[] password = pwdText.getPassword();
			String phone = phoneText.getText();
			String role = (String) selectBox.getSelectedItem();
			// ��ȷ��ѯ��ӵĹ�����Ϣ�Ƿ��Ѵ���
			Admin admin = adminService.findAdminByName(name);
			if (admin!=null) {
				JOptionPane.showMessageDialog(this, "���ʧ�ܣ��ù���Ա�Ѵ���!", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
				return;
			}else {
				Admin newAdmin = new Admin();
				newAdmin.setAdminId(RandomIdFactory.getRandomId());
				newAdmin.setAdminName(name);
				newAdmin.setPassword(String.valueOf(password));
				newAdmin.setPhone(phone);
				newAdmin.setRole(role);
				int res = adminService.addAdmin(newAdmin);
				if (res > 0) {
					JOptionPane.showMessageDialog(this, "��ӳɹ�!", "�����ɹ�", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
					nameText.setText("");
					pwdText.setText("");
					phoneText.setText("");
					selectBox.setSelectedIndex(0);
					// ˢ���б�
					searchAndRefreshInfo(null, SEARCHALL);
				}else {
					JOptionPane.showMessageDialog(this, "���ʧ�ܣ�������!", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
				}
			}
		});
		this.add(northPane,BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		JTextField searchField = (JTextField) southPane.getComponent(1);
		String content = searchField.getText(); 	// ��ȡ���������
		if (source instanceof JButton) {
			JButton button = (JButton) source;
			String text = button.getText();
			if ("������ѯ".equals(text)) {	// ��������ѯ
				if ("".equals(content.trim())) {	// �ж����������Ƿ�Ϊ��
					JOptionPane.showMessageDialog(this, "�������ѯ����!", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
					return ;
				}
				searchAndRefreshInfo(content, SEARCHBYNAME);  // �ڶ���������SEARCHBYNAME����������ѯ
				searchField.setText("");
			}else if ("�ֻ��Ų�ѯ".equals(text)){		// ���ֻ��Ų�ѯ
				if ("".equals(content.trim())) {	// �ж����������Ƿ�Ϊ��
					JOptionPane.showMessageDialog(this, "�������ѯ����!", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
					return ;
				}
				searchAndRefreshInfo(content, SEARCHBYPHONE);  // �ڶ���������SEARCHBYPHONE�����ֻ��Ų�ѯ
				searchField.setText("");
			}else if ("ɾ��".equals(text)){
				int yesOrNo = JOptionPane.showConfirmDialog(table, "�Ƿ�ȷ��ɾ��?");
				// ���ȷ��ɾ��
				if(yesOrNo == JOptionPane.OK_OPTION) {
					int[] rowIndex = table.getSelectedRows();
					String ids[] = new String[rowIndex.length];
					for (int i = 0; i < rowIndex.length; i++) {
						ids[i] = (String) table.getValueAt(rowIndex[i], 0);
					}
					int result = adminService.removeAdmin(ids);
					if (result == rowIndex.length) {
						JOptionPane.showMessageDialog(table, "ɾ���ɹ���", "�����ɹ�", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
						// ��������
						searchAndRefreshInfo(null, SEARCHALL);
					}else {
						JOptionPane.showMessageDialog(table, "ɾ��ʧ�ܣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
					}
				}
			}else if ("�޸�".equals(text)){		// �޸�
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				String adminId = (String) table.getValueAt(row, 0);
				String newValue = JOptionPane.showInputDialog(table, "�������µ�ֵ");
				if (!StringUtils.isEmpty(newValue)) {
					int res = adminService.modifyAdminById(adminId, newValue, column);
					if (res > 0) {
							JOptionPane.showMessageDialog(table, "�޸ĳɹ�����ˢ�¼��أ�", "�����ɹ�", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
					}else {
						JOptionPane.showMessageDialog(table, "�޸�ʧ�ܣ������ԣ�", "����ʧ��", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
					}
				}
			}else {		//ˢ���б�
				searchAndRefreshInfo(null, SEARCHALL);
			}
		}
	}
	
	// ��ѯ����Ա��Ϣ
	private void searchAndRefreshInfo(String content, int searchWay) {
		List<Admin> admins = new ArrayList<Admin>();
		if (searchWay==SEARCHBYNAME) {	// ����������ѯ
			admins = adminService.findAdminsByName(content);
		}else if (searchWay==SEARCHBYPHONE){	// �����ֻ��Ų�ѯ
			admins = adminService.findAdminsByPhone(content);
		}else {		// ��ѯ����
			admins = adminService.findAllAdmins();	// ��ѯ������Ϣ
		}
		Vector<Vector<String>> info = transListToTwoDimension(admins);
		InfoTableModel tableModel = new InfoTableModel(columnHeader, info);
		table = new JTable(tableModel);
		tableModel.setTableStyle(table);
		centerPane.setViewportView(table);
	}
	
	// ���б�ת��Ϊ��ά���� 
	private Vector<Vector<String>> transListToTwoDimension(List<Admin>admins) {
		Vector<Vector<String>>info = new Vector<Vector<String>>();
		if (admins==null) {
			return info;
		}
		for (Admin admin : admins) {
			Vector<String>line = new Vector<String>();
			line.add(admin.getAdminId());
			line.add(admin.getAdminName());
			line.add(admin.getPassword());
			line.add(admin.getPhone());
			line.add(admin.getRole());
			info.add(line);
		}
		return info;
	}
}
