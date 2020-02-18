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
 * չʾ�û���Ϣ����
 * @author linyanbin
 *
 * 2018��3��12������9:40:54
 */
public class UserInfoOperation extends AbstractInfoOperation{
	private final String[] columnHeader = {"�û�ID","�û���","����","�ֻ���","�Ա�","����","ְλ","����"};// ��ͷ;
	public static JFrame frame;
	private UserService userService = new UserServiceImpl();
	// ��һ�ε�½����������ݵ����
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
		tableModel.setTableStyle(table);	// ���ñ����ʽ
		return table;
	}
	
	// ���±����ʾ���û�����
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
		tableModel.setTableStyle(table);	// ���ñ����ʽ
		// �������ñ����ͼ
		UserGlobalObject.setjTable(table);
		// Ϊ������������¼�
		table.addMouseListener(new UserTableListener());
        UserGlobalObject.getjScrollPane().setViewportView(table);
	}

	@Override
	// ���¼��ر�ǩ����
	public void reloadLabelData(JPanel southPane) {
		JLabel countDynamicLabel = (JLabel) southPane.getComponent(1);
		JLabel currDynamicLabel = (JLabel) southPane.getComponent(3);
		JLabel totalDynamicLabel = (JLabel) southPane.getComponent(5);
		countDynamicLabel.setText(String.valueOf(UserGlobalObject.getCount()));
		currDynamicLabel.setText(String.valueOf(UserGlobalObject.getCurrentPage()));
		totalDynamicLabel.setText(String.valueOf(UserGlobalObject.getTotalPage()));
	}
	
}
