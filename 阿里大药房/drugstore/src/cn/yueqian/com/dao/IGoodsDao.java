package cn.yueqian.com.dao;

import java.util.List;

import cn.yueqian.com.dao.entity.Goods;

/**
 * @author she
 * 类名：IGoodsDao 
 * 功能描述：操作商品信息表
 * 时间：2019年12月12日 下午1:52:59 
 */
public interface IGoodsDao {
	//添加一条商品信息记录
	public int addGoods(Goods goods);
	//根据ID删除一条商品记录
	public int delGoodsById(int goodid);
	//删除所有的商品记录
	public int delAllGoods();
	//根据修改一条商品记录
	public int updateGoods(Goods goods);
	//查询所有商品信息记录，用list返回,根据销量降序排序
	public List<Goods> selAllGoods();
	//根据ID查询一条商品信息记录
	public Goods selGoodsById(int id);
	//查询某二级分类下的商品，根据销量降序排序
	public List<Goods> selGoodsByKindId(int KindId);
	//查询某一级分类下的商品，根据销量降序排序
	public List<Goods> selGoodsBySId(int SuperId);

}
