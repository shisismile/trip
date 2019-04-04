<%--
  Created by IntelliJ IDEA.
  User: smile
  Date: 2019/1/6
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="Form2" action="/trip/file/doUpload.html" method="post"  enctype="multipart/form-data">
    <h1>采用multipart提供的file.transfer方法上传文件</h1>
    <input type="file" id="file" name="file">
    <input type="text"  name="file_name">
    <input type="submit" value="upload"/>
</form>
</body>
</html>
