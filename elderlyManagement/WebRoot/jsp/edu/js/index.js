// JavaScript Document
//左边按钮
$("div.banner a.but-left").click(function(){
	var bBox = $("#bannerBox");
	bBox.prepend($("#bannerBox li:last"));
	bBox.css("left","-100%");
	bBox.stop(true).animate({left:"0%"},1000);
})
//右边按钮
$("div.banner a.but-right").click(function(){
	auto();
})

$("#bannerBox").hover(function(){
	clearInterval(timer);
},function(){
	timer = setInterval(auto,5000);
})
var timer = setInterval(auto,5000);
function auto(){
	var bBox = $("#bannerBox");
	bBox.stop(true).animate({left:"-100%"},1000,function(){
		bBox.append($("#bannerBox li:first"));
		bBox.css("left","0%");
	})
}
$("#header div.content div.meun ul li").hover(function(){
	var _left = $(this).position().left;
	$("#header div.content div.meun div.hover")
	.stop(true).animate({left:_left},200)
		.stop(true).animate({left:_left-10},50)
		.stop(true).animate({left:_left+10},50)
		.stop(true).animate({left:_left+10},50)
		.stop(true).animate({left:_left},20);	
},function(){
	$("#header div.content div.meun div.hover")
		.stop(true).animate({left:0},150);
});
