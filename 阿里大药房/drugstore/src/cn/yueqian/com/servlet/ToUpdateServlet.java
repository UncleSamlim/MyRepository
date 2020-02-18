package cn.yueqian.com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yueqian.com.dao.entity.User;

@WebServlet("/ToUpdateServlet")
public class ToUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			User user = (User)request.getSession().getAttribute("user");
			if(user!=null){
				response.sendRedirect("update.jsp");
			}else{
				response.sendRedirect("login.jsp");
			}
			}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
