package cn.yueqian.com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.yueqian.com.dao.IGoodsDao;
import cn.yueqian.com.dao.IGoodsKindDao;
import cn.yueqian.com.dao.entity.Goods;
import cn.yueqian.com.dao.entity.GoodsKind;
import cn.yueqian.com.dao.impl.GoodsDaoImpl;
import cn.yueqian.com.dao.impl.GoodsKindDaoImpl;
import cn.yueqian.com.service.IGoodsKindService;

public class GoodsKindServiceImpl implements IGoodsKindService{
	private IGoodsKindDao goodsKindDao = new GoodsKindDaoImpl();
	private IGoodsDao goodsDao = new GoodsDaoImpl();
	@Override
	public List<GoodsKind> getAllSuperKind() {
		// TODO Auto-generated method stub
		return goodsKindDao.getAllSuperKind();
	}

	@Override
	public List<GoodsKind> getKindBySuperKind(String superkind) {
		// TODO Auto-generated method stub
		return goodsKindDao.getKindBySuperKind(superkind);
	}

	@Override
	public Map<GoodsKind, List<GoodsKind>> getShowKind() {
		Map<GoodsKind, List<GoodsKind>> map = new HashMap<GoodsKind,List<GoodsKind>>();
		List<GoodsKind> list =goodsKindDao.getAllSuperKind();
		for (GoodsKind goodsKind : list) {
			List<GoodsKind> listt = goodsKindDao.getKindBySuperKind(goodsKind.getKindName());
			List<GoodsKind> dataList  = new ArrayList<GoodsKind> ();
			for (GoodsKind goodsKind2 : listt) {
				dataList.add(goodsKind2);
			}
			map.put(goodsKind, dataList);
		}
		return map;
	}

	@Override
	public Map<GoodsKind, List<Goods>> getShowGoods() {
		Map<GoodsKind, List<Goods>> map = new HashMap<>();
		List<GoodsKind> list = goodsKindDao.selAllGoodsKind();
		for (GoodsKind goodsKind : list) {			
			if(goodsKind.getSuperKind()!=0){
				List list2 = goodsDao.selGoodsByKindId(goodsKind.getId());
				map.put(goodsKind, list2);
			}
		}
		return map;
	}

	@Override
	public Map<GoodsKind, List<Goods>> getShowGoodsOfSuper() {
		Map<GoodsKind, List<Goods>> map = new HashMap<>();
		List<GoodsKind> list = goodsKindDao.getAllSuperKind();
		for (GoodsKind goodsKind : list) {
			List<Goods> list2 = goodsDao.selGoodsBySId(goodsKind.getId());
			map.put(goodsKind, list2);
		}
		return map;
	}


}
