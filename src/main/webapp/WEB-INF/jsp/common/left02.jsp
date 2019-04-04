<%--
  Created by IntelliJ IDEA.
  User: smile
  Date: 2019/1/3
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="con-2left">
    <div id="con-2left1">

        <c:forEach items="${tripTypesLeft}" var="tripType" begin="0" step="1">
        <div class="${tripType.cls}"></div>
        <div class="jingdian">
            <ul>
            <c:forEach items="${tripType.secondTypeEntitySet}" var="tripType0" begin="0" step="1">
                <li>
                    <a href="${tripType0.href}">${tripType0.typeName}</a>
                </li>
            </c:forEach>
            </ul>
        </div>
        </c:forEach>

        <div class="picj"><img src="<%=basePath%>/file/image.html?file_name=bb1.jpg" width="248" height="94" /></div>
        <div class="picj"><img src="<%=basePath%>/file/image.html?file_name=bb2.jpg" width="248" height="94" /></div>
        <div class="picj"><img src="<%=basePath%>/file/image.html?file_name=bb3.jpg" width="248" height="94" /></div>

    </div>
</div>
