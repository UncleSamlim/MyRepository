package cn.yueqian.com.dao.entity;

import java.util.Date;

public class PayOrderObject {
	private Date orderDate;
	private String picPath;
	private String goodesName;
	private Double goodesPrice;
	private int goodsNumber;
	private Integer orderId;
	private int catscore; 
	private String orderDestination;
	private double orderPayMoney;
	public PayOrderObject() {
	}
	public PayOrderObject(Date orderDate, String picPath, String goodesName, Double goodesPrice, int goodsNumber,
			Integer orderId, int catscore, String orderDestination, double orderPayMoney) {
		super();
		this.orderDate = orderDate;
		this.picPath = picPath;
		this.goodesName = goodesName;
		this.goodesPrice = goodesPrice;
		this.goodsNumber = goodsNumber;
		this.orderId = orderId;
		this.catscore = catscore;
		this.orderDestination = orderDestination;
		this.orderPayMoney = orderPayMoney;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getGoodesName() {
		return goodesName;
	}
	public void setGoodesName(String goodesName) {
		this.goodesName = goodesName;
	}
	public Double getGoodesPrice() {
		return goodesPrice;
	}
	public void setGoodesPrice(Double goodesPrice) {
		this.goodesPrice = goodesPrice;
	}
	public int getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public int getCatscore() {
		return catscore;
	}
	public void setCatscore(int catscore) {
		this.catscore = catscore;
	}
	public String getOrderDestination() {
		return orderDestination;
	}
	public void setOrderDestination(String orderDestination) {
		this.orderDestination = orderDestination;
	}
	public double getOrderPayMoney() {
		return orderPayMoney;
	}
	public void setOrderPayMoney(double orderPayMoney) {
		this.orderPayMoney = orderPayMoney;
	}
	@Override
	public String toString() {
		return "PayOrderObject [orderDate=" + orderDate + ", picPath=" + picPath + ", goodesName=" + goodesName
				+ ", goodesPrice=" + goodesPrice + ", goodsNumber=" + goodsNumber + ", orderId=" + orderId
				+ ", catscore=" + catscore + ", orderDestination=" + orderDestination + ", orderPayMoney="
				+ orderPayMoney + "]";
	}

	
	
}
