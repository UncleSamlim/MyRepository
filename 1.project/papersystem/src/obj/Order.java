package obj;

import java.sql.Date;

public class Order {
	private String order_id;

	private String user_id;

	private String receiver;

	private String phone;

	private String address;

	private int number;

	private double money;

	private Date order_date;

	private String status;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
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

	public int getNumber() {
		return number;
	}

	public int setNumber(int number) {
		return this.number = number;
	}

	public double getMoney() {
		return money;
	}

	public double setMoney(double money) {
		return this.money = money;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public Date setOrder_date(Date order_date) {
		return this.order_date = order_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
