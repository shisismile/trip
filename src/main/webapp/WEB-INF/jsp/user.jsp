<%--
  Created by IntelliJ IDEA.
  User: smile
  Date: 2019/1/10
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用戶管理</title>
    <%@include file="common/header.jsp" %>
    <style>
        .menu-left {
            font-size: 18px;
        }

        .menu-left ul li {
            font-size: 20px;
        }
    </style>
</head>
<body>
<!--头部-->
<div id="top-cont">
    <div id="top-min">
        <div id="min-left"></div>
        <div id="min-right"></div>
    </div>
</div>
<!--导航-->
<%@include file="common/nav.jsp" %>
<!--广告位图片-->
<%@include file="common/advertise.jsp" %>
<%--${sessionScope.get("CURRENT_USER")}--%>
<div id="content1">
    <div class="easyui-layout" style="width:1003px;height:600px;">
        <div data-options="region:'center'">
            <div id="tt" class="easyui-tabs" style="width:1001px;height:598px;">
                <div id="user" title="用户管理" style="padding:20px;">
                    <div id="userManager" style="float:left;width:49%;">
                        <h3>用户管理:</h3>
                        <form id="ff" method="post">
                            <input id="id" name="userId" hidden value="${sessionScope.get("CURRENT_USER").userId}">
                            <div>
                                <label for="username">用户名&nbsp;&nbsp;&nbsp;&nbsp;:</label>
                                <input class="easyui-validatebox" type="text" name="username" id="username"
                                       value="${sessionScope.get("CURRENT_USER").username}" data-options="required:true"
                                       readonly/>
                            </div>
                            <br/>
                            <div>
                                <label for="trueName">真实姓名:</label>
                                <input class="easyui-validatebox" type="text" name="trueName" id="trueName"
                                       value="${sessionScope.get("CURRENT_USER").trueName}" data-options=""/>
                            </div>
                            <br/>
                            <div>
                                <label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码&nbsp;&nbsp;&nbsp;&nbsp;:</label>
                                <input class="easyui-passwordbox" iconWidth="28" id="password" name="password">
                            </div>
                            <br/>
                            <div>
                                <label for="gender">性&nbsp;&nbsp;&nbsp;&nbsp;别&nbsp;&nbsp;&nbsp;&nbsp;:</label>
                                <%--<input class="easyui-validatebox" type="text" name="gender" id="gender" data-options="" value="${sessionScope.get("CURRENT_USER").gender}"/>--%>
                                <select id="gender" class="easyui-combobox" name="gender"
                                        value="${sessionScope.get("CURRENT_USER").gender}" style="width:150px;">
                                    <option value="1">男</option>
                                    <option value="0">女</option>
                                    <option value="2">未知</option>
                                </select>

                            </div>
                            <br/>
                            <div>
                                <label for="mobile">手&nbsp;&nbsp;&nbsp;&nbsp;机&nbsp;&nbsp;&nbsp;&nbsp;:</label>
                                <input class="easyui-validatebox" type="text" name="mobile" id="mobile" data-options=""
                                       value="${sessionScope.get("CURRENT_USER").mobile}"/>
                            </div>
                            <br/>
                            <div>
                                <label for="idCode">身份证&nbsp;&nbsp;&nbsp;&nbsp;:</label>
                                <input class="easyui-validatebox" type="text" name="idCode" id="idCode" data-options=""
                                       value="${sessionScope.get("CURRENT_USER").idCode}"/>
                            </div>
                            <br/>
                            <div>
                                <label for="createTime">创建时间:</label>
                                <input class="easyui-datetimebox" type="text" name="createTime0" id="createTime"
                                       data-options="" readonly value="${sessionScope.get("CURRENT_USER").createTime}"/>
                            </div>
                            <br/>
                            <div>
                                <label for="updateTime">更新时间:</label>
                                <input class="easyui-datetimebox" type="text" name="updateTime0" id="updateTime"
                                       data-options="" readonly value="${sessionScope.get("CURRENT_USER").updateTime}"/>
                            </div>
                            <br/>
                            <a href="javascript:modify()" class="easyui-linkbutton" iconCls="icon-ok">修改</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="#" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
                        </form>
                    </div>
                    <div id="comment" style="float:left;width:49%;">
                        <h3>已订购路线：</h3>
                        <ul>
                            <c:forEach items="${allByUserCart}" var="cart" begin="0" step="1">
                                <ul>
                                    <li>
                                        <a href="${cart.picUrl}" title="美国"><img src="${cart.picUrl}" width="87"
                                                                                 height="58"/></a>
                                    </li>
                                    <li>
                                        <a href="${cart.tripDetailEntity.url}">产品编号：${cart.tripDetailEntity.id}&nbsp;&nbsp;线路名：${cart.tripDetailEntity.shortName}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="javascript:openWindow(${cart.id})">点击评论</a>
                                    </li>

                                </ul>
                            </c:forEach>
                        </ul>
                    </div>

                </div>
                <c:if test='${sessionScope.get("CURRENT_USER").type==1 }'>
                    <div id="resource" title="资料管理" data-options="closable:true" style="overflow:auto;padding:20px;">
                        <div style="float:left;width:39%;">
                            <a href="javascript:openAdvertise()">广告位修改/添加</a>
                        </div>
                        <div style="float:left;width:59%;">
                            <h3>信息发布与修改：</h3>
                            <a href="javascript:openPublishWindow(-1)">发布新路线</a>
                            <ul>
                                <%
                                    int i = 0;
                                %>
                                <c:forEach items="${tripDetails}" var="tripDetailEntity" begin="0" step="1">
                                    <ul>
                                        <li>
                                            <a href="${tripDetailEntity.url}" title=""><img
                                                    src="${tripDetailEntity.fileDetail}" width="87" height="58"/></a>
                                        </li>
                                        <li>
                                            <a href="${tripDetailEntity.url}">产品编号：${tripDetailEntity.id}&nbsp;&nbsp;线路名：${tripDetailEntity.shortName}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <a href="javascript:openPublishWindow(<%=i%>)" class="easyui-linkbutton"
                                               iconCls="icon-ok">点击修改</a> <a
                                                href="<%=basePath%>/detail/delete.html?id=${tripDetailEntity.id}"
                                                class="easyui-linkbutton" iconCls="icon-cancle">点击删除</a>
                                        </li>
                                    </ul>
                                    <%i++;%>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </c:if>

                <c:if test='${sessionScope.get("CURRENT_USER").type==2}'>
                    <div id="resource" title="订单管理" data-options="closable:true" style="overflow:auto;padding:20px;">
                        <table id="tt1" class="easyui-datagrid" style="width:950px;height:500px"
                               data-options="singleSelect:true,collapsible:true,pagination:true,toolbar:'#tb',url:'<%=basePath%>/getWithPage.html',method:'get'">
                            <thead>
                            <tr>
                                <th data-options="field:'number',width:80">编号</th>
                                    <%--<th data-options="field:'tripDetailEntity',width:180,formatter:tripDetailTitleFormatter">路线名</th>--%>
                                    <%--&lt;%&ndash;<th data-options="field:'tripDetailEntity',width:80,formatter:tripDetailRealPriceFormatter">实际价格</th>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<th data-options="field:'tripDetailEntity',width:80,formatter:tripDetailTripDayFormatter">出游天数</th>&ndash;%&gt;--%>
                                <th data-options="field:'tripDetailEntity',width:180,formatter:tripDetailHrefFormatter">
                                    路线详情
                                </th>
                                <th data-options="field:'sysUserEntity',width:80,formatter:usernameFormatter">用户名</th>
                                <th data-options="field:'createTime',width:120">创建时间</th>
                                <th data-options="field:'status',width:60">状态</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                    <div id="resource" title="普通用户管理" data-options="closable:true" style="overflow:auto;padding:20px;">
                        <table id="tt0" class="easyui-datagrid" style="width:950px;height:500px"
                               data-options="singleSelect:true,collapsible:true,pagination:true,toolbar:'#tb',url:'<%=basePath%>/user/getWithPage.html',method:'get'">
                            <thead>
                            <tr>
                                <th data-options="field:'userId',width:150">用户编号</th>
                                <th data-options="field:'username',width:80">用户名</th>
                                <th data-options="field:'trueName',width:80">真实姓名</th>
                                <th data-options="field:'gender',width:80,formatter:genderFormatter">性别</th>
                                <th data-options="field:'mobile',width:80">手机号</th>
                                <th data-options="field:'idCode',width:200">身份证号</th>
                                <th data-options="field:'type',width:80,formatter:typeFormatter">用户类型</th>
                                <th data-options="field:'createTime',width:120">创建时间</th>
                                <th data-options="field:'status',width:60 ,formatter:statusFormatter">状态</th>
                            </tr>
                            </thead>
                        </table>

                        <div id="tb" style="padding:5px;height:auto">
                            <div style="margin-bottom:5px">
                                    <%--<a href="javascript:openAddUserWindow()" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>--%>
                                    <%--<a href="javascript:openChangeUserWindow()" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>--%>
                                <a href="javascript:removeUser()" class="easyui-linkbutton" iconCls="icon-remove"
                                   plain="true"></a>
                            </div>
                        </div>

                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>

<%@include file="window.jsp" %>
<%@include file="common/foot.jsp" %>
<%@include file="js.jsp" %>
<script>

    // function openAddUserWindow() {
    //     $("#addUser").window({top: 100, left: 400});
    //     $("#addUser").window("open");
    // }
    //
    // function openChangeUserWindow() {
    //     var tt=$("#tt0").datagrid('getSelected');
    //     $("#id").val(tt.userId);
    //     $("#username").val(tt.username);
    //     $("#trueName").val(tt.trueName);
    //     $("#gender").val(tt.gender);
    //     $("#mobile").val(tt.mobile);
    //     $("#idCode").val(tt.idCode);
    //     $("#createTime").val(tt.createTime);
    //     $("#updateTime").val(tt.updateTime);
    //         debugger
    //     $("#addUser").window({top: 100, left: 400});
    //     $("#addUser").window("open");
    // }
    function genderFormatter(val, row) {
        if (val == 0) {
            return "女"
        } else if (val == 1) {
            return "男"
        } else {
            return "未知"
        }
    }

    function typeFormatter(val, row) {
        if (val == 1) {
            return "资料管理员"
        } else if (val == 2) {
            return "系统管理员"
        } else if (val == 0) {
            return "普通用户"
        } else {
            return "未知"
        }
    }

    function statusFormatter(val, row) {
        if (val == 0) {
            return "正常"
        } else if (val == -1) {
            return "删除"
        } else {
            return "未知"
        }
    }

    function usernameFormatter(val, row) {
        try {
            return val.username
        } catch (e) {
            return ""
        }
    }

    function truenameFormatter(val, row) {
        try {
            return val.trueName
        } catch (e) {
            return ""
        }
    }

    function tripDetailHrefFormatter(val, row) {
        try {
            return "<a href=" + val.url + ">查看路线详情</a>"
        } catch (e) {
            return ""
        }
    }

    function tripDetailTitleFormatter(val, row) {
        try {
            return val.title
        } catch (e) {
            return ""
        }
    }

    function tripDetailRealPriceFormatter(val, row) {
        try {
            return "￥" + val.realPrice
        } catch (e) {
            return ""
        }
    }

    function tripDetailTripDayFormatter(val, row) {
        try {
            return val.tripDays
        } catch (e) {
            return ""
        }
    }

    function removeUser() {
        var tt = $("#tt0").datagrid('getSelected');
        $.ajax({
            url: webath + "user/delete.html",
            data: {"uId":tt.userId},
            method: "get",
            dataType: "json",
            success: function (result) {
                alert(result.msg)
                $("#tt0").datagrid('reload');
            }
        });
    }
</script>
</body>
</html>
