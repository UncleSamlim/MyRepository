package team.fourth.papersys.util;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UserGlobalObject {
	private static JScrollPane jScrollPane;
	private static JTable jTable;
	private static int currentPage; // ��ǰҳ
	private static int pageSize; // ÿҳ��ʾ��¼��
	private static int count; // �ܼ�¼��
	private static int totalPage; // ��ҳ��
	private static String username; // ���û���
	private static String phone; // ���ֻ���

	public static JScrollPane getjScrollPane() {
		return jScrollPane;
	}

	public static void setjScrollPane(JScrollPane jScrollPane) {
		UserGlobalObject.jScrollPane = jScrollPane;
	}

	public static JTable getjTable() {
		return jTable;
	}

	public static void setjTable(JTable jTable) {
		UserGlobalObject.jTable = jTable;
	}

	public static int getCurrentPage() {
		return currentPage;
	}

	public static void setCurrentPage(int currentPage) {
		UserGlobalObject.currentPage = currentPage;
	}

	public static int getPageSize() {
		return pageSize;
	}

	public static void setPageSize(int pageSize) {
		UserGlobalObject.pageSize = pageSize;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		UserGlobalObject.username = username;
	}

	public static String getPhone() {
		return phone;
	}

	public static void setPhone(String phone) {
		UserGlobalObject.phone = phone;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		UserGlobalObject.count = count;
	}

	public static int getTotalPage() {
		return totalPage;
	}

	public static void setTotalPage(int totalPage) {
		UserGlobalObject.totalPage = totalPage;
	}
}
