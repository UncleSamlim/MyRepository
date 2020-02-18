package cn.yueqian.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yueqian.com.dao.UserDao;
import cn.yueqian.com.dao.entity.User;
import cn.yueqian.com.dao.impl.UserDaoImpl;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	UserDao ud=new  UserDaoImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
				//编码格式
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				//取得已经登录的user信息
				User user = (User)request.getSession().getAttribute("user");
				//接收参数
				String realname = request.getParameter("realname");
				String phone =request.getParameter("phone");
				String address =request.getParameter("address");
				
				//只能修改三个参数+更新用的索引ID
				user.setId(user.getId());
				user.setRealname(realname);;
				user.setPhone(phone);
				user.setAddress(address);
				int rows=ud.update(user);
				if(rows>0){
					request.getSession().setAttribute("user", user);
					out.write("<script type=\"text/javascript\">"+
					"alert(\"修改成功\");"+
					"window.location.href=\"UserServlet?action=InitIndex\";"+
				"</script>");
				}else{
					out.write("<script type=\"text/javascript\">"+
							"alert(\"修改失败\");"+
							"window.location.href=\"UserServlet?action=InitIndex\";"+
						"</script>");
				}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}
