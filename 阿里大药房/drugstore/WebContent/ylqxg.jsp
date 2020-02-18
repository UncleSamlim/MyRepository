<%@page import="cn.yueqian.com.dao.entity.Goods"%>
<%@page import="java.util.List"%>
<%@page import="cn.yueqian.com.dao.entity.GoodsKind"%>
<%@page import="java.util.Map"%>
<%@page import="cn.yueqian.com.dao.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title>阿里健康居家保健-理想生活上天猫</title>
		<link rel="stylesheet" type="text/css" href="css/fkgAndylqxg/alyf.css"/>
		<link rel="stylesheet" type="text/css" href="css/headerAndfooter/header1.css" />
		<link rel="stylesheet" type="text/css" href="css/headerAndfooter/body.css" />
	</head>
	<body>
		<div id="header1">
			<div id="top">
			<%User user = (User)session.getAttribute("user");%>
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
		<%Map<GoodsKind,List<GoodsKind>> ShowKinds = (Map<GoodsKind,List<GoodsKind>>)session.getAttribute("ShowKind");
		Map<GoodsKind,List<Goods>> ShowSuperGoods = (Map<GoodsKind,List<Goods>>)session.getAttribute("ShowSuperGoods");
		Map<GoodsKind,List<Goods>> ShowGoods = (Map<GoodsKind,List<Goods>>)session.getAttribute("ShowGoods");%>
		<div id="container">
			<div class="top">
				
			</div><br />
			<div id="topz">
			<div class="a" align="center"> 
				<ul>
					<li>
				<%for(GoodsKind gk:ShowKinds.keySet()){
				if(gk.getId()==4){
				List<GoodsKind> gsl = ShowKinds.get(gk);
				int q =0;
				for(GoodsKind gkk:gsl){
					q++;
				%>
				<a href="#"><span><%=gkk.getKindName()%></span></a>
					<%if(q==10){%>
					<br /><br />
				<%}}}}%>	
					</li>
				</ul>
			</div>
			
			</div><br />
			<div id="topx" align="center">
				<table border="1">
					<tr>
						<th><img src="img/fkgAndylqxg/1.png"/></th>
						<th><img src="img/fkgAndylqxg/2.png"/></th>
						<th><img src="img/fkgAndylqxg/3.png"/></th>
						<th><img src="img/fkgAndylqxg/4.png"/></th>
						<th><img src="img/fkgAndylqxg/5.png"/></th>
						<th><img src="img/fkgAndylqxg/6.png"/></th>
						<th><img src="img/fkgAndylqxg/7.png"/></th>
						<th><img src="img/fkgAndylqxg/8.png"/></th>
						<th><img src="img/fkgAndylqxg/9.png"/></th>
						
						</tr>
						<tr>
						<th><img src="img/fkgAndylqxg/10.png"/></th>
						<th><img src="img/fkgAndylqxg/11.png"/></th>
						<th><img src="img/fkgAndylqxg/12.png"/></th>
						<th><img src="img/fkgAndylqxg/13.png"/></th>
						<th><img src="img/fkgAndylqxg/14.png"/></th>
						<th><img src="img/fkgAndylqxg/15.png"/></th>
						<th><img src="img/fkgAndylqxg/16.png"/></th>
						
					</tr>
				</table>
				<br />
				<span class="da">健康精选</span><span class="x">为你推荐</span>
				<div class="hx">
					<img src="img/fkgAndylqxg/hx.jpg"/>
				</div>
				<div class="topxx" align="center">
					<a href="#"><img src="img/fkgAndylqxg/topx.18.png" /></a>
					<a href="#"><img src="img/fkgAndylqxg/topx.19.png" /></a>
					<a href="#"><img src="img/fkgAndylqxg/topx.20.png" /></a>
					<a href="#"><img src="img/fkgAndylqxg/topx.21.png" /></a>
					<a href="#"><img src="img/fkgAndylqxg/topx.22.png""></div>
			</div>
			
			<br />
			<div class="nr" align="center">
				<a href="#">————&nbsp;&nbsp;口罩防护&nbsp;&nbsp;————</a>
			</div>
			<br />
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr1.jpg"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr2.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr3.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr4.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr5.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr6.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr7.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr8.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr9.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr10.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr11.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr12.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr13.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr14.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr15.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr16.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr17.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr18.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr19.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr20.png"/></a>
			</div>
			
			<br />
			<div class="nr" align="center">
				<a href="#">————&nbsp;&nbsp;口腔清洁&nbsp;&nbsp;————</a>
			</div>
			<br />
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr21.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr22.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr23.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr24.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr25.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr26.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr27.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr28.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr29.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr30.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr31.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr32.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr33.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr34.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr35.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr36.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr37.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr38.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr39.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr40.png"/></a>
			</div>
			
			<br />
			<div class="nr" align="center">
				<a href="#">————&nbsp;&nbsp;康复按摩&nbsp;&nbsp;————</a>
			</div>
			<br />
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr41.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr42.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr43.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr44.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr45.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr46.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr47.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr48.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr49.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr50.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr51.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr52.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr53.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr54.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr55.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr56.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr57.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr58.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr59.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr60.png"/></a>
			</div>
			
			<br />
			<div class="nr" align="center">
				<a href="#">————&nbsp;&nbsp;身体护理&nbsp;&nbsp;————</a>
			</div>
			<br />
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr61.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr62.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr63.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr64.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr65.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr66.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr67.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr68.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr69.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr70.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr71.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr72.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr73.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr74.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr75.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr76.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr77.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr78.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr79.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr80.png"/></a>
			</div>
			
			<br />
			<div class="nr" align="center">
				<a href="#">————&nbsp;&nbsp;环境消毒&nbsp;&nbsp;————</a>
			</div>
			<br />
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr81.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr82.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr83.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr84.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr85.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr86.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr87.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr88.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr89.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr90.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr91.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr92.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr93.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr94.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr95.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr96.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr97.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr98.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr99.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr100.png"/></a>
			</div>
			
						<br />
			<div class="nr" align="center">
				<a href="#">————&nbsp;&nbsp;家庭保健&nbsp;&nbsp;————</a>
			</div>
			<br />
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr101.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr102.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr103.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr104.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr105.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr106.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr107.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr108.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr109.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr110.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr111.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr112.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr113.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr114.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr115.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr116.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr117.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr118.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr119.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr120.png"/></a>
			</div>
			
			<br />
			<div class="nr" align="center">
				<a href="#">————&nbsp;&nbsp;急救消毒&nbsp;&nbsp;————</a>
			</div>
			<br />
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr121.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr122.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr123.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr124.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr125.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr126.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr127.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr128.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr129.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr130.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr131.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr132.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr133.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr134.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr135.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr136.png"/></a>
			</div>
			
			<div id="nr1" align="center">
				<a href="#"><img src="img/fkgAndylqxg/nr137.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr138.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr139.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr140.png"/></a>
			</div>
			
			<br />
			<div class="nr" align="center">
				<a href="#">————&nbsp;&nbsp;健身测重&nbsp;&nbsp;————</a>
			</div>
			<br />
			<div id="nr1" align="center"">
				<a href="#"><img src="img/fkgAndylqxg/nr141.png"/></a>
				<a href="#"><img src="img/fkgAndylqxg/nr142.png"/></a>
			</div>
			
		</div>
<iframe src="footer.html" width="100%" height="268px" scrolling="no" frameborder="0" style="z-index: 20;"></iframe>
			
	</div>
	</body>
</html>