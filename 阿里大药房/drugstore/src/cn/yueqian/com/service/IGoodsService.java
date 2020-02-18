package cn.yueqian.com.service;

import java.util.List;
import java.util.Map;

import cn.yueqian.com.dao.entity.Goods;
import cn.yueqian.com.dao.entity.GoodsKind;

public interface IGoodsService {
	//查询所有商品信息记录，用list返回
	public List<Goods> selAllGoods();
	//根据ID查询一条商品信息记录
	public Goods selGoodsById(int id);
	//查询某分类下的商品
	public List<Goods> selGoodsByKindId(int KindId);
}
