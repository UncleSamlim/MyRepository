<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@page import="cn.yueqian.com.dao.entity.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>淘宝购物车页面</title>
    <link href="css/myPayOrders.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="css/headerAndfooter/header1.css" />
	<link rel="stylesheet" type="text/css" href="css/headerAndfooter/body.css" />
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/myCart.js"></script>
	
	
</head>
<body>
<div id="header1">
			<%User user = (User)session.getAttribute("user");%>
			<div id="top">
				<div class="wrap">
					<p><img src="img/header1/icon1.png" /><a href="index.jsp">阿里药房首页</a></p>
					<p id="header_p"><span>喵，欢迎来天猫</span><%if(user==null){%><a href="login.jsp">请登录</a><%}else{%><a>欢迎您! ${user.name}</a><a href="LogoutServlet">注销</a><%}%><a href="register.jsp">免费注册</a></p>
		
					<ul>
						<li class="list myTaobao" style="position: relative;"><a href="">我的淘宝<i></i></a>
							<div id="menu1"><a href="OrderServlet?action=paytOrderInfo">查看宝贝订单</a><a href="ToUpdateServlet">修改个人信息</a></div>
						</li>
						<li>
							<div></div><a href="OrderServlet?action=cartOrderInfo">购物车</a>
						</li>
						<li class="list favorites" style="position: relative;"><a href="">收藏夹<i></i></a>
							<div id="menu2"><a href="">收藏的宝贝</a><a href="">收藏的店铺</a></div>
						</li>
						<li></li>
						<li class="phone">
							<div></div><a href="">手机版</a>
							<div id="menu3"><img src="img/header1/Qr_code.png" alt=""></div>
						</li>
						<li><a href="">淘宝网</a></li>
						<li class="list support"><a href="">商家支持<i></i></a>
							<div id="menu4">
								<ul>
									<li><span>商家：</span></li>
									<li><a href="">商家中心</a><a href="">天猫规则</a></li>
									<li><a href="">商家入驻</a><a href="">运营服务</a></li>
									<li><a href="">商家品控</a><a href="">商家工具</a></li>
									<li><a href="">天猫智库</a><a href="">喵言喵语</a></li>
								</ul>
								<ul class="help">
									<li><span>帮助：</span></li>
									<li><a href="">帮助中心</a><a href="">问商友</a></li>
								</ul>
							</div>
						</li>
						<li class="list navigation">
							<div></div>
							<a href="">网站导航<i></i></a>
							<div id="menu5">
								<div class="card">
									<p class="cTitle">热点推荐Hot</p>
									<ul>
										<li>
											<a href="">天猫超市</a>
											<a href="">喵鲜生</a>
											<a href="">科技新品</a>
											<a href="">女装新品</a>
											<a href="">酷玩街</a>
										</li>
										<li>
											<a href="">内衣新品</a>
											<a href="">试美妆</a>
											<a href="">运动新品</a>
											<a href="">时尚先生</a>
											<a href="">精明妈咪</a>
										</li>
										<li>
											<a href="">吃乐会</a>
											<a href="">企业采购</a>
											<a href="">会员积分</a>
											<a href="">天猫国际</a>
											<a href="">品质频道</a>
										</li>
									</ul>
								</div>
								<div class="card">
									<p class="cTitle">行业市场Market</p>
									<ul class="Market">
										<li>
											<a href="">美妆</a>
											<a href="">电器</a>
											<a href="">女装</a>
											<a href="">男装</a>
											<a href="">女鞋</a>
										</li>
										<li>
											<a href="">男鞋</a>
											<a href="">内衣</a>
											<a href="">箱包</a>
											<a href="">运动</a>
											<a href="">母婴</a>
										</li>
										<li>
											<a href="">家装</a>
											<a href="">医药</a>
											<a href="">食品</a>
											<a href="">配饰</a>
											<a href="">汽车</a>
										</li>
									</ul>
								</div>
								<div class="helpCard">
									<p class="cTitle">服务指南Help</p>
									<ul>
										
										<li>
											<a href="">帮助中心</a>
											<a href="">品质保障</a>
										</li>
										<li>
											<a href="">特色服务</a>
											<a href="">7天退换货</a>
										</li>
									</ul>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div id="header_body">
				<div class="wrap">
					<a href="">
						<div class="logo">
						</div>
					</a>
					<div class="seach">
						<form action="search.html" method="">
							<input type="text" name="" id="" value="" placeholder="搜索本店商品" style="height: 30px;"/>
							<input type="submit" id="" name="" value="" />
						</form>
		
					</div>
					<div class="fragment">
						<ul>
							<li><img src="img/header1/icon5.png"> <span>自营正品</span></li>
							<li><img src="img/header1/icon6.png"> <span>担保交易</span></li>
							<li><img src="img/header1/icon7.png"> <span>满88包邮</span></li>
							<li><img src="img/header1/icon8.png"> <span>药师服务</span></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
<div id="nav">您的位置：<a href="#">首页</a> &gt; <a href="#">我的淘宝</a> &gt; <a href="OrderServlet?action=cartOrderInfo">我的购物车</a> &gt; 我的历史订单</div>
<div id="navlist">
    <ul>
        <li class="navlist_red_left"></li>
        <li class="navlist_red">1. 查看购物车</li>
        <li class="navlist_red_arrow"></li>
        <li class="navlist_gray">2. 确认订单信息</li>
        <li class="navlist_gray_arrow"></li>
        <li class="navlist_gray">3. 付款到支付宝</li>
        <li class="navlist_gray_arrow"></li>
        <li class="navlist_gray">4. 确认收货</li>
        <li class="navlist_gray_arrow"></li>
        <li class="navlist_gray">5. 评价</li>
        <li class="navlist_gray_right"></li>
    </ul>
</div>

<div id="content" style="height: 650px">
	<form action="" method="post" name="myform">
    	<table width="100%" border="0" cellspacing="0" cellpadding="0" id="shopping">        
            <tr>
                <td class="title_1">交易时间</td>
                <td class="title_2" colspan="2">店铺宝贝</td>
                <td class="title_3">获积分</td>
                <td class="title_4">单价（元）</td>
                <td class="title_5">数量</td>
                <td class="title_6">支付</td>
                <td class="title_7">地址</td>
            </tr>
            <tr>
                <td colspan="8" class="line"></td>
            </tr>
           <c:if test="${sessionScope.payOrderObjectlist==null}">
					<jsp:forward page="OrderServlet?action=paytOrderInfo"></jsp:forward>
				</c:if>
				<c:forEach items="${sessionScope.payOrderObjectlist}"
					var="payOrderObject">
					<tr id="product1">
						<td class="cart_td_1">${payOrderObject.orderDate}</td>

						<!-- 图片路径尚未设置！！！！！！！！！！！！！！！！！1 -->
						<td class="cart_td_2"><img src="img/imgTest.jpg" style="height: 45px;width: 45px"
							alt="shopping" /></td>
						<td class="cart_td_3"><a href="#">${payOrderObject.goodesName}</a><br />
							保障：<img src="images/taobao_icon_01.jpg" alt="icon" /></td>
						<td class="cart_td_4">${payOrderObject.catscore}</td>
						<td class="cart_td_5">${payOrderObject.goodesPrice}</td>

						<td class="cart_td_6">${payOrderObject.goodsNumber}</td>
						<td class="cart_td_7">${payOrderObject.orderPayMoney}</td>
						<td class="cart_td_8">${payOrderObject.orderDestination}</td>
					</tr>

				</c:forEach>
                 
    	</table>
    </form>

</div>
<iframe src="footer.html" width="100%" height="268px" scrolling="no" frameborder="0" style="z-index: 20;"></iframe>
</body>
</html>
