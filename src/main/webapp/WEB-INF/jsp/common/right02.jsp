<%--
  Created by IntelliJ IDEA.
  User: smile
  Date: 2019/1/3
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="con-2right">
    <div id="con-2meun">

    </div>

    <c:forEach step="1" items="${tripDetails}" var="detail" begin="0">
        <div class="con-2inf">
            <ul>
                <li class="w130">
                    <a href="${detail.url}"><img src="${detail.fileDetail}" width="120" height="75" /></a> 编号:${detail.id}</li>
                <li class="w440">
                    <div class="w440lx">
                        <a href="${detail.url}">${detail.title}</a>
                    </div>
                    <div class="w440xx">
                        <a href="${detail.url}">简介:${detail.shortIntroductions}</a> <br />
                        本线路已有<span>${detail.triperNumber}</span>人出游
                    </div>
                </li>
                <li class="w140"><br /> <span>￥${detail.countPrice}元/每人</span></li>
            </ul>
        </div>
    </c:forEach>
</div>
