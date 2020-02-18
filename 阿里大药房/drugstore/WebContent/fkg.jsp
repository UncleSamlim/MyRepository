<%@page import="cn.yueqian.com.dao.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>阿里健康-妇科专题</title>
		<link rel="stylesheet" type="text/css" href="css/fkgAndylqxg/fkg.css"/>
		<link rel="stylesheet" type="text/css" href="css/headerAndfooter/header1.css" />
		<link rel="stylesheet" type="text/css" href="css/headerAndfooter/body.css" />
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
							<input type="text" name="" id="" value="" placeholder="搜索本店商品" />
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
		<div id="container">
			<div class="t1">
				<img src="img/fkgAndylqxg/fk1.png"/>
			</div>
			<div class="t2">
				<img src="img/fkgAndylqxg/fk2.png"/>
			</div>
			<div class="t3">
				<img src="img/fkgAndylqxg/fk3.png"/>
			</div>
			<div class="t4">
				<img src="img/fkgAndylqxg/fk4.png"/>
			</div>
			<div id="nr" align="center">
				<a href="#"><img src="img/fkgAndylqxg/fk5.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk6.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk7.png"/></a>
			</div>
			
			<div class="t4">
				<img src="img/fkgAndylqxg/fk8.png"/>
			</div>
			<div id="nr" align="center">
				<a href="#"><img src="img/fkgAndylqxg/fk9.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk10.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk11.png"/></a>
			</div>
			
			<div class="t4">
				<img src="img/fkgAndylqxg/fk12.png"/>
			</div>
			<div id="nr" align="center">
				<a href="#"><img src="img/fkgAndylqxg/fk13.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk14.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk15.png"/></a>
			</div>
			
			<div class="t4">
				<img src="img/fkgAndylqxg/fk16.png"/>
			</div>
			<div id="nr" align="center">
				<a href="#"><img src="img/fkgAndylqxg/fk17.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk18.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk19.png"/></a>
			</div>
			
			<div class="t4">
				<img src="img/fkgAndylqxg/fk20.png"/>
			</div>
			<div id="nr" align="center">
				<a href="#"><img src="img/fkgAndylqxg/fk21.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk22.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk23.png"/></a>
			</div>
			
			<div class="t4">
				<img src="img/fkgAndylqxg/fk24.png"/>
			</div>
			<div id="nr" align="center">
				<a href="#"><img src="img/fkgAndylqxg/fk25.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk26.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk27.png"/></a>
			</div>
			
			<div class="t4">
				<img src="img/fkgAndylqxg/fk28.png"/>
			</div>
			<div id="nr" align="center">
				<a href="#"><img src="img/fkgAndylqxg/fk29.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk30.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk31.png"/></a>
			</div>
			
			<div class="t4">
				<img src="img/fkgAndylqxg/fk32.png"/>
			</div>
			<div id="nr" align="center">
				<a href="#"><img src="img/fkgAndylqxg/fk33.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk34.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk35.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk36.png"/></a>
			</div>
			<div id="nr" align="center">
				<a href="#"><img src="img/fkgAndylqxg/fk37.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk38.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk39.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk40.png"/></a>
			</div>
			<div id="nr" align="center">
				<a href="#"><img src="img/fkgAndylqxg/fk41.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk42.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk43.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk44.png"/></a>
			</div>
			<div id="nr" align="center">
				<a href="#"><img src="img/fkgAndylqxg/fk45.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk46.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk47.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk48.png"/></a>
			</div>
			<div id="nr" align="center">
				<a href="#"><img src="img/fkgAndylqxg/fk49.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk50.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk51.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk52.png"/></a>
			</div>
			<div id="nr" align="center">
				<a href="#"><img src="img/fkgAndylqxg/fk53.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk54.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk55.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk56.png"/></a>
			</div>
			<div id="nr" align="center">
				<a href="#"><img src="img/fkgAndylqxg/fk57.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk58.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk59.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk60.png"/></a>
			</div>
			<div id="nr" align="center">
				<a href="#"><img src="img/fkgAndylqxg/fk61.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk62.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk63.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk64.png"/></a>
			</div>
			<div id="nr" align="center">
				<a href="#"><img src="img/fkgAndylqxg/fk65.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk66.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk67.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk68.png"/></a>
			</div>
			<div id="nr" align="center">
				<a href="#"><img src="img/fkgAndylqxg/fk69.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk70.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk71.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/fk72.png"/></a>
			</div>
			<div class="t4">
				<img src="img/fkgAndylqxg/fk73.png"/>
			</div>
			<div class="t4">
				<img src="img/fkgAndylqxg/fk74.png"/>
			</div>
		</div>
<iframe src="footer.html" width="100%" height="268px" scrolling="no" frameborder="0" style="z-index: 20;"></iframe>
	</body>
</html>
