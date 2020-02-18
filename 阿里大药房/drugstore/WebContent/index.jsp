<%@page import="cn.yueqian.com.dao.entity.User"%>
<%@page import="cn.yueqian.com.dao.entity.Goods"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Map"%>
<%@page import="cn.yueqian.com.dao.entity.GoodsKind"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/headerAndfooter/body.css" />
		<link rel="stylesheet" type="text/css" href="css/headerAndfooter/header1.css" />
		<link rel="stylesheet" type="text/css" href="css/index/index.css" />
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	</head>
	<body>
		<%if(session.getAttribute("ShowGoods")==null){
			response.sendRedirect("UserServlet?action=InitIndex");
		}
		User user = (User)session.getAttribute("user");%>
		<div id="header1">
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

		<div class="wrap bd">
			<div class="allclass">
				<span>全部商品分类</span>
			</div>
			<ul class="title">
				<li><a href="UserServlet?action=InitHaiwai">海外自营馆</a></li>
				<li><a href="fkg.jsp">妇科馆</a></li>
				<li><a href="UserServlet?action=InitBaojian">保健滋补馆</a></li>
				<li><a href="ylqxg.jsp">医疗器械馆</a></li>
				<li><a href="muying.jsp">母婴馆</a></li>
				<li><a href="Sex.jsp">成人计生馆</a></li>
			</ul>
		</div>
		<div class="hr"></div>
		<div class="cnt">
			<div class="wrap">
				<div class="products_nav">
					<ul class="nav">
					<%
					Map<GoodsKind,List<GoodsKind>> ShowKinds = (Map<GoodsKind,List<GoodsKind>>)session.getAttribute("ShowKind");
					Map<GoodsKind,List<Goods>> ShowSuperGoods = (Map<GoodsKind,List<Goods>>)session.getAttribute("ShowSuperGoods");
					Map<GoodsKind,List<Goods>> ShowGoods = (Map<GoodsKind,List<Goods>>)session.getAttribute("ShowGoods");
					int mapcount =0;
					for(GoodsKind key:ShowKinds.keySet()){
						mapcount++;
						String path ="";
						int sign=key.getId();
						if(sign==1){
							path ="UserServlet?action=InitHaiwai";
						}else if(sign==2){
							path ="fkg.jsp";
						}
						else if(sign==3){
							path ="UserServlet?action=InitBaojian";
						}
						else if(sign==4){
							path ="ylqxg.jsp";
						}
						else if(sign==5){
							path ="muying.jsp";
						}else{
							path ="Sex.jsp";
						}
						if(mapcount<=5){
					%>
											 
						<li>
							<div class="icon">
								<img src="img/index/p_icon<%=mapcount%>.png"><a href="<%=path%>"><%=key.getKindName()%></a>
							</div>
							<div class="nav_class">
								<%	
									int listcount =0;
									for(GoodsKind g:ShowKinds.get(key)){
										listcount++;
									if(listcount<=3){
								%>
								<a href=""><%=g.getKindName() %></a>/
								<%}} %>
							</div>
						</li>
						
					<%}}
					%>
					</ul>
				</div>
				<div class="adv_show">
					<a href="UserServlet?action=InitCommodity&GoodsId=1759"><img src="img/index/ad.jpg"></a>
				</div>
				<div class="adv2">
					<a href="UserServlet?action=InitCommodity&GoodsId=1759"><img src="img/index/adv2.png"></a>
				</div>
				<div class="hot">
				<p>— 热门推荐 —</p>
				<%   int mapcountt =0;
					for(GoodsKind gsk:ShowGoods.keySet()){
						mapcountt++;
						if(mapcountt<=6){
							List<Goods> goodsList = ShowGoods.get(gsk);
							/*为了防止某二级分类专区下没有四个以上商品时，出现索引越界（没有四个时，直接找下一个二级分类专区）*/
							if(goodsList.size()<4){
								mapcountt--;
								continue;
							}
							if(mapcountt==1||mapcountt==3||mapcountt==5){%>						
					<div class="column">
						<%}%>
						<div class="row">
							<div class="left">
								<img src="img/index/adv<%=mapcountt+2%>.jpg">
							</div>
							<div class="right">
								<p><%=gsk.getKindName()%></p>
								<p>世界如此美好...</p>
								<div class="recommended">
								<%for(int i=0;i<=3;i++){				
									%>
									<a href="UserServlet?action=InitCommodity&GoodsId=<%=goodsList.get(i).getId()%>"><img src="img/<%=goodsList.get(i).getPic()%>"></a>
								<%}%>
								</div>
							</div>
						</div>
						<%if(mapcountt==2||mapcountt==4||mapcountt==6){ %>
					</div>		
					<%}}}%>
				</div>
				<div class="imported_goods">
				<%for(GoodsKind gsk:ShowKinds.keySet()){
				List<GoodsKind> glist =ShowKinds.get(gsk);
				List<Goods> glist2 = null;
				/*为了同时遍历两个MAP，KEY值为对象，两个MAP的KEY值的属性相同*/
				for(GoodsKind gk :ShowSuperGoods.keySet()){
					if(gk.getKindName().equals(gsk.getKindName())){
						glist2 = ShowSuperGoods.get(gk);
					}
				}
				%>
					<p>— <%=gsk.getKindName()%> —</p>
					<div class="mb">
						<div class="left">
							<h4><%=gsk.getKindName()%></h4>
							<p>健康自营 品质保障</p>
							<a href=""><img src="img/index/adv9.png"></a>
							<div class="tags"> 
							<%int j=0;
							for(GoodsKind gk :glist){
							j++;
							if(j<=6){%>
								<a href=""><%=gk.getKindName()%></a>
							<%}}%>							
							</div>
						</div>
						<div class="mid">
						<%for(int k=0;k<7;k++){ 
						if(k==0){%>			
								<a class="item  first" href="UserServlet?action=InitCommodity&GoodsId=<%=glist2.get(k).getId()%>">
						<%}else{ %>
							<a class="item" href="UserServlet?action=InitCommodity&GoodsId=<%=glist2.get(k).getId()%>">
							<%} %>
								<div class="img"><img src="img/<%=glist2.get(k).getPic()%>"></div>
								<div class="info">
									<p style="display: block;width:118px;height:20px;overflow: hidden;">
									<%=glist2.get(k).getName()%></p>
									<div class="price">
										<span class="new-price">
											¥<%=glist2.get(k).getPrice()%>
										</span>
										<span class="old-price">
											¥<%=glist2.get(k).getPreviousPrice()%>
										</span>
									</div>
								</div>
							</a>											
						<%}%>


						</div>
						<div class="right">
							<div class="title">
								<p>热卖品牌</p>
							</div>
							<div class="rmb">
								<a href="">
									<div class="img">
										<img src="img/index/brand1.png" >
									</div>
									<span>善存</span>
								</a>
								<a href="" class="second-list">
									<div class="img">
										<img src="img/index/brand2.png" >
									</div>
									<span>佐藤</span>
								</a>
								<a href="">
									<div class="img">
										<img src="img/index/brand3.png" >
									</div>
									<span>冈本</span>
								</a>
								<a href="" class="second-list">
									<div class="img">
										<img src="img/index/brand4.png" >
									</div>
									<span>双心</span>
								</a>
								<a href="">
									<div class="img">
										<img src="img/index/brand5.png" >
									</div>
									<span>参天</span>
								</a>
								<a href="" class="second-list">
									<div class="img">
										<img src="img/index/brand6.png" >
									</div>
									<span>sweisse</span>
								</a>
								<a href="">
									<div class="img">
										<img src="img/index/brand7.png" >
									</div>
									<span>Blackmores</span>
								</a>
								<a href="" class="second-list">
									<div class="img">
										<img src="img/index/brand8.png" >
									</div>
									<span>Bioisland</span>
								</a>
							</div>
						</div>
					</div>			
				<%}%>
				</div>
			</div>
		</div>
		<iframe src="footer.html" width="100%" height="270px" frameborder="none"></iframe>
	</body>
</html>
