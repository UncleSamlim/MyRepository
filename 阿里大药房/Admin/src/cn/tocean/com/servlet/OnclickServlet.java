package cn.tocean.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tocean.com.dao.IOrderDao;
import cn.tocean.com.dao.impl.OrderDaoImpl;

@WebServlet("/OnclickServlet")
public class OnclickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IOrderDao orderDao = new OrderDaoImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String idStr = request.getParameter("id");
		int id  = Integer.valueOf(idStr);
		int isDel = orderDao.fahuo(id);
		if(isDel>0){
			System.out.println("成功");
			out.write("<script type=\"text/javascript\">"+
			"alert(\"修改成功\");"+
			"window.location.href=\"PageServlet\";"+
		"</script>");
		}else{
			System.out.println("失败了");
			out.write("<script type=\"text/javascript\">"+
			"alert(\"修改失败\");"+
			"window.location.href=\"PageServlet\";"+
		"</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
