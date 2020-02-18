<%@page import="cn.yueqian.com.dao.entity.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="cn.yueqian.com.dao.entity.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title>Nutrilon诺优能幼儿配方奶粉3段双罐装奶粉800g2罐爱尔兰原装进口</title>
		<link rel="stylesheet" type="text/css" href="css/commodity/commodity.css"/>
		<link rel="stylesheet" type="text/css" href="css/headerAndfooter/header1.css" />
		<link rel="stylesheet" type="text/css" href="css/headerAndfooter/body.css" />
		<script src="js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/commodity/commodity.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<!--<iframe src="header2.html" width="100%" height="160px" scrolling="no" frameborder="0"></iframe>-->
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
		<%Goods goods = (Goods)session.getAttribute("OneGoods"); 
		  Date date = new Date();
		  SimpleDateFormat sdf=new SimpleDateFormat("MM月dd日晚上12点前");
		  String dateStr =sdf.format(date);
		  %>
		<div class="page">
			<!--上部分，导航栏-->
			<div class="C_top">
				<div class="C_tcenter">
					<ul>
						<li>
							<a href="#"></a>
						</li>
						<li>
							<a href="#"></a>
						</li>
						<li>
							<a href="#"></a>
						</li>
					</ul>
					<ul class="C_tcUL">
						<li class="C_tcLi">
							<a href="index.html"></a>
						</li>
						<li>
							<a href="#"></a>
						</li>
						<li>
							<a href="#"></a>
						</li>
						<li>
							<a href="#"></a>
						</li>
						<li>
							<a href="#"></a>
						</li>
						<li>
							<a href="#"></a>
						</li>
						<li>
							<a href="#"></a>
						</li>
						<li>
							<a href="#"></a>
						</li>
						<li>
							<a href="#"></a>
						</li>
						<li>
							<a href="#"></a>
						</li>
						<li>
							<a href="#"></a>
						</li>
					</ul>
				</div>
			</div>
			<!--中部分，商品展示-->
			<div class="C_center">
				<!--中&左-->
				<div class="C_cleft">
					<div class="C_clleft">
						<div class="C_clltop">
							<div id="SSpan" class="display_no">
							</div>
							<a>
								<img src="img/commodity/img_show1_s.jpg" /></a>
						</div>
						<ul class="C_cllcenter">
							<li>
								<a style="border-color: black"><img src="img/commodity/img_show1_s.jpg" /></a>
							</li>
							<li>
								<a href=""><img src="img/commodity/img_show2_s.jpg" /></a>
							</li>
							<li>
								<a href=""><img src="img/commodity/img_show3_s.jpg" /></a>
							</li>
							<li>
								<a href=""><img src="img/commodity/img_show4_s.jpg" /></a>
							</li>
							<li>
								<a href=""><img src="img/commodity/img_show5_s.jpg" /></a>
							</li>
						</ul>
						<p class="C_cllP">
							<a href=""><img src="img/commodity/img_star.png" />收藏商品 </a>（7966人气）
							<a class="C_cllA" href="">举报</a>
						</p>
					</div>
					<div class="C_clright">
						<div class="C_clrDiv1">
							<h1><a href=""><%=goods.getName()%></a></h1>
							<p><%=goods.getShortDescription() %></p>
						</div>
						<div class="C_clrDiv2">
							<span class="C_clrD2span1">聚划算</span> 此商品正参加聚划算，<span class="C_clrD2span2">2天13小时</span>后结束，请尽快购买！
						</div>
						<div class="C_clrDiv3">
							<dl class="C_clrDiv3DL1">
								<dt>价格</dt>
								<dd><em style="font-size: 12px;">¥</em>&nbsp;<span><%=goods.getPreviousPrice() %></span></dd>
							</dl>
							<dl class="C_clrDiv3DL2">
								<dt>促销价</dt>
								<dd><em style="font-size: 18px;">¥</em><span><%=goods.getPrice() %></span>&nbsp;<img src="img/commodity/img_juhuasuan.png"></dd>
							</dl>
						</div>
						<div class="C_clrDiv4">
							<dl>
								<dt>运费</dt>
								<dd>
									<ul>
										<li>广东广州至<img src="img/commodity/img_xiajiantou.png">广州荔湾区</li>
										<li>12:00前付款，预计<%=dateStr%>送达</li>
									</ul>
								</dd>
							</dl>
						</div>
						<ul class="C_clrDiv5">
							<li>月销量&nbsp;<span><%=goods.getSaleamount()%></span></li>
							<li>累积评论&nbsp;<span>10196</span></li>
							<li style="border-width: 0px;">送天猫积分&nbsp;<span><%=goods.getCatscore() %></span></li>
							<div class="C_clrDiv4_ABox">
							</div>
						</ul>
						<div class="C_clrDiv6">
							<dl class="C_clrDiv6DL1">
								<dt>版本</dt>
								<dd>
									<ul>
										<li style="border: 2px solid #FF0036;margin:-1px ;margin-right: 4px">800g2罐组合 三段</li>
									</ul>
								</dd>
							</dl>

							<dl class="C_clrDiv6DL2">
								<dt>数量</dt>
								<dd>
									<ul>
										<li><input type="text" name="" id="" value="1" /></li>
										<li>
											<span class="C_clrDiv6DL2_span1">
											<span class="C_clrDiv6DL2_span2">
												<img src="img/commodity/img_jiantou_shang_s.png"/>
											</span>
											<span class="C_clrDiv6DL2_span3">
												<img src="img/commodity/img_jiantou_xia_s.png"/>
											</span>
											</span>
											件
										</li>
										<li class="C_clrDiv6DL2LI1">库存<%=goods.getAmount()%>件</li>
									</ul>
								</dd>
							</dl>

							<dl class="C_clrDiv6DL3">
								<dt>花呗分区</dt>
								<dd>
									<ul class="C_clrDiv6DL3UL1">
										<li>¥<b><%= ((int)goods.getPrice()/3 *100)/100.0+2%></b>×3期<br>（含手续费）</li>
										<li>¥<b><%= ((int)goods.getPrice()/6 *100)/100.0+2%></b>×6期<br>（含手续费）</li>
										<li>¥<b><%= ((int)goods.getPrice()/12 *100)/100.0+2%></b>×12期<br>（含手续费）</li>
									</ul>
									<ul class="C_clrDiv6DL3UL2">
										<li class="C_clrDiv6DL3UL2LI1">立即购买</li>
										<a href="OrderServlet?action=AddOrderInfo&goodsId=<%=goods.getId()%>&orderPayWay=支付宝&goodsNumber=1"><li class="C_clrDiv6DL3UL2LI2"><img src="img/commodity/img_smallCar.png" />加入购物车</li></a>
									</ul>
								</dd>
							</dl>
						</div>
						<div class="C_clrDiv7">
							<a style="color: #999;;">服务承诺</a>
							<a href="">赠保价险</a>
							<a href="">正品保证</a>
							<a href="">极速退款</a>
							<a href="">七天无理由退换</a>
							<a>支付方式<img class="C_clrDiv7ImgBtn" src="img/commodity/img_jiantou_close.png" /> </a>

							<ul class="C_clrDiv7_absBox ">
								<li><img src="img/commodity/img_xingtongka.png" />
									<a href="">信用卡</a>
								</li>
								<li><img src="img/commodity/img_kuaijiezhifu.png" />
									<a href="">快捷支付</a>
								</li>
								<li><img src="img/commodity/img_mayihuabei.png" />
									<a href="">蚂蚁花呗</a>
								</li>
								<li><img src="img/commodity/img_yuebao.png" />
									<a href="">余额宝</a>
								</li>
							</ul>

						</div>
					</div>
				</div>

				<!--中&右-->
				<div class="C_cright">
					<div class="C_crtop">
						<p></p>
						<span>
							看了又看
						</span>
						<p></p>
					</div>
					<ul class="C_crcenter">
						<li><img src="img/commodity/img_right_show1.jpg" /></li>
						<li><img src="img/commodity/img_right_show2.jpg" /></li>
						<li><img src="img/commodity/img_right_show3.jpg" /></li>
						<li><img src="img/commodity/img_right_show4.jpg" /></li>
						<li><img src="img/commodity/img_right_show5.jpg" /></li>
						<li><img src="img/commodity/img_right_show6.jpg" /></li>
					</ul>
					<ul class="C_crbottom">
						<li class="C_crbottomLI1"></li>
						<li></li>
						<li class="C_crbottomLI2"></li>
					</ul>
				</div>

			</div>
			<!--下部分,商品详情-->
			<div class="C_bottom">
				<div class="C_bleft">

					<ul class="C_bltop">
						<div class="C_bltopLI1DIVBOX">
							<li class="C_bltopLI1">
								<a href="">阿里健康大药房<img src="img/commodity/img_xiaoshuidi.png"></a>
							</li>
						</div>
						<li class="C_bltopLI2"><span>4</span>&nbsp;天猫4年店</li>
						<li class="C_bltopLI3">
							<p>描 述&nbsp;服 务&nbsp;物 流</p>
							<p class="C_bltopLI3P">4.9-&nbsp;4.8-&nbsp;4.8-</p>
						</li>
						<li class="C_bltopLI4">
							<a href="">进店逛逛</a>
							<a class="C_bltopLI4A" href="">店铺收藏</a>
						</li>
					</ul>

					<ul class="C_blcenter">
						<li class="C_blcenterLI1">本店搜索</li>
						<li class="C_blcenterLI2">关键字<input type="text"></li>
						<li class="C_blcenterLI3">价格<input type="text">-<input type="text"></li>
						<li class="C_blcenterLI4"><input type="image" name="" id="" value="" src="img/commodity/img_teshu_btn.png" /></li>
					</ul>
					<ul class="C_blbottom">
						<li class="C_blbottomLI1">店铺分类</li>
						<li class="C_blbottomLI2">
							<a>查看所有宝贝</a>
						</li>
						<li class="C_blbottomLI3">
							<a href="">按销量</a>
							<a href="">按新品</a>
							<a href="">按价格</a>
							<a href="">按收藏</a>
						</li>
						<li class="C_blbottomLI4">
							<dl>
								<dt><img src="img/commodity/img_listBtn_close.png" class="display_no"/><img src="img/commodity/img_listBtn_open.png"/>滋补调养</dt>
								<dd>
									<a name="mao">补肾 | </a>
									<a href=""> 安神助眠 |</a>
									<a href=""> 心脏疾病 |</a>
									<a href=""> 益肝</a>
								</dd>
							</dl>
							<dl>
								<dt><img src="img/commodity/img_listBtn_close.png" class="display_no"/><img src="img/commodity/img_listBtn_open.png"/>风湿骨科</dt>
								<dd>
									<a href="">风湿类风湿 | </a>
									<a href="">跌打损伤 |</a>
									<a href="">关节炎 |</a>
									<a href="">骨质增生 |</a>
									<a href="">颈肩腰腿痛 |</a>
									<a href="">活血止痛 |</a>
									<a href="">强骨壮骨 |</a>
									<a href="">颈椎病 |</a>
									<a href="">抗风湿 |</a>
									<a href="">舒筋活络 |</a>
									<a href="">腰椎间盘 |</a>
								</dd>
							</dl>
							<dl>
								<dt><img src="img/commodity/img_listBtn_close.png" class="display_no"/><img src="img/commodity/img_listBtn_open.png"/>肠胃用药</dt>
								<dd>
									<a href="">胃炎胃痛 | </a>
									<a href="">便秘 |</a>
									<a href="">腹泻 |</a>
									<a href="">胃肠溃疡 |</a>
									<a href="">消化不良 | </a>
									<a href="">痔疮 |</a>
									<a href="">小儿肠胃病 |</a>
									<a href="">肠胃不适 |</a>
									<a href="">晕车呕吐 | </a>
									<a href="">胃酸烧心 |</a>
								</dd>
							</dl>
							<dl>
								<dt><img src="img/commodity/img_listBtn_close.png" class="display_no"/><img src="img/commodity/img_listBtn_open.png"/>滋补调养</dt>
								<dd>
									<a href="">补肾 | </a>
									<a href=""> 安神助眠 |</a>
									<a href=""> 心脏疾病 |</a>
									<a href=""> 益肝</a>
								</dd>
							</dl>
							<dl>
								<dt><img src="img/commodity/img_listBtn_close.png" class="display_no"/><img src="img/commodity/img_listBtn_open.png"/>风湿骨科</dt>
								<dd>
									<a href="">风湿类风湿 | </a>
									<a href="">跌打损伤 |</a>
									<a href="">关节炎 |</a>
									<a href="">骨质增生 |</a>
									<a href="">颈肩腰腿痛 |</a>
									<a href="">活血止痛 |</a>
									<a href="">强骨壮骨 |</a>
									<a href="">颈椎病 |</a>
									<a href="">抗风湿 |</a>
									<a href="">舒筋活络 |</a>
									<a href="">腰椎间盘 |</a>
								</dd>
							</dl>
							<dl>
								<dt><img src="img/commodity/img_listBtn_close.png" class="display_no"/><img src="img/commodity/img_listBtn_open.png"/>肠胃用药</dt>
								<dd>
									<a href="">胃炎胃痛 | </a>
									<a href="">便秘 |</a>
									<a href="">腹泻 |</a>
									<a href="">胃肠溃疡 |</a>
									<a href="">消化不良 | </a>
									<a href="">痔疮 |</a>
									<a href="">小儿肠胃病 |</a>
									<a href="">肠胃不适 |</a>
									<a href="">晕车呕吐 | </a>
									<a href="">胃酸烧心 |</a>
								</dd>
							</dl>
							<dl>
								<dt><img src="img/commodity/img_listBtn_close.png" class="display_no"/><img src="img/commodity/img_listBtn_open.png"/>滋补调养</dt>
								<dd>
									<a href="">补肾 | </a>
									<a href=""> 安神助眠 |</a>
									<a href=""> 心脏疾病 |</a>
									<a href=""> 益肝</a>
								</dd>
							</dl>
							<dl>
								<dt><img src="img/commodity/img_listBtn_close.png" class="display_no"/><img src="img/commodity/img_listBtn_open.png"/>风湿骨科</dt>
								<dd>
									<a href="">风湿类风湿 | </a>
									<a href="">跌打损伤 |</a>
									<a href="">关节炎 |</a>
									<a href="">骨质增生 |</a>
									<a href="">颈肩腰腿痛 |</a>
									<a href="">活血止痛 |</a>
									<a href="">强骨壮骨 |</a>
									<a href="">颈椎病 |</a>
									<a href="">抗风湿 |</a>
									<a href="">舒筋活络 |</a>
									<a href="">腰椎间盘 |</a>
								</dd>
							</dl>
							<dl>
								<dt><img src="img/commodity/img_listBtn_close.png" class="display_no"/><img src="img/commodity/img_listBtn_open.png"/>肠胃用药</dt>
								<dd>
									<a href="">胃炎胃痛 | </a>
									<a href="">便秘 |</a>
									<a href="">腹泻 |</a>
									<a href="">胃肠溃疡 |</a>
									<a href="">消化不良 | </a>
									<a href="">痔疮 |</a>
									<a href="">小儿肠胃病 |</a>
									<a href="">肠胃不适 |</a>
									<a href="">晕车呕吐 | </a>
									<a href="">胃酸烧心 |</a>
								</dd>
							</dl>
						</li>
					</ul>
				</div>
				<div class="C_bcenter">
					<div class="C_bctopDIVBOX">
						<ul class="C_bctop">
							<li class="C_bctopLI1 selected_on">商品详情</li>
							<li class="C_bctopLI2">累积评论<span>10275</span></li>
							<li class="C_bctopLI3">
								<p>手机购买</p><span class="C_bctopLI3Span1"></span><span class="C_bctopLI3Span2"></span>
								<img style="z-index: 10;" class="display_no" src="img/commodity/img_eweima_big.png" />
							</li>
						</ul>

					</div>
					<div class="C_bccenter">
						<div class="C_bcctop">
							<p class="C_bcctopP1">品牌名称：Nutrilon/诺优能(牛栏)</p>
							<p class="C_bcctopP2">产品参数：</p>
							<ul>
								<li>厂名：NUTRICIA Cuijk B.V.</li>
								<li>厂址：Grotestraat91, 5431 DJ Cuijk</li>
								<li>厂家联系方式：0800-022 26 26</li>
								<li>保质期：540 天</li>
								<li>产品名称：Nutrilon/诺优能(牛栏)...</li>
								<li>品牌: Nutrilon/诺优能(牛栏)</li>
								<li>系列: 爱尔兰版</li>
								<li>具体规格: 800g</li>
								<li>适用年龄: 12-36个月</li>
								<li>销售地: 中国大陆</li>
								<li>包装种类: 罐装</li>
								<li>是否为有机食品: 否</li>
								<li>适用阶段: 3段</li>
								<li>包装方式: 包装</li>
								<li>是否进口: 进口</li>
								<li>原产地: 爱尔兰</li>
							</ul>
						</div>
						<div class="C_bccbottom">
							<img id="mao_canshu" src="img/commodity/img_tooBig1.jpg" />
							<img src="img/commodity/img_tooBig2.jpg" />
							<img id="mao_zhanshi" src="img/commodity/img_tooBig3.jpg" />
							<img src="img/commodity/img_tooBig4.jpg" />
							<img src="img/commodity/img_tooBig5.jpg" />
							<img src="img/commodity/img_tooBig6.jpg" />
							<img src="img/commodity/img_tooBig7.jpg" />
							<img src="img/commodity/img_tooBig8.jpg" />
							<img id="mao_xijie" src="img/commodity/img_tooBig9.jpg" />
							<img src="img/commodity/img_tooBig10.jpg" />
							<img src="img/commodity/img_tooBig11.jpg" />
							<img id="mao_fuwu" src="img/commodity/img_tooBig12.jpg" />
							<img src="img/commodity/img_tooBig13.jpg" />
							<img src="img/commodity/img_tooBig14.png" />
							<img src="img/commodity/img_tooBig15.gif" />
						</div>
					</div>

					<div class="C_bcbottom  display_no">
						<div class="C_bcbtop">
							<ul class="C_bcbtleft">
								<li class="C_bcbtleftLI1">与描述相符</li>
								<li class="C_bcbtleftLI2">4.9</li>
								<li class="C_bcbtleftLI3"></li>
							</ul>
							<div class="C_bcbtcenter">
								大家都写到
							</div>
							<ul class="C_bcbtright">
								<li>很便宜(274)</li>
								<li>物流快(114)</li>
								<li>正品(107)</li>
								<li>包装不错(87)</li>
								<li>质量不错(71)</li>
								<li>发货快(60)</li>
								<li>口感好(55)</li>
								<li>价格合理(52)</li>
								<li>性价比高(39)</li>
								<li>新鲜(37)</li>
							</ul>
						</div>
						<div class="C_bcbcenter">
							<input type="radio" name="radioground" id="" value="" checked="checked" /><label>全部</label>
							<input type="radio" name="radioground" id="" value="" /><label>追评(154)</label>
							<input type="radio" name="radioground" id="" value="" /><label>图片(1000)</label>
							<input class="C_bcbcenterCheckbox" type="checkbox" name="" id="" value="" /><label>有内容</label>
							<span class="C_bcbcenterSPAN">
								按默认
							</span>
						</div>
						<div class="C_bcbbottom">
							<table>
								<tbody>
									<tr>
										<td class="C_bcbbottomTD1">
											<ul>
												<li class="C_bcbbottomTD1LI1">宝宝从小就喝诺优能，奶粉一直都很容易冲不结块，一般三四十度的水就能，不上火，营养搭配均匀，微量元素都有，宝宝很喜欢喝。搞活动的价格绝对让你满意，希望多促销。</li>
												<li class="C_bcbbottomTD1LI2"><img src="img/commodity/img_buyerShow.jpg" /></li>
												<li class="C_bcbbottomTD1LI3"><img src="img/commodity/img_buyerShow.jpg" /></li>
											</ul>
										</td>
										<td class="C_bcbbottomTD2"></td>
										<td class="C_bcbbottomTD3">l***8（匿名）</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="C_bright">
					<ul>
						<li class="C_brightLI1"><span></span>
							<a href="#mao_canshu">商品参数</a>
						</li>
						<li><span></span>
							<a href="#mao_zhanshi">商品展示</a>
						</li>
						<li><span></span>
							<a href="#mao_xijie">商品细节</a>
						</li>
						<li><span></span>
							<a href="#mao_fuwu">服务质量</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<iframe src="footer.html" width="100%" height="268px" scrolling="no" frameborder="0" style="z-index: 20;"></iframe>
	</body>

</html>