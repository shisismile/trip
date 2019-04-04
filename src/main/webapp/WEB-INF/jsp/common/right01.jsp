<%--
  Created by IntelliJ IDEA.
  User: smile
  Date: 2019/1/3
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="con1-right">
    <div id="right-top">
        <div class="banner">
            <ul id="imgs">
                <c:forEach items="${tgs}" var="tg" begin="0" step="1">
                    <li><img src="${tg.filePath}" width="540" height="240"/></li>
                </c:forEach>
            </ul>
            <ul id="numbers">
                <li>1</li>
                <li>2</li>
                <li>3</li>
                <li>4</li>
            </ul>
        </div>
        <div class="zcdl">
            <c:choose>
                <c:when test='${sessionScope.get("CURRENT_USER")==null}'>
                    <ul>
                        <li style="margin-right:3px;">
                            <a href="<%=basePath%>login.html"><img src="<%=basePath%>static/images/dl.jpg" width="85"
                                                                   height="36"/></a>
                        </li>
                        <li>
                            <a href="<%=basePath%>/register/register.html"><img src="<%=basePath%>static/images/zc.jpg"
                                                                                width="85" height="36"/></a>
                        </li>
                    </ul>
                </c:when>
                <c:when test='${sessionScope.get("CURRENT_USER")!=null}'>
                    <div style="font-size: 15px"> 用户名：<a href="<%=basePath%>/user/userDetail.html">${sessionScope.get("CURRENT_USER").username}</a> &nbsp;&nbsp;<a href="<%=basePath%>/loginout.html">退出</a></div>
                </c:when>
            </c:choose>

        </div>
        <div class="my">
            <ul>
                <li><span class="myd">96%</span> 满意度</li>
                <li class="cls">
                    <a href="<%=basePath%>/user/userDetail.html">查看历史订单</a>
                </li>
            </ul>
        </div>
    </div>
    <div id="right-btm">
        <div class="tgjlx">
            <ul style="width:1446px">
               <c:forEach items="${tripDetails}" var="tripDetail" begin="0" step="1">
                   <li><img src="${tripDetail.fileDetail}" width="160" height="88"/>
                       <a href="${tripDetail.url}">${tripDetail.title}</a><br/>
                       <span>￥${tripDetail.countPrice}</span>起 原价￥${tripDetail.realPrice}
                   </li>
               </c:forEach>
            </ul>
        </div>
    </div>
</div>
