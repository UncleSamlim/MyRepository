package cn.yueqian.com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.yueqian.com.dao.IGoodsKindDao;
import cn.yueqian.com.dao.entity.Goods;
import cn.yueqian.com.dao.entity.GoodsKind;
import cn.yueqian.com.dao.impl.GoodsKindDaoImpl;
import cn.yueqian.com.service.IGoodsKindService;
import cn.yueqian.com.service.impl.GoodsKindServiceImpl;

public class GoodsKindDaoTest {
	IGoodsKindDao goodsKindDao = new GoodsKindDaoImpl();
	@Test
	public void test1() {
		GoodsKind goodsKind = new GoodsKind(12,"奶粉",5);
		int sign = goodsKindDao.addGoodsKind(goodsKind);
		System.out.println("添加成功记录条数"+sign);
	}
	@Test
	public void test2() {
		int sign = goodsKindDao.delGoodsKindById(7);
		System.out.println("删除成功记录条数"+sign);
	}
	@Test
	public void test3() {
		GoodsKind goodsKind = new GoodsKind(8,"三辣奶粉",6);
		int sign = goodsKindDao.updateGoodsKindById(goodsKind);
		System.out.println("修改成功条数"+sign);
	}
	@Test
	public void test4(){
		int sign = goodsKindDao.delAllGoodsKind();
		System.out.println("删除全部成功条数"+sign);
	}
	@Test
	public void test5(){
		List<GoodsKind> list = new ArrayList<GoodsKind>();
		list = goodsKindDao.selAllGoodsKind();
		for (GoodsKind goodsKind : list) {
			System.out.println(goodsKind.toString());
		}
	}
	@Test
	public void test6(){
		GoodsKind goodsKind = goodsKindDao.selGoodsKindById(12);
		System.out.println(goodsKind.toString());
	}
	//得到所有一级分类
	@Test
	public void test7(){
		List<GoodsKind> list = goodsKindDao.getAllSuperKind();
		for (GoodsKind goodsKind : list) {
			System.out.println(goodsKind.toString());
		}
	}
	@Test
	public void test8(){
		List<GoodsKind> list = goodsKindDao.getKindBySuperKind("母婴大区");
		for (GoodsKind goodsKind : list) {
			System.out.println(goodsKind.toString());
		}
	}
	@Test
	public void test9(){
		IGoodsKindService goodsKinService = new GoodsKindServiceImpl();
		Map<GoodsKind,List<Goods>> m =goodsKinService.getShowGoods();
		for(GoodsKind gk:m.keySet()){
			System.out.println(gk);
		}
	}
}
