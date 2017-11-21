function changeProductRec(){
	var root = document.getElementById("root").value;
	var obj = document.getElementById("selectError1");     //定位到选择的select
	var index = obj.selectedIndex ;
	var productCustom = new Object();
	var productid = document.getElementById("productRecomend1").value;  //原本框内的商品id
	var userid = obj.options[index].value;   //被选中的商品id
	productCustom.userid = userid;
	productCustom.productid = productid;
	$.ajax({
		type:'post',
		url : root+'/brach/RequestBranchProductRec.action',
		contentType:'application/json;charset=utf-8',
		data:JSON.stringify(productCustom),
		success : function(data){
		}
	});
}
function changeProductRec2(){
	var root = document.getElementById("root").value;
	var obj = document.getElementById("selectError2");     //定位到选择的select
	var index = obj.selectedIndex ;
	var productCustom = new Object();
	var productid = document.getElementById("productRecomend2").value;  //原本框内的商品id
	var userid = obj.options[index].value;   //被选中的商品id
	productCustom.userid = userid;
	productCustom.productid = productid;
	$.ajax({
		type:'post',
		url : root+'/brach/RequestBranchProductRec.action',
		contentType:'application/json;charset=utf-8',
		data:JSON.stringify(productCustom),
		success : function(data){
		}
	});
}
function changeProductRec3(){
	var root = document.getElementById("root").value;
	var obj = document.getElementById("selectError3");     //定位到选择的select
	var index = obj.selectedIndex ;
	var productCustom = new Object();
	var productid = document.getElementById("productRecomend3").value;  //原本框内的商品id
	var userid = obj.options[index].value;   //被选中的商品id
	productCustom.userid = userid;
	productCustom.productid = productid;
	$.ajax({
		type:'post',
		url : root+'/brach/RequestBranchProductRec.action',
		contentType:'application/json;charset=utf-8',
		data:JSON.stringify(productCustom),
		success : function(data){
		}
	});
}