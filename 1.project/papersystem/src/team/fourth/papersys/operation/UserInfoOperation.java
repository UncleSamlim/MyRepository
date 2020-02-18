package team.fourth.papersys.operation;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import team.fourth.papersys.listener.UserTableListener;
import team.fourth.papersys.service.UserService;
import team.fourth.papersys.service.UserServiceImpl;
import team.fourth.papersys.util.UserGlobalObject;
import team.fourth.papersys.util.InfoTableModel;
/**
 * 展示用户信息的类
 * @author linyanbin
 *
 * 2018年3月12日上午9:40:54
 */
public class UserInfoOperation extends AbstractInfoOperation{
	private final String[] columnHeader = {"用户ID","用户名","密码","手机号","性别","年龄","职位","邮箱"};// 表头;
	public static JFrame frame;
	private UserService userService = new UserServiceImpl();
	// 第一次登陆界面加载数据到表格
	public JTable initInfo(int pageSize, int currentPage) {
		Vector<Vector<String>> info = userService.findUsers(null, null, pageSize, currentPage);
		int count = userService.countUsers(null, null);
		int totalPage = (int) Math.ceil((count*1.0/pageSize));
		if(totalPage==0) {
			UserGlobalObject.setTotalPage(1);
		}else {
			UserGlobalObject.setTotalPage(totalPage);
		}
		UserGlobalObject.setTotalPage(totalPage);
		UserGlobalObject.setCount(count);
		InfoTableModel tableModel = new InfoTableModel(columnHeader, info);
		JTable table = new JTable(tableModel);
		tableModel.setTableStyle(table);	// 设置表格样式
		return table;
	}
	
	// 更新表格显示的用户数据
	public void reloadInfo(int pageSize, int currentPage, String...parames) {
		String username = parames[0];
		String phone = parames[1];
		Vector<Vector<String>> info = userService.findUsers(username, phone, pageSize, currentPage);
		int count = userService.countUsers(username, phone);
		int totalPage = (int) Math.ceil((count*1.0/pageSize));
		if(totalPage==0) {
			UserGlobalObject.setTotalPage(1);
		}else {
			UserGlobalObject.setTotalPage(totalPage);
		}
		UserGlobalObject.setCount(count);
		InfoTableModel tableModel = new InfoTableModel(columnHeader, info);
		JTable table = new JTable(tableModel);
		tableModel.setTableStyle(table);	// 设置表格样式
		// 重新设置表格视图
		UserGlobalObject.setjTable(table);
		// 为表格添加鼠标点击事件
		table.addMouseListener(new UserTableListener());
        UserGlobalObject.getjScrollPane().setViewportView(table);
	}

	@Override
	// 重新加载标签内容
	public void reloadLabelData(JPanel southPane) {
		JLabel countDynamicLabel = (JLabel) southPane.getComponent(1);
		JLabel currDynamicLabel = (JLabel) southPane.getComponent(3);
		JLabel totalDynamicLabel = (JLabel) southPane.getComponent(5);
		countDynamicLabel.setText(String.valueOf(UserGlobalObject.getCount()));
		currDynamicLabel.setText(String.valueOf(UserGlobalObject.getCurrentPage()));
		totalDynamicLabel.setText(String.valueOf(UserGlobalObject.getTotalPage()));
	}
	
}
