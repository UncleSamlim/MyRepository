package com.yq.entity;

import java.util.Date;

public class Admin {
	private Integer id;
	private String name;
	private String pwd;
	private String power;
	private Date lasttime;
	public Admin() {
		super();
	}
	public Admin(Integer id, String name, String pwd, String power, Date lasttime) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.power = power;
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
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public Date getLasttime() {
		return lasttime;
	}
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", pwd=" + pwd + ", power=" + power + ", lasttime=" + lasttime
				+ "]";
	}

}
