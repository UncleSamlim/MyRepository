package cn.yueqian.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yueqian.com.dao.UserDao;
import cn.yueqian.com.dao.entity.User;
import cn.yueqian.com.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao ud=new UserDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		
		request.setCharacterEncoding("utf-8");
		// 解决从服务器端到客户端的乱码处理
		response.setCharacterEncoding("utf-8");
		// 重新设置客户端头部的编码，实现乱码处理
		
		//将表单提交的数据放入user对象
		response.setContentType("text/html; charset=utf-8");
		user.setName(request.getParameter("name"));
		user.setPwd(request.getParameter("password"));
		user.setRealname(request.getParameter("realname"));
		user.setAge(request.getParameter("age"));
		user.setSex(request.getParameter("sex"));
		user.setPhone(request.getParameter("phone"));
		user.setAddress(request.getParameter("address"));
		
		
		
	
		//调用注册方法
		if(ud.add(user)){
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else
			request.getRequestDispatcher("register.jsp").forward(request, response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
