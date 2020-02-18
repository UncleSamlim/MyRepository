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
<script type="text/javascript">
	$().ready(
					function() {
						productCount();
						function productCount() {
							var products = $("#shopping").find("tr[id]");
							var zongJia = 0;
							var zongJiFen = 0;
							products.each(function(i, dom) {
								var productTr = $(dom);
								var shuLiang = productTr.children(".cart_td_6")
										.find("input").val();
								var danJia = productTr.children(".cart_td_5")
										.text();
								var xiaoJi = (danJia * 100 * shuLiang) / 100;
								productTr.children(".cart_td_7").text(xiaoJi);
								zongJia += xiaoJi;
								zongJiFen += productTr.children(".cart_td_4")
										.text()
										* shuLiang;
							});
							$("#total").text(zongJia);
							$("#integral").text(zongJiFen);
						}
						$("#allCheckBox").click(
								function() {
									var isChecked = $("#allCheckBox").is(
											":checked");
									$(".cart_td_1").children(
											"[name='cartCheckBox']").attr(
											"checked", isChecked);
								});
						$(".cart_td_1 input[name='cartCheckBox']")
								.click(
										function() {
											var allCheckBoxes = $(".cart_td_1 input[name='cartCheckBox']");
											var sum = allCheckBoxes.size();
											var k = 0;
											for (var i = 0; i < allCheckBoxes.length; i++) {
												if ($(allCheckBoxes[i]).is(
														":checked")) {
													k++;
												}

											}
											if (sum == k) {
												$("#allCheckBox").attr(
														"checked", true);
											} else {
												$("#allCheckBox").attr(
														"checked", false);
											}
										});

						//点击加一
						$(".cart_td_6").find("img[alt='add']").click(
								function() {
									var input = $(this).parent().find("input");
									var value = input.val();
									value++;
									input.val(value);
									productCount();
								});
						//点击减一
						$(".cart_td_6").find("img[alt='minus']").click(
								function() {
									var input = $(this).parent().find("input");
									var value = input.val();
									value--;
									if (value <= 0) {
										value = 1;
									}
									input.val(value);
									productCount();
								});
						//删除操作
						$(".cart_td_8").find("a").click(function() {
							var isYes = window.confirm("确定要删除该商品吗");
							if (isYes) {
								$(this).parent().parent().prev().remove();
								$(this).parent().parent().remove();
								productCount();
							}
						});
						//删除所选操作
						$("#deleteAll")
								.click(
										function() {
											$(this)
													.parent()
													.parent()
													.parent()
													.parent()
													.parent()
													.attr("action",
															"OrderServlet?action=getFormInfo&option=deleteSelect");
											$(this).parent().parent().parent()
													.parent().parent().submit();

										});
					});
</script>
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
	<div id="nav">
		您的位置：<a href="#">首页</a> &gt; <a href="#">我的淘宝</a> &gt; 我的购物车
	</div>
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
		<form action=" OrderServlet?action=getFormInfo&option=buyNow"
			method="post" name="myform" id="goodsform">

			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				id="shopping">
				<tr>
					<td class="title_1"><input id="allCheckBox" type="checkbox"
						value="" />全选</td>
					<td class="title_2" colspan="2">店铺宝贝</td>
					<td class="title_3">获积分</td>
					<td class="title_4">单价（元）</td>
					<td class="title_5">数量</td>
					<td class="title_6">小计（元）</td>
					<td class="title_7">操作</td>
				</tr>

				<tr>
					<td colspan="8" class="line"></td>
				</tr>
				<c:if test="${sessionScope.CartInfoObjectlist==null}">
					<jsp:forward page="OrderServlet?action=cartOrderInfo"></jsp:forward>
				</c:if>
				<c:forEach items="${sessionScope.CartInfoObjectlist}"
					var="CarInfoObject">
					<tr id="product1">
						<td class="cart_td_1"><input name="cartCheckBox"
							type="checkbox" class="" value="${CarInfoObject.orderId}" /></td>

						<!-- 图片路径尚未设置！！！！！！！！！！！！！！！！！1 -->
						<td class="cart_td_2"><img src="img/imgTest.jpg" style="height: 45px;width: 45px"
							alt="shopping" /></td>
						<td class="cart_td_3"><a href="#">${CarInfoObject.goodesName}</a><br />
							保障：<img src="images/taobao_icon_01.jpg" alt="icon" /></td>
						<td class="cart_td_4">${CarInfoObject.catscore}</td>
						<td class="cart_td_5">${CarInfoObject.goodesPrice}</td>

						<td class="cart_td_6"><a
							href="OrderServlet?id=${CarInfoObject.orderId}&action=minus"><img
								src="images/taobao_minus.jpg" alt="minus" class="hand" /></a> <input
							id="num_1" type="text" value="${CarInfoObject.goodsNumber}"
							class="num_input" readonly="readonly" /> <a
							href="OrderServlet?id=${CarInfoObject.orderId}&action=add"><img
								src="images/taobao_adding.jpg" alt="add" class="hand" /></a></td>
						<td class="cart_td_7"></td>
						<td class="cart_td_8"><a
							href="OrderServlet?id=${CarInfoObject.orderId}&action=deleteOrder">删除</a></td>
					</tr>

				</c:forEach>
				<tr>
					<td colspan="3"><a id="deleteAll" href="javascript:void(0);"><img
							src="images/taobao_del.jpg" alt="delete" /></a></td>
					<td colspan="5" class="shopend">商品总价（不含运费）：<label id="total"
						class="yellow"></label> 元<br /> 可获积分 <label class="yellow"
						id="integral"></label> 点<br /> <input name="" type="image"
						src="images/taobao_subtn.jpg" />
					</td>
				</tr>
			</table>
		</form>

	</div>
	<iframe src="footer.html" width="100%" height="268px" scrolling="no" frameborder="0" style="z-index: 20;"></iframe>
</body>
</html>