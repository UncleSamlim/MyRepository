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
 * 用户信息面板类
 * @author linyanbin
 *
 * 2018年3月12日上午9:41:59
 */
public class UserManagerPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel northPane;	// 北部面板
	private JPanel southPane;	// 南部面板
	private JScrollPane centerPane;	// 中部面板
	private AbstractInfoOperation infoOperation = new UserInfoOperation();
	
	public UserManagerPanel() {}
	
	public UserManagerPanel(int pageSize, int currentPage) {
		UserGlobalObject.setPageSize(pageSize);
		UserGlobalObject.setCurrentPage(currentPage);
		init();
	}
	
	public void init() {
		// 总面板设置为边框布局
		this.setLayout(new BorderLayout());
		// 创建并添加北部面板
		createNorthPane();
		// 创建并添加中部面板
		createCenterPane();
		// 创建并添加南部面板
		createSouthPane();
	}
	
	// 创建并添加中部面板
	public void createCenterPane() {
		// 初始化用户信息表格
		JTable userTable = infoOperation.initInfo(UserGlobalObject.getPageSize(), UserGlobalObject.getCurrentPage());
		centerPane = new JScrollPane(userTable);	// 中部滚轮面板
		this.add(centerPane, BorderLayout.CENTER);
		// 为表格添加鼠标点击事件
		UserGlobalObject.setjTable(userTable);
		userTable.addMouseListener(new UserTableListener());
		UserGlobalObject.setjScrollPane(centerPane);
	}
	
	// 创建并添加南部面板，实现分页功能
	public void createSouthPane() {
		southPane = new JPanel();
		// 定义静态标签和动态标签
		JLabel countStaticLabel = new JLabel();	// 总记录数
		JLabel currStaticLabel = new JLabel();	// 当前页数
		JLabel totalStaticLabel = new JLabel();	// 当前页数
		JLabel countDynamicLabel = new JLabel(String.valueOf(UserGlobalObject.getCount()));
		JLabel currDynamicLabel = new JLabel(String.valueOf(UserGlobalObject.getCurrentPage()));
		JLabel totalDynamicLabel = new JLabel(String.valueOf(UserGlobalObject.getTotalPage()));
		countStaticLabel.setText("总记录数：");
		currStaticLabel.setText("当前页数：");
		totalStaticLabel.setText("总页数：");
		// 定义按钮
		JButton first = new JButton("首页");// 首页
		JButton last = new JButton("尾页");// 尾页
		JButton previous = new JButton("上一页");// 上一页
		JButton next = new JButton("下一页");// 下一页
		// 为按钮添加点击事件
		first.addActionListener(this);
		last.addActionListener(this);
		previous.addActionListener(this);
		next.addActionListener(this);
		// 将所有组件按序添加到面板中
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
		// 为面板的组件设置字体样式
		Component[] components = southPane.getComponents();
		for (Component component : components) {
			component.setFont(new Font("楷书", Font.ITALIC, 14));
		}
		this.add(southPane,BorderLayout.SOUTH);
	}
	
	// 创建并添加北部面板，提供查询功能
	public void createNorthPane() {
		northPane = new JPanel();	// 北部面板
		// 创建标签并设置字体样式
		JLabel usernameJLabel = new JLabel("用户名：");
		JLabel phoneJLabel = new JLabel("手机号：");
		Font font = new Font("宋体", Font.ITALIC, 14);
		usernameJLabel.setFont(font);
		phoneJLabel.setFont(font);
		// 创建查询输入文本框和查询按钮
		JTextField usernameField = new JTextField();
		JTextField phoneField = new JTextField();
		JButton butSearch = new JButton("查询", new ImageIcon("img/search-icon.png"));
		JButton addSearch = new JButton("添加", new ImageIcon("img/add-icon.png"));
		butSearch.setFont(font);
		addSearch.setFont(font);
		usernameField.setColumns(15);
		phoneField.setColumns(15);
		
		// 将以上组件按序添加到面板中
		northPane.add(usernameJLabel);
		northPane.add(usernameField);
		northPane.add(phoneJLabel);
		northPane.add(phoneField);
		northPane.add(butSearch);
		northPane.add(addSearch);
		//设置面板所在的位置
		this.add(northPane, BorderLayout.NORTH);
		// 为查询按钮添加点击事件
		butSearch.addActionListener(event -> {
			String username = usernameField.getText();
			String phone = phoneField.getText();
			// 将查询条件设置为全局变量
			UserGlobalObject.setUsername(username);
			UserGlobalObject.setPhone(phone);
			// 清空输入框内容
			usernameField.setText("");
			phoneField.setText("");
			// 点击查询默认显示回第一页
			UserGlobalObject.setCurrentPage(1);
			infoOperation.reloadInfo(UserGlobalObject.getPageSize(), UserGlobalObject.getCurrentPage(), username, phone);
			// 重新加载表格数据
			infoOperation.reloadLabelData(southPane);	
		});
		// 为添加按钮加点击事件
		addSearch.addActionListener(event -> {
			JFrame frame = new AddAndModifyUserFrame();
			frame.setTitle("添加用户");
			JFrameUtil.init(frame, 700, 600, JFrame.DISPOSE_ON_CLOSE);
		});
	}
	
	// 监听南部面板的按钮
	@Override
	public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			// 将数据取出
			String username = UserGlobalObject.getUsername();
			String phone = UserGlobalObject.getPhone();
			int pageSize = UserGlobalObject.getPageSize();
			int currentPage = UserGlobalObject.getCurrentPage();
			int totalPage = UserGlobalObject.getTotalPage();
			
			if(source instanceof JButton) {
				JButton button = (JButton) source;
				String text = button.getText();
				if("首页".equals(text)) {
					if(currentPage==1) {
						JOptionPane.showMessageDialog(this, "当前已是首页了！", "操作失败", JOptionPane.ERROR_MESSAGE);
						return;
					}
					currentPage = 1;
					// 重新加载表格数据
					infoOperation.reloadInfo(pageSize, currentPage, username, phone);
					// 改变当前页面数
					UserGlobalObject.setCurrentPage(currentPage);
					// 重新加载动态标签数据
					infoOperation.reloadLabelData(southPane);
				}else if ("上一页".equals(text)){
					currentPage = currentPage - 1;
					if(currentPage<=0) {
						JOptionPane.showMessageDialog(this, "已经是首页了！", "操作失败", JOptionPane.ERROR_MESSAGE);
						return;
					}
					infoOperation.reloadInfo(pageSize, currentPage, username, phone);
					UserGlobalObject.setCurrentPage(currentPage);
					infoOperation.reloadLabelData(southPane);
				}else if ("下一页".equals(text)){
					currentPage = currentPage + 1;
					if(currentPage>totalPage) {
						JOptionPane.showMessageDialog(this, "已经是最后一页了！", "操作失败", JOptionPane.ERROR_MESSAGE);
						return;
					}
					infoOperation.reloadInfo(pageSize, currentPage, username, phone);
					UserGlobalObject.setCurrentPage(currentPage);
					infoOperation.reloadLabelData(southPane);
				}else {		// 尾页
					if(currentPage==totalPage) {
						JOptionPane.showMessageDialog(this, "当前已是最后一页了！", "操作失败", JOptionPane.ERROR_MESSAGE);
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
