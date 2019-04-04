<%--
  Created by IntelliJ IDEA.
  User: smile
  Date: 2019/1/3
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="con1-left">
    <c:forEach items="${tripTypes}" var="tripType" step="1" begin="0" >
        <div class="${tripType.cls}">${tripType.typeName}</div>
        <div class="cs">
            <ul>
                <c:forEach items="${tripType.secondTypeEntitySet}" var="second"  step="1" begin="0">
                    <li>
                        <a href="${second.href}">${second.typeName}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </c:forEach>

</div>
