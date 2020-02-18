package cn.yueqian.com.dao;

import cn.yueqian.com.dao.entity.OrderGoods;

/**
 * 
 * @ClassName: IOrderGoodsDao.java
 * @Description: 中间表增删操作
 *
 * @version: v1.0.0
 * @author: Sam
 * @date: 2019年12月17日 下午8:30:35
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2019年12月17日
 *        ASUS v1.0.0 修改原因
 */
public interface IOrderGoodsDao {
	public void save(OrderGoods orderGoods);

	public void delete(OrderGoods orderGoods);

	public OrderGoods getOrderGoodsObjectById(int id);
}
