package cn.yueqian.com.dao.entity;

/**
 * 
 * @ClassName: OrderGoodsList.java
 * @Description: 订单商品中间表
 *
 * @version: v1.0.0
 * @author: Sam
 * @date: 2019年12月17日 下午8:12:48
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2019年12月17日
 *        ASUS v1.0.0 修改原因
 */
public class OrderGoods {
	private int orderId;
	private int goodsId;

	public OrderGoods() {
	}

	public OrderGoods(int orderId, int goodsId) {
		super();
		this.orderId = orderId;
		this.goodsId = goodsId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	@Override
	public String toString() {
		return "OrderGoodsList [orderId=" + orderId + ", goodsId=" + goodsId + "]";
	}

}
