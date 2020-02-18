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
		<meta charset="UTF-8">
		<title></title>
	</head>
	<style type="text/css">
		body{
			
			background-color: #FFC1C2;
		}
		#all {
			width: 1500px;
			height: 2000px;
			margin: 0 auto;
		}
		
		#BB {
			width: 1000px;
			height: 921px;
			background: url(img/muyingAndbaojian/BB.jpg) no-repeat;
			position: relative;
			left: 240px;
		}
		
		#choise {
			width: 1000px;
			height: 160px;
			position: relative;
			top: -300px;
			left: 240px;
		}
		
		.list {
			list-style: none;
			float: left;
		}
		
		.lpic {
			width: 240px;
			height: 160px;
		}
		
		.yc {
			background-color: #F181AA;
			position: relative;
			top: -16px;
			left: -40px;
		}
		
		.mm {
			background-color: #4EC8F8;
			position: relative;
			top: -16px;
			left: -30px;
		}
		
		.xy {
			background-color: #77c950;
			position: relative;
			top: -16px;
			left: -20px;
		}
		
		.zy {
			background-color: #F181AA;
			position: relative;
			top: -16px;
			left: -10px;
		}
		
		.test {
			color: white;
		}
		
		.btext {
			font-size: 20px;
			position: absolute;
			top: 30px;
			left: 15px;
		}
		
		.stext {
			font-size: 12px;
			position: absolute;
			top: 60px;
			left: 15px;
		}
		
		.bor {
			color: white;
			width: 30px;
			height: 19.6px;
			border: 1px solid white;
			position: absolute;
			bottom: 30px;
			left: 20px;
			text-align: center;
			font-size: 16px;
			line-height: 18px;
			padding: 0 10px;
			border-radius: 10px;
		}
		
		.pic {
			position: absolute;
			top: 30px;
			right: 12px;
			width: 110px;
			height: 110px;
		}
		
		#keyword {
			width: 990px;
			height: 80px;
			position: relative;
			top: -300px;
			left: 240px;
		}
		
		#hotlist {
			width: 180px;
			height: 80px;
		}
		
		#word {
			width: 810px;
			height: 80px;
			position: relative;
			top: -80px;
			left: 180px;
			background-color: #FFEDF0;
			border: 1px solid #FFC1C2;
		}
		
		.wordstyle {
			list-style: none;
			width: 82px;
			height: 22px;
			border: 1px solid darkgray;
			text-align: center;
			font-size: 12px;
			line-height: 20px;
			border-radius: 10px;
			float: left;
		}
		
		a {
			text-decoration: none;
			color: black;
		}
		
		#sign {
			width: 990px;
			height: 169px;
			background: white;
			position: relative;
			top: -280px;
			left: 240px;
			border: 1px solid #FFC1C2;
		}
		
		#signul {
			margin: 0px;
			padding: 0px;
			display: inline-block;
			position: relative;
			height: 169px;
			top: -53px;
			left: 8px;
		}
		
		#all #sign #signul .signli {
			list-style: none;
			float: left;
			border: 1px solid darkgray;
			width: 95px;
			height: 70px;
			margin: 0px;
			padding: 0px;
			text-align: center;
			line-height: 90px;
		}
		
		.signpic {
			width: 70px;
			height: 35px;
		}
		
		.showthing {
			width: 990px;
			height: 340px;
			position: relative;
			left: 240px;
			top: -270px;
		}
		
		.things {
			height: 289px;
			background-color: #FFC1C2;
			position: relative;
			float: left;
		}
		
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
		
		.last_f {
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
			background-color: #FFEDF0;
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
			width: 240px;
			height: 356px;
			border: 5px solid #FFEDF0;
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
			border-right: hidden;
			border-left: hidden;
		}
		
		.newthingsdetails_text {
			overflow: hidden;
			height: 12px;
			color: #ff697d;
			text-align: center;
			line-height: 10px;
			font-size: 11px;
			text-overflow: ellipsis;
			white-space: nowrap;
			font-weight: 700;
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
			top: 10px;
			left: 5px;
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
			top: -9px;
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
			top: -20px;
			text-align: right;
			left: -10px;
		}
		
		.ndoller {
			font-size: 15px;
		}
		
		.nnum {
			color: red;
			font-size: 15px;
			font-weight: 700;
		}
		
		.buynow {
			width: 240px;
			height: 30px;
			position: relative;
			top: 48px;
			text-align: center;
			background-color: #FF8E8F;
		}
		
		.buynowtext {
			color: white;
			font-weight: 700;
			line-height: 30px;
		}
		
		.float{
			position: fixed;
			right: 150px;
			bottom: 100px;
			z-index: 11;
			width: 94px;
		}
		
		.float_pic_div{
		background-color: #cc7272;
		height: 100px;
		
	}
		
		
		.float_pic{
		width: 78px;
		height: 78px;
		position: relative;
		left: 8px;
		top: 10px;
	}
	
	.side{
		width: 95px;
		height: 24.8px;
		color: white;
		background-color: #FF8F8E;
		font-size: 12px;
		position: relative;
		top: -12px;
		line-height: 24.8px;
		/*float: left;*/
		margin: 0px;
	}
	
	.fris{
		background-color: #663939
	}
	
	.last{
		width: 95px;
		height: 24.8px;
		color: white;
		background-color: #FF8F8E;
		font-size: 12px;
		position: relative;
		top: -12px;
		line-height: 24.8px;
		/*float: left;*/
		margin: 0px;
		text-align: center;
		color: #FFBEBD;
	}
	
	.changecolor{
		background-color: #663939;
	}
	
	</style>
	<link rel="stylesheet" type="text/css" href="css/headerAndfooter/header1.css" />
	<link rel="stylesheet" type="text/css" href="css/headerAndfooter/body.css" />
	<script src="js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(function() {
			$(".wordstyle").hover(function() {
				$(this).find("a").css("color", "white")
			}, function() {
				$(this).find("a").css("color", "black")
			})
			$(".side").hover(function(){
				$(this).addClass("changecolor")
			},function(){
				$(this).removeClass("changecolor")
			})
		})
	</script>

	<body>
		<div class="float">
			<div class="float_pic_div">
				<img class="float_pic" src="img/muyingAndbaojian/TB1l6FNSFXXXXX6XFXXwu0bFXXX.png"/>
			</div>
			<a href=""><p class="side fris">
				&nbsp;&nbsp;奶粉辅食
			</p></a>
			<a href=""><p class="side">
				&nbsp;&nbsp;孕产健康
			</p></a>
			<a href=""><p class="side">
				&nbsp;&nbsp;尿裤湿布
			</p></a>
			<a href=""><p class="side">
				&nbsp;&nbsp;奶瓶餐具
			</p></a>
			<a href=""><p class="side">
				&nbsp;&nbsp;清洁护肤
			</p></a>
			<a href=""><p class="side">
				&nbsp;&nbsp;妈妈用品
			</p></a>
			<a href=""><p class="side">
				&nbsp;&nbsp;奶瓶消毒
			</p></a>
			<a href=""><p class="side">
				&nbsp;&nbsp;车床寝具
			</p></a>
			<a href=""><p class="side">
				&nbsp;&nbsp;母婴药品
			</p></a>
			<a href=""><p class=" last">
				&nbsp;&nbsp;▲
			</p></a>
			<a href="#">
				<p class=" last">回到顶部</p>
			</a>
		</div>
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
							<input type="text" name="" id="" value="" placeholder="搜索本店商品" style="height: 30px"/>
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
		<div id="all">
			<div id="BB"></div>
			<div id="choise">
				<ul>
					<li class="list">
						<a href="">
							<div class="lpic yc">
								<div class="test">
									<span class="btext">孕产营养</span><br />
									<span class="stext">孕育聪明健康宝宝</span>
								</div>
								<div class="bor go">
									Go
								</div>
								<img class="pic" src="img/muyingAndbaojian/nf.png" />
							</div>
						</a>
					</li>
					<li class="list">
						<a href="">
							<div class="lpic mm">
								<div class="test">
									<span class="btext">妈妈用品</span><br />
									<span class="stext">产前产后妈妈用品</span>
								</div>
								<div class="bor go">
									Go
								</div>
								<img class="pic" src="img/muyingAndbaojian/mmyp.png" />
							</div>
						</a>
					</li>
					<li class="list">
						<a href="">
							<div class="lpic xy">
								<div class="test">
									<span class="btext">洗浴护肤</span><br />
									<span class="stext">保护宝宝娇嫩肌肤</span>
								</div>
								<div class="bor go">
									Go
								</div>
								<img class="pic" src="img/muyingAndbaojian/xyhf.png">
							</div>
						</a>
					</li>
					<li class="list">
						<a href="">
							<div class="lpic zy">
								<div class="test">
									<span class="btext">专业喂养</span><br />
									<span class="stext">更适合宝宝的奶瓶</span>
								</div>
								<div class="bor go">
									Go
								</div>
								<img class="pic" src="img/muyingAndbaojian/zywy.png" />
							</div>
						</a>
					</li>
				</ul>
			</div>
			<div id="keyword">
				<div id="hotlist">
					<img src="img/muyingAndbaojian/gjc.png" />
					<%Map<GoodsKind,List<GoodsKind>> ShowKinds = (Map<GoodsKind,List<GoodsKind>>)session.getAttribute("ShowKind");
					Map<GoodsKind,List<Goods>> ShowSuperGoods = (Map<GoodsKind,List<Goods>>)session.getAttribute("ShowSuperGoods");
					Map<GoodsKind,List<Goods>> ShowGoods = (Map<GoodsKind,List<Goods>>)session.getAttribute("ShowGoods"); %>
				</div>
				<div id="word">
					<ul>
										<%for(GoodsKind gk:ShowKinds.keySet()){
				if(gk.getId()==5){
				List<GoodsKind> gsl = ShowKinds.get(gk);
				int q =0;
				for(GoodsKind gkk:gsl){
					q++;
				%>
						<li class="wordstyle ">
							<a href=""><%=gkk.getKindName() %></a>
						</li></span></a>
					<%if(q>=20){
						break;
					}}}}%>

					</ul>
				</div>
			</div>
			<div id="sign">
				<ul id="signul">
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign1.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign2.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign3.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign4.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign5.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign6.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign7.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign8.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign9.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign10.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign11.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign12.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign13.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign14.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign15.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign16.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign17.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign18.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign19.png" /></a>
					</li>
					<li class="signli">
						<a href=""><img class="signpic" src="img/muyingAndbaojian/sign20.png" /></a>
					</li>
				</ul>
			</div>
			
			<div class="showthing rmtj">
				<p class="titletsext">
					热卖推荐
					<span class="titledetails">阿里直营！品质精选！价格优惠！妈咪宝贝更健康！</span>
				</p>
				<div class="blackline">

				</div>
				<%GoodsKind gsk =null;
				for(GoodsKind gk:ShowKinds.keySet()){
				if(gk.getId()==5){
				gsk=gk;
				int q=0;
				List<Goods> gl = ShowSuperGoods.get(gk);
				for(Goods g : gl){
				q++;
				if(q<=5){ %>
				<a href="UserServlet?action=InitCommodity&GoodsId=<%=g.getId()%>">
					<div class="things">
						<div class="realthings">
							<img class="thingspic" src="img/<%=g.getPic() %>" />
						</div>
						<p class="price">
							<span id="yuan">
								￥
							</span><%=g.getPrice() %></p>
						<p class="sold">月销:<%=g.getSaleamount() %>件</p>
						<p class="buy">立即购买</p>
					</div>
				</a>
				<%}}}}%>
				<div id="whitelin">
				</div>
			</div>
			
			<div class="shownewthing nffs">
				<img src="img/muyingAndbaojian/TB1iNxlSFXXXXcUaXXXSutbFXXX.jpg" />
				<div id="pinkline"></div>
				<%List<Goods> gl = ShowSuperGoods.get(gsk);
				for(Goods g :gl){%>
				<a href="UserServlet?action=InitCommodity&GoodsId=<%=g.getId()%>">
					<div class="shownewthing_border left_top">
						<img class="newthingspic" src="img/<%=g.getPic()%>" />
						<div class="newthingsdetails">
							<p class="newthingsdetails_text">
								<%=g.getName()%>
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
                       					<%=g.getPreviousPrice()%>
                       				</span></s>
									</p>

									<p class="nprice">
										活动价
										<span class="ndoller">
                       					￥
                       				</span>
										<span class="nnum">
                       					<%=g.getPrice()%>
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
				</a>
				<%} %>

			</div>
		</div>
		<iframe src="footer.html" width="100%" height="268px" scrolling="no" frameborder="0" style="z-index: 20;"></iframe>
	</body>

</html>