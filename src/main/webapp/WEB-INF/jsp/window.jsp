<%--
  Created by IntelliJ IDEA.
  User: smile
  Date: 2019/1/13
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="win" class="easyui-window" title="评论" style="width:600px;height:200px"
     data-options="iconCls:'icon-save',modal:true,closed:true">
    <input id="cartId" hidden value=""/>
    评论内容：
    <input class="easyui-textbox" id="commentContent" data-options="multiline:true" value=""
           style="width:580px;height:100px">
    <a href="javascript:saveComment()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeWindow()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>


<div id="advertise" class="easyui-window" title="广告位添加" style="width:600px;height:100px"
     data-options="iconCls:'icon-ok',modal:true,closed:true">
    <br/>
    &nbsp; &nbsp; <input type="file" id="advertiseimg" name="file" style="width:300px">
    <a href="javascript:saveAdvertise()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeWindow()" class="easyui-linkbutton" iconClos="icon-cancel">关闭</a>
</div>

<div id="publish" class="easyui-window" title="发布/修改旅游路线" style="width:600px;height:400px" data-options="iconCls:'icon-ok',modal:true,closed:true">
    <br/>
    <form id="ff0" method="post">
        <div style="float:left;width:49%;">
            <input id="idTrip" hidden value=""/>
            <div>
                <label for="title">标题&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
                <input class="easyui-validatebox" type="text" name="title" id="title" data-options="" value=""/>
            </div>

            <div>
                <label for="realPrice">原价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
                <input class="easyui-validatebox" type="text" name="realPrice" id="realPrice" data-options="" value=""/>
            </div>

            <div>
                <label for="countPrice">折价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
                <input class="easyui-validatebox" type="text" name="countPrice" id="countPrice" data-options=""
                       value=""/>
            </div>

            <div>
                <label for="maxMinus">最大优惠:</label>
                <input class="easyui-validatebox" type="text" name="maxMinus" id="maxMinus" data-options="" value=""/>
            </div>


            <div>
                <label for="tripDays">出游天数:</label>
                <input class="easyui-validatebox" type="text" name="tripDays" id="tripDays" data-options="" value=""/>
            </div>

            <div>
                <label for="fileDetail">标题图片:</label>
                <input type="file" name="fileDetail" id="fileDetail" data-options=""
                       value=""/>
            </div>
            <div>
                <label for="fileDetail0">附图1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
                <input type="file" name="fileDetail0" id="fileDetail0" data-options=""
                       value=""/>
            </div>
            <div>
                <label for="fileDetail1">附图2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
                <input  type="file" name="fileDetail1" id="fileDetail1" data-options=""
                       value=""/>
            </div>
            <div>
                <label for="fileDetail2">附图3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
                <input type="file" name="fileDetail2" id="fileDetail2" data-options=""
                       value=""/>
            </div>

            <div>
                <label for="firstType">产品分类:</label>
                <input class="easyui-combobox" id="firstType" name="firstType" value="" data-options="valueField:'id',textField:'text',method:'get',url:'<%=basePath%>/static/type.json'" >
            </div>

            <div>
                <label for="belong">所属区域:</label>
                <input class="easyui-combobox" id="belong" name="belong"  data-options="valueField:'id',textField:'text',method:'get',url:'<%=basePath%>/static/belong.json'" >
            </div>
        </div>
        <div style="float:left;width:49%;">

            <div>
                <label for="recommended">推荐理由:</label>
                <input class="easyui-textbox" id="recommended" name="recommended" data-options="multiline:true" value=""
                       style="width:150px;height:50px">
            </div>


            <div>
                <label for="discoutDetail">特别优惠:</label>
                <input class="easyui-validatebox" type="text" name="discoutDetail" id="discoutDetail"
                       data-options="multiline:true" value="" style="width:150px;height:50px">
            </div>


            <div>
                <label for="introductions">景点介绍:</label>
                <input class="easyui-validatebox" type="text" name="introductions" id="introductions"
                       data-options="multiline:true" value="" style="width:150px;height:50px">
            </div>

            <div>
                <label for="tips">温馨提示:</label>
                <input class="easyui-validatebox" type="text" name="tips" id="tips" data-options="multiline:true"
                       value="" style="width:150px;height:50px">
            </div>


            <div>
                <label for="shortIntroductions">简介&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
                <input class="easyui-validatebox" type="text" name="shortIntroductions" id="shortIntroductions" data-options="" value="" >
            </div>

            <div>
                <label for="shortName">路线名&nbsp;&nbsp;&nbsp;&nbsp;:</label>
                <input class="easyui-validatebox" type="text" name="shortName" id="shortName" data-options="" value="" >
            </div>
        </div>
        <br>
        <a href="javascript:saveTripDetail()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
        <a href="javascript:closeWindow()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
    </form>
</div>

<div id="addUser" class="easyui-window" title="添加/修改用户" style="width:600px;height:400px" data-options="iconCls:'icon-ok',modal:true,closed:true">
    <h3>用户管理:</h3>
    <form id="ff1" method="post">
        <input id="id" name="userId" hidden value="">
        <div>
            <label for="username">用户名&nbsp;&nbsp;&nbsp;&nbsp;:</label>
            <input class="easyui-validatebox" type="text" name="username" id="username"
                   value="" data-options="required:true"
                   readonly/>
        </div>
        <br/>
        <div>
            <label for="trueName">真实姓名:</label>
            <input class="easyui-validatebox" type="text" name="trueName" id="trueName"
                   value="" data-options=""/>
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
                    value="" style="width:150px;">
                <option value="1">男</option>
                <option value="0">女</option>
                <option value="2">未知</option>
            </select>

        </div>
        <br/>
        <div>
            <label for="mobile">手&nbsp;&nbsp;&nbsp;&nbsp;机&nbsp;&nbsp;&nbsp;&nbsp;:</label>
            <input class="easyui-validatebox" type="text" name="mobile" id="mobile" data-options=""
                   value=""/>
        </div>
        <br/>
        <div>
            <label for="idCode">身份证&nbsp;&nbsp;&nbsp;&nbsp;:</label>
            <input class="easyui-validatebox" type="text" name="idCode" id="idCode" data-options=""
                   value=""/>
        </div>
        <br/>
        <div>
            <label for="createTime">创建时间:</label>
            <input class="easyui-datetimebox" type="text" name="createTime0" id="createTime"
                   data-options="" readonly value=""/>
        </div>
        <br/>
        <div>
            <label for="updateTime">更新时间:</label>
            <input class="easyui-datetimebox" type="text" name="updateTime0" id="updateTime"
                   data-options="" readonly value=""/>
        </div>
        <br/>
        <a href="javascript:save()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    </form>
</div>