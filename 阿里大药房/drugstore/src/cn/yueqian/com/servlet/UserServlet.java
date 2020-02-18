package cn.yueqian.com.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yueqian.com.dao.entity.Goods;
import cn.yueqian.com.dao.entity.GoodsKind;
import cn.yueqian.com.service.IGoodsKindService;
import cn.yueqian.com.service.IGoodsService;
import cn.yueqian.com.service.impl.GoodsKindServiceImpl;
import cn.yueqian.com.service.impl.GoodsServiceImpl;
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet{
	//保健馆初始化
	public void InitBaojian(HttpServletRequest request, HttpServletResponse response){
		try {
			response.sendRedirect("baojian.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void InitCommodity(HttpServletRequest request, HttpServletResponse response){
		int GoodsId = Integer.parseInt(request.getParameter("GoodsId"));
		IGoodsService goodsService = new GoodsServiceImpl();
		Goods oneGoods= goodsService.selGoodsById(GoodsId);
		HttpSession session = request.getSession();
		session.setAttribute("OneGoods", oneGoods);
		try {
			response.sendRedirect("commodity.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void InitFkg(HttpServletRequest request, HttpServletResponse response){
		
	}
	public void InitHaiwai(HttpServletRequest request, HttpServletResponse response){
		try {
			response.sendRedirect("haiwai.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void InitIndex(HttpServletRequest request, HttpServletResponse response){
		IGoodsKindService goodsKindService = new GoodsKindServiceImpl();
		Map<GoodsKind,List<GoodsKind>> KindMap =goodsKindService.getShowKind();
		Map<GoodsKind,List<Goods>> GoodsMap=goodsKindService.getShowGoods();
		Map<GoodsKind,List<Goods>> SuperMap=goodsKindService.getShowGoodsOfSuper();
		request.getSession().setAttribute("ShowKind", KindMap);
		request.getSession().setAttribute("ShowGoods", GoodsMap);
		request.getSession().setAttribute("ShowSuperGoods", SuperMap);
		
		try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void InitMuying(HttpServletRequest request, HttpServletResponse response){
	
	}
	public void InitSearch(HttpServletRequest request, HttpServletResponse response){
	
	}
	public void InitSex(HttpServletRequest request, HttpServletResponse response){
		
	}
	public void InitYlgxg(HttpServletRequest request, HttpServletResponse response){
		
	}
}
