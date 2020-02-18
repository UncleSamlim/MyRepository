package cn.yueqian.com.dao;

import java.util.List;

import cn.yueqian.com.dao.entity.GoodsKind;

/**
 * @author she
 * 类名：IGoodsKindDao 
 * 功能描述：操作商品分类表
 * 时间：2019年12月12日 下午1:52:38 
 */
public interface IGoodsKindDao {
	//添加一个商品类别记录
	public int addGoodsKind(GoodsKind goodskind);
	//删除所有商品类别记录
	public int delAllGoodsKind();
	//根据ID删除商品类别记录
	public int delGoodsKindById(int goodskindid);
	//更新一条商品类别记录
	public int updateGoodsKindById(GoodsKind goodskind);
	//查询所有商品类别记录，使用list返回
	public List<GoodsKind> selAllGoodsKind();
	//查询一个ID的商品类别记录，返回一个GoodsKind对象
	public GoodsKind selGoodsKindById(int goodskindid);
	/*多表查询*/
	/*自连接*/
	//查询所有一级分类({母婴店，海外自营店})
	public List<GoodsKind> getAllSuperKind();
	//查询一个一级分类的二级分类(传入‘母婴店’，返回{奶粉区，奶嘴区})
	public List<GoodsKind> getKindBySuperKind(String superkind);

}
