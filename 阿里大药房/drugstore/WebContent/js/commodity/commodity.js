$().ready(function() {
	//设置右下DIV的高度
	heightSet();
	//实现切换图片
	$(".C_clleft .C_cllcenter a").mouseover(function() {
		$(this).parent().siblings().children().css("border-color", "transparent");
		$(this).css("border-color", "black");
		var img_name = $(this).children()[0].src;
		$(".C_clleft .C_clltop img").attr('src', img_name);
	});
	//更换邮寄地址
	//				$(".C_clright .C_clrDiv4 dl dd ul li img").click(function() {
	//					$(".C_clright .C_clrDiv5 .C_clrDiv4_ABox").toggle();
	//				});
	//鼠标经过亮
	$(".C_bottom .C_bleft .C_blbottom .C_blbottomLI4 dl dt").hover(function() {
		$(this).css("background-color", "#C9C9C9");
	}, function() {
		$(this).css("background-color", "#FFFFFF");
	});
	//展开导航栏
	$(".C_bottom .C_bleft .C_blbottom .C_blbottomLI4 dl dt img").click(function() {
		$(this).siblings().removeClass("display_no");
		$(this).addClass("display_no");
		$(this).parent().next().toggleClass("display_no");
	});
	//鼠标经过改变点样式
	$(".C_bottom .C_bright ul li").hover(function() {
		var sign = $(this).children("span").css("background-position-y");
		$(this).attr("value", sign);
		if(sign == "-39px") {
			$(this).children("span").css("background-position-y", "0px");
			$(this).children("a").css("color", "#c00");

		}

	}, function() {
		if($(this).val() == -39) {
			$(this).children("span").css("background-position-y", "-39px");
			$(this).children("a").css("color", "#999");

		}
	});

	//点击改变点样式
	$(".C_bottom .C_bright ul li a").click(function() {
		$(".C_bottom .C_bctop .C_bctopLI1").next().removeClass("selected_on");
		$(".C_bottom .C_bctop .C_bctopLI1").addClass("selected_on")
		$(".C_bottom .C_bccenter").removeClass("display_no");
		$(".C_bottom .C_bcbottom").addClass("display_no");
		$(this).parent().siblings().children("span").css("background-position-y", "-39px");
		$(this).parent().siblings().children("a").css("color", "#999");
		$(this).prev().css("background-position-y", "0px");
		$(this).css("color", "#c00");
		$(".C_bottom .C_bright ul li").attr("value", 100);
	});
	//切换物品详情和评论
	$(".C_bottom .C_bctop .C_bctopLI1").click(function() {
		$(this).next().removeClass("selected_on");
		$(this).addClass("selected_on")
		$(".C_bottom .C_bccenter").removeClass("display_no");
		$(".C_bottom .C_bcbottom").addClass("display_no");
		$(".C_bright").css("height", "20400px");

	});
	$(".C_bottom .C_bctop .C_bctopLI2").click(function() {
		$(this).prev().removeClass("selected_on");
		$(this).addClass("selected_on")
		$(".C_bottom .C_bcbottom").removeClass("display_no");
		$(".C_bottom .C_bccenter").addClass("display_no");
		$(".C_bright").css("height", "2500px");
	});
	//鼠标经过出现二维码
	$(".C_bottom .C_bctop .C_bctopLI3").hover(function() {
		$(this).css("background-color", "#F5F5F5")
		$(this).children(".C_bctopLI3Span2").css("background-position", "-25px -40px");
		$(this).children("img").removeClass("display_no");
	}, function() {
		$(this).css("background-color", "#FFFFFF")
		$(this).children(".C_bctopLI3Span2").css("background-position", "-25px 0px");
		$(this).children("img").addClass("display_no");
	});
	//滚动条事件
	//scroll 事件适用于所有可滚动的元素和 window 对象（浏览器窗口）。
	$(window).scroll(function() {
		var scroHei = $(window).scrollTop(); //滚动的高度
		if(scroHei > 960) {
			$(".C_bottom .C_bltopLI1,.C_bctop,.C_bright ul").css({
				"position": "fixed",
				"top": "0px"
			});
			$(".C_bottom .C_bltopLI1").css("width", "200px");
			$(".C_clright .C_clrDiv6 .C_clrDiv6DL3 .C_clrDiv6DL3UL2 .C_clrDiv6DL3UL2LI2").css({
				"position": "fixed",
				"top": "0px",
				"margin-left": "460px",
				"width": "199px",
				"height": "48px"
			});
		} else {
			$(".C_bottom .C_bltopLI1,.C_bctop,.C_bright ul").css("position", "static");
			$(".C_bottom .C_bltopLI1").css("width", "188px");
			$(".C_clright .C_clrDiv6 .C_clrDiv6DL3 .C_clrDiv6DL3UL2 .C_clrDiv6DL3UL2LI2").css({
				"position": "static",
				"margin-left": "6px",
				"width": "180px",
				"height": "40px"
			});
		}
	});
	//选择边框变色
	$(".C_clright .C_clrDiv6 .C_clrDiv6DL1 dd ul li").click(function() {
		$(this).siblings().css({
			"border": "1px solid #e2e1e3",
			"margin": "0px",
			"margin-right": "5px"
		});
		$(this).css({
			"border": "2px solid #FF0036",
			"margin": "-1px",
			"margin-right": "4px"
		});
		jisuan();
	});
	$(".C_clright .C_clrDiv6 .C_clrDiv6DL3 .C_clrDiv6DL3UL1 li").click(function() {
		var sign = $(this).css("border-width");
		$(this).siblings().css({
			"border": "1px solid #b8b7bd",
			"margin": "0px",
			"margin-left": "6px"
		});
		if(sign == "1px") {
			$(this).css({
				"border": "2px solid #FF0036",
				"margin": "-1px",
				"margin-left": "5px"
			});
		} else {
			$(this).css({
				"border": "1px solid #b8b7bd",
				"margin": "0px",
				"margin-left": "6px"
			});
		}
	});
	//右边图片切换
	$(".C_cright .C_crbottom .C_crbottomLI1").hover(function() {

		$(this).css("background-position-y", "-61px");
	}, function() {
		$(this).css("background-position-y", "0");
	});
	$(".C_cright .C_crbottom .C_crbottomLI1").click(function() {
		$(".C_cright .C_crcenter li:gt(2)").hide();
		$(".C_cright .C_crcenter li:lt(3)").show();
	});
	$(".C_cright .C_crbottom .C_crbottomLI2").hover(function() {

		$(this).css("background-position-y", "-93px");
	}, function() {
		$(this).css("background-position-y", "-30px");
	});
	$(".C_cright .C_crbottom .C_crbottomLI2").click(function() {
		$(".C_cright .C_crcenter li:lt(3)").hide();
		$(".C_cright .C_crcenter li:gt(2)").show();

	});
	//评论出选择高亮
	$(".C_bottom .C_bcbottom .C_bcbtop .C_bcbtright li ").click(function() {
		var sign = $(this).attr("value");
		if(sign == "0") {
			$(this).css({
				"background": "#ffe2e2",
				"border-color": "#ff0036"
			});
			$(this).attr("value", "1");
		} else {
			$(this).css({
				"background-color": "#FFFFFF",
				"border-color": "#ffd7dd"
			});
			$(this).attr("value", "0");
		}
	});
	$(".C_bottom .C_bcbottom .C_bcbtop .C_bcbtright li ").hover(function() {
		var sign = 1;
		if($(this).css("background-color") == "rgb(255, 255, 255)") {
			sign = 0;
		}
		//"1"为被选中，"0"为未被选中
		$(this).attr("value", sign);
		$(this).css({
			"background-color": "#ffe2e2",
			"border-color": "#ff0036"
		});
	}, function() {
		if($(this).attr("value") == "0") {
			$(this).css({
				"background-color": "#FFFFFF",
				"border-color": "#ffd7dd"
			});
		}
	});
	//支付方式悬浮框
	$(".C_clrDiv7 .C_clrDiv7ImgBtn").click(function() {
		if($(this).attr("src") != "img/commodity/img_jiantou_open.png") {
			$(this).attr("src", "img/commodity/img_jiantou_open.png");
			$(".C_clright .C_clrDiv7 .C_clrDiv7_absBox").css("display", "block");
		} else {
			$(this).attr("src", "img/commodity/img_jiantou_close.png");
			$(".C_clright .C_clrDiv7 .C_clrDiv7_absBox").css("display", "none");
		}

	});
	//加减模块
	$(".C_clright .C_clrDiv6 .C_clrDiv6DL2 dd ul li").find("img").click(function() {
		var src = $(this).attr("src");
		var result = 0;
		var value = parseInt($(this).parent().parent().parent().siblings().find("input").val());
		if(src == "../../img/commodity/img_jiantou_shang_s.png") {
			result = value + 1;
		} else {
			if(value == 1) {
				result = 1;
			} else {
				result = value - 1;
			}
		}
		$(this).parent().parent().parent().siblings().find("input").val(result);
	});
	//图片放大查看

	$(".C_clleft .C_clltop img").hover(function(event) {
		$("#SSpan").css("display", "block");
		var picPath = $(this).attr("src");
		var length = picPath.length;
		var picPath2 = picPath.substring(0, length - 5) + "m.jpg";
		$("#SSpan").css("background", "url(" + picPath2 + ") no-repeat");
		$(document).bind('mousemove', function(event) {
			var str_x = -event.offsetX * 582 / 428;
			var str_y = -event.offsetY * 582 / 428;
			$("#SSpan").animate({
				"background-position-x": str_x,
				"background-position-y": str_y
			}, 10);

		})
	}, function(event) {
		$("#SSpan").css("display", "none");
	});

});
//高度设置（很菜的方法）
function heightSet() {
	//					$(".C_bccbottom").css("display").
};
//计算价格显示
//function jisuan() {
//	var liGroup = $(".C_clright .C_clrDiv6 .C_clrDiv6DL1 dd ul li");
//	var sign = 1;
//	liGroup.each(function(i, dom) {
//		if($(dom).css("border-width") == "2px") {
//			sign = i;
//		}
//	});
//	if(sign == 0) {
//		$(".C_clright .C_clrDiv3 .C_clrDiv3DL1 dd span").text("999.00");
//		$(".C_clright .C_clrDiv3 .C_clrDiv3DL2 dd span").text("620.00");
//		$(".C_clright .C_clrDiv6 .C_clrDiv6DL3 .C_clrDiv6DL3UL1 li").children("b:eq(0)").text("211.41");
//		$(".C_clright .C_clrDiv6 .C_clrDiv6DL3 .C_clrDiv6DL3UL1 li").children("b:eq(1)").text("107.97");
//		$(".C_clright .C_clrDiv6 .C_clrDiv6DL3 .C_clrDiv6DL3UL1 li").children("b:eq(2)").text("55.53");
//	} else if(sign == 1) {
//		$(".C_clright .C_clrDiv3 .C_clrDiv3DL1 dd span").text("340.00");
//		$(".C_clright .C_clrDiv3 .C_clrDiv3DL2 dd span").text("155.00");
//		$(".C_clright .C_clrDiv6 .C_clrDiv6DL3 .C_clrDiv6DL3UL1 li").children("b:eq(0)").text("52.84");
//		$(".C_clright .C_clrDiv6 .C_clrDiv6DL3 .C_clrDiv6DL3UL1 li").children("b:eq(1)").text("26.99");
//		$(".C_clright .C_clrDiv6 .C_clrDiv6DL3 .C_clrDiv6DL3UL1 li").children("b:eq(2)").text("13.87");
//	} else if(sign == 2) {
//		$(".C_clright .C_clrDiv3 .C_clrDiv3DL1 dd span").text("376.00");
//		$(".C_clright .C_clrDiv3 .C_clrDiv3DL2 dd span").text("330.00");
//		$(".C_clright .C_clrDiv6 .C_clrDiv6DL3 .C_clrDiv6DL3UL1 li").children("b:eq(0)").text("112.52");
//		$(".C_clright .C_clrDiv6 .C_clrDiv6DL3 .C_clrDiv6DL3UL1 li").children("b:eq(1)").text("57.47");
//		$(".C_clright .C_clrDiv6 .C_clrDiv6DL3 .C_clrDiv6DL3UL1 li").children("b:eq(2)").text("29.56");
//	}
//};