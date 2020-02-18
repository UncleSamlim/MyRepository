package cn.tocean.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tocean.com.dao.IOrderDao;
import cn.tocean.com.dao.entity.Order;
import cn.tocean.com.dao.impl.OrderDaoImpl;
import cn.tocean.com.utils.Page;

@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
//		IEmployeeService employeeService = new EmployeeServiceImpl();
		IOrderDao orderDao = new OrderDaoImpl();
		String currentPageStr = req.getParameter("currentPage");
		if(currentPageStr==null||currentPageStr.equals("")){
			currentPageStr="1";
		}
		int currentPage = Integer.valueOf(currentPageStr);
		int pageSize = 3;
		Page<Order> orderList =  orderDao.getPage(currentPage, pageSize);
		HttpSession session =  req.getSession();
		session.setAttribute("orderList", orderList);
		resp.sendRedirect("Admin.jsp");
	}
}
