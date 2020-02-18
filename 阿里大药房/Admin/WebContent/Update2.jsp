<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ page import="java.util.List" %>
 <%@ page import="cn.tocean.com.dao.entity.*" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>修改员工信息</title>
		<style type="text/css">
			input[type="reset"]{
				margin-left: 15px;
			}
			input[type="submit"]{
				width: 200px;
				margin-left: 30px;
			}
			select{
				width: 173px;
				height: 21px;
			}
			input[type="date"]{
				width: 168px;
				height: 17px;
			}
			#empNo{
			pointer-events: none;
			pointer-events: none;
    		opacity: 0.5;
			}
		</style>
		<script type="text/javascript">
			
		</script>
	</head>
	<body>
			<%User user = (User)session.getAttribute("updateUser");%>
			<form action="UserServlet?action=update" method="post">
			<table border="" cellspacing="2" cellpadding="5" style="margin: auto;margin-top: 50px;">
			<tr><th colspan="2">修改员工信息</th></tr>
			<tr><td>用户编码</td><td><input type="text" name="uid" id="empNo" value="<%=user.getId() %>" readonly="true"/></td></tr>
			<tr><td>用户名</td><td><input type="text" name="uname" id="" value="<%=user.getName() %>" /></td></tr>
			<tr><td>密码</td><td><input type="text" name="upwd" id="" value="<%=user.getPwd() %>" /></td></tr>
			<tr><td>真实姓名</td><td><input type="text" name="urealname" id="" value="<%=user.getRealname()%>" /></td></tr>
			<tr><td>年龄</td><td><input type="text" name="uage" id="" value="<%=user.getAge()%>" /></td></tr>
			<tr><td>性别</td><td><input type="text" name="usex" id="" value="<%=user.getSex()%>" /></td></tr>
			<tr><td>联系方式</td><td><input type="text" name="uphone" id="" value="<%=user.getPhone()%>" /></td></tr>
			<tr><td>地址</td><td><input type="text" name="uaddress" id="" value="<%=user.getAddress()%>" /></td></tr>
			<tr><td>最后修改时间</td><td><input type="date" name="ulasttime" id="empNo" value="<%=user.getLasttime()%>" /></td></tr>
			<tr><td colspan="2"><input type="submit" name="" id="btn1" value="提交" /><input type="reset" name="" id="btn2" value="重置" /></td></tr>
		</table>
		</form>
	</body>
</html>