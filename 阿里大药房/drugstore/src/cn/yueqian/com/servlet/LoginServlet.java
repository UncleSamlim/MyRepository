package cn.yueqian.com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yueqian.com.dao.UserDao;
import cn.yueqian.com.dao.entity.User;
import cn.yueqian.com.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao ud=new UserDaoImpl();
	User user= new User();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
				
	
	
		//通过getParameter方法获取到表单数据
		User user= new User();
		user.setName(request.getParameter("uesrname"));
		user.setPwd(request.getParameter("password"));
		List<User> list = ud.find(user);
		if(list.size()>0){
			user =list.get(0);
			 HttpSession session = request.getSession();
	            //把用户数据保存在session对象中
	            session.setAttribute("user",user);
	          
			response.sendRedirect("UserServlet?action=InitIndex");
		}else{
			response.sendRedirect("login.jsp?error=yes");

		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
