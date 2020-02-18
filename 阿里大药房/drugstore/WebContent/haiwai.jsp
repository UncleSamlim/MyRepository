<%@page import="cn.yueqian.com.dao.entity.User"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="cn.yueqian.com.dao.entity.Goods"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="cn.yueqian.com.dao.entity.GoodsKind"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<title>这是一个海外旗舰店</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/haiwaiAndsex/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="css/haiwaiAndsex/slider.css" rel="stylesheet" type="text/css" media="all"/>
		<link rel="stylesheet" type="text/css" href="css/headerAndfooter/header1.css" />
		<link rel="stylesheet" type="text/css" href="css/headerAndfooter/body.css" />
<script type="text/javascript" src="js/haiwaiAndsex/jquery-1.7.2.min.js"></script> 
<script type="text/javascript" src="js/haiwaiAndsex/move-top.js"></script>
<script type="text/javascript" src="js/haiwaiAndsex/easing.js"></script>
<script type="text/javascript" src="js/haiwaiAndsex/startstop-slider.js"></script>
</head>
<body>
			<!--<iframe src="header2.html" width="100%" height="160px" scrolling="no" frameborder="0" style="z-index: 10px;"></iframe>-->
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
 <div class="wrap">
	<div class="header">
		<div class="headertop_desc">

		</div>
	
		<div class="header_top">
			<div class="logo">
				<a href="index.html"><img src="images/logo.png" alt="" /></a>
			</div>
			  <div class="cart">
			  
			  		<img src="img/haiwaiAndsex/gj.png" />
			  	   <p>经营主体：<span>阿里健康（香港）科技有限公司</span><div id="dd" class="wrapper-dropdown-2"> 发现全球健康好货
			  	   	<ul class="dropdown">
							<li>广州粤嵌从入门到删库跑路</li>
					</ul></div></p>
					
			  </div>
			  <script type="text/javascript">
			function DropDown(el) {
				this.dd = el;
				this.initEvents();
			}
			DropDown.prototype = {
				initEvents : function() {
					var obj = this;

					obj.dd.on('click', function(event){
						$(this).toggleClass('active');
						event.stopPropagation();
					});	
				}
			}

			$(function() {

				var dd = new DropDown( $('#dd') );

				$(document).click(function() {
					// all dropdowns
					$('.wrapper-dropdown-2').removeClass('active');
				});

			});

		</script>
		<% Map<GoodsKind,List<GoodsKind>> ShowKinds = (Map<GoodsKind,List<GoodsKind>>)session.getAttribute("ShowKind");
					Map<GoodsKind,List<Goods>> ShowSuperGoods = (Map<GoodsKind,List<Goods>>)session.getAttribute("ShowSuperGoods");
					Map<GoodsKind,List<Goods>> ShowGoods = (Map<GoodsKind,List<Goods>>)session.getAttribute("ShowGoods");%>
	 <div class="clear"></div>
  </div>
	<div class="header_bottom">
	     	<div class="menu">
	     		<ul>
			    	<li class="active"><a href="index.jsp">首页</a></li>
			    	<li><a href="">关爱父母</a></li>
			    	<li><a href="">幼婴儿营养</a></li>
			    	<li><a href="">孕妇专区</a></li>
			    	<li><a href="">品牌故事</a></li>
			    	<div class=""></div>
     			</ul>
	     	</div>
	     
	     	<div class="clear"></div>
	     </div>	     
	<div class="header_slide">
			<div class="header_bottom_left">				
				<div class="categories">
				  <ul>
				  	<h3>全明星产品</h3>
				  		<%
				  		for(GoodsKind g : ShowKinds.keySet()){
				  	 	int q = 0;
				  		if(g.getId()==1){
				  		for(GoodsKind gk : ShowKinds.get(g)){	
				  			q++;
				  			if(q<=12){%>
				      <li><a href="#"><%=gk.getKindName()%></a></li>
				      <%}}}}%>
				  </ul>
				</div>					
	  	     </div>
					 <div class="header_bottom_right">					 
					 	 <div class="slider">					     
							 <div id="slider">
			                    <div id="mover">
			                    	<div id="slide-1" class="slide">			                    
									 <div class="slider-img">
									     <a href=""><img src="img/haiwaiAndsex/lb01.png"alt="learn more" /></a>									    
									 </div>

									  <div class="clear"></div>				
				                  </div>	
						             	<div class="slide">
						             		<div class="slider-text">
		                               
									   <div class="features_list">
									   	               
							            </div>
							         
			                   </div>		
						             	 <div class="slider-img">
									     <a href=""><img src="img/haiwaiAndsex/lb02.png" alt="learn more" /></a>
									  </div>						             					                 
									  <div class="clear"></div>				
				                  </div>
				                  <div class="slide">						             	
					                  <div class="slider-img">
									     <a href=""><img src="img/haiwaiAndsex/lb03.png" alt="learn more" /></a>
									  </div>
									  <div class="slider-text">
		                                
									  
							         
					                   </div>	
									  <div class="clear"></div>				
				                  </div>												
			                 </div>		
		                </div>
					 <div class="clear"></div>					       
		         </div>
		      </div>
		   <div class="clear"></div>
		</div>
   </div>
  
 <div class="main">
    <div class="content">
    	<%	for(GoodsKind g : ShowKinds.keySet()){
	  		if(g.getId()==1){
	  		for(GoodsKind gk : ShowKinds.get(g)){
	  		if(ShowGoods.get(gk).size()==0){
	  			continue;
	  		}
	  		%>
	  		   	<div class="content_top">
    		<div class="heading">
    		<h3><%=gk.getKindName()%></h3>
    		</div>
    		<div class="see">
    			<p><a href="#">查看更多</a></p>
    		</div>
    		<div class="clear"></div>
    	</div>
    	
    	
    	
    	
	     <div class="section group">
	     <%int w =0;
	     for(Goods gg:ShowGoods.get(gk)){
	     w++;
	     if(w<=4){
	     %>
	    	 			<div class="grid_1_of_4 images_1_of_4">
					 <a href="UserServlet?action=InitCommodity&GoodsId=<%=gg.getId()%>"><img src="img/<%=gg.getPic()%>" alt="" /></a>
					 <h6><%=gg.getName()%></h6>
					<div class="price-details">
				       <div class="price-number">
							<p><span class="rupees">$<%=gg.getPrice() %></span></p>
					    </div>
					       		<div class="add-cart">								
									<h4><a href="UserServlet?action=InitCommodity&GoodsId=<%=gg.getId()%>">加入购物车</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>
				</div>
	    
	  		<%}}}}}%>
    
 
			

			
			
			
			
    </div>
 </div>
</div>
   <div class="footer">
    </div>
    <script type="text/javascript">
		$(document).ready(function() {			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
    <a href="#" id="toTop"><span id="toTopHover"> </span></a>
		<iframe src="footer.html" width="100%" height="268px" scrolling="no" frameborder="0"></iframe>
</body>
</html>

