package util;

import java.util.List;

import obj.Bookinfo;
import obj.Order;

public class GetData {
	private String[] columnhead = { "报刊编号", "报刊类别编号", "报刊名称", "出版社", "价格",
			"刊期", "出版日期", "报刊图片", "报刊库存量" };

	public Object[][] queryDataall() {
		PackData d = new PackData();
		List<Bookinfo> list = d.findbookinfo();
		Object[][] data1 = new Object[list.size()][columnhead.length];

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < columnhead.length; j++) {
				data1[i][0] = list.get(i).getPaper_id();
				data1[i][1] = list.get(i).getCategory();
				data1[i][2] = list.get(i).getBookName();
				data1[i][3] = list.get(i).getPublishing();
				data1[i][4] = list.get(i).getPrice();
				data1[i][5] = list.get(i).getPublishnumber();
				data1[i][6] = list.get(i).getPublishdate();
				data1[i][7] = list.get(i).getImg();
				data1[i][8] = list.get(i).getStoragenum();
			}
		}
		return data1;
	}

	public Object[][] queryDataname(String name) {
		PackData d = new PackData();
		List<Bookinfo> list = d.findbookinfobyname(name);
		Object[][] data1 = new Object[list.size()][columnhead.length];

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < columnhead.length; j++) {
				data1[i][0] = list.get(i).getPaper_id();
				data1[i][1] = list.get(i).getBookName();
				data1[i][2] = list.get(i).getCategory();
				data1[i][3] = list.get(i).getPublishing();
				data1[i][4] = list.get(i).getPrice();
				data1[i][5] = list.get(i).getPublishnumber();
				data1[i][6] = list.get(i).getPublishdate();
				data1[i][7] = list.get(i).getImg();
				data1[i][8] = list.get(i).getStoragenum();
			}
		}
		return data1;
	}

	public Object[][] queryDatapublisher(String publisher) {
		PackData d = new PackData();
		List<Bookinfo> list = d.findbookinfobypublisher(publisher);
		Object[][] data1 = new Object[list.size()][columnhead.length];

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < columnhead.length; j++) {
				data1[i][0] = list.get(i).getPaper_id();
				data1[i][1] = list.get(i).getBookName();
				data1[i][2] = list.get(i).getCategory();
				data1[i][3] = list.get(i).getPublishing();
				data1[i][4] = list.get(i).getPrice();
				data1[i][5] = list.get(i).getPublishnumber();
				data1[i][6] = list.get(i).getPublishdate();
				data1[i][7] = list.get(i).getImg();
				data1[i][8] = list.get(i).getStoragenum();
			}
		}
		return data1;
	}
	
	public Object[][] queryorderchecked(String user_id) {
		PackData d = new PackData();
		List<Order> list = d.findorderchecked(user_id);
		Object[][] data1 = new Object[list.size()][columnhead.length];

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < columnhead.length; j++) {
				data1[i][0] = list.get(i).getOrder_id();
				data1[i][1] = list.get(i).getUser_id();
				data1[i][2] = list.get(i).getReceiver();
				data1[i][3] = list.get(i).getPhone();
				data1[i][4] = list.get(i).getAddress();
				data1[i][5] = list.get(i).getNumber();
				data1[i][6] = list.get(i).getMoney();
				data1[i][7] = list.get(i).getOrder_date();
				data1[i][8] = list.get(i). getStatus();
			}
		}
		return data1;
	}
	
	public Object[][] queryorderunchecked(String user_id) {
		PackData d = new PackData();
		List<Order> list = d.findorderunchecked(user_id);
		Object[][] data1 = new Object[list.size()][columnhead.length];

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < columnhead.length; j++) {
				data1[i][0] = list.get(i).getOrder_id();
				data1[i][1] = list.get(i).getUser_id();
				data1[i][2] = list.get(i).getReceiver();
				data1[i][3] = list.get(i).getPhone();
				data1[i][4] = list.get(i).getAddress();
				data1[i][5] = list.get(i).getNumber();
				data1[i][6] = list.get(i).getMoney();
				data1[i][7] = list.get(i).getOrder_date();
				data1[i][8] = list.get(i). getStatus();
			}
		}
		return data1;
	}
}
