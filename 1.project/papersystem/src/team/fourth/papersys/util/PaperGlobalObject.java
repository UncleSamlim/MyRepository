package team.fourth.papersys.util;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PaperGlobalObject {
	private static JScrollPane jScrollPane;
	private static JTable jTable;
	private static int currentPage; // 当前页
	private static int pageSize; // 每页显示记录数
	private static int count; // 总记录数
	private static int totalPage; // 总页数
	private static String paperName; // 存报刊名
	private static String publisher; // 存出版社

	public static JScrollPane getjScrollPane() {
		return jScrollPane;
	}

	public static void setjScrollPane(JScrollPane jScrollPane) {
		PaperGlobalObject.jScrollPane = jScrollPane;
	}

	public static JTable getjTable() {
		return jTable;
	}

	public static void setjTable(JTable jTable) {
		PaperGlobalObject.jTable = jTable;
	}

	public static int getCurrentPage() {
		return currentPage;
	}

	public static void setCurrentPage(int currentPage) {
		PaperGlobalObject.currentPage = currentPage;
	}

	public static int getPageSize() {
		return pageSize;
	}

	public static void setPageSize(int pageSize) {
		PaperGlobalObject.pageSize = pageSize;
	}

	public static String getPaperName() {
		return paperName;
	}

	public static void setPaperName(String paperName) {
		PaperGlobalObject.paperName = paperName;
	}

	public static String getPublisher() {
		return publisher;
	}

	public static void setPublisher(String publisher) {
		PaperGlobalObject.publisher = publisher;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		PaperGlobalObject.count = count;
	}

	public static int getTotalPage() {
		return totalPage;
	}

	public static void setTotalPage(int totalPage) {
		PaperGlobalObject.totalPage = totalPage;
	}
}
