<%--
  Created by IntelliJ IDEA.
  User: smile
  Date: 2019/1/3
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql"
           uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="java.util.Date" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    long timmestamp=new Date().getTime();
%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath%>/static/css/layout.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/js/jquery-easyui-1.3.3/themes/default/easyui.css"></link>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/js/jquery-easyui-1.3.3/themes/icon.css"></link>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/css/demo.css"></link>
<script type="text/javascript" src="<%=basePath%>/static/js/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script src="<%=basePath%>/static/js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=basePath%>/static/js/jquery.metadata.js" type="text/javascript"></script>
<script src="<%=basePath%>/static/js/jquery.validate.messages_cn.js"></script>
<script src="<%=basePath%>/static/js/NFLightBox.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/regist.js"></script>
<script type="text/javascript">
    var webath="<%=basePath%>";
</script>
<style type="text/css">
    .txtInit {
        border: 1px #cecece solid;
    }

    .txtFocus {
        border: 1px solid #009;
    }

    .spanInit {
        width: 300px;
        height: 22px;
        display: block;
        float: right;
        background-repeat: no-repeat;
        background-position: left;
    }
    /* 错误提示时的样式设置 */

    input.error {
        border: 1px solid red;
    }

    label.error {
        padding-left: 16px;
        padding-bottom: 2px;
        font-weight: bold;
        color: #EA5200;
    }
</style>