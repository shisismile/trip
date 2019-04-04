<%--
  Created by IntelliJ IDEA.
  User: smile
  Date: 2019/1/3
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="menu">
    <div id="menu-m">
        <ul>
            <c:forEach step="1" items="${navEntities}" var="navEntity" begin="0">
                <li>
                    <a href="<%=basePath%>/${navEntity.href}">${navEntity.navName}</a>
                </li>
            </c:forEach>

        </ul>
    </div>
</div>
