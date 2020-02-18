package cn.yueqian.com.dao.entity;

import java.util.Date;

/**
 * 
 * @ClassName: Order.java
 * @Description:
 *
 * @version: v1.0.0
 * @author: Sam
 * @date: 2019年12月12日 下午7:15:42
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2019年12月12日
 *        ASUS v1.0.0 修改原因
 */

public class Order {
	private Integer orderId;
	private int userId;
	private String orderDestination;
	private String orderStatus;
	private double orderPayMoney;
	private String orderPayWay;
	private Date orderDate;
	private int goodsId;
	private int goodsNumber;

	public Order() {
	}

	public Order(Integer orderId, int userId, String orderDestination, String orderStatus, double orderPayMoney,
			String orderPayWay, Date orderDate, int goodsId, int goodsNumber) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDestination = orderDestination;
		this.orderStatus = orderStatus;
		this.orderPayMoney = orderPayMoney;
		this.orderPayWay = orderPayWay;
		this.orderDate = orderDate;
		this.goodsId = goodsId;
		this.goodsNumber = goodsNumber;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOrderDestination() {
		return orderDestination;
	}

	public void setOrderDestination(String orderDestination) {
		this.orderDestination = orderDestination;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getOrderPayMoney() {
		return orderPayMoney;
	}

	public void setOrderPayMoney(double orderPayMoney) {
		this.orderPayMoney = orderPayMoney;
	}

	public String getOrderPayWay() {
		return orderPayWay;
	}

	public void setOrderPayWay(String orderPayWay) {
		this.orderPayWay = orderPayWay;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", orderDestination=" + orderDestination
				+ ", orderStatus=" + orderStatus + ", orderPayMoney=" + orderPayMoney + ", orderPayWay=" + orderPayWay
				+ ", orderDate=" + orderDate + ", goodsId=" + goodsId + ", goodsNumber=" + goodsNumber + "]";
	}

}
