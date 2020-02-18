package cn.yueqian.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yueqian.com.dao.IGoodsDao;
import cn.yueqian.com.dao.IOrderDao;
import cn.yueqian.com.dao.IOrderGoodsDao;
import cn.yueqian.com.dao.entity.CartInfoObject;
import cn.yueqian.com.dao.entity.Goods;
import cn.yueqian.com.dao.entity.Order;
import cn.yueqian.com.dao.entity.OrderGoods;
import cn.yueqian.com.dao.entity.PayOrderObject;
import cn.yueqian.com.dao.entity.User;
import cn.yueqian.com.dao.impl.GoodsDaoImpl;
import cn.yueqian.com.dao.impl.OrderDaoImpl;
import cn.yueqian.com.dao.impl.OrderGoodsImpl;

public class OrderServlet extends BaseServlet {
	IOrderDao orderDao = new OrderDaoImpl();
	IGoodsDao goodsDao = new GoodsDaoImpl();
	IOrderGoodsDao orderGoodsDao = new OrderGoodsImpl();

	//添加商品到购物车
	public void AddOrderInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
		int userId= user.getId();
		int goodsId= Integer.parseInt(request.getParameter("goodsId"));
		String orderPayWay = new String(request.getParameter("orderPayWay").getBytes("ISO-8859-1"), "utf-8");
		int amount =1;
		String orderDestination =user.getAddress();
		String orderStatus ="未付款";
		int goodsNumber = Integer.parseInt(request.getParameter("goodsNumber"));
		Double price = goodsDao.selGoodsById(userId).getPrice();
		Double orderPayMoney = (price*goodsNumber);
		Order order = new Order(0, userId, orderDestination, orderStatus, orderPayMoney, orderPayWay, new Date(), goodsId, goodsNumber);
		int OKAcount =orderDao.addOrders(order);
		if(OKAcount>0){
			out.write("<script type=\"text/javascript\">"+
			"alert(\"成功添加到购物车\");"+
			"window.location.href=\"UserServlet?action=InitCommodity&GoodsId="+goodsId+"\";"+
		"</script>");
		}else{
			out.write("<script type=\"text/javascript\">"+
					"alert(\"添加失败\");"+
					"window.location.href=\"UserServlet?action=InitCommodity&GoodsId="+goodsId+"\";"+
				"</script>");
		}
		}
	}
	// 从数据库获取数据并显示到购物车中
	public void cartOrderInfo(HttpServletRequest request, HttpServletResponse response) {
		int goodsNumber = 0;
		int goodsId = 0;
		int orderId = 0;
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List<CartInfoObject> cartInfoObjects = new ArrayList<CartInfoObject>();
		//
		// 这里要通过session获取userid
		//
		List<Order> orders = orderDao.ListAllOrdersToUser(user.getId());
		for (Order order : orders) {
			if (order.getOrderStatus().equals("未付款")) {
				goodsNumber = order.getGoodsNumber();
				goodsId = order.getGoodsId();
				orderId = order.getOrderId();
				Goods goods = goodsDao.selGoodsById(goodsId);
				CartInfoObject cartInfoObject = new CartInfoObject(goods.getPic(), goods.getName(), goods.getPrice(),
						goodsNumber, orderId, goods.getCatscore());
				cartInfoObjects.add(cartInfoObject);
			}
		}
		session.setAttribute("CartInfoObjectlist", cartInfoObjects);
		try {
			response.sendRedirect("myCart.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	// 从数据库获取数据并显示到已支付订单信息中
	public void paytOrderInfo(HttpServletRequest request, HttpServletResponse response) {
		int goodsNumber = 0;
		int goodsId = 0;
		int orderId = 0;
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List<PayOrderObject> payOrderObjects = new ArrayList<PayOrderObject>();
		//
		// 这里要通过session获取userid
		//
		List<Order> orders = orderDao.ListAllOrdersToUser(user.getId());
		for (Order order : orders) {
			if (order.getOrderStatus().equals("已付款")) {
				goodsNumber = order.getGoodsNumber();
				goodsId = order.getGoodsId();
				orderId = order.getOrderId();
				Goods goods = goodsDao.selGoodsById(goodsId);
				PayOrderObject payOrderObject = new PayOrderObject(order.getOrderDate(), goods.getPic(), goods.getName(),
						goods.getPrice(), order.getGoodsNumber(), order.getOrderId(), goods.getCatscore(), order.getOrderDestination(),order.getOrderPayMoney());
				payOrderObjects.add(payOrderObject);
			}
		}
		session.setAttribute("payOrderObjectlist", payOrderObjects);
		try {
			response.sendRedirect("myPayOrders.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 购买付款
	public void buyNow(HttpServletRequest request, HttpServletResponse response) {
		Order order = new Order();
		HttpSession session = request.getSession();
		List<CartInfoObject> cartInfoObjects = (List<CartInfoObject>) session.getAttribute("CartInfoObjectlist");
		for (CartInfoObject cartInfoObject : cartInfoObjects) {
			order = orderDao.getOrderById(cartInfoObject.getOrderId());
			order.setOrderStatus("已付款");
			order.setOrderPayMoney(order.getGoodsNumber() * cartInfoObject.getGoodesPrice());
			orderDao.updateOrders(order);
		}
		cartOrderInfo(request, response);
	}

	// 加一操作
	public void add(HttpServletRequest request, HttpServletResponse response) {
		int id = 0;
		id = Integer.valueOf(request.getParameter("id").trim());
		Order order = orderDao.getOrderById(id);
		order.setGoodsNumber(order.getGoodsNumber() + 1);
		orderDao.updateOrders(order);
		cartOrderInfo(request, response);
	}

	// 减一操作
	public void minus(HttpServletRequest request, HttpServletResponse response) {
		int id = 0;
		id = Integer.valueOf(request.getParameter("id").trim());
		Order order = orderDao.getOrderById(id);
		if (order.getGoodsNumber() > 1) {
			order.setGoodsNumber(order.getGoodsNumber() - 1);
			orderDao.updateOrders(order);
		}
		cartOrderInfo(request, response);
	}
	//对单个订单进行删除操作
	public void deleteOrder(HttpServletRequest request, HttpServletResponse response) {
		int id = 0;
		id = Integer.valueOf(request.getParameter("id").trim());
		OrderGoods orderGoods = orderGoodsDao.getOrderGoodsObjectById(id);
		orderGoodsDao.delete(orderGoods);
		orderDao.deleteOrders(id);
		cartOrderInfo(request, response);
	}
	
	//对选中的checkBox进行删除以及结算操作
	public void getFormInfo(HttpServletRequest request, HttpServletResponse response) {
		Integer orderId = null;
		Integer goodId = null;
		String option = request.getParameter("option");
		System.out.println(option);
		String[] cbStrings = request.getParameterValues("cartCheckBox");
		if (cbStrings!=null) {
			if (option.equals("deleteSelect")) {
				for (String string : cbStrings) {
					orderId = Integer.valueOf(string.toString().trim());
					OrderGoods orderGoods = orderGoodsDao.getOrderGoodsObjectById(orderId);
					orderGoodsDao.delete(orderGoods);
					orderDao.deleteOrders(orderId);
				}
				cartOrderInfo(request, response);
			} else if (option.equals("buyNow")) {
				for (String string : cbStrings) {
					orderId = Integer.valueOf(string.toString().trim());
					Order order = orderDao.getOrderById(orderId);
					goodId = order.getGoodsId();
					OrderGoods orderGoods = new OrderGoods(orderId, goodId);
					orderGoodsDao.save(orderGoods);
					order.setOrderStatus("已付款");
					Goods goods = goodsDao.selGoodsById(orderGoods.getGoodsId());
					order.setOrderPayMoney(order.getGoodsNumber() * goods.getPrice());
					orderDao.updateOrders(order);
					paytOrderInfo(request, response);
				}
			}
		}else {
			cartOrderInfo(request, response);
		}
	}
}
