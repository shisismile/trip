<%--
  Created by IntelliJ IDEA.
  User: smile
  Date: 2019/1/6
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>东莞旅游网--旅游景点</title>
    <%@include file="common/header.jsp" %>
    <script src="<%=basePath%>static/js/detail.js"></script>
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

<!--主体内容第一部分开始-->
<div class="jindck">
    <div class="jindck-meun">${detail.title}
        <c:if test="${detail.isOnCount==1}">
            <img src="<%=basePath%>static/images/tjcp.jpg" width="40" height="40"/>
        </c:if>
        <c:if test="${detail.payWay==0}">
            <img src="<%=basePath%>static/images/fk.jpg" width="40" height="40"/>
        </c:if>
    </div>
    <div class="jin2">
        <div class="jin2-left">
            <ul>
                <li>
                    <a href="#" id="zoom">
                        <img id="mainImg" src="${detail.fileDetail}" title="详细图片" width="400" height="250"/>
                    </a>
                </li>
                <c:if test="${detail.fileDetail0!=null}">
                    <li class="pics"><img class="pimg" src="${detail.fileDetail0}" width="100" height="63"/></li>
                </c:if>
                <c:if test="${detail.fileDetail1!=null}">
                    <li class="pics"><img class="pimg" src="${detail.fileDetail1}" width="100" height="63"/></li>
                </c:if>
                <c:if test="${detail.fileDetail2!=null}">
                    <li class="pics"><img class="pimg" src="${detail.fileDetail2}" width="100" height="63"/></li>
                </c:if>
            </ul>
        </div>
        <div class="jin2-right">
            <input id="detailId" hidden value="${detail.id}"/>
            <ul>
                <li>途乐行价：<span class="colorc">￥${detail.realPrice}</span></li>
                <li>团购价：<strong>￥${detail.countPrice}</strong> 起</li>
                <li>最大优惠：￥${detail.maxMinus}</li>
                <li>出游天数：${detail.tripDays}天</li>
                <li>出游人数：已有<span>${detail.triperNumber}</span>人出游此线路</li>
                <li>提前报名：建议提前一天报名</li>
                <li>
                    <a href="javascript:save()"><img src="<%=basePath%>static/images/jgwc.jpg" width="122" height="42"/></a>
                </li>
            </ul>
        </div>
    </div>
    <div class="tuijian">
        <div class="tuijian-m">推荐理由</div>
        <div class="tuijian-inf">
            <ul>
                ${detail.recommended}
            </ul>
        </div>
        <div class="tuijian-t">特别优惠</div>
        <div class="tuijian-inf">
            <ul>
                ${detail.discoutDetail}
            </ul>
        </div>
    </div>
    <div class="jianjie">
        <div class="jianjie-m">景点简介</div>
        <div>
            ${detail.introductions}
        </div>
    </div>
    <div class="tuijian">
        <div class="tuijian-m">温馨提示</div>
        <div class="tuijian-inf">
            <ul>
                ${detail.tips}
            </ul>
        </div>
    </div>

    <div class="tuijian">
        <div class="tuijian-m">留言评论</div>
        <div class="tuijian-inf">
            <ul>
                <c:if test="${detail.commentEntitySet !=null}">
                    <c:forEach var="comment" items="${detail.commentEntitySet}" begin="0" step="1">
                        <li><fmt:formatDate value="${comment.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /> &nbsp;&nbsp;${comment.sysUserEntity.username}:&nbsp;&nbsp;&nbsp;&nbsp;${comment.comment}</li>
                    </c:forEach>
                </c:if>
            </ul>
        </div>
    </div>
</div>
<!--主体内容第一部分结束-->
<!--底部-->
<%@include file="common/foot.jsp" %>
<script type="text/javascript">
    function save() {
        var detailId=$("#detailId").val();
        window.location.href=webath+"/save.html?detailId="+detailId;
    }
</script>
</body>
</html>
