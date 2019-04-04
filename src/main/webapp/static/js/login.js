// JavaScript Document
$(function() {
	$("#txtLoginNo").focus(function() {
		var txt_value = $(this).val();
		if(txt_value == "请输入6~12位账号") {
			$(this).val("");
		}
	});
	$("#txtLoginNo").blur(function() {
		var txt_value = $(this).val();
		if(txt_value == "") {
			$(this).val("请输入6~12位账号");
		}
	});
});
// 测试登录类型
function cheakBtn() {
	debugger;
	var txtLoginNo = document.getElementById("txtLoginNo").value;
	var txtPwd = document.getElementById("txtPwd").value;
	if(txtLoginNo==null||txtLoginNo==undefined||txtLoginNo==""){
		alert("用户名不能为空！");
		return false;
	}
	if(txtPwd==null||txtPwd==undefined||txtPwd==""){
		alert("密码不能为空！");
		return false;
	}
	var data={"username":txtLoginNo,"password":txtPwd};
    $.ajax({
        url: webath + "doLogin.html",
        type: "POST",
        data: data,
        dataType: "json",
        success: function (result) {
            alert(result.msg);
            if (result.code == 500) {
                window.location.href = webath + "/login.html"
            } else if (result.code == 0) {

                window.location.href = webath + "/index.html";
            } else {
                window.location.href = webath + "/";
            }

        },
        error: function (result) {
            alert("error");
        }
    });
}