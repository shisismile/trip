<%--
  Created by IntelliJ IDEA.
  User: smile
  Date: 2019/1/7
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>购物车</title>
  <%@include file="common/header.jsp"%>
    <script type="text/javascript" src="<%=basePath%>/static/js/shop.js"></script>
    <style type="text/css">
        .mask {
            /*遮罩层*/
            background-color: gray;
            left: 0;
            position: absolute;
            top: 0;
            z-index: 100;
            filter: alpha(opacity=30);
            opacity: 0.3;
        }

        div.dialog {
            width: 296px;
            height: 173px;
            position: absolute;
            z-index: 101;
            display: none;
            background-image: url(<%=basePath%>/static/images/dialog.png)
        }

        div.title {
            padding-top: 5px;
            padding-left: 270px;
        }

        div.dialog div.content {
            height: 90px;
            text-align: center;
            font: bold 15px/90px Verdana, Geneva, sans-serif;
        }

        div.dialog div.bottom {
            text-align: right;
            padding: 10px 10px 10px 0px;
            border-top: 1px dashed #999999;
        }

        div.bottom .btn1 {
            border: none;
            width: 63px;
            height: 29px;
            cursor: pointer;
        }

        div.bottom #btnSure {
            background-image: url(<%=basePath%>/static/images/delSure.jpg);
        }

        div.bottom #btnCancel {
            background-image: url(<%=basePath%>/static/images/delCancel.jpg);
        }
    </style>
    <script type="text/javascript">
        window.onload = function picLight() {
            var settings = {
                containerResizeSpeed: 350,
                overlayOpacity: 0.5
            };
            $('#luxian a[title]').lightBox(settings);
        }
    </script>
</head>

<body onclick="picLight(),calTotal()">
<!--头部-->
<div id="top-cont">
    <div id="top-min">
        <div id="min-left"></div>
        <div id="min-right"></div>
    </div>
</div>
<div id="menu">
    <div id="menu-m">
      <%@include file="common/nav.jsp"%>
    </div>
</div>
<!--广告位图片-->

<!--注册版块-->
<div id="shop">
    <div id="shop-t">
        <div id="shop-l"><img src="<%=basePath%>/static/images/sh.jpg" width="74" height="67" /></div>
        <div id="shop-r">我的购物车</div>
    </div>
    <div id="shop-inf">
        <ul>
            <li class="xh">序号</li>
            <li class="lx">路线名称</li>
            <li class="rs">单价</li>
            <li class="dj">
                <a href="#">下单</a>
            </li>
            <li class="cz">操作</li>
        </ul>
    </div>
    <div id="shop-xx">
        <% int i=0;%>
       <c:forEach items="${list}" var="cart" begin="0" step="1">
        <ul id="shop<%=i%>">
            <li class="xh"><%=i%></li>
            <input value="${cart.id}" class="values" hidden/>
            <li class="lx">
                <div id="luxian">
                    <ul>
                        <li>
                            <a href="${cart.picUrl}" title="美国"><img src="${cart.picUrl}" width="87" height="58" /></a>
                        </li>
                        <li>
                            <a href="${cart.tripDetailEntity.url}">产品编号：${cart.tripDetailEntity.id}&nbsp;&nbsp;线路名：${cart.tripDetailEntity.shortName}</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="rs">￥${cart.tripDetailEntity.countPrice}</li>
            <li class="dj">
                <a href="#">下单</a>
            </li>
            <li class="cz">
                <a href="javascript:void(0)" class="btnDel"><span style="color:#F60; text-decoration:underline;">删除</span></a>
            </li>
        </ul>
           <%i++;%>
       </c:forEach>

    </div>
    <div id="fanye">
        <a href="#">首页</a>
        <a href="#">上一页</a>
        <a href="#">下一页</a>
        <a href="#">尾页</a>
    </div>
    <div id="jine">应付金额：<span style="color:#F00;"></span>元</div>
    <div id="js">
        <input name="button" type="image" id="button" value="提交" src="<%=basePath%>/static/images/js.jpg" />
    </div>
</div>

<!--底部-->
<div class="mask"></div>

<div class="dialog">
    <div class="title">
        <img src="<%=basePath%>/static/images/del.png" id="closePic" title="关闭" /> </div>
    <div class="content">
        <p>您真的要删除这条记录吗？</p>
    </div>
    <div class="bottom">
        <input type="button" value="" class="btn1" id="btnSure" />
        <input type="button" value="" class="btn1" id="btnCancel" />
    </div>
</div>
<%@include file="common/foot.jsp"%>
<script type="text/javascript">
    $("#button").click(function () {
        debugger;
        var values=$(".values");
        var ids=[];
        $.each(values,function (idx,obj) {
            var input= obj.defaultValue;
            ids.push(input);
        });
        $.ajax({
            url:webath+"update.html",
            data:{"data":JSON.stringify(ids)},
            method:"post",
            dataType:"json",
            success:function (result) {
                alert(result.msg);
                window.location.href=webath+"/";
            }
        });
    });
</script>
</body>
</html>