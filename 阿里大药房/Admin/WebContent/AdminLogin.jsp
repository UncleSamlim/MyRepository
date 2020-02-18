<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="css/login/login.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="css/body.css" />
		<script type="text/javascript" src="jquery-1.8.3.js"></script>
</head>
<script>
		var errori ='<%=request.getParameter("error")%>'
    	if(errori=='yes'){
    		alert("账号或者密码错误！");
    	}
</script>
<body>
	<div class="header">
			<a href=""><img src="img/login/logo.png"></a>
		</div>
		<div class="wow">
			<div class="inner">
				<div class="adv_link">
					<a href=""></a>
				</div>
				<div class="login">
					<div class="hd">
						<div class="login_switch">
							<img src="img/login/Qr_code.png">
						</div>
						<div class="login_tip">
							<img src="img/login/tip.png">
						</div>
					</div>
					<div class="bd">
						<p>管理员登录</p>
						<form action="AdminLogin" method="post">
							<div class="username">
								<img src="img/login/userIcon.png" class="user_icon">
								<input type="text" name="uesrname" id="" value="" placeholder="请输入管理员账户" />
								<img src="img/login/bnt.png" class="bnt">
							</div>
							<div class="pwd">
								<img src="img/login/pwdIcon.png" class="pwd_icon">
								<input type="password" name="password" id="" value="" />
							</div>

							<input type="submit" value="登 录" class="submit" />
						</form>
						
					</div>
					<div class="fd">
						<a href="">忘记密码</a><a href="">忘记会员名</a><a href="">免费注册</a>
					</div>
				</div>
			</div>
		</div>
		<div class="footer wrap">
			<p>
				<a href="">关于天猫</a>
				<a href="">帮助中心</a>
				<a href="">开放平台</a>
				<a href="">诚聘英才</a>
				<a href="">联系我们</a>
				<a href="">网站合作</a>
				<a href="">法律声明</a>
				<a href="">隐私权政策</a>
				<a href="">知识产权</a>
				<a href="">廉正举报</a>
			</p>
			<p>
				<a href="">阿里巴巴集团</a>
				<a href="">淘宝网</a>
				<a href="">天猫</a>
				<a href="">聚划算</a>
				<a href="">全球速卖通</a>
				<a href="">阿里巴巴国际交易市场</a>
				<a href="">1688</a>
				<a href="">阿里妈妈</a>
				<a href="">飞猪</a>
				<a href="">阿里云计算</a>
				<a href="">AliOS</a>
				<a href="">阿里通信</a>
				<a href="">万网</a>
				<a href="">高德</a>
				<a href="">UC</a>
				<a href="">友盟</a>
				<a href="">虾米</a>
				<a href="">钉钉</a>
				<a href="">支付宝</a>
			</p>
			
			<div class="fb">
				<span>增值电信业务经营许可证： </span><a style="margin-right: 60px;" href="">浙B2-20110446</a>
				<span style="margin-right: 60px;">市场名称登记证：工商网市字3301004119号</span>
				<span>出版物网络交易平台服务经营备案证： 新出发浙备字第001号</span><br/>
				   
				<span style="margin-right: 60px;">互联网违法和不良信息举报电话：0571-81683755 blxxjb@alibaba-inc.com</span>
				<span>互联网药品信息服务资质证书编号：</span><a style="margin-right: 60px;" href="">浙-（经营性）-2017-0005</a>
				<a style="margin-right: 60px;" href=""><img src="" alt="">浙公网安备 33010002000120号</a><br/>
				
				<span>医疗器械网络交易服务第三方平台备案：（浙）网械平台备字[2018]第00002号</span>
				<span>互联网药品交易服务资格证书：国A20150001</span><br/>
				
				<span>浙江省网络食品销售第三方平台提供者备案：浙网食A33010002 </span>
				<a href="">12318举报</a><br/>
				
				<span>© 2003-2019 TMALL.COM 版权所有</span>
				
			</div>
			

</body>
</html>