package cn.yueqian.com.dao.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: CartInfoObject.java
 * @Description: 购物车中订单信息对象 用于servlet与jsp交互传递信息
 *
 * @version: v1.0.0
 * @author: Sam
 * @date: 2019年12月13日 下午5:11:40
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2019年12月13日
 *        ASUS v1.0.0 修改原因 "?g;'';;
 */
public class CartInfoObject implements Serializable {
	private String picPath;
	private String goodesName;
	private Double goodesPrice;
	private int goodsNumber;
	private int orderId;
	private int catscore;

	public CartInfoObject() {
	}

	public CartInfoObject(String picPath, String goodesName, Double goodesPrice, int goodsNumber, int orderId,
			int catscore) {
		super();
		this.picPath = picPath;
		this.goodesName = goodesName;
		this.goodesPrice = goodesPrice;
		this.goodsNumber = goodsNumber;
		this.orderId = orderId;
		this.catscore = catscore;
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

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCatscore() {
		return catscore;
	}

	public void setCatscore(int catscore) {
		this.catscore = catscore;
	}

	@Override
	public String toString() {
		return "CartInfoObject [picPath=" + picPath + ", goodesName=" + goodesName + ", goodesPrice=" + goodesPrice
				+ ", goodsNumber=" + goodsNumber + ", orderId=" + orderId + ", catscore=" + catscore + "]";
	}

}
