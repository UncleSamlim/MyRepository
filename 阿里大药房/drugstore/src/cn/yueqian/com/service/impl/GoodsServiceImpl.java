package cn.yueqian.com.service.impl;

import java.util.List;
import java.util.Map;

import cn.yueqian.com.dao.IGoodsDao;
import cn.yueqian.com.dao.entity.Goods;
import cn.yueqian.com.dao.entity.GoodsKind;
import cn.yueqian.com.dao.impl.GoodsDaoImpl;
import cn.yueqian.com.service.IGoodsService;

public class GoodsServiceImpl implements IGoodsService{
	private IGoodsDao goodsDao  = new GoodsDaoImpl();


	@Override
	public List<Goods> selAllGoods() {
		// TODO Auto-generated method stub
		return goodsDao.selAllGoods();
	}

	@Override
	public Goods selGoodsById(int id) {
		// TODO Auto-generated method stub
		return goodsDao.selGoodsById(id);
	}

	@Override
	public List<Goods> selGoodsByKindId(int KindId) {
		// TODO Auto-generated method stub
		return goodsDao.selGoodsByKindId(KindId);
	}


}
