$().ready(function() {
	//搜索栏清空
	$(".S_cDIV1LI3_input1").focus(function() {
		var content = $(this).val();
		if(content == "在当前结果中搜索") {
			$(this).val("");
		}
	}).blur(function() {
		var content = $(this).val();
		if(content == "") {
			$(this).val("在当前结果中搜索")
		}
	});
	//点击加减号隐藏和显示内容
	$(".S_cDIV1LI4").click(function() {
		//					    background-position: -130px -74px;
		if($(this).css("background-position-y") == "-74px") {
			$(this).css("background-position-y", "-101px");
			$(this).parent().siblings().css("display", "none");
		} else {
			$(this).css("background-position-y", "-74px")
			$(this).parent().siblings().css("display", "block");
		}
	});
	//收起功能
	$(".S_cDIV2_div3 b").click(function() {
		if($(this).text() == "更多") {
			$(this).text("收起");
			$(".S_cDIV2").css("height", "186px");
			$(this).siblings("i").css("background-position-y", "-72px");
		} else {
			$(this).text("更多");
			$(".S_cDIV2").css("height", "60px");
			$(this).siblings("i").css("background-position-y", "-66px");
		}
	});
	//展开多选
	$(".S_cDIV3_div2_btn1 a").click(function() {

		$(".S_cDIV3_div2_btn1 a").each(function() {

			$(this).css("display", "block");
			$(this).parent().parent().css("background-color", "#FFFFFF");
			$(this).parent().parent().parent().css("height", "30px");
			$(this).parent().siblings("ul").find("a").css("border-color", "transparent");
			$(this).parent().siblings(".S_cDIV3_div2_btn2").css({
				"background-color": "#f2f2f2",
				"border-color": "#ccc",
				"color": "#c5c5c5"
			});
		});
		$(this).css("display", "none");
		$(this).parent().parent().css("background-color", "#EFECEB");
		$(this).parent().parent().parent().css("height", "63px");
	});
	//取消多选功能
	$(".S_cDIV3_div2_btn3").click(function() {
		$(this).siblings().children("a").css("display", "block");
		$(this).parent().css("background-color", "#FFFFFF");
		$(this).parent().parent().css("height", "30px");
		$(this).siblings("ul").find("a").css("border-color", "transparent");
		$(this).siblings(".S_cDIV3_div2_btn2").css({
			"background-color": "#f2f2f2",
			"border-color": "#ccc",
			"color": "#c5c5c5"
		})
	});
	//多选功能
	$(".S_cDIV3_div2 ul li a").click(function() {
		if($(this).parent().parent().siblings(".S_cDIV3_div2_btn1").children("a").css("display") == "none") {
			if($(this).css("border-color") == "rgba(0, 0, 0, 0)") {
				$(this).css("border-color", "#B0A59F");
			} else {
				$(this).css("border-color", "transparent");
			}
		}
		var isYes = false;
		$(this).parent().parent().find("a").each(function(i, e) {
			if($(e).css("border-color") == "rgb(176, 165, 159)") {
				isYes = true;

			};
		});
		if(isYes) {
			$(this).parent().parent().siblings(".S_cDIV3_div2_btn2").css({
				"background-color": "#950b00",
				"border-color": "#950b00",
				"color": "#fff"
			});
		} else {
			$(this).parent().parent().siblings(".S_cDIV3_div2_btn2").css({
				"background-color": "#f2f2f2",
				"border-color": "#ccc",
				"color": "#c5c5c5"
			});
		}
	});
	//模式切换
	$(".S_cDIV8_div2 a").click(function() {
		if($(this).children("i").css("background-position-x") == "-48px") {
			$(this).children("i").css("background-position-x", "-58px");
			$(this).children("b").text("更多选项");
			$(".BEHEIDE").css("display", "none");
		} else {
			$(this).children("i").css("background-position-x", "-48px");
			$(this).children("b").text("精简选项");
			$(".BEHEIDE").css("display", "block");
		}
	});
});