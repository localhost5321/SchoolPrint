var PAGE_HEIGHT;
$(function(){
	//网页可视区域高度
	PAGE_HEIGHT = document.documentElement.clientHeight;
	//广告结束的位置
	var ad_2_top = $(".ad_2").offset().top + $(".ad_2").height();
	var ad_1_top = $(".ad_1").offset().top + $(".ad_1").height();
	var ad_4_top = $(".ad_4").offset().top + $(".ad_4").height();
	var ad_3_top = $(".ad_3").offset().top + $(".ad_3").height();
	window.onscroll = function(){
		//页面下方离顶部的距离
		var scrollHeight = document.documentElement.scrollTop + PAGE_HEIGHT;
		//到达第一个广告
		if(scrollHeight >= ad_2_top ){
			ad_2_animate();
		}
		if(scrollHeight >= ad_1_top ){
			ad_1_animate();
		}
		if(scrollHeight >= ad_4_top ){
			ad_4_animate();
		}
		if(scrollHeight >= ad_3_top ){
			ad_3_animate();
		}
	};
});

function ad_2_animate(){
	//图标
	$(".ad_2_icon").animate({
		left : "75px",
		top:"36px",
		opacity:"1"
	}, 1000);
	//文字一
	$(".ad_2_text_1").animate({
		right : "376px",
		top:"65px",
		opacity:"1"
	}, 1000);
	//文字二
	$(".ad_2_text_2").animate({
		right : "150px",
		top:"120px",
		opacity:"1"
	}, 1000);
	//文字三
	$(".ad_2_text_3").animate({
		right : "53px",
		top:"242px",
		opacity:"1"
	}, 1000);
}

function ad_1_animate(){
	//图标
	$(".ad_1_icon").animate({
		left : "170px",
		top:"76px",
		opacity:"1"
	}, 1000);
	//文字
	$(".ad_1_text").animate({
		right : "96px",
		top:"112px",
		opacity:"1"
	}, 1000);
	//云
	$(".ad_1_cloud").animate({
		top: "105px",
		opacity:"1"
	}, 1000);
}

function ad_4_animate(){
	//图标
	$(".ad_4_icon").animate({
		left : "0px",
		opacity:"1"
	}, 1000);
	//灯泡
	$(".ad_4_bulb").animate({
		top: "0px",
		opacity:"1"
	}, 1000);
	//文字
	$(".ad_4_text_1").animate({
		top:"70px",
		opacity:"1"
	}, 1000);
	$(".ad_4_text_2").animate({
		top:"155px",
		opacity:"1"
	}, 1000);
	$(".ad_4_text_3").animate({
		top:"272px",
		opacity:"1"
	}, 1000);
}

function ad_3_animate(){
	//文字
	$(".ad_3_text_1").animate({
		top:"20px",
		opacity:"1"
	}, 1000);
	$(".ad_3_text_2").animate({
		left:"225px",
		opacity:"1"
	}, 1000);
	$(".ad_3_text_3").animate({
		left:"410px",
		opacity:"1"
	}, 1000);
	$(".ad_3_text_4").animate({
		top:"118px",
		opacity:"1"
	}, 1000);
	$(".ad_3_text_5").animate({
		left:"163px",
		opacity:"1"
	}, 1000);
	$(".ad_3_text_6").animate({
		top:"238px",
		opacity:"1"
	}, 1000);
	$(".ad_3_text_7").animate({
		top:"180px",
		opacity:"1"
	}, 1000);
	$(".ad_3_text_8").animate({
		left:"410px",
		opacity:"1"
	}, 1000);
	$(".ad_3_text_9").animate({
		top:"302px",
		opacity:"1"
	}, 1000);
}