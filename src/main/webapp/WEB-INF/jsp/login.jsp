<%--
  Created by IntelliJ IDEA.
  User: smile
  Date: 2019/1/9
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>登录页面</title>
    <%@include file="common/header.jsp"%>
    <script type="text/javascript" src="<%=basePath%>/static/js/login.js"></script>
</head>
<body>
<!--头部-->
<div id="top-cont">
    <div id="top-min">
        <div id="min-left"></div>
        <div id="min-right"></div>
    </div>
</div>
<%@include file="common/nav.jsp"%>
<!--登录版块-->
<div id="login-bg">
    <div id="login-m">
        <ul>
            <li>登录名
                <input name="textfield" type="text" class="box" id="txtLoginNo" size="33" maxlength="12" value="请输入6~12位账号">
            </li>
            <li>密&nbsp;&nbsp;&nbsp;码
                <input name="textfield" type="password" class="box" id="txtPwd" size="33" maxlength="16">
            </li>

            <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input name="button" type="image" id="button" value="提交" src="<%=basePath%>/static/images/login-b.jpg" onclick="cheakBtn()">
            </li>
        </ul>
    </div>
</div>
<%@include file="common/foot.jsp"%>
</body>
</html>
