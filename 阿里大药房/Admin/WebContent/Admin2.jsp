<%@page import="java.util.List"%>
<%@page import="cn.tocean.com.dao.entity.User"%>
<%@page import="cn.tocean.com.utils.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>后台管理</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<meta name="renderer" content="webkit">

<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="icon" type="image/png" href="assets/i/favicon.png">

<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">

<meta name="apple-mobile-web-app-title" content="Amaze UI" />

<link rel="stylesheet" href="assets/css/amazeui.min.css"/>

<link rel="stylesheet" href="assets/css/admin.css">

<script src="assets/js/jquery.min.js"></script>

<script src="assets/js/app.js"></script>
			<style type="text/css">
			body{
				text-align: center;
			}
			th,tr{
				width: 100px;
				height: 50px;
			}
			table{
			margin: auto;
			}
		</style>
</head>
<body>
<header class="am-topbar admin-header">
  <div class="am-topbar-brand"><img src="assets/i/logo.png"></div>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
    <ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">

   <li class="am-dropdown tognzhi" data-am-dropdown>
  <button class="am-btn am-btn-primary am-dropdown-toggle am-btn-xs am-radius am-icon-bell-o" data-am-dropdown-toggle> 消息管理<span class="am-badge am-badge-danger am-round">6</span></button>
  <ul class="am-dropdown-content">
  	
  	
  	
    <li class="am-dropdown-header">所有消息都在这里</li>

    

    <li><a href="#">未激活会员 <span class="am-badge am-badge-danger am-round">556</span></a></li>
    <li><a href="#">未激活代理 <span class="am-badge am-badge-danger am-round">69</span></a></a></li>
    <li><a href="#">未处理汇款</a></li>
    <li><a href="#">未发放提现</a></li>
    <li><a href="#">未发货订单</a></li>
    <li><a href="#">低库存产品</a></li>
    <li><a href="#">信息反馈</a></li>
    
    
    
  </ul>
</li>

 <li class="kuanjie">
 	
 	<a href="#">会员管理</a>          
 	<a href="#">奖金管理</a> 
 	<a href="#">订单管理</a>   
 	<a href="#">产品管理</a> 
 	<a href="#">个人中心</a> 
 	 <a href="#">系统设置</a>
 </li>

 <li class="soso">
 	
<p>   
	
	<select data-am-selected="{btnWidth: 70, btnSize: 'sm', btnStyle: 'default'}">
          <option value="b">全部</option>
          <option value="o">产品</option>
          <option value="o">会员</option>
          
        </select>

</p>

<p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="圆角表单域" /></p>
<p><button class="am-btn am-btn-xs am-btn-default am-xiao"><i class="am-icon-search"></i></button></p>
 </li>
      <li class="am-hide-sm-only" style="float: right;"><a href="AdminCancellationServlet">退出登录</a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main"> 

<div class="nav-navicon admin-main admin-sidebar">
    
    
    <div class="sideMenu am-icon-dashboard" style="color:#aeb2b7; margin: 10px 0 0 0;"> 欢迎系统管理员</div>
    <div class="sideMenu">
      <h3 class="am-icon-flag"><em></em> <a href="PageServlet">商品管理</a></h3>
      <h3 class="am-icon-cart-plus"><em></em> <a href="#"> 用户管理</a></h3>
    </div>
    <!-- sideMenu End --> 
    
    <script type="text/javascript">
			jQuery(".sideMenu").slide({
				titCell:"h3", //鼠标触发对象
				targetCell:"ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
				effect:"slideDown", //targetCell下拉效果
				delayTime:300 , //效果时间
				triggerTime:150, //鼠标延迟触发时间（默认150）
				defaultPlay:true,//默认是否执行效果（默认true）
				returnDefault:true //鼠标从.sideMen移走后返回默认状态（默认false）
				});
		</script>   
</div>

<div class=" admin-content">
	
		<div class="daohang">
			<ul>
				<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs"> 首页 </li>
				<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">帮助中心<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
				<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">奖金管理<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
				<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">产品管理<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
		
			</ul>

</div>

<div class="admin">

   <div class="admin-index">
		<%			
		Page<User> userList = (Page<User>)session.getAttribute("pageEmp");
		String condition  = (String)session.getAttribute("condition");
		int Count = userList.getCount();
		int CountPage = userList.getCurrentPage();
		int TotalPages = userList.getTotalPages();
		if(userList==null){
			response.sendRedirect("UserServlet?action=page");
			return ;
		} %>
		<form action="UserServlet?action=page" method="post">
		<input type="text" name="condition">
		<input type="submit" value="搜素">
		<table border="" cellspacing="" cellpadding="">
			<tr>
				<th>用户编码</th>
				<th>用户名</th>
				<th>用户密码</th>
				<th>真实姓名</th>
				<th>年龄</th>
				<th>性别</th>
				<th>联系方式</th>
				<th>收获地址</th>
				<th>操作</th>
			</tr>		
			<%
			List<User> users = userList.getList();
			for(User u:users){%>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getName()%></td>
				<td><%=u.getPwd()%></td>
				<td><%=u.getRealname()%></td>
				<td><%=u.getAge()%></td>
				<td><%=u.getSex()%></td>
				<td><%=u.getPhone()%></td>
				<td><%=u.getAddress()%></td>
				<td><a href="UserServlet?action=initUpdate&id=<%=u.getId()%>" >修改</a>&nbsp<a href="UserServlet?action=delete&id=<%=u.getId()%>" onclick="return confirm ('确定删除用户信息吗')">删除</a></td>
			</tr>
			<%}
			%>
		</table>
		<a href="UserServlet?action=page&currentPage=1&condition=<%=condition%>">首页</a>
		<a href="UserServlet?action=page&currentPage=<%=CountPage-1<1?1:CountPage-1%>&condition=<%=condition%>">上一页</a>
		<%for(int i=5;i>=1;i--){
			if(CountPage-i>=1){%>
				<input type="button" value="<%=CountPage-i%>"  onclick="window.location.href='UserServlet?action=page&currentPage=<%=CountPage-i%>&condition=<%=condition%>'">
			<%}
		}			%>
		<input type="submit" value="<%=CountPage%>" style="background-color: darkgrey;">
		<%for(int i=1;i<=5;i++){
			if(CountPage+i<=TotalPages){%>
				<input type="button" value="<%=CountPage+i%>" onclick="window.location.href='UserServlet?action=page&currentPage=<%=CountPage+i%>&condition=<%=condition%>'">
			<%}
		}			%>
		<a href="UserServlet?action=page&currentPage=<%=CountPage+1>TotalPages?TotalPages:CountPage+1%>&condition=<%=condition%>">下一页</a>
		<a href="UserServlet?action=page&currentPage=<%=TotalPages%>&condition=<%=condition%>">尾页</a>
		<span><%=CountPage%>/<%=TotalPages %>&nbsp</span><span>总跳数:&nbsp<%=Count%></span>
		</form>
    </div>

</div>

<script src="assets/js/amazeui.min.js"></script>


</body>
</html>