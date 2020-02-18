package cn.yueqian.com.dao.entity;

import java.util.Date;

public class User {

	
	private Integer id;
	private String name;
	private String pwd;
	private String realname;
	private String age;
	private String sex;
	private String phone;
	private String address;
	private Date lasttime;
	public User() {
		super();
	}
	public User(Integer id, String name, String pwd, String realname, String age, String sex, String phone,
			String address, Date lasttime) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.realname = realname;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
		this.address = address;
		this.lasttime = lasttime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getLasttime() {
		return lasttime;
	}
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", realname=" + realname + ", age=" + age
				+ ", sex=" + sex + ", phone=" + phone + ", address=" + address + ", lasttime=" + lasttime + "]";
	}
	


 }
