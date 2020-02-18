<%@page import="cn.yueqian.com.dao.entity.Goods"%>
<%@page import="java.util.List"%>
<%@page import="cn.yueqian.com.dao.entity.GoodsKind"%>
<%@page import="java.util.Map"%>
<%@page import="cn.yueqian.com.dao.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title></title>
</head>
<style type="text/css">
	.header {
		font-size: 60px;
	}
	
	.all {
		background-color: yellow;
		background: url(img/muyingAndbaojian/otherimg/2b21d178b403f34bcb49386f37c926a.png);
	}
	
	.top_pic {
		width: 1920px;
		height: 150px;
		background-color: ;
		text-align: center;
	}
	
	.center_pic {
		height: 405;
		width: 1920px;
		background-color: white;
	}
	
	.center_pic_box{
		
		height: 404px;
		width: 1500px;
		background-color: white;
		text-align: center;
		line-height: 404px;
		margin: 0 auto;
	}
	.pic {
		position: relative;
		top: 2px;
	}
	
	.title {
		height: 37px;
		background-color: #F7970C;
	}
	
	.title_text {
		color: white;
		text-align: center;
		line-height: 10px;
		position: relative;
		top: 8px;
	}
	
	.things {
		width: 990px;
		height:720px;
		margin: 0 auto;
	}
	/*.showthing {
			width: 990px;
			height: 340px;
			position: relative;
			left: 240px;
			top: -270px;
		}*/
	
	/*.things {
		height: 289px;
		background-color: #FFC1C2;
		position: relative;
		float: left;
	}*/
	
	.titletsext {
		background-color: #FFC1C2;
		height: 50px;
		margin: 0px;
		padding: 0px;
		font-size: 22px;
		line-height: 50px;
		background-color: white;
	}
	
	.titledetails {
		font-size: 14px;
	}
	
	.blackline {
		height: 4px;
		width: 990px;
		background-color: black;
	}
	
	#whitelin {
		height: 1px;
		width: 990px;
		background-color: white;
		position: relative;
		top: 273px;
	}
	
	.realthings {
		width: 196px;
		height: 272.6px;
		border: 1px solid white;
		border-top: hidden;
	}
	
	.last {
		border-right: hidden;
	}
	
	.thingspic {
		position: relative;
		top: 20px;
		left: 20px;
		width: 155px;
		height: 156px;
	}
	
	.price {
		width: 87px;
		height: 22px;
		position: relative;
		top: -100px;
		font-size: 20px;
		color: red;
	}
	
	#yuan {
		color: red;
		font-size: 14px;
	}
	
	.sold {
		width: 87px;
		height: 22px;
		position: relative;
		top: -140px;
		left: 125px;
		font-size: 12px;
		color: gray;
	}
	
	.buy {
		border: 1px solid red;
		width: 102px;
		height: 33.6px;
		position: relative;
		top: -150px;
		left: 45px;
		font-size: 20px;
		line-height: 33.6px;
		text-align: center;
		color: red;
	}
	
	.shownewthing {
		width: 990px;
		height: 840px;
		/*background-color: #FFEDF0;*/
		position: relative;
		top: -270px;
		left: 240px;
	}
	
	.newthingstitle {
		height: 80px;
		width: 990px;
		border: 1px solid red;
	}
	
	#pinkline {
		height: 30px;
		width: 990px;
		background-color: #FFC1C2;
		position: relative;
		top: -5px;
	}
	
	.shownewthing_border {
		width: 245px;
		height: 356px;
		border: 5px solid #F7970C;
		position: relative;
		top: -5px;
		background-color: white;
		float: left;
	}
	
	.left_top {
		border-left: hidden;
		border-top: hidden;
	}
	
	.top {
		width: 250px;
		border-top: hidden;
	}
	
	.right_top {
		border-right: hidden;
		border-top: hidden;
	}
	
	.left {
		border-left: hidden;
	}
	
	.right {
		border-right: hidden;
	}
	
	.left_bottom {
		border-left: hidden;
		border-bottom: hidden;
	}
	
	.bottom {
		width: 250px;
		border-bottom: hidden;
	}
	
	.right_bottom {
		border-right: hidden;
		border-bottom: hidden;
	}
	
	.newthingspic {
		width: 240px;
		height: 240px;
	}
	
	.newthingsdetails {
		width: 240px;
		height: 30px;
		border: 1px solid #FFEDF0;
		position: relative;
		top: -5px;
		border-top: hidden;
		border-right: hidden;
		border-left: hidden;
	}
	
	.newthingsdetails_text {
		overflow: hidden;
		height: 12px;
		color: #ff697d;
		text-align: center;
		line-height: 14px;
		font-size: 11px;
		text-overflow: ellipsis;
		white-space: nowrap;
		font-weight: 700;
		position: relative;
		top: 10px;
		
	}
	
	.pic_price {
		width: 240px;
		height: 55px;
		position: relative;
		top: 0px;
	}
	
	.pic_price .pic {
		width: 70px;
		height: 35px;
		position: relative;
		top: 20px;
		left: 10px;
	}
	
	.pic_price .price {
		width: 138px;
		height: 48px;
		position: relative;
		top: -35px;
		left: 100px;
	}
	
	.oprice {
		color: grey;
		font-size: 12px;
		height: 20px;
		position: relative;
		top: 10px;
		text-align: right;
		left: -10px;
	}
	/*.odoller{
			color: grey;
			font-size: 12px;
			height: 5px;
		}
		
		.onum{
			color: grey;
			font-size: 12px;
			height: 5px;
		}*/
	
	.nprice {
		color: red;
		font-size: 12px;
		font-weight: 700;
		height: 20px;
		position: relative;
		top: px;
		text-align: right;
		left: -10px;
	}
	
	.ndoller {
		font-size: 15px;
		position: relative;
		/*top: 5px;*/
	}
	
	.nnum {
		color: red;
		font-size: 15px;
		font-weight: 700;
	}
	
	.buynow {
		width: 230px;
		height: 30px;
		position: relative;
		top: 48px;
		text-align: center;
		background-color: red;
		position: relative;
		left: 5px;
		/*top: 1px;*/
	}
	
	.buynowtext {
		color: white;
		font-weight: 700;
		line-height: 30px;
	}
	
	.er{
		position: relative;
		left: 255px;
		top: 2px;
	}
	
	.floay{
		width: 100px;
		height: 100px;
	}
	
	.float_pic{
		width: 100px;
		height: 100px;
	}
</style>
<link rel="stylesheet" type="text/css" href="css/muyingAndbaojian/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/headerAndfooter/header1.css" />
		<link rel="stylesheet" type="text/css" href="css/headerAndfooter/body.css" />
<script src="js/muyingAndbaojian/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/muyingAndbaojian/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<body>
	<div class="float">
	<a style="position: fixed;right: 40px;bottom: 200px;z-index: 11">
		<img class="float_pic" src="img/muyingAndbaojian/TB1uNOtCntYBeNjy1XdXXXXyVXa-147-147.png" />
	</a>
	</div>
	<div id="header1">
			<div id="top">
				<div class="wrap">
				<%User user = (User)session.getAttribute("user");%>
					<p><img src="img/header1/icon1.png" /><a href="index.jsp">阿里药房首页</a></p>
					<p id="header_p"><span>喵，欢迎来天猫</span><%if(user==null){%><a href="login.jsp">请登录</a><%}else{%><a>欢迎您! ${user.name}</a><a href="LogoutServlet">注销</a><%}%><a href="register.jsp">免费注册</a></p>
		
					<ul>
						<li class="list myTaobao" style="position: relative;"><a href="">我的淘宝<i></i></a>
							<div id="menu1"><a href="OrderServlet?action=paytOrderInfo">查看宝贝订单</a><a href="">修改个人信息</a></div>
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
							<input type="text" name="" id="" value="" placeholder="搜索本店商品" style="height: 36px"/>
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
	<div class="all">
		<div class="top_pic">
			<img src="img/muyingAndbaojian/otherimg/TB1SIwQgxrI8KJjy0FpXXb5hVXa-990-150.png"/>
		</div>
		<div class="center_pic">
			<div class="center_pic_box">
			<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="1000">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img class="er" src="img/muyingAndbaojian/otherimg/TB1_PK6j49YBuNjy0FfXXXIsVXa-990-400.jpg_q60.jpg" alt="...">
						<div class="carousel-caption">
						</div>
					</div>
					<div class="item">
						<img  class="er" src="img/muyingAndbaojian/TB1eyGOkTJYBeNjy1zeXXahzVXa-990-400.jpg_q60.jpg" alt="...">
						<div class="carousel-caption">
							
						</div>
					</div>
					<div class="item">
						<img  class="er" src="img/muyingAndbaojian/TB1VaXNj3mTBuNjy1XbXXaMrVXa-990-400.jpg_q60.jpg" alt="...">
						<div class="carousel-caption">
							
						</div>
					</div>
				</div>

				<!-- Controls -->
				
			</div>		
			</div>
		</div>

		<%  Map<GoodsKind,List<GoodsKind>> ShowKinds = (Map<GoodsKind,List<GoodsKind>>)session.getAttribute("ShowKind");
			Map<GoodsKind,List<Goods>> ShowSuperGoods = (Map<GoodsKind,List<Goods>>)session.getAttribute("ShowSuperGoods");
			Map<GoodsKind,List<Goods>> ShowGoods = (Map<GoodsKind,List<Goods>>)session.getAttribute("ShowGoods"); %>
		<%for(GoodsKind g:ShowKinds.keySet()){ 
		if(g.getId()==3){
			for(GoodsKind gkk:ShowKinds.get(g)){
		%>
		<div class="title">
		<p class="title_text"> --<%=gkk.getKindName()%> --</p>
		</div>
		<div class="things">
			<!--<div class="shownewthing nffs">-->
			<!--<img src="img/muyingAndbaojian/TB1iNxlSFXXXXcUaXXXSutbFXXX.jpg" />-->
			<!--<div id="pinkline"></div>-->
			<%int s =0;
			for(Goods ggg:ShowGoods.get(gkk)){
			s++;
			if(s>8){
				continue;
			}%>
			<a href="UserServlet?action=InitCommodity&GoodsId=<%=ggg.getId()%>">
				<div class="shownewthing_border left_top">
					<img class="newthingspic" src="img/<%=ggg.getPic()%>" />
					<div class="newthingsdetails">
						<p class="newthingsdetails_text">
							<%=ggg.getName()%>
						</p>
						<div class="pic_price">

							<img class="pic" src="img/muyingAndbaojian/sign4.png" />
							<div class="price">
								<p class="oprice">
									专柜价
									<span class="odoller">
                       					￥
                       				</span>
									<s><span class="onum">
                       					<%=ggg.getPreviousPrice()%>
                       				</span></s>
								</p>

								<p class="nprice">
									活动价
									<span class="ndoller">
                       					￥
                       				</span>
									<span class="nnum">
                       					<%=ggg.getPrice()%>
                       				</span>
								</p>
							</div>
						</div>
					</div>
					<div class="buynow">
						<span class="buynowtext">
							立即购买 ⊹
						</span>
					</div>
				</div>
			</a><%} %>
			<!--</div>-->
		</div>
<%}}} %>		
	</div>
			<iframe src="footer.html" width="100%" height="268px" scrolling="no" frameborder="0" style="z-index: 20;"></iframe>
</body>

</html>