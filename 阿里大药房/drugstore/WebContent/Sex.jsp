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
		<title>这是一个成人计生馆</title>
		<script type="text/javascript" src="js/haiwaiAndsex/jquery-1.8.3.min.js" ></script>
		<link rel="stylesheet" href="css/haiwaiAndsex/page.css" />
				<link rel="stylesheet" type="text/css" href="css/headerAndfooter/header1.css" />
		<link rel="stylesheet" type="text/css" href="css/headerAndfooter/body.css" />
		<script type="text/javascript">
			
			
			
		</script>
		
	</head>
	<body>
	<%Map<GoodsKind,List<GoodsKind>> ShowKinds = (Map<GoodsKind,List<GoodsKind>>)session.getAttribute("ShowKind");
	Map<GoodsKind,List<Goods>> ShowSuperGoods = (Map<GoodsKind,List<Goods>>)session.getAttribute("ShowSuperGoods");
	Map<GoodsKind,List<Goods>> ShowGoods = (Map<GoodsKind,List<Goods>>)session.getAttribute("ShowGoods"); %>
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
		<div class="header" align="center">
				<!--<iframe id="" src="header2.html" width=100% height=100% frameborder="0" scrolling="no"></iframe>-->
			</div>
		<div id="OverAll">
			
			<div class="top" align="center">
				<img src="img/haiwaiAndsex/top.png" />
			</div>
			<br />
			<div class="hot" align="center">
				<span>——&nbsp;&nbsp;健康热销&nbsp;&nbsp;爆款尖货&nbsp;&nbsp;——</span>
				<div class="bj01"></div>
				</div>
				
			<div id="sp">
				<div class="hot">
					<br />
					<img src="img/haiwaiAndsex/zdb.jpg" width="155px" height="155px"/>
					<img src="img/haiwaiAndsex/jsb.jpg" width="155px" height="155px"/>
					<img src="img/haiwaiAndsex/dls.jpg" width="155px" height="155px"/>
					<img src="img/haiwaiAndsex/yuting.jpg" width="155px" height="155px"/>
					</a><img src="img/haiwaiAndsex/dls01.jpg" width="155px" height="155px"/>

				</div>
				<div class="hots">
					<a href="#"><img src="img/haiwaiAndsex/gm02.png"/></a>
					<a href="#"><img src="img/haiwaiAndsex/gm01.png"/></a>
					<a href="#"><img src="img/haiwaiAndsex/gm03.png"/></a>
					<a href="#"><img src="img/haiwaiAndsex/gm03.png"/></a>
					<a href="#"><img src="img/haiwaiAndsex/gm04.png"/></a>
				</div>
			</div>
			
			<br />
			<div class="hot" align="center" >
				<span>——&nbsp;&nbsp;品牌推荐&nbsp;&nbsp;——</span>
				<div class="bj01"></div>
				</div>
				<div id="bg">
				<table border="1"> 
					<tr>
						<th><a href="#"><img src="img/haiwaiAndsex/tj_jsb.png"/></a></th>
						<th><a href="#"><img src="img/haiwaiAndsex/tj_dls.png"/></a></th>
						<th><a href="#"><img src="img/haiwaiAndsex/tj_gb.png"/></a></th>
						<th><a href="#"><img src="img/haiwaiAndsex/tj_dlg.png"/></a></th>
						<th><a href="#"><img src="img/haiwaiAndsex/tj_fyj.png"/></a></th>
						<th><a href="#"><img src="img/haiwaiAndsex/tj_yt.png"/></a></th>
						<th><a href="#"><img src="img/haiwaiAndsex/tj_xiuer.png"/></a></th>
						<th><a href="#"><img src="img/haiwaiAndsex/tj_jinxiuer.png"/></a></th>
						<th><a href="#"><img src="img/haiwaiAndsex/tj_kl.png"/></a></th>
					</tr>
				
				</table>
		</div>
		<br />
		<div class="hot" align="center" >
				<span>——&nbsp;&nbsp;TT专区&nbsp;&nbsp;——</span>
				<div class="bj01"></div>
				</div>
				<div id="TT">
				<div class="ttcj">
					<br />
					<a href="#"><img src="img/haiwaiAndsex/tt_dls01.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/tt_dls01.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/tt_dls01.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/tt_dls01.png" width="240px" height="360px"/></a>
					

				</div>
				<div class="ttcj">
					<br />
					<a href="#"><img src="img/haiwaiAndsex/tt_gb02.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/tt_gb02.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/tt_gb02.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/tt_gb02.png" width="240px" height="360px"/></a>

				</div>
				
				<div class="ttcj">
					<br />
					<a href="#"><img src="img/haiwaiAndsex/tt_yt03.png"  width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/tt_yt03.png"  width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/tt_yt03.png"  width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/tt_yt03.png"  width="240px" height="360px"/></a>

				</div>
				
				<div class="ttcj">
					<br />
					<a href="#"><img src="img/haiwaiAndsex/tt_jsb04.png"  width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/tt_jsb04.png"  width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/tt_jsb04.png"  width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/tt_jsb04.png"  width="240px" height="360px"/></a>

				</div>
				
				<div class="ttcj">
					<br />
					<a href="#"><img src="img/haiwaiAndsex/tt_dlg05.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/tt_dlg05.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/tt_dlg05.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/tt_dlg05.png" width="240px" height="360px"/></a>

				</div>
				
				<br />
				<div class="hot" align="center" >
				<span>——&nbsp;&nbsp;排卵验孕&nbsp;&nbsp;——</span>
				<div class="bj01"></div>
				</div>
				<div id="PL">
				<div class="plyy">
					<br />
					<a href="#"><img src="img/haiwaiAndsex/yy_dw01.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/yy_dw01.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/yy_dw01.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/yy_dw01.png" width="240px" height="360px"/></a>
					

				</div>
				<div class="plyy">
					<br />
					<a href="#"><img src="img/haiwaiAndsex/yy_yt02.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/yy_yt02.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/yy_yt02.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/yy_yt02.png" width="240px" height="360px"/></a>

				</div>
				
				<div class="plyy">
					<br />
					<a href="#"><img src="img/haiwaiAndsex/yy_jinxiuer03.png"  width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/yy_jinxiuer03.png"  width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/yy_jinxiuer03.png"  width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/yy_jinxiuer03.png"  width="240px" height="360px"/></a>

				</div>
				
				<br />
				<div class="hot" align="center" >
				<span>——&nbsp;&nbsp;润滑剂&nbsp;&nbsp;——</span>
				<div class="bj01"></div>
				</div>
				<div id="YH">
				<div class="rhj">
					<br />
					<a href="#"><img src="img/haiwaiAndsex/yh_dls01.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/yh_dls01.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/yh_dls01.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/yh_dls01.png" width="240px" height="360px"/></a>
					

				</div>
				
				<br />
				<div class="hot" align="center" >
				<span>——&nbsp;&nbsp;情趣用品&nbsp;&nbsp;——</span>
				<div class="bj01"></div>
				</div>
				<div id="QQ">
				<div class="qqyp">
					<br />
					<a href="#"><img src="img/haiwaiAndsex/qq_dls01.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/qq_dls01.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/qq_dls01.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/qq_dls01.png" width="240px" height="360px"/></a>
					

				</div>
				<div class="qqyp">
					<br />
					<a href="#"><img src="img/haiwaiAndsex/qq_fyj02.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/qq_fyj02.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/qq_fyj02.png" width="240px" height="360px"/></a>
					<a href="#"><img src="img/haiwaiAndsex/qq_fyj02.png" width="240px" height="360px"/></a>

				</div>
				
				
				
		</div>
		<br />
		<div id="footer">
		<iframe src="footer.html" width="100%" height="268px" scrolling="no" frameborder="0" style="z-index: 20;"></iframe>
		</div>
	</body>
</html>
