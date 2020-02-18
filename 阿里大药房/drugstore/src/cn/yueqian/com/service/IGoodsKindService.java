package cn.yueqian.com.service;

import java.util.List;
import java.util.Map;

import cn.yueqian.com.dao.entity.Goods;
import cn.yueqian.com.dao.entity.GoodsKind;

public interface IGoodsKindService {
	/*多表查询*/
	/*自连接*/
	//查询所有一级分类({母婴店，海外自营店})
	public List<GoodsKind> getAllSuperKind();
	//查询一个一级分类的二级分类(传入‘母婴店’，返回{奶粉区，奶嘴区})
	public List<GoodsKind> getKindBySuperKind(String superkind);
	//查询一级标题对应二级标题的，放在map中返回
	public Map<GoodsKind,List<GoodsKind>> getShowKind();
	//查询二级标题中的商品，放在map中放回
	public Map<GoodsKind,List<Goods>>getShowGoods();
	//查询一个一级标题的所有商品
	public Map<GoodsKind,List<Goods>>getShowGoodsOfSuper();
}
