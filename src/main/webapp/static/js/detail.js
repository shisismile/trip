$(function() {
	$("#zoom").jqueryzoom({
		xzoom: 300, //放大图的宽度(默认是 200)  
		yzoom: 300, //放大图的高度(默认是 200)  
		offset: 10, //离原图的距离(默认是 10)  
		position: "right", //放大图的定位(默认是 "right")  
		preload: 1
	});
});
$(function(){
	var x = 5, y = 15;
	$("img").mouseover(function (e) {
	$("#mainImg")
		.attr("src",this.src)
		.css({"top":(e.pageY + y) + "px","left":(e.pageX + x) + "px"})
		.show(1000);
	});
	$("img").mouseout(function () {
		$("#mainImg").hide();
	});
});