package cn.tocean.com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.tocean.com.dao.UserDao;
import cn.tocean.com.dao.entity.User;
import cn.tocean.com.dao.impl.UserDaoImpl;
import cn.tocean.com.service.UserService;
import cn.tocean.com.service.impl.UserServiceImpl;
import cn.tocean.com.utils.Page;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();
	
	public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean isMulti = ServletFileUpload.isMultipartContent(request);
		  	 String id = null;
			 String name = null;
			 String pwd = null;
			 String realname = null;
			 String age = null;
			 String sex = null;
			 String phone = null;
			 String address = null;
			 String lasttime = null;
			 String onlyFileName = null;
		if(isMulti) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> items = upload.parseRequest(request);
				for(FileItem fileItem : items) {
					boolean isFormFile = fileItem.isFormField();
					if(isFormFile) {
						String inputName = fileItem.getFieldName();
						if(inputName.equals("Id")) {
							id = fileItem.getString("utf-8") ;
						}
						if(inputName.equals("Name")) {
							name = fileItem.getString("utf-8");
						}
						if(inputName.equals("Pwd")) {
							pwd = fileItem.getString("utf-8");	
						}
						if(inputName.equals("Realname")) {
							realname = fileItem.getString("utf-8");
						}
						if(inputName.equals("Age")) {
							age = fileItem.getString("utf-8");	
						}
						if(inputName.equals("Sex")) {
							sex = fileItem.getString("utf-8");
						}
						if(inputName.equals("Phone")) {
							phone = fileItem.getString("utf-8");
						}
						if(inputName.equals("Address")) {
							address = fileItem.getString("utf-8");
						}
						if(inputName.equals("Lasttime")) {
							lasttime = fileItem.getString("utf-8");
						}
						
					}else {
						String fileName  =fileItem.getName();
						String extendName = fileName.substring(fileName.lastIndexOf("."),fileName.length());
						String uuid = UUID.randomUUID().toString();
						onlyFileName = uuid+extendName;
						String serverPath = this.getServletContext().getRealPath("/upload");
						File file =  new File(serverPath,onlyFileName);
						try {
							fileItem.write(file);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PrintWriter out = response.getWriter();
		User user = new User();
		user.setId(Integer.valueOf(id));
		user.setName(name);
		user.setPwd(pwd);
		user.setRealname(realname);
		user.setAge(Integer.valueOf(age));
		user.setSex(sex);
		user.setPhone(phone);
		user.setAddress(address);
		user.setLasttime(Date.valueOf(lasttime));
		int isAdd = userService.add(user);
		if(isAdd==1) {
			
				out.write("<script type=\"text/javascript\">\r\n" + 
						"		alert(\"添加成功！！！\");\r\n" + 
						"window.location.href='EmployeeServlet?action=listAll'" +
						"	</script>");
		}else {
				out.write("<script type=\"text/javascript\">\r\n" + 
						"		alert(\"添加失败！！！\");\r\n" + 
						"window.location.href='EmployeeServlet?action=listAll'" +
						"	</script>");
		}
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		int id=Integer.valueOf(request.getParameter("id"));
		
		String serverPath = this.getServletContext().getRealPath("/upload");
		
		int isDelete=userService.deleteById(id);
		
		if (isDelete==1) {
			out.write("<script type=\"text/javascript\">\r\n" + 
					"		alert(\"删除成功！！！\");\r\n" + 
					"window.location.href='UserServlet?action=page'" +
					"	</script>");
		}else {
			out.write("<script type=\"text/javascript\">\r\n" + 
					"		alert(\"删除失败！！！\");\r\n" + 
					"window.location.href='UserServlet?action=page'" +
					"	</script>");
		}
	}
	public void initUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		UserDao userDao = new UserDaoImpl();
		String idStr = request.getParameter("id");
		User updateUser = (User)userDao.selById(Integer.parseInt(idStr));
		HttpSession session = request.getSession();
		session.setAttribute("updateUser", updateUser);
		response.sendRedirect("Update.jsp");
	}
	
	
	
	
	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
	  	 String id = null;
		 String name = null;
		 String pwd = null;
		 String realname = null;
		 String age = null;
		 String sex = null;
		 String phone = null;
		 String address = null;
		 String lasttime = null;
		 id = request.getParameter("uid");
		 name = request.getParameter("uname");
		 pwd = request.getParameter("upwd");
		 realname = request.getParameter("urealname");
		 age = request.getParameter("uage");
		 sex = request.getParameter("usex");
		 phone = request.getParameter("uphone");
		 address = request.getParameter("uaddress");
		 lasttime = request.getParameter("ulasttime");
		User user = new User();
		user.setId(Integer.valueOf(id));
		user.setName(name);
		user.setPwd(pwd);
		user.setRealname(realname);
		user.setAge(Integer.valueOf(age));
		user.setSex(sex);
		user.setPhone(phone);
		user.setAddress(address);
		user.setLasttime(Date.valueOf(lasttime));
		int isAdd = userService.update(user);
		if(isAdd>0) {
				out.write("<script type=\"text/javascript\">\r\n" + 
						"		alert(\"修改成功！！！\");\r\n" + 
						"window.location.href='UserServlet?action=page'" +
						"	</script>");
		}else {
				out.write("<script type=\"text/javascript\">\r\n" + 
						"		alert(\"修改失败！！！\");\r\n" + 
						"window.location.href='Update.jsp'" +
						"	</script>");
		}
	}
	
	
	public void page(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String condition = request.getParameter("condition");
		if (condition==null||condition.equals("")) {
			condition="";
		} 
		String currentPageStr = request.getParameter("currentPage");
		if (currentPageStr==null||currentPageStr.equals("")) {
			currentPageStr="1";
		}
		int currentPage = Integer.valueOf(currentPageStr);
		int pageSize = 3;
		Page<User> pageEmp = userService.getPages(condition, currentPage, pageSize);
		HttpSession session = request.getSession();
		session.setAttribute("pageEmp", pageEmp);
		session.setAttribute("condition", condition);
		response.sendRedirect("Admin2.jsp?condition="+condition);
	}
}
