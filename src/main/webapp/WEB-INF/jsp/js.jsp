<%--
  Created by IntelliJ IDEA.
  User: smile
  Date: 2019/1/13
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>
    function modify() {
        debugger
        $('#ff').form('submit', {
            url: webath + "/user/save.html",
            onSubmit: function () {

            },
            success: function (data) {

                alert(JSON.parse(data).msg);
            }
        });
    }

    function openWindow(id) {
        $("#cartId").val(id);
        $('#win').window({top: 170, left: 400});
        $('#win').window('open');
    }

    function closeWindow() {
        $("#publish").window("close");
        $('#win').window('close');
        $("#advertise").window("close");
    }

    function saveComment() {
        var cartId = $("#cartId").val();
        var comment = $("#commentContent").val();
        $.ajax({
            url: webath + "comment/save.html",
            data: {"cartId": cartId, "comment": comment},
            method: "post",
            dataType: "json",
            success: function (result) {
                alert(result.msg)
                $('#win').window('close');
                $("#commentContent").val("");
            }
        });
    }

    function openAdvertise() {
        $("#advertise").window({top: 150, left: 400});
        $("#advertise").window("open");
    }

    function saveAdvertise() {
        var formData = new FormData();
        // var formData = new window.FormData();
        var uploadFile = document.getElementById("advertiseimg").files[0];
        formData.append("file", uploadFile);
        formData.append("file_name", "banner");
        $.ajax({
            url: webath + '/file/doUpload.html',
            type: 'POST',
            data: formData,
            processData: false,  //tell jQuery not to process the data
            contentType: false,  //tell jQuery not to set contentType
            dataType: "json",
            //这儿的三个参数其实就是XMLHttpRequest里面带的信息。
            success: function (arg) {
                alert(arg.msg);
                $("#advertise").window("close");
                $("#advertiseimg").val("");
            }
        });
    }

    function openPublishWindow(item) {
        if (item >= 0) {
            $("#idTrip").val("${tripDetails[""+item+""].id}");
            $("#title").val("${tripDetails[""+item+""].title}");
            $("#realPrice").val("${tripDetails[""+item+""].realPrice}");
            $("#countPrice").val("${tripDetails[""+item+""].countPrice}");
            $("#maxMinus").val("${tripDetails[""+item+""].maxMinus}");
            $("#tripDays").val("${tripDetails[""+item+""].tripDays}");
            $("#recommended").val("${tripDetails[""+item+""].recommended}");
            $("#discoutDetail").val("${tripDetails[""+item+""].discoutDetail}");
            $("#introductions").val("${tripDetails[""+item+""].introductions}");
            $("#tips").val("${tripDetails[""+item+""].tips}");
            $("#shortName").val("${tripDetails[""+item+""].shortName}");
            $("#shortIntroductions").val("${tripDetails[""+item+""].shortIntroductions}");
        } else {
            $("#idTrip").val("");
            $("#title").val("");
            $("#realPrice").val("");
            $("#countPrice").val("");
            $("#maxMinus").val("");
            $("#tripDays").val("");
            $("#recommended").val("");
            $("#discoutDetail").val("");
            $("#introductions").val("");
            $("#tips").val("");
            $("#shortName").val("");
            $("#shortIntroductions").val("");
            $('#cc').combobox('setValue', '');
        }
        $("#publish").window({top: 100, left: 400});
        $("#publish").window("open");
    }

    function saveTripDetail() {
        var formData = new FormData();
        var firstType=$("#firstType").combobox('getValue');
        formData.append("firstType", firstType);
        formData.append("id", $("#idTrip").val())
        formData.append("title", $("#title").val());
        formData.append("realPrice", $("#realPrice").val());
        formData.append("countPrice", $("#countPrice").val());
        formData.append("maxMinus", $("#maxMinus").val());
        formData.append("tripDays", $("#tripDays").val());
        formData.append("recommended", $("#recommended").val());
        formData.append("discoutDetail", $("#discoutDetail").val());
        formData.append("introductions", $("#introductions").val());
        formData.append("tips", $("#tips").val());
        formData.append("belong", $("#belong").combobox('getValue'));
        formData.append("shortName", $("#shortName").val());
        formData.append("shortIntroductions",$("#shortIntroductions").val());
        var fileDetail2 = document.getElementById("fileDetail2").files[0];
        var fileDetail1 = document.getElementById("fileDetail1").files[0];
        var fileDetail0 = document.getElementById("fileDetail0").files[0];
        var fileDetail = document.getElementById("fileDetail").files[0];
        formData.append("fileDetail_file", fileDetail);
        formData.append("fileDetail0_file",fileDetail0);
        formData.append("fileDetail1_file",fileDetail1);
        formData.append("fileDetail2_file",fileDetail2);
        debugger;
        $.ajax({
            url: webath + '/detail/saveAll.html',
            type: 'POST',
            data: formData,
            processData: false,  //tell jQuery not to process the data
            contentType: false,  //tell jQuery not to set contentType
            dataType: "json",
            //这儿的三个参数其实就是XMLHttpRequest里面带的信息。
            success: function (arg) {
                alert(arg.msg);
                $("#publish").window("close");
                $("#title").val("");
                $("#realPrice").val("");
                $("#countPrice").val("");
                $("#maxMinus").val("");
                $("#tripDays").val("");
                $("#recommended").val("");
                $("#discoutDetail").val("");
                $("#introductions").val("");
                $("#tips").val("");
                $("#idTrip").val("");
                $("#shortName").val("");
                $("#shortIntroductions").val("");
                $('#cc').combobox('setValue', '');
            }
        });



    }

    function saveUser() {
        $('#ff1').form('submit', {
            url: webath + "/user/save.html",
            onSubmit: function () {
            },
            success: function (data) {
                alert(JSON.parse(data).msg);
            }
        });
    }

</script>
