package cn.tocean.com.dao.entity;

import java.util.Date;

public class Comment {

	private int id;
	private int user_id;
	private int goods_id;
	private String pic;
	private String content;
	private String ip;
	private String date;
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", user_id=" + user_id + ", goods_id=" + goods_id + ", pic=" + pic + ", content="
				+ content + ", ip=" + ip + ", date=" + date + "]";
	}

	public Comment() {
		super();
	}
	public Comment(int id, int user_id, int goods_id, String pic, String content, String ip, String date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.goods_id = goods_id;
		this.pic = pic;
		this.content = content;
		this.ip = ip;
		this.date = date;
	}
	public Comment(int user_id, int goods_id, String pic, String content, String ip, String date) {
		super();
		this.user_id = user_id;
		this.goods_id = goods_id;
		this.pic = pic;
		this.content = content;
		this.ip = ip;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
