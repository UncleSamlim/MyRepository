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
	private final String[] columnHeader = {"管理员ID", "姓名", "密码", "手机号", "角色"};
	
	private JPanel northPane;	// 北部面板
	private JPanel southPane;	// 南部面板
	private JScrollPane centerPane;	//中部面板
	private JTable table;
	private AdminService adminService = new AdminServiceImpl();
	
	public AdminManagerPanel() {
		northPane = new JPanel();
		southPane = new JPanel();
		init();
	}

	private void init() {
		// 总面板设置为边框布局
		this.setLayout(new BorderLayout());
		// 北部面板
		createNorthPane();
		// 南部面板
		createSouthPane();
		// 中部面板
		createCenterPane();
	}

	private void createSouthPane() {
		// 南部面板
		JLabel findLabel = new JLabel("请输入：");
		JLabel blankLabel = new JLabel("        ");
		JTextField textField = new JTextField(20);
		JButton nameButton = new JButton("姓名查询");
		JButton phoneButton = new JButton("手机号查询");
		JButton refreshButton = new JButton("刷新列表");
		JButton deleteButton = new JButton("删除");
		JButton modifyButton = new JButton("修改");
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
		// 统一设置面板字体样式
		Font font = new Font("宋体", Font.ITALIC, 14);
		FontStyleUtil.setFontStyle(southPane, font);
		this.add(southPane, BorderLayout.SOUTH);
	}

	private void createCenterPane() {
		// 查询并刷新列表
		centerPane = new JScrollPane();
		searchAndRefreshInfo(null, SEARCHALL);
		this.add(centerPane, BorderLayout.CENTER);
	}
	
	private void createNorthPane() {
		JLabel nameLabel = new JLabel("帐号：");
		JLabel pwdLabel = new JLabel("密码：");
		JLabel phoneLabel = new JLabel("手机号：");
		JLabel roleLabel = new JLabel("角色：");
		JLabel blankLabel = new JLabel("          ");
		JComboBox<String>selectBox = new JComboBox<String>(new String[] {"普通管理员", "超级管理员"});
		JTextField nameText = new JTextField(15);
		JPasswordField pwdText = new JPasswordField(15);
		JTextField phoneText = new JTextField(15);
		JButton addButton = new JButton("确认添加");
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
		// 统一设置面板字体样式
		Font font = new Font("宋体", Font.ITALIC, 14);
		FontStyleUtil.setFontStyle(northPane, font);
		addButton.addActionListener(event -> {
			String name = nameText.getText();
			char[] password = pwdText.getPassword();
			String phone = phoneText.getText();
			String role = (String) selectBox.getSelectedItem();
			// 精确查询添加的管理信息是否已存在
			Admin admin = adminService.findAdminByName(name);
			if (admin!=null) {
				JOptionPane.showMessageDialog(this, "添加失败，该管理员已存在!", "操作失败", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
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
					JOptionPane.showMessageDialog(this, "添加成功!", "操作成功", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
					nameText.setText("");
					pwdText.setText("");
					phoneText.setText("");
					selectBox.setSelectedIndex(0);
					// 刷新列表
					searchAndRefreshInfo(null, SEARCHALL);
				}else {
					JOptionPane.showMessageDialog(this, "添加失败，请重试!", "操作失败", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
				}
			}
		});
		this.add(northPane,BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		JTextField searchField = (JTextField) southPane.getComponent(1);
		String content = searchField.getText(); 	// 获取输入的内容
		if (source instanceof JButton) {
			JButton button = (JButton) source;
			String text = button.getText();
			if ("姓名查询".equals(text)) {	// 按姓名查询
				if ("".equals(content.trim())) {	// 判断输入内容是否为空
					JOptionPane.showMessageDialog(this, "请输入查询内容!", "操作失败", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
					return ;
				}
				searchAndRefreshInfo(content, SEARCHBYNAME);  // 第二个参数传SEARCHBYNAME代表按姓名查询
				searchField.setText("");
			}else if ("手机号查询".equals(text)){		// 按手机号查询
				if ("".equals(content.trim())) {	// 判断输入内容是否为空
					JOptionPane.showMessageDialog(this, "请输入查询内容!", "操作失败", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
					return ;
				}
				searchAndRefreshInfo(content, SEARCHBYPHONE);  // 第二个参数传SEARCHBYPHONE代表按手机号查询
				searchField.setText("");
			}else if ("删除".equals(text)){
				int yesOrNo = JOptionPane.showConfirmDialog(table, "是否确认删除?");
				// 点击确认删除
				if(yesOrNo == JOptionPane.OK_OPTION) {
					int[] rowIndex = table.getSelectedRows();
					String ids[] = new String[rowIndex.length];
					for (int i = 0; i < rowIndex.length; i++) {
						ids[i] = (String) table.getValueAt(rowIndex[i], 0);
					}
					int result = adminService.removeAdmin(ids);
					if (result == rowIndex.length) {
						JOptionPane.showMessageDialog(table, "删除成功！", "操作成功", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
						// 重载数据
						searchAndRefreshInfo(null, SEARCHALL);
					}else {
						JOptionPane.showMessageDialog(table, "删除失败！", "操作失败", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
					}
				}
			}else if ("修改".equals(text)){		// 修改
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				String adminId = (String) table.getValueAt(row, 0);
				String newValue = JOptionPane.showInputDialog(table, "请输入新的值");
				if (!StringUtils.isEmpty(newValue)) {
					int res = adminService.modifyAdminById(adminId, newValue, column);
					if (res > 0) {
							JOptionPane.showMessageDialog(table, "修改成功，请刷新加载！", "操作成功", JOptionPane.OK_OPTION, new ImageIcon("img/correct-icon.png"));
					}else {
						JOptionPane.showMessageDialog(table, "修改失败，请重试！", "操作失败", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/error-icon.png"));
					}
				}
			}else {		//刷新列表
				searchAndRefreshInfo(null, SEARCHALL);
			}
		}
	}
	
	// 查询管理员信息
	private void searchAndRefreshInfo(String content, int searchWay) {
		List<Admin> admins = new ArrayList<Admin>();
		if (searchWay==SEARCHBYNAME) {	// 根据姓名查询
			admins = adminService.findAdminsByName(content);
		}else if (searchWay==SEARCHBYPHONE){	// 根据手机号查询
			admins = adminService.findAdminsByPhone(content);
		}else {		// 查询所有
			admins = adminService.findAllAdmins();	// 查询所有信息
		}
		Vector<Vector<String>> info = transListToTwoDimension(admins);
		InfoTableModel tableModel = new InfoTableModel(columnHeader, info);
		table = new JTable(tableModel);
		tableModel.setTableStyle(table);
		centerPane.setViewportView(table);
	}
	
	// 将列表转换为二维向量 
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
