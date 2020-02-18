package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yq.IAdminDao;
import com.yq.entity.Admin;
import com.yq.impl.AdminDaoImpl;


@WebServlet("/AdminLogin")
public class AdminLoginServlet extends HttpServlet {
	
	IAdminDao admin = new AdminDaoImpl();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 	//解决从客户端传到服务器的乱码处理
			request.setCharacterEncoding("utf-8");
			//解决从服务器端到客户端的乱码处理
			response.setCharacterEncoding("utf-8");
			//重新设置客户端头部的编码，实现乱码处理
			response.setContentType("text/html;charset=utf-8");
			
		Admin admins = new Admin();
		admins.setName(request.getParameter("uesrname"));
		admins.setPwd(request.getParameter("password"));
		List<Admin> c = admin.listAll(admins);
		if (c.size()>0) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			response.sendRedirect("PageServlet");
		}else{
			
			response.sendRedirect("AdminLogin.jsp?error=yes");
			//System.out.println("密码错误！");

			//response.sendRedirect("AdminLogin.jsp");



		}
			
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
