package cn.tocean.com.utils;

import java.util.List;

public class Page<T> {
	private int currentPage;//��ǰҳ��  ǰ�˴������ģ��ֹ���ֵ
	private int pageSize;//ÿҳ��С  �ֹ���ֵ
	private int count;//��������ѯ�����ܼ�¼��     ������ ��ѯ���ݿ�õ���
	private int totalPages;//��ҳ��   ����
	private List<T> list; //ÿҳ�ļ�¼��ϸ��Ϣ      ������ ��ѯ���ݿ�õ���
	public int getTotalPages() {
		totalPages = count/pageSize;
		if (count%pageSize!=0) {
			totalPages = totalPages + 1;
		}
		return totalPages;
	}
	public Page() {
		super();
	}
	public Page(int currentPage, int pageSize, int count, 
			List<T> list) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.count = count;
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
