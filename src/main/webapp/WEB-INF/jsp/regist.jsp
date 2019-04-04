<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>注册用户</title>
		<%@include file="common/header.jsp"%>
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
		<!--广告位图片-->

		<!--注册版块-->
		<div id="reg">
			<div id="reg-top">&nbsp;&nbsp;&nbsp;&nbsp;会员注册</div>
			<div id="reg-mleft">
				<form id="regFrm">
					<ul>
						<li class="m">用户帐号 </li>
						<li class="r">
							<input name="username" type="text" class="box txtInit" id="username" maxlength="12"/>
						</li>
						<li class="m">设置密码 </li>
						<li class="r">
							<input name="password" type="password" class="box txtInit" id="password" maxlength="16"/>
						</li>
						<li class="m">确认密码 </li>
						<li class="r">
							<input name="txtConfirmPwd" type="password" class="box txtInit" id="txtConfirmPwd" maxlength="16"/>
						</li>
						<li class="m">用户姓名 </li>
						<li class="r">
							<input name="trueName" type="text" class="box txtInit" id="trueName" maxlength="6"/>
						</li>
						<li class="m">身份证号 </li>
						<li class="r">
							<input name="idCode" type="text" class="box txtInit" id="idCode" maxlength="18"/>
						</li>
						<li class="m">性 别 </li>
						<li class="r">
							<input name="gender" type="radio" id="radio" value="0" checked="checked" /> 男
							<input type="radio" name="gender" id="radio2" value="1" /> 女 </li>
						<li class="m">手机号码 </li>
						<li class="r">
							<input name="mobile" type="text" class="box txtInit" id="mobile" maxlength="18"/>
						</li>
						<li class="m">用户类型 </li>
						<li class="r">
							<input name="type" type="radio" id="type0" value="0" checked="checked" /> 普通用户
							<input type="radio" name="type" id="type1" value="1" /> 管理员 </li>
						</li>
						<%--<li class="m">校验码 </li>--%>
						<%--<li class="r">--%>
							<%--<input name="textfield" type="text" class="box txtInit" id="textfield" size="15" maxlength="6"/>   <img id="imageCode" alt="" src="/trip/code/getImage.html?${timmestamp}" onclick="checkcode()" style="cursor: pointer;" title="点我更换验证码" />--%>
						<%--</li>--%>
						<li class="m"> </li>
						<li class="r">
							<input name="button" type="image" id="button" onclick="doRegister()" value="提交" src="<%=basePath%>/static/images/but2.jpg" />
						</li>
						<li class="m"> </li>
						<li class="r">
							<input name="checkbox" type="checkbox" id="checkbox" checked="checked" /> 《途乐行旅游网会员服务条款》 <img src="<%=basePath%>/static/images/jt.jpg" width="13" height="12" /></li>
					</ul>
				</form>
			</div>

			<div id="reg-right">
				<div><img src="<%=basePath%>/static/images/kf.jpg" width="230" height="150" /></div>
				<div id="kf2">
					<a href="login.html">已有账户，请点击登录</a>
				</div>

			</div>
		</div>

		<!--底部-->
		<div id="foot">
			<div id="foot-t">
				<p>Copyright © 2015-2017 鄂ICP备16015628号 版权所有，保留一切权利。</p>
				<p>
					<a href="https://ceet-gov.top">隐私保护</a> |
					<a href="https://ceet-gov.top">诚聘英才</a> |
					<a href="https://ceet-gov.top">关于我们</a> |
					<a href="https://ceet-gov.top">网站地图</a> |
					<a href="https://ceet-gov.top">友情链接</a> |
					<a href="https://ceet-gov.top">商务合作</a>
				</p>
			</div>
		</div>
	</body>

</html>