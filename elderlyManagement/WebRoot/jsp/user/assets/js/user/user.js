
$("#btn-sub").hide();
$("#health2").hide();
$("#birthday").attr("onClick",null);
$("#sub-changeMed").click(function(){
		$("#form-name").attr("readonly",null);
		$("#health").attr("readonly",null);
		$("#bank").attr("readonly",null);
		$("#addr").attr("readonly",null);
		$("#birthday").attr("readonly",null);
		$("#birthday").attr("onClick","laydate()");
		$("#mail").attr("readonly",null);
		$("#file").attr("readonly",null);
		$("#name").attr("readonly",null);
		$("#password").attr("readonly",null);
		$("#rad-sex").attr("readonly",null);
		$("#btn-sub").show();
		$("#health2").show();
		$("#health").hide();
		/*$(this).hide();
		$(".update-phone-label").show();*/
	});


$("#meds1").hide();
$("#meds2").hide();
$("#meds3").hide();
$("#meds4").hide();
$("#btn-submit").hide();
$("#sub-changeMeds").click(function(){
	$("#med1").hide();
	$("#med3").hide();
	$("#med2").hide();
	$("#med4").hide();
	$("#meds1").show();
	$("#meds2").show();
	$("#meds3").show();
	$("#meds4").show();
	$("#btn-submit").show();
});






