$(function () {

});

function doRegister() {
    var form = $("#regFrm").serializeArray();
    debugger;
    var data = {};
    $.each(form, function () {
        data[this.name] = this.value;
    });
debugger
    $.ajax({
        url: webath + "/register/doRegister.html",
        type: "POST",
        data: data,
        dataType: "json",
        beforeSend: function (req) {
            for (var item in data) {
                var val = data[item];
                if (val == null || val == undefined || val == "") {
                    alert(item + " 不能为空");
                    return false;
                }
            }
            if (data.password != data.txtConfirmPwd) {
                alert("密码不一致");
                return false;
            }
            return true;
        },
        success: function (result) {
            alert(result.msg);
            if (result.code == 500) {
                window.location.href = webath + "/register/register.html"
            } else if (result.code == 0) {
                window.location.href = webath + "/login.html";
            } else {
                window.location.href = webath + "/";
            }
        },
        error: function (result) {
            alert("error");
        }
    });
}


