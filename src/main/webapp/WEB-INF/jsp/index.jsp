<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-12-31
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>东莞旅行--首页</title>
    <%@include file="common/header.jsp"%>
    <script type="text/javascript" src="<%=basePath%>static/js/index.js"></script>
</head>

<body onclick="leftScroll()">
<!--头部-->
<div id="top-cont">
    <div id="top-min">
        <div id="min-left"></div>
        <div id="min-right"></div>
    </div>
</div>
<!--导航-->
<%@include file="common/nav.jsp"%>
<!--广告位图片-->
<%@include file="common/advertise.jsp"%>

<!--主体内容第一部分开始-->
<div id="content1">
    <!--左侧-->
    <%@include file="common/left01.jsp"%>
    <!--右侧-->
    <%@include file="common/right01.jsp"%>
</div>
<!--主体内容第一部分结束-->
<!--主体内容第二部分开始-->
<div id="con-2">
    <!--左侧开始-->
   <%@include file="common/left02.jsp"%>
    <!--左侧结束-->
    <!--右侧开始-->
   <%@include file="common/right02.jsp"%>
    <!--主体内容第二部分结束-->
    <!--底部-->
    <%@include file="common/foot.jsp"%>
</body>

</html>
